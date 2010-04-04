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

package org.reward4j.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.reward4j.dao.AccountDao;
import org.reward4j.model.Coin;
import org.reward4j.model.User;
import org.reward4j.service.RewardService;

/**
 * The {@code RewardServiceImpl} represents the concrete 
 * implementation of the {@link RewardService}.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class RewardServiceImpl implements RewardService {
    private static final Logger LOG = Logger.getLogger(RewardServiceImpl.class);
    
    private AccountDao accountDao;
    

    @Override
    public void payForAction(Coin coins, String actionName, User user) {
        if(null==user) throw new IllegalArgumentException("user must not be null");
        if(StringUtils.isEmpty(actionName)) throw new IllegalArgumentException("actionName must not be empty");
        if(null==coins) throw new IllegalArgumentException("coins must not be null");
        
        //fetch the user's account
        
        
    }
    
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
