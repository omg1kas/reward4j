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
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The {@code Position} represents a position within a user's {@link Account}. After 
 * creation a {@code Position} is immutable.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 * @author hillger.t
 */
@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = -4937858211810042799L;

	// Unique identifier.
	@Id
	@Column(name = "itemid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	// Date of insertion. Should always be sysdate and mandatory.
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertionDate = new Date();

	// Points to the position's {@link Account}.
	@ManyToOne(optional = false)
	@JoinColumn(name = "accountid")
	private Account account;

	// Rate for this account position according to the underlying action.
	private double balance;

	// The origin {@link RateableAction} that forces this item position
	@OneToOne(targetEntity = RateableAction.class, optional = false)
	@JoinColumn(name = "actionid")
	private RateableAction action;
	
	public Item() {}

	public Item(RateableAction action, Coin balance) {
		if (null == action)
			throw new IllegalArgumentException("action must not be null");
		if (null == balance)
			throw new IllegalArgumentException("balance must not be null");

		this.id = UUID.randomUUID().getMostSignificantBits();
		this.action = action;
		this.balance = balance.amount();
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public RateableAction getAction() {
		return action;
	}

	public Date getInsertionDate() {
		return (Date) insertionDate.clone();
	}

	public Coin getValue() {
		return new Coin(this.balance);
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

		Item rhs = (Item) obj;

		return new EqualsBuilder().append(this.id, rhs.id).append(this.action, rhs.action).append(this.balance, rhs.balance).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).append(this.action).append(this.balance).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.id).append("action", this.action).append("balance", this.balance).append("insertionDate", this.insertionDate).toString();
	}

}
