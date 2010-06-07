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

/**
 * Will be thrown if a {@link User} could not be found by the
 * {@link UserResolver}.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class UserNotFoundException extends Exception {
  private static final long serialVersionUID = -3177505119076944494L;

  public UserNotFoundException(String userId) {
    super("user with id '" + userId + "' could not be found");
  }

  public UserNotFoundException() {
    super("user could not be found");
  }

}
