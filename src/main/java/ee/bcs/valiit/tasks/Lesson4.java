package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
        // Store account nr as a key and account balance as value
    static HashMap<String, BigDecimal> accountBalanceMap = new HashMap<>();
    static int accountNumberInt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("Pleas enter command: ");
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("exit")) {
                break;
            }

            else if (line.equalsIgnoreCase("createAccount")) {
                createAccount();
            }

            else if (line.equalsIgnoreCase("getBalance")) {
                getBalance();
            }

            else if (line.equalsIgnoreCase("depositMoney")) {
                depositMoney();
            }

            else if (line.equalsIgnoreCase("withdrawMoney")) {
                withdrawMoney();
            }

            else if (line.equalsIgnoreCase("transfer")) {
                transfer();
            }


            else {
                System.out.println("Unknown command");
            }
        }
    }

    public static void createAccount () {
        // TODO 1
        // Add command: "createAccount ${accountNr}"
        // this has to store accountNr with 0 balance
        accountNumberInt++;

        String accountNumberString = Integer.toString(accountNumberInt);
        accountBalanceMap.put(accountNumberString, new BigDecimal(0));

        System.out.println("Account automatically created!");
        System.out.println("Your account number is: " + accountNumberString);
    }

    public static void getBalance() {
        // TODO 2
        // Add command: "getBalance ${accountNr}"
        // this has to display account balance of specific acount
        Scanner getBalanceScanner = new Scanner(System.in);
        System.out.print("Please enter account number: ");
        String requestedAccount = getBalanceScanner.nextLine();

        System.out.println();
        System.out.println("Your account balance is: " + accountBalanceMap.get(requestedAccount));
    }

    public static void depositMoney() {
        // TODO 3
        // Add command: "depositMoney ${accountNr} ${amount}
        // this has to add specified amount of money to account
        // You have to check that amount is positive number
        String requestedAccount = "";
        String depositedMoney = "";
        Scanner depositMoneyScanner = new Scanner(System.in);

        System.out.print("Please enter account number: ");
        requestedAccount = depositMoneyScanner.nextLine();

        System.out.print("Please enter deposit amount: ");
        depositedMoney = depositMoneyScanner.nextLine();

        BigDecimal balanceVar = new BigDecimal(String.valueOf(accountBalanceMap.get(requestedAccount)));
        BigDecimal depositVar = new BigDecimal(String.valueOf(depositedMoney));

        if (Integer.parseInt(depositedMoney) >= 0) {
            accountBalanceMap.put(requestedAccount, balanceVar.add(depositVar));

            System.out.println("Deposited amount: " + depositedMoney);
            System.out.println("New balance: " + accountBalanceMap.get(requestedAccount));
        }
        else {
            System.out.println("Sorry, mate... can't deposit negative numbers");
        }

    }

    public static void withdrawMoney () {
        // TODO 4
        // Add command: "withdrawMoney ${accountNr} ${amount}
        // This has to remove specified amount of money from account
        // You have to check that amount is positive number
        // You may not allow this transaction if account balance would become negative
        String requestedAccount = "";
        String withdrawnMoney = "";
        Scanner withdrawMoneyScanner = new Scanner(System.in);

        System.out.print("Please enter account number: ");
        requestedAccount = withdrawMoneyScanner.nextLine();

        System.out.print("Please enter withdraw amount: ");
        withdrawnMoney = withdrawMoneyScanner.nextLine();

        BigDecimal balanceVar = new BigDecimal(String.valueOf(accountBalanceMap.get(requestedAccount)));
        BigDecimal withdrawVar = new BigDecimal(String.valueOf(withdrawnMoney));

        if (Integer.parseInt(withdrawnMoney) >= 0 && balanceVar.compareTo(withdrawVar) > 0) {
            accountBalanceMap.put(requestedAccount, balanceVar.subtract(withdrawVar));

            System.out.println("Withdrawn amount: " + withdrawnMoney);
            System.out.println("New balance: " + accountBalanceMap.get(requestedAccount));
        }
        else {
            System.out.println("Sorry, mate... can't withdraw negative numbers and you must have enough money!");
        }
    }

    public static void transfer () {
        // TODO 5
        // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
        // This has to remove specified amount from fromAccount and add it to toAccount
        // Your application needs to check that toAccount is positive
        // And from account has enough money to do that transaction
        String yourAccount = "";
        String receiverAccount = "";
        String transferredMoney = "";
        Scanner transferMoneyScanner = new Scanner(System.in);

        System.out.print("Please enter Your account number: ");
        yourAccount = transferMoneyScanner.nextLine();

        System.out.print("Please enter receiver account number: ");
        receiverAccount = transferMoneyScanner.nextLine();

        System.out.print("Please enter transfer amount: ");
        transferredMoney = transferMoneyScanner.nextLine();

        BigDecimal yourBalanceVar = new BigDecimal(String.valueOf(accountBalanceMap.get(yourAccount)));
        BigDecimal receiverBalanceVar = new BigDecimal(String.valueOf(accountBalanceMap.get(receiverAccount)));
        BigDecimal transferVar = new BigDecimal(String.valueOf(transferredMoney));

        if (Integer.parseInt(transferredMoney) >= 0 && yourBalanceVar.compareTo(transferVar) > 0) {

            accountBalanceMap.put(yourAccount, yourBalanceVar.subtract(transferVar));
            accountBalanceMap.put(receiverAccount, receiverBalanceVar.add(transferVar));

            System.out.println("Transfer was successful!");
        }
        else {
            System.out.println("Sorry, mate... you cant transfer negative amount and you must have enough money!");
        }
    }
}
