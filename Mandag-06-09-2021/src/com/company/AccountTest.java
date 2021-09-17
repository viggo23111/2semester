package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account accountTest = new Account("Test",100);

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Test",accountTest.getName());

    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        assertEquals(100,accountTest.getBalance());
    }

    @Test
    void testInsert() {
        assertEquals(213,accountTest.insert(113));
    }

    @Test
    void testInsertNegative() {
        assertEquals(100,accountTest.insert(-1000));
    }

    @Test
    void testWithdraw() {
        assertEquals(50,accountTest.withdraw(50));
    }
}