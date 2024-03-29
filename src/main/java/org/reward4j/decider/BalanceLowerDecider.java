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
package org.reward4j.decider;

import org.reward4j.RestrictionDecider;

/**
 * The {@code BalanceHigherDecider} is a {@link RestrictionDecider}
 * implementation deciding if the user's balance is lower than some reference
 * value.
 * 
 * @author hillger.t
 */
public class BalanceLowerDecider implements RestrictionDecider {

  public boolean decide(double userBalance, double value) {
    return userBalance < value;
  }
}
