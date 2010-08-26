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

package org.reward4j.dao.jpa;

import javax.annotation.Resource;

import static org.hamcrest.core.IsEqual.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.reward4j.dao.AccountDao;
import org.reward4j.dao.AccountNotExistException;
import org.reward4j.dao.RateableActionDao;
import org.reward4j.model.Account;
import org.reward4j.model.AccountPosition;
import org.reward4j.model.Coin;
import org.reward4j.model.RateableAction;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AccountJpaDaoTest {

  @Resource
  private AccountDao accountDao;

  @Resource
  private RateableActionDao rateableActionDao;

  @Transactional
  @Test
  public void saveAndReadAccount() throws AccountNotExistException {
    Account account = new Account("testAccount");
    this.accountDao.saveAccount(account);

    Account savedAccount = this.accountDao.getAccountByName("testAccount");
    assertThat(savedAccount, equalTo(account));
  }

  @Transactional
  @Test
  public void saveAndModifyAccount() throws AccountNotExistException {
    Account account = new Account("accountToModify");
    this.accountDao.saveAccount(account);

    RateableAction action = new RateableAction("testAction");
    this.rateableActionDao.saveAction(action);

    account.addPosition(new AccountPosition(action, new Coin(10)));
    this.accountDao.saveAccount(account);

    Account modifiedAccount = this.accountDao.getAccountByName("accountToModify");
    assertThat(modifiedAccount, equalTo(account));
  }

  @Test(expected = AccountNotExistException.class)
  public void tryToReadNotExistingAccount() throws AccountNotExistException {
    this.accountDao.getAccountByName("notExistingAccount");
  }
}
