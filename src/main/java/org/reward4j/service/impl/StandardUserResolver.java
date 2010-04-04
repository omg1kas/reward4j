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

import org.reward4j.model.User;
import org.reward4j.service.UserNotFoundException;
import org.reward4j.service.UserResolver;

/**
 * The {@code StandardUserResolver} retrieves a {@link User} by looking
 * for the necessary information within a specific <code>ThreadLocal</code>
 * context.
 * <p/>
 * So it is necessary that somebody puts the {@link User} into this <code>ThreadLocal</code>
 * context when user's actions shall be rewarded by the {@code StandardUserResolver}.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 *
 */
public class StandardUserResolver implements UserResolver {
    private static ThreadLocal<User> tl = new ThreadLocal<User>();

    @Override
    public User getUser() throws UserNotFoundException {
        User foundUser = null;
        
        foundUser = tl.get();
        
        if(null==foundUser) {
            throw new UserNotFoundException();
        }
        
        return foundUser;
    }

}
