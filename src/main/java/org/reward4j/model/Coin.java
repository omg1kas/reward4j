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
import java.math.BigInteger;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * {@code Coin} is equivalent to the design pattern <code>Money</code>
 * of <i>Martin Fowler</i>. {@code Coin} is a <code>ValueObject</code>, 
 * that is immutable after creation. Therefore no setters exist. 
 *
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class Coin implements Comparable<Coin>, Serializable {
	private static final long serialVersionUID = 3724649778476283564L;
	
	private BigInteger amount;

	protected Coin() {}

	public Coin(double amount) {
		this.amount = BigInteger.valueOf(Math.round(amount * 100));
	}

	public Coin(long amount) {
		this.amount = BigInteger.valueOf(amount * 100);
	}

	protected Coin(BigInteger amountInPennies) {
		this.amount = amountInPennies;
	}

	protected BigInteger getAmount() {
		return this.amount;
	}

	public Coin add(Coin c) {
		return createNewInstance(this.amount.add(c.amount));
	}

	public Coin subtract(Coin c) {
		return createNewInstance(this.amount.add(c.amount.negate()));
	}

	public Coin negate() {
		return createNewInstance(this.amount.negate());
	}

	public Coin multiply(double value) {
		return createNewInstance(this.amount() * value);
	}

	public Coin div(double value) {
		if (value > 0) {
			return createNewInstance(this.amount() / value);
		} else {
			return createNewInstance(this.amount);
		}
	}

	public double amount() {
		return this.amount.doubleValue() / 100;
	}

	public int compareTo(Coin coin) {
		return this.amount.compareTo(coin.amount);
	}

	public boolean greaterThan(Coin c) {
		return (this.compareTo(c) == 1);
	}

	public boolean lessThan(Coin c) {
		return (this.compareTo(c) == -1);
	}

	protected Coin createNewInstance(double amount) {
		return new Coin(amount);
	}

	protected Coin createNewInstance(BigInteger amount) {
		return new Coin(amount);
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
        
        Coin rhs = (Coin) obj;
        
        return new EqualsBuilder()
            .append(this.amount, rhs.amount)
            .isEquals();
	}

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(this.amount)
            .toHashCode(); 
    }

    @Override
	public String toString() {
		return new ToStringBuilder(this)
		    .append("amount", this.amount)
			.toString();
	}

}
