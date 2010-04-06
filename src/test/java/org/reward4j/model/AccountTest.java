package org.reward4j.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class AccountTest {

    
    @Test
    public void testGetBalance() {
        RateableAction action = new RateableAction("action");
        Position position1 = new Position(action, new Coin(4));
        Position position2 = new Position(action, new Coin(6));
        
        Account account = new Account("testaccount");
        account.addPosition(position1);
        account.addPosition(position2);
        
        assertEquals(new Coin(10), account.getBalance());
        
        Account account2 = new Account("testaccount2");
        assertEquals(new Coin(0), account2.getBalance());
    }
    
    public void testEquals() {
        Account account1a = new Account("testaccount1");
        Account account1b = new Account("testaccount1");
        Account account2 = new Account("testaccount1");
        
        assertEquals(account1a, account1b);
        assertFalse(account1a.equals(account2));
    }

}
