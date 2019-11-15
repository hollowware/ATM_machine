/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bank.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author IX Hero
 */
public class Options extends Account {

    int selection;
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> credentials = new HashMap<>();

    public void getLogin() {
        int x = 1;
        do {
            try {
                credentials.put(12, 12);
                credentials.put(15, 15);
                System.out.println("Welcome to XXX ATM");
                System.out.print("Please enter customer number: ");
                setCustomerNumber(input.nextInt());
                System.out.print("Please enter pin code: ");
                setPinCode(input.nextInt());
                System.out.println();
            } catch (Exception e) {
                System.out.println("\n" + "Wrong input, only numbers please." + "\n");
                x = 2;
            }
            for (Entry<Integer, Integer> entry : credentials.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinCode()) {
                    chooseAcc();
                }
            }
            System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
        } while (x == 1); 
    }
    
    public void chooseAcc() {
        System.out.println("Choose acc bellow: ");
        System.out.println("You have nothing to choose from. Press \"ENTER\" to continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getMenu();
    }

    public void getMenu() {
        System.out.println("Welcome, please choose option bellow: ");
        System.out.println("Press 1 - for checking current balance.");
        System.out.println("Press 2 - to withdraw funds");
        System.out.println("Press 3 - to deposit funds");
        System.out.println("Prees 4 - to exit");
        selection = input.nextInt();
        switch(selection) {
            case 1:
                System.out.println("Your current balance is: " + moneyFormat.format(getBalance()) + "\n");
                getMenu();
                break;
            case 2:
                getWithdraw();
                getMenu();
                break;
            case 3:
                getDeposit();
                getMenu();
                break;
            case 4:
                System.out.println("Thank you and bye bye.");
                System.exit(0);
            default:
                System.out.println("\n" + "Bad choice, try again" + "\n");
                getMenu();
        }
    }

}
