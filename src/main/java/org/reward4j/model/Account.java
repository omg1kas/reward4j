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

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user's account.
 */
public class Account {
  /**
   * Unique identifier.
   */
  private long id;

  /**
   * Name of this account.
   */
  private String name;

  /**
   * The current account balance. The initial value of 0 should be discussed.
   */
  private double balance = 0d;

  /**
   * Collection of all account positions for this account.
   */
  private List<Position> positions = new ArrayList<Position>();

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

  public List<Position> getPositions() {
    return positions;
  }

  public void setPositions(List<Position> positions) {
    this.positions = positions;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
