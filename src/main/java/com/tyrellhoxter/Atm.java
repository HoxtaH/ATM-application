package com.tyrellhoxter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by tyrellhoxter on 5/21/16.
 */
public class Atm {

    Database db = new Database();
    static Scanner sc = new Scanner(System.in);
    public String userPassword;
    public String userNameId;
    public String accountLoginName;
    public String accountLoginPassword;

    Random accountNumberGenerator = new Random();

    public static void welcomeMessage(){
        User.inputPrompt("Welcome To The House Of Tyrell Bank");
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

    public void createNewUserAccount(){
        inputStringPrompt("Please enter a User Account Name");
        userNameId = sc.next();
        inputStringPrompt("Please enter a Password for Account");
        userPassword = sc.next();
        Database.userDataMap.put(userNameId, new User(userNameId, userPassword));
        createNewBankAccount(userNameId);
        inputPrompt("Thank you For allowing The House Of Tyrell Bank to help you with all of your financial needs " + "\n" +
                "Your account name is " + userNameId + " and account password is " + userPassword + "Please do not forget your password " + "\n");
    }

    public void createNewBankAccount(String userNameId){
       String choices = inputStringPrompt("Which Type of Bank account would you like to open With us?  CHECKING | SAVINGS | COMMERCIAL | INVESTMENT");

        switch (choices.toUpperCase()){
           case "CHECKING" :
               Database.userDataMap.get(userNameId).addCheckingAccount();
               break;
           case "SAVINGS" :
                Database.userDataMap.get(userNameId).addSavingsAccount();
               break;
            case "COMMERCIAL":
                 Database.userDataMap.get(userNameId).addCommercialAccount();
                break;
            case "INVESTMENT":
                 Database.userDataMap.get(userNameId).addInvestmentAccount();
                break;
            default: inputPrompt("Sorry.  This is not an option at The House Tyrell Bank");
       }
    }

    public void logIntoExistingAccount(){
       accountLoginName = inputStringPrompt("Please enter Name ");
        if(accountLoginName.equals(Database.userDataMap.get(accountLoginName))){
            accountLoginPassword = inputStringPrompt("Please enter Your password");
            if(accountLoginPassword.equals(Database.userDataMap.containsValue(accountLoginPassword))){

            }
        }
    }

    public void atmRunApplication(){
       welcomeMessage();

        int choice = inputIntPrompt("Please input from our list of available operations : " + "\n" +
        "1 : Create New Account | 2: Log into Existing Account ");
        switch (choice){
            case 1 : createNewUserAccount();
                break;
            case 2 :
        }
    }
}
