package com.tyrellhoxter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tyrellhoxter on 5/19/16.
 */
public class Ledger {
    private static int transactionNumber = 0;
    static ArrayList<String> transactionRecord = new ArrayList<String>();
    Date date = new Date();

    public static void transactionRecords(long accountNumber,String transactionType, double transaction, BankAccounts accountType, Date dateStamp){

        transactionRecord.add("Destination Account Number: "+ accountNumber +" Amount: " + transaction + " Transaction Type: " + transactionType  +  " Account Type: " + accountType.getTypeString() + " Date: " + dateStamp.toString() + transactionNumber);
    }

}
