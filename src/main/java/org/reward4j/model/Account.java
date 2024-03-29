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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The {@code Account} represents a user's account.
 */
@Entity
public class Account implements Serializable {
  private static final long serialVersionUID = -3766204445266143843L;

  /** Name of this account. */
  @Id
  @Column(nullable = false, unique = true, length = 250)
  private String name;

  /** Points to the user of this account. */
  @OneToOne(mappedBy = "account")
  private User user;

  /** Collection of all account positions for this account. */
  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
  private List<AccountPosition> positions = new ArrayList<AccountPosition>();

  /**
   * Constructor.
   */
  protected Account() {
  }

  /**
   * Constructor.
   *
   * @param name
   */
  public Account(final String name) {
    if (null == name)
      throw new IllegalArgumentException("name must not be null");

    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<AccountPosition> getPositions() {
    return positions;
  }

  protected void setPositions(List<AccountPosition> positions) {
    this.positions = positions;
  }

  public void addPosition(AccountPosition position) {
    if (null != position) {
      this.positions.add(position);
      position.setAccount(this);
    }
  }

  public Coin getBalance() {
    Coin balance = new Coin(0);
    for (AccountPosition position : this.positions) {
      balance = balance.add(position.getValue());
    }
    return balance;
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }

    Account rhs = (Account) obj;

    return new EqualsBuilder().append(this.name, rhs.name).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(this.name).toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("name", this.name).toString();
  }

}
