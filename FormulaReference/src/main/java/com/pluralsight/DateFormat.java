package com.pluralsight;

// import utilities

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class DateFormat {
    public static void main(String[] args) {

        // set scanner variable for input
        Scanner userInput = new Scanner(System.in);

        // create a variable for a date formatter. this formatter is how the user should input the date.
        DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // this formatter outputs the date to omit the zeros from the month and day
        //  DateTimeFormatter correctFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

        // ask user questions and allow for input. set variables.
        // set name variable in a string.
        String name = "";

        // Do not allow user to input only one name.
        while (name.split(" ").length < 2) {
            System.out.println("What is your first and last name: ");
            name = userInput.nextLine();

            // if the user types only one name, then process an error message.
            if (name.split(" ").length < 2) {
                System.out.println("Please enter both first and last name.");
            }
        }

        // split the string by the space.
        String[] nameParts = name.split(" ");

        // define parts of each name
        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];

        // ask user for date of the show.
        System.out.println("What is the date of the show (MM/dd/yyyy): ");
        String dateInput = userInput.nextLine();

        // convert their date into the correct date format.
        LocalDate dateOfShow = LocalDate.parse(dateInput, formatInput);

        // ask how many tickets
        System.out.println("How many tickets will you need?: ");
        int numberOfTickets = userInput.nextInt();

        // create a ternary statement for tickets vs. ticket
        String ticketWord = (numberOfTickets == 1) ? "ticket" : "tickets";

        // this is just for organization
        System.out.println("----------------------------");

        // print out the final statement.
        System.out.println(numberOfTickets + " " + ticketWord +  "\nFor " + dateOfShow + "\nUnder: " + lastName + ", " + firstName);

        userInput.close();

























    }
}

