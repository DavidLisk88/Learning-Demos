package Fixers;

import java.util.Scanner;

public class StringSplitting1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // prompt for first middle and last name

        System.out.println("Please enter your full name.");
        System.out.println("Format: First, Last OR First, Middle, Last and Suffix (if applicable)");

        // fullName variable will store users first middle and last name.
        String fullName = userInput.nextLine().trim();

        // Split spaces in between first middle and last name.
        String[] nameParts = fullName.split(" ");

        // use if statements to print a result based on how the user has input their name.
        if (nameParts.length == 2){ // this is stating that if the user inputs 2 characters in nameParts (first middle and last).
            // split the parts of nameParts into first and last name.
            String firstName = nameParts[0]; // zero is the first part of name parts. which is the users first name.
            String lastName = nameParts[1];
            // display the first and last name as the users input and the middle name as none or N/A.
            System.out.println("First Name: " + firstName);
            System.out.println("Middle Name: N/A");
            System.out.println("Last Name: " + lastName);
        }
        else if (nameParts.length == 3){ // this is determining if the user input 3 names for nameParts.
            // redefine how the parts of the name is split
            String firstName = nameParts[0];
            String middleName = nameParts[1];
            String lastName = nameParts[2];
            // print out name in parts, but this time the output will include middle name.
            System.out.println("First Name: " + firstName);
            System.out.println("Middle Name: " + middleName);
            System.out.println("Last Name: " + lastName);
        }

        else if (nameParts.length == 4) { // this is determining if the user input 3 names for nameParts.
            // redefine how the parts of the name is split
            String firstName = nameParts[0];
            String middleName = nameParts[1];
            String lastName = nameParts[2];
            String suffix = nameParts[3];
            // print out name in parts, but this time the output will include middle name.
            System.out.println("First Name: " + firstName);
            System.out.println("Middle Name: " + middleName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Suffix: " + suffix);
        }

        else {
            System.out.println("Please enter name in correct format:\nFirst, Last OR First, Middle, Last and Suffix (if applicable)");
        }


































    }
}

