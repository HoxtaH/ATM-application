package com.tyrellhoxter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tyrellhoxter on 5/21/16.
 */
public class TransactionsSpec {

    @Test
    public void addCreditTest(){
        BankAccounts bankAccounts = new Savings(283487374, "Vince Carter", Status.OPEN);
        Transactions transactions = new Transactions();
        double expected = 35.50;
        transactions.addCredit(35.50, bankAccounts);
        double actual = bankAccounts.getBalance();
        Assert.assertEquals("The account should have 35.50", expected, actual, Math.ulp(.0001));
    }

    @Test
    public void deductDebitTest(){
        BankAccounts bankAccounts = new Savings(283487374,"Micheal Jordan", Status.OPEN);
        Transactions transactions = new Transactions();
        double expected = 15.50;
        transactions.addCredit(35.50, bankAccounts);
        transactions.deductDebit(20, bankAccounts);
        double actual = bankAccounts.getBalance();
        Assert.assertEquals("The acount should have 15.50", expected, actual, Math.ulp(.0001));
    }

    @Test
    public void transferFundsTest(){
        BankAccounts michaelJordansAccount = new Savings(283487374,"Micheal Jordan", Status.OPEN);
        BankAccounts michaelJordansAccount2 = new Savings(283487375,"Micheal Jordan", Status.OPEN);
        Transactions transactions = new Transactions();
        double expected = 100;
        transactions.addCredit(50, michaelJordansAccount);
        transactions.addCredit(50,michaelJordansAccount2);
        transactions.transferFunds(michaelJordansAccount,50,michaelJordansAccount2);
        double actual = michaelJordansAccount2.getBalance();
        Assert.assertEquals("Michael jordans second account should have 60 dollars", expected, actual, Math.ulp(.0001));
    }
}
