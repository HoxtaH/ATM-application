package com.tyrellhoxter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by tyrellhoxter on 5/20/16.
 */
public class User {

     HashMap<String, ArrayList<BankAccounts>> MasterBankAccountList = new HashMap<>();
    ArrayList<BankAccounts> Checkings = new ArrayList<>();
    ArrayList<BankAccounts> Savings = new ArrayList<>();
    ArrayList<BankAccounts> Investment = new ArrayList<>();
    ArrayList<BankAccounts> Commercial = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public String userPassword;
    public String userNameId;
    Random accountNumberGenerator = new Random();

    public User( String name, String password){
        this.userNameId = name;
        this.userPassword = password;
    }

    public void addCheckingAccount(){
        Checkings.add(new Checking(accountNumberGenerator.nextLong(),userNameId,Status.OPEN));
        MasterBankAccountList.put("Checking", Checkings);
    }

    public void addSavingsAccount(){
        Savings.add(new Savings(accountNumberGenerator.nextLong(), userNameId, Status.OPEN));
        MasterBankAccountList.put("Savings", Savings);
    }

    public void addInvestmentAccount(){
        Investment.add(new Investment(accountNumberGenerator.nextLong(), userNameId, Status.OPEN));
        MasterBankAccountList.put("Investment", Investment);
    }

    public void addCommercialAccount(){
        Investment.add(new Commercial(accountNumberGenerator.nextLong(), userNameId, Status.OPEN));
        MasterBankAccountList.put("Commercial", Commercial);
    }


    public static void inputPrompt(String message){
        System.out.println(message);
    }

    public static double inputDoublePrompt(String message){
        inputPrompt(message);
        return sc.nextDouble();
    }

    public static int inputIntPrompt(String message){
        inputStringPrompt(message);
        return sc.nextInt();
    }


    public static String inputStringPrompt(String message){
        inputPrompt(message);
        return sc.next();
    }
}
