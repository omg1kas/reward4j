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

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.reward4j.dao.AccountDao;
import org.reward4j.dao.AccountNotExistException;
import org.reward4j.model.Account;
import org.reward4j.model.Coin;
import org.reward4j.model.User;
import org.reward4j.service.RewardService;
import org.reward4j.service.UserNotFoundException;
import org.reward4j.service.UserResolver;
import org.reward4j.test.BaseTestCase;

import static org.easymock.classextension.EasyMock.*;


/**
 * The {@code RewardServiceImplTest} tests the behaviour of {@link RewardServiceImpl}.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class RewardServiceImplTest {
    private RewardServiceImpl rewardService;
    
    @Before
    public void setUp() {
        this.rewardService = new RewardServiceImpl();
    }

    @Test
    public void testPayForAction() {
        fail();
    }
    
    @Test
    public void testGetAccountOfUser() throws UserNotFoundException, AccountNotExistException {
        User user = new User(1, "john doe");
        
        Account account = createMock(Account.class);
        
        AccountDao accountDao = createMock(AccountDao.class);
        expect(accountDao.getAccountForUser(user)).andReturn(account);
        replay(accountDao);
        
        this.rewardService.setAccountDao(accountDao);
        
        Account userAccount = this.rewardService.getAccount(user);
        assertEquals(account, userAccount);
    }
    
    @Test
    public void testGetAllAccounts() {
        Account account1 = createMock(Account.class);
        Account account2 = createMock(Account.class);
        Set<Account> accounts = new HashSet<Account>();
        accounts.add(account1);
        accounts.add(account2);
        
        AccountDao accountDao = createMock(AccountDao.class);
        expect(accountDao.getAllAccounts()).andReturn(accounts);
        replay(accountDao);
        
        this.rewardService.setAccountDao(accountDao);
        
        Set<Account> returnedAccounts = this.rewardService.getAllAccounts();
        assertEquals(accounts, returnedAccounts);
    }

}
