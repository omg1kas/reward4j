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

import org.reward4j.model.RateableAction;

/**
 * The {@code RateableActionDao} is a data access layer for
 * {@link RateableAction}s.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public interface RateableActionDao {

  /**
   * Retrieves the {@link RateableAction} using the given name. If the
   * {@link RateableAction} doesn't exist a
   * {@link RateableActionNotExistException} will be thrown.
   * 
   * @param actionName
   *          name of the {@link RateableAction}
   * @return the {@link RateableAction} with the given name
   * @throws RateableActionNotExistException
   *           if {@link RateableAction} with the name does not exist
   */
  RateableAction getAction(final String actionName) throws RateableActionNotExistException;

  /**
   * Saves a {@link RateableAction}.
   * 
   * @param action
   *          the {@link RateableAction} that shall be saved
   */
  void saveAction(final RateableAction action);
}
