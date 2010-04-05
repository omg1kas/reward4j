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

import static org.junit.Assert.*;
import org.junit.Test;
import org.reward4j.model.Account;
import org.reward4j.model.Coin;
import org.reward4j.service.RewardService;
import org.reward4j.test.BaseTestCase;

/**
 * The {@code RewardServiceImplTest} tests the behaviour of {@link RewardServiceImpl}.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class RewardServiceImplTest extends BaseTestCase {
    
    private RewardService rewardService;
    
    public void setRewardService(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @Test
    public void testPayForAction() {
        fail();
    }
    
    @Test
    public void testGetAccountOfUser() {
        fail();
    }
    
    @Test
    public void testGetAllAccounts() {
        fail();
    }

}
