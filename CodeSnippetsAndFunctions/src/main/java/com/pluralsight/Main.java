package com.pluralsight;

import java.util.Scanner;

public class Main {

    public String userInputName () {
        String userName = "";
        boolean confirmed = false;
        Scanner scanner = new Scanner(System.in);
        while (!confirmed) {
            System.out.println("What is your name?");
            System.out.println("Enter: ");
            userName = scanner.nextLine().toLowerCase().trim();

            // Confirm Name -------------------------------------------------------------------------------------------
            System.out.println("\nIs [" + nameToPartsToName(userName)+ "] correct? (Y) or (N).");
            System.out.println("(Y)es");
            System.out.println("(N)o");
            char isRight = scanner.nextLine().toUpperCase().charAt(0);

            if (isRight == 'Y') {
                break;
            } else if (isRight == 'N') {
                continue;
            } else {
                System.out.println("-------------------------------");
                System.out.println("Invalid Input: DO OVER");
                System.out.println("-------------------------------");
            }
        }


        return userName;
    }

    public static String nameToPartsToName (String name) {
        String [] nameParts = name.trim().split(" ");

        String fullName = "";

        if (nameParts.length == 3) {
            String firstName = nameParts [0].toLowerCase().substring(0, 1).toUpperCase() + nameParts[0].substring(1);
            String middleName = nameParts [1].toLowerCase().substring(0, 1).toUpperCase() + nameParts[1].substring(1);;
            String lastName = nameParts [2].toLowerCase().substring(0, 1).toUpperCase() + nameParts[2].substring(1);;
            fullName = firstName + " " + middleName + " " + lastName;
        } if (nameParts.length == 2) {
            String firstName = nameParts [0].toLowerCase().substring(0, 1).toUpperCase() + nameParts[0].substring(1);
            String lastName = nameParts [1].toLowerCase().substring(0, 1).toUpperCase() + nameParts[1].substring(1);;
            fullName = firstName + " " + lastName;
        } if (nameParts.length == 1) {
            String firstName = nameParts [0].toLowerCase().substring(0, 1).toUpperCase() + nameParts[0].substring(1);
            fullName = firstName;
        }
        return fullName;
    }

























}