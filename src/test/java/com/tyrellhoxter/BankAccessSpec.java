package com.tyrellhoxter;
import com.tyrellhoxter.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by tyrellhoxter on 5/2/16.
 */

public class BankAccessSpec {
    public double delta = 1e-15;
    @Test
    public void assignTest(){
        BankAccounts bankAccounts = new BankAccounts(283487374,"Mike Jones", Status.OPEN);

        long expected = 283487374;
        long actual = bankAccounts.getAccountNum();
        assertEquals("Test expected result is COMMERCIAL", expected, actual);
    }

    @Test
    public void balanceTest(){
        BankAccounts bankAccounts = new BankAccounts(263748557, "Mikes Jones",Status.OPEN);
        double actual = bankAccounts.getBalance();
        double expected = 0;
        Assert.assertEquals("The expected value should be 5", actual, expected, delta);
    }

    @Test
    public void setgetNameTest(){
        BankAccounts bankAccounts = new BankAccounts(283487374,"Donald Trump", Status.OPEN);
        String actual = bankAccounts.getName();
        String expected = "Donald Trump";
        Assert.assertEquals("Expected should Be HalleBerry", actual, expected);
    }

    @Test
    public void stringBuilderTest(){
        Transactions transactions = new Transactions();
        BankAccounts bankAccounts = new Savings(283487374, "Cloud Strife", Status.OPEN);
        String expected = "Amount: 14.0 Transaction Type: Debit Account Type: Savings Date: Thu May 19 17:06:06 EDT 20160";
         Ledger.transactionRecords(bankAccounts.getAccountNum(),transactions.debit,14,bankAccounts,transactions.date);
       // Assert.assertEquals("The expected should be a readable string builder consisting of dates and transactions",expected,actual );
    }





}

