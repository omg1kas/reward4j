/*
 * Copyright 2009 reward4j.org
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

import java.util.Date;

/**
 * 
 */
public class Position {
  /**
   * Unique identifier.
   */
  private long id;

  /**
   * Date of insertion. Should always be sysdate and mandatory.
   */
  private Date idate = new Date();

  /**
   * Rate for this account position according to the underlying action.
   */
  private Coin value;
  
  /**
   * 
   */
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

  public Date getIdate() {
    return idate;
  }

  public void setIdate(Date idate) {
    this.idate = idate;
  }

  public Coin getValue() {
    return value;
  }

  public void setValue(Coin value) {
    this.value = value;
  }
}
