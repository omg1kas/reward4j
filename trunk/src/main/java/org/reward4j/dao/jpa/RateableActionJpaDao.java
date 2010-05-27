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

import java.util.List;

import org.reward4j.dao.AccountDao;
import org.reward4j.dao.RateableActionDao;
import org.reward4j.dao.RateableActionNotExistException;
import org.reward4j.model.RateableAction;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * {@code AccountJpaDao} is the jpa specific implementation of the {@link AccountDao} using the spring specific dao support.
 * 
 * @author hillger.t
 */
public class RateableActionJpaDao extends JpaDaoSupport implements RateableActionDao {

	@Override
	@SuppressWarnings("unchecked")
	public RateableAction getAction(String actionName) throws RateableActionNotExistException {
		try {
			List<RateableAction> result = this.getJpaTemplate().find("select ra from RateableAction ra where ra.name = ?");
			return result.get(0);
		}
		catch (Exception e) {
			throw new RateableActionNotExistException("RateableAction could not be found: " + actionName);
		}
		
	}

	@Override
	public void saveAction(RateableAction action) {
		this.getJpaTemplate().persist(action);
	}

}
