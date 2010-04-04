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
import java.util.Date;

/**
 * The {@code Position} represents a position within a user's {@link Account}.
 */
public class Position implements Serializable {
    private static final long serialVersionUID = -4937858211810042799L;

    // Unique identifier.
    private long id;

    // Date of insertion. Should always be sysdate and mandatory.
    private Date insertionDate = new Date();

    // Rate for this account position according to the underlying action.
    private Coin value;

    // The origin {@link RateableAction} that forces this position
    private RateableAction action;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RateableAction getAction() {
        return action;
    }

    public void setAction(RateableAction action) {
        this.action = action;
    }

    public Date getInsertionDate() {
        return (Date)insertionDate.clone();
    }

    public void setInsertionDate(Date idate) {
        this.insertionDate.setTime(idate.getTime());
    }

    public Coin getValue() {
        return value;
    }

    public void setValue(Coin value) {
        this.value = value;
    }
}
