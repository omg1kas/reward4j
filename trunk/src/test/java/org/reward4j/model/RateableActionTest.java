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

import static org.junit.Assert.*;

import org.junit.Test;

public class RateableActionTest {

    @Test
    public void testGetName() {
        RateableAction action = new RateableAction("testaction");
        assertEquals("testaction", action.getName());
    }
    
    @Test
    public void testEquals() {
        RateableAction action1 = new RateableAction("action");
        RateableAction action2 = new RateableAction("action2");
        RateableAction action3 = new RateableAction("action");
        
        assertEquals(action1, action3);
        assertFalse(action1.equals(action2));
    }

}
