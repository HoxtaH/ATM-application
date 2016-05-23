package com.tyrellhoxter;

/**
 * Created by tyrellhoxter on 5/5/16.
 */
public class Savings extends BankAccounts {

    private String typeString = "Savings";

    public String getTypeString() {
        return typeString;
    }

    public Savings(long acctNum, String acctName,  Status sts){
        super(acctNum, acctName, sts);
    }


    }

