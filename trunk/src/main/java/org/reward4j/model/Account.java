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
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The {@code Account} represents a user's account.
 */
@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = -3766204445266143843L;

	// Unique identifier.
	@Id
	@Column(name = "accountid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// Name of this account.
	@Column(nullable = false)
	private String name;

	// Points to the user of this account.
	@ManyToOne
	@JoinColumn
	private User user;

	// Collection of all account positions for this account.
	@OneToMany(mappedBy = "account")
	private List<Position> positions = new ArrayList<Position>();

	public Account(final String name) {
		if (null == name)
			throw new IllegalArgumentException("name must not be null");

		this.id = UUID.randomUUID().getMostSignificantBits();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
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

	public List<Position> getPositions() {
		return positions;
	}

	protected void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public void addPosition(Position position) {
		if (null != position) {
			position.setAccount(this);
			this.positions.add(position);
		}
	}

	public Coin getBalance() {
		Coin balance = new Coin(0);
		for (Position position : this.positions) {
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

		return new EqualsBuilder().append(this.id, rhs.id).append(this.name, rhs.name).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).append(this.name).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("name", this.name).toString();
	}

}
