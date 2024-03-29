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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The {@code User} represents a user in the reward4j domain. A {@code User} has
 * an {@link Account}.
 *
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 * @author hillger.t
 */
@Entity
public class User implements Serializable {
  private static final long serialVersionUID = -523897108104173970L;

  // the unique identifier of the user
  @Id
  @Column(name = "userid")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  // the name if the user
  @Column(nullable = false, unique = true, length = 250)
  private String name;

  // the user's account
  @OneToOne
  @JoinColumn(name = "accountid", nullable = false)
  private Account account;

  public User() {
  }

  public User(final long id, final String name) {
    if (0 >= id)
      throw new IllegalArgumentException("id must be positiv");
    if (null == name)
      throw new IllegalArgumentException("name must not be null");

    this.id = id;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("id", this.id).append("name", this.name).toString();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(this.id).append(this.name).toHashCode();
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

    User rhs = (User) obj;

    return new EqualsBuilder().append(this.id, rhs.id).append(this.name, rhs.name).isEquals();
  }

}
