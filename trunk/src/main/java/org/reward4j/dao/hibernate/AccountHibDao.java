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

package org.reward4j.dao.hibernate;

import java.util.Set;

import org.reward4j.dao.AccountDao;
import org.reward4j.dao.AccountNotExistException;
import org.reward4j.model.Account;
import org.reward4j.model.User;

/**
 * {@code AccountHibDao} is the hibernate specific implementation
 * of the {@link AccountDao}.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 * 
 * TODO: DISCUSS: Should we really implement a Hibernate implementation
 * when we already have jpa implemented? One of the advantages of jpa is 
 * that there are several implementations like Hibernate or TopLink etc. 
 */
public class AccountHibDao implements AccountDao {

    @Override
    public Account getAccountForUser(User user) throws AccountNotExistException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
		public Account getAccountByName(String name) throws AccountNotExistException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
    public double getBalanceForUser(User user) {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public Set<Account> getAllAccounts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        // TODO Auto-generated method stub

    }

}
