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

import org.reward4j.model.User;

/**
 * The {@code UserResolver} describes how the concrete {@link User} can be
 * fetched.
 * <p/>
 * The {code UserResolver} is the entry point to customize the reward4j
 * framework, when the standard user resolving shall not be used.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 * 
 */
public interface UserResolver {

  /**
   * Retrieves the concrete {@link User} that is represented by the key value.
   * 
   * @param userId
   *          the key of the {@link User}
   * @return the {@link User}
   * @throws UserNotFoundException
   *           if no user belongs to given key
   */
  User getUser() throws UserNotFoundException;
}
