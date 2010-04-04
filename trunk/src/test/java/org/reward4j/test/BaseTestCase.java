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

package org.reward4j.test;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * The {@code BaseTestCase} is the base for all test cases within the 
 * reward4j framework.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public abstract class BaseTestCase extends AbstractDependencyInjectionSpringContextTests {
    protected final Logger LOG = Logger.getLogger(getClass());

    protected ResourceBundle rb;

    protected String[] getConfigLocations() {
      setAutowireMode(AUTOWIRE_BY_NAME);
      return new String[] {
          "classpath*:/applicationContext.xml"
      };
    }

    public BaseTestCase() {
      this.loadResourceBundle();
    }

    public BaseTestCase(final String name) {
      super(name);
      this.loadResourceBundle();
    }

    private void loadResourceBundle() {
      // Since a ResourceBundle is not required for each class, just
      // do a simple check to see if one exists
      String className = this.getClass().getName();

      try {
        rb = ResourceBundle.getBundle(className);
      } catch (MissingResourceException mre) {
        LOG.warn("No resource bundle found for '" + className + "'");
      }
    }

}
