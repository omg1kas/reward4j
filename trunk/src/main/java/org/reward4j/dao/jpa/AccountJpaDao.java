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

import java.util.Set;

import org.reward4j.dao.AccountDao;
import org.reward4j.dao.AccountNotExistException;
import org.reward4j.model.Account;
import org.reward4j.model.User;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * {@code AccountJpaDao} is the jpa specific implementation of the {@link AccountDao} using some spring specific dao support.
 * 
 * @author hillger.t
 */
public class AccountJpaDao extends JpaDaoSupport implements AccountDao {
	
	// TODO: This sould be rethought somehow. 
	@Override
	public Account getAccountForUser(User user) throws AccountNotExistException {
		try {
			return user.getAccounts().get(0);
		}
		catch (Exception e) {
			throw new AccountNotExistException(e);
		}
	}

	@Override
	public Account getAccountByName(String name) throws AccountNotExistException {
		return (Account) this.getJpaTemplate().find("select a from Account a where a.name = ?", name);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<Account> getAllAccounts() {
		return (Set<Account>) this.getJpaTemplate().find("select a from Account a order by a.id");
	}

	@Override
	public void saveAccount(Account account) {
		if (!this.getJpaTemplate().contains(account))
			account=this.getJpaTemplate().merge(account);
		this.getJpaTemplate().persist(account);
	}
}
