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
