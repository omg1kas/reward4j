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

package org.reward4j.dao;

import java.util.Set;

import org.reward4j.model.Account;
import org.reward4j.model.User;

/**
 * The {@code AccountDao} is a data access layer for 
 * {@link Account}s.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public interface AccountDao {

    /**
     * Retrieves the user's account. If the account doesn't exist
     * an {@link AccountNotExistException} will be thrown.
     * 
     * @param user the {@link User} the account is for
     * @throws AccountNotExistException if user hasn't got any account
     * @return the account that belongs to the user
     */
    Account getAccountForUser(User user) throws AccountNotExistException;
    
    /**
     * Retrieves an account with the given name. If the account doesn't exist
     * an {@link AccountNotExistException} will be thrown.
     * 
     * @param name of the {@link Account} to search for
     * @throws AccountNotExistException if user hasn't got any account
     * @return the account that has that name
     */
    Account getAccountByName(String name) throws AccountNotExistException;
    
    /**
     * Retrieves all available {@link Account}s.
     * 
     * @return All {@link Account}s 
     */
    Set<Account> getAllAccounts();
    
    /**
     * Saves an {@link Account}.
     * 
     * @param account the account that shall be saved
     */
    void saveAccount(Account account);
}
