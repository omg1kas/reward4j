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
import org.reward4j.model.User;
import org.reward4j.service.RewardService;
import org.reward4j.service.UserResolver;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * The {@code RestrictableInterceptor} is looking for methods which are annotated by
 * the {@link Restrictable} annotation. If so the execution of these methods will only
 * get processed if the {@link RewardService} could possitivly check some account balance
 * confition.
 * 
 * <p/>
 * The most necessary information are described by the according {@link Restrictable}
 * annotation.
 * 
 * @author hillger.t
 */
public class RestrictableInterceptor implements MethodBeforeAdvice {
  private static final Log LOG = LogFactory.getLog(RestrictableInterceptor.class);
  private RewardService rewardService;
  private UserResolver userResolver;

  public void setRewardService(RewardService rewardService) {
    this.rewardService = rewardService;
  }

  public void setUserResolver(UserResolver userResolver) {
    this.userResolver = userResolver;
  }

  @Override
  public void before(Method method, Object[] args, Object target) throws Throwable {
    try {
      if (method.isAnnotationPresent(Restrictable.class)) {
        Restrictable restrictable = method.getAnnotation(Restrictable.class);

        User user = this.userResolver.getUser();
        double amount = restrictable.coins();

        if (rewardService.hasBalance(user, amount)) {
          throw new RuntimeException("the user has not the necessary account balance to execute this action");
        }
      }
    }
    catch (Exception e) {
      LOG.warn("action execution is not allowed due to account balance", e);
      throw e;
    }
  }
}
