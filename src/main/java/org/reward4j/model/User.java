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

package org.reward4j.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code User} represents a user in the reward4j domain. A {@code User} has an {@link Account}. 
 */
public class User implements Serializable {
    private static final long serialVersionUID = -523897108104173970L;
    
    // the unique identifier of the user
    private long id;
    // the name if the user
    private String name;
    
    // the user's accounts; normally a user has only one account
    private List<Account> accounts = new ArrayList<Account>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
