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

/**
 * {@code CoinTest} tests the behaviour of {@link Coin}.
 * 
 * @author Peter Kehren <mailto:kehren@eyeslide.de>
 */
public class CoinTest {
    
    @Test
    public void testAmount() {
        Coin coins = new Coin(10.0);
        assertEquals(10.0, coins.amount(), 0);
        
        coins = new Coin(-10.0);
        assertEquals(-10.0, coins.amount(), 0);
        
        coins = new Coin(5);
        assertEquals(5, coins.amount(), 0);
    }
    
    @Test
    public void testAdd() {
        Coin coins = new Coin(5);
        coins = coins.add(new Coin(3));
        assertEquals(8, coins.amount(), 0);
    }
    
    @Test
    public void testSubtract() {
        Coin coins = new Coin(5);
        coins = coins.subtract(new Coin(3));
        assertEquals(2, coins.amount(), 0);
    }
    
    @Test
    public void testNegate() {
        Coin coins = new Coin(5);
        coins = coins.negate();
        assertEquals(-5, coins.amount(), 0);
    }
    
    @Test
    public void testMultiply() {
        Coin coins = new Coin(5);
        coins = coins.multiply(2.5);
        assertEquals(5*2.5, coins.amount(), 0);
    }
    
    @Test
    public void testDiv() {
        Coin coins = new Coin(10);
        coins = coins.div(2);
        assertEquals(10 / 2, coins.amount(), 0);
        
        coins = new Coin(5);
        coins = coins.div(0);
        assertEquals(5, coins.amount(), 0);
    }
    
    @Test
    public void testGreaterThan() {
        Coin coins5 = new Coin(5);
        Coin coins6 = new Coin(6);
        
        assertTrue(coins6.greaterThan(coins5));
        assertFalse(coins5.greaterThan(coins6));
    }

    @Test
    public void testLesserThan() {
        Coin coins5 = new Coin(5);
        Coin coins6 = new Coin(6);
        
        assertTrue(coins5.lessThan(coins6));
        assertFalse(coins6.lessThan(coins5));
    }
    
    @Test
    public void testEquals() {
        Coin coinsA = new Coin(5);
        Coin coinsB = new Coin(5);
        Coin coinsC = new Coin(4);
        
        assertTrue(coinsA.equals(coinsB));
        assertTrue(coinsB.equals(coinsA));
        assertTrue(coinsA.equals(coinsA));
        
        assertFalse(coinsA.equals(coinsC));
        
        String notACoin = new String("notACoin");
        assertFalse(coinsA.equals(notACoin));
    }
    
    @Test
    public void testHashCode() {
        Coin coins = new Coin(4);
        int hashCode = coins.hashCode();
        coins.div(2);
        assertEquals(hashCode, coins.hashCode());
        
        coins.subtract(new Coin(1));
        assertEquals(hashCode, coins.hashCode());
        
        coins.add(new Coin(5));
        assertEquals(hashCode, coins.hashCode());
    }
}
