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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * A {@code RateableAction} describes an action, that will be payed for, when 
 * the action is executed. An action is always executed by an {@link User}.
 *   
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
@Entity
public class RateableAction implements Serializable {
    private static final long serialVersionUID = -2900499255363027395L;
    
    // Unique identifier.
  	@Id
  	@Column(name = "actionid")
  	@GeneratedValue(strategy = GenerationType.AUTO)
  	private long id;
    
		// name of the rateable action that is also used as unique identifier
		@Column(nullable = false)
		private String name;
		
		public RateableAction() {}
		
		public RateableAction(final String name) {
	    this.name = name;
    }
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		@Override
		public String toString() {
		    return new ToStringBuilder(this)
		        .append("name", this.name)
		        .toString();
		}
		
		@Override
		public int hashCode() {
		    return new HashCodeBuilder()
		        .append(this.name)
		        .toHashCode(); 
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
		    
		    RateableAction rhs = (RateableAction) obj;
		    
		    return new EqualsBuilder()
		        .append(this.name, rhs.name)
		        .isEquals();
		}

}
