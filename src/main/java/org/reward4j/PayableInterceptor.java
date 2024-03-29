/**
 * Copyright 2009-2010 reward4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.reward4j;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reward4j.model.Amount;
import org.reward4j.model.Coin;
import org.reward4j.model.User;
import org.reward4j.service.RewardService;
import org.reward4j.service.UserNotFoundException;
import org.reward4j.service.UserResolver;
import org.springframework.aop.AfterReturningAdvice;

/**
 * The {@code PayableInterceptor} is looking for methods which are annotated by
 * the {@link Payable} annotation. If so the rewarding will be executed using
 * the {@link RewardService}.
 * <p/>
 * The most necessary information are described by the according {@link Payable}
 * annotation (the amount of the reward).
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class PayableInterceptor implements AfterReturningAdvice {
  private static final Log LOG = LogFactory.getLog(PayableInterceptor.class);

  private RewardService rewardService;
  private UserResolver userResolver;

  public void setRewardService(RewardService rewardService) {
    this.rewardService = rewardService;
  }

  public void setUserResolver(UserResolver userResolver) {
    this.userResolver = userResolver;
  }

  @Override
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    try {
      final Payable payable = method.getAnnotation(Payable.class);

      if (null != payable) {

        double value = 0.0;
        try {
          Amount amount = payable.amountClass().newInstance();
          amount.setAmount(payable.coins());
          value = amount.getAmount();
        } catch (NumberFormatException fe) {
          LOG.error("could not convert " + payable.coins() + " to double amount value!", fe);
        }

        String actionName = "";
        if (null != payable.action()) {
          actionName = payable.action();
        }

        if (null != this.rewardService) {
          Coin coins = new Coin(value);
          try {

            // fetch user and pay for action execution
            User user = this.userResolver.getUser();
            this.rewardService.payForAction(coins, actionName, user);

          } catch (UserNotFoundException unfe) {
            LOG.warn("couldn't find necessary user for reward action execution! So do nothing.", unfe);
          }
        } else {
          LOG.error("necessary RewardService is not defined!");
        }

      }
    } catch (Exception e) {
      LOG.warn("couldn't pay for action", e);
    }
  }
}
