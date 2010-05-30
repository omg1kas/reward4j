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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.reward4j.model.User;

/**
 * Indicates whether a type annotated with this annotation shall be analyzed using the
 * {@link PayableInterceptor}, so that a {@link User} can be rewarded.
 * 
 * @author hillger.t
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Restrictable {

  /**
   * Describes the amount of the reward of the action's execution.
   * 
   * @return amount of the reward
   */
  double coins() default 0.0;
  
  /**
   * Describes how a validation of a restrictable action should be performed. Normaly
   * the amount should be higher. But other situations could maybe also occur.
   * 
   * @return
   */
  Class<? extends RestrictionDecider> decider() default BalanceHigherDecider.class;
}
