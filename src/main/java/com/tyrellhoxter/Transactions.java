package com.tyrellhoxter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tyrellhoxter on 5/2/16.
 */
public class Transactions {
    public String credit = "Credit";
    public String debit = "Debit";
    Date date = new Date();
    private int transactionNumber = 0;

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void addCredit(double val1, BankAccounts bankAccounts) {
        double myBalance = bankAccounts.getBalance();
        bankAccounts.getStatus();
        if (bankAccounts.getStatus() == Status.FROZEN || bankAccounts.getStatus() == Status.CLOSED || bankAccounts.getStatus() == Status.OFAC) {
            System.out.println("Declined, Balance can not be retrieved, Please contact the Bank of T");
        } else {
            bankAccounts.setBalance(myBalance + val1);
            transactionNumber++;
            Ledger.transactionRecords(bankAccounts.getAccountNum() ,credit, val1, bankAccounts,date);
        }
    }

    public void deductDebit(double val2, BankAccounts bankAccounts) {
        double myBalance = bankAccounts.getBalance();
        bankAccounts.getStatus();
        if (bankAccounts.getStatus() == Status.FROZEN || bankAccounts.getStatus() == Status.CLOSED || bankAccounts.getStatus() == Status.OFAC) {
            System.out.println("Bank Account Frozen, Balance can not be retrieved");
        } else if(myBalance - val2 < 0){
            System.out.println("Transaction Declined");
        }
        else {
            bankAccounts.setBalance(myBalance - val2);
           transactionNumber++;
            Ledger.transactionRecords(bankAccounts.getAccountNum() ,debit, val2,bankAccounts,date);
        }
    }

    public void transferFunds(BankAccounts bankAccounts,double transferAmount,BankAccounts otherBankAccount){
        String accountName1 = bankAccounts.getName();
        String accountName2 = otherBankAccount.getName();
        if(accountName1.equals(accountName2)){
            deductDebit(transferAmount, bankAccounts);
            addCredit(transferAmount ,otherBankAccount);

        }else {
            System.out.println("Transfer between accounts can not happen at this time");
        }
    }
}
