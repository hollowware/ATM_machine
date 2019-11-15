/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bank.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author IX Hero
 */
public class Account {
    
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    
    private int customerNumber;
    private int pinCode;
    private double balance;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public int setPinCode(int pinCode) {
        this.pinCode = pinCode;
        return pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void getWithdraw() {
        System.out.println("Checking account balance: " + moneyFormat.format(balance) + "\n");
        System.out.println("Amount you want to withdraw from Your Account: ");
        double amount = input.nextDouble();
        if ((balance - amount) >= 0) {
            calcWithdrawBalance(amount);
            System.out.println("Your new balance is " + moneyFormat.format(balance) + "\n");
        } else {
            System.out.println("Balance can't be negative");
        }
    }
    
    public void getDeposit() {
        System.out.println("Checking account balance: " + moneyFormat.format(balance) + "\n");
        System.out.println("Amount you want to deposit into Your Account: ");
        double amount = input.nextDouble();
        if ((balance + amount) >= 0) {
            calcDepositBalance(amount);
            System.out.println("Your new balance is " + moneyFormat.format(balance) + "\n");
        } else {
            System.out.println("Balance can't be negative");
        }
    }

    private double calcWithdrawBalance(double amount) {
        balance -= amount;
        return balance;
    }

    private double calcDepositBalance(double amount) {
        balance += amount;
        return balance;
    }
    
}
