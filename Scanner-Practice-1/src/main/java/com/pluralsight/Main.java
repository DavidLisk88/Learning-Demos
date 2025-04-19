package com.pluralsight;
import java.rmi.dgc.Lease;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        double leasePrice = 100.00;
        double exclusivePrice = 300.00;
        System.out.println("Choose your License:\nLease or Exclusive (Enter L or E)");
        String userChoice = userInput.nextLine().toLowerCase();

        int howMany;

        do {
            System.out.println("How many would you like?: ");
            while (!userInput.hasNextInt()){
                System.out.println("Invalid Input. Please Try again.");
                userInput.next();
            }
            howMany = userInput.nextInt();
            if (howMany <= 0) {
                System.out.println("Not a valid input. Please enter a number greater than zero.");
            }
        } while (howMany <=0);
        switch (userChoice) {
            case "L":
                System.out.println("Your total is $" + howMany * leasePrice);
                break;
            case "E":
                System.out.println("Your total is: $" + howMany * exclusivePrice);
                break;
            case "lemon":
                System.out.println("Lemons are sour!");
                break;
            default:
                System.out.println("Invalid input.");
        }











      /*  if (userChoice.equalsIgnoreCase("L")){
            System.out.printf("Your lease price is $%.2f. Would you like to add another lease or exclusive? (Y/N): ", leasePrice);
            userChoice = userInput.nextLine();
            if (userChoice.equalsIgnoreCase("y")){
                System.out.println("Lease or Exclusive? (L/E)");
                userChoice = userInput.nextLine();
                System.out.println("How many would you like?");
                int howMany = userInput.nextInt();
                if (userChoice.equalsIgnoreCase("L")) {
                    System.out.println("Your total is $" + howMany * leasePrice);
                } else if (userChoice.equalsIgnoreCase("e")) {
                    System.out.println("Your total is $" + howMany * exclusivePrice);
                }
                else {
                    System.out.println("Invalid Input. Please try again.");
                }
            } else if (userChoice.equalsIgnoreCase("N")) {
                System.out.println("Your total is $" + leasePrice);
            }
        }

       */







































    }
}