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
package org.reward4j;

/**
 * {@code RestrictionDecider} implementations decide on base of some {@link user}'s account balance.
 * 
 * @author hillger.t
 */
public interface RestrictionDecider {
  
  /**
   * Some decision results in a boolean value. 
   * 
   * @param userBalance the user's balance
   * @param value the reference value for validating
   * @return boolean
   */
  //TODO: DICUSS: Is return type boolean okay or should it be void with some exception thrown.
  boolean decide(double userBalance, double value);
}
