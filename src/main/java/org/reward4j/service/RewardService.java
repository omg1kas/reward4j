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

package org.reward4j.service;

import java.util.Set;

import org.reward4j.dao.AccountNotExistException;
import org.reward4j.model.Account;
import org.reward4j.model.Coin;
import org.reward4j.model.User;

/**
 * The {@code RewardService} represents the main service within the reward4j
 * framework.
 * <p/>
 * This service is used by the {@link PayableInterceptor} if a recognized action
 * shall be rewarded for a {@link User}.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public interface RewardService {

  /**
   * Executes the payment of an action that a user has done.
   * 
   * @param coins
   *          The amount of the payment
   * @param actionName
   *          The name of the action
   * @param user
   *          The user who has done the action
   */
  void payForAction(Coin coins, String actionName, User user);

  /**
   * Retrieves the {@link Account} of an {@link User}.
   * 
   * @param user
   *          the owner of the {@link Account}
   * @return the user's {@link Account}
   */
  Account getAccount(User user) throws AccountNotExistException;

  /**
   * Returns an {@link User}'s account balance.
   * 
   * @param user
   *          The user to check
   */
  double getBalance(User user);

  /**
   * Gets all available {@link Account}s.
   * 
   * @return all available {@link Account}s.
   */
  Set<Account> getAllAccounts();

}
