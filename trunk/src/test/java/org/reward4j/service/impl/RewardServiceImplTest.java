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

import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import org.reward4j.dao.AccountDao;
import org.reward4j.dao.AccountNotExistException;
import org.reward4j.dao.RateableActionDao;
import org.reward4j.dao.RateableActionNotExistException;
import org.reward4j.model.Account;
import org.reward4j.model.Coin;
import org.reward4j.model.RateableAction;
import org.reward4j.model.User;
import org.reward4j.service.UserNotFoundException;

import static org.easymock.classextension.EasyMock.*;

/**
 * The {@code RewardServiceImplTest} tests the behavior of
 * {@link RewardServiceImpl}.
 *
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class RewardServiceImplTest {
  private RewardServiceImpl rewardService = new RewardServiceImpl();

  @Test
  public void payForAnActionOfUser() throws AccountNotExistException, RateableActionNotExistException {
    User user = new User(1, "john doe");

    Account account = new Account("default");
    AccountDao accountDao = createMock(AccountDao.class);
    expect(accountDao.getAccountForUser(user)).andReturn(account).times(4);
    accountDao.saveAccount(account);
    expectLastCall().times(2);
    replay(accountDao);

    RateableAction testAction = new RateableAction("testAction");
    RateableActionDao actionDao = createMock(RateableActionDao.class);
    expect(actionDao.getAction("testAction")).andReturn(testAction).times(2);
    replay(actionDao);

    this.rewardService.setAccountDao(accountDao);
    this.rewardService.setRateableActionDao(actionDao);

    this.rewardService.payForAction(new Coin(10), "testAction", user);

    Account usersAccount = this.rewardService.getAccount(user);
    assertEquals(new Coin(10), usersAccount.getBalance());

    this.rewardService.payForAction(new Coin(-4), "testAction", user);
    assertEquals(new Coin(6), usersAccount.getBalance());
  }

  @Test(expected = AccountNotExistException.class)
  public void retrieveUsers() throws UserNotFoundException, AccountNotExistException {
    User user = new User(1, "john doe");
    User user2 = new User(2, "unknown");

    Account account = createMock(Account.class);

    AccountDao accountDao = createMock(AccountDao.class);
    expect(accountDao.getAccountForUser(user)).andReturn(account);
    expect(accountDao.getAccountForUser(user2)).andThrow(new AccountNotExistException());
    replay(accountDao);

    this.rewardService.setAccountDao(accountDao);

    Account userAccount = this.rewardService.getAccount(user);
    assertThat(account, equalTo(userAccount));

    try {
      userAccount = this.rewardService.getAccount(user2);
    } catch (AccountNotExistException e) {
      throw e;
    }

  }

  @Test
  public void retrieveAllAccounts() {
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
