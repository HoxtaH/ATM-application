package com.tyrellhoxter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tyrellhoxter on 5/2/16.
 */
public class BankAccounts {


    private long accountNum;
    private String name = "";
    private float Interest;
    private Status status;
    private boolean overdraftPrevention;
    private double interestRate;
    private double balance;
    Random random = new Random();
    private String typeString;



    public BankAccounts(long acctNum, String acctName, Status sts) {
        this.accountNum = acctNum;
        this.name = acctName;
        this.status = sts;
        balance = 0;
        overdraftPrevention = true;

    }

    public long getAccountNum() {
        return accountNum;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() { return name; }

    public void setName(String acctName) {
        name = acctName;
    }

    public Status getStatus() {
        return status;
    }

    public String getTypeString() {
        return typeString;
    }



    public void closeAccount(){
        if(getBalance() > 0){
            System.out.println("Bank account must balance must be at zero to close");
        } else{
            this.status = Status.CLOSED;
        }
    }
}
