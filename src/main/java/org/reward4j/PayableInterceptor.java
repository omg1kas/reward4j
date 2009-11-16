/*
 * Copyright 2009 reward4j.org
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
import org.reward4j.model.Coin;
import org.reward4j.model.User;
import org.reward4j.service.RewardService;
import org.reward4j.service.UserResolver;
import org.springframework.aop.AfterReturningAdvice;

/**
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
  
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    try {
      final Payable payable = method.getAnnotation(Payable.class);
      
      if(null!=payable) {
        
        double amount = 0.0;
        try {
          amount = Double.valueOf(payable.coins());
        } catch(NumberFormatException fe) {
          LOG.error("could not convert " + payable.coins() + " to double amount value!", fe);
        }
        
        String actionName = "";
        if(null!=payable.action()) {
        	actionName = payable.action();
        }
        
        if(null!=this.rewardService) {
        	Coin coins = new Coin(amount);
        	User user = this.userResolver.getUser();
        	this.rewardService.payForAction(coins, actionName, user);
        } else {
        	LOG.error("necessary RewardService is not defined!");
        }
        
      }
    } catch(Exception e) {
      LOG.warn("couldn't pay for action", e);
    }
  }
}
