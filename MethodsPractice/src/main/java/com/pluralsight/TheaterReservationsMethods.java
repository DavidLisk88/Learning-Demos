package com.pluralsight;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class TheaterReservationsMethods {


    public static void main(String[] args) {

        // set scanner variable for input.
        Scanner userInput = new Scanner(System.in);

        String name2 = getname2(userInput);
        // split the name by white space.
        String[] nameParts = name2.split(" ");
        // define the nameParts index
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        System.out.println("What is the date of the show? (MM/dd/yyyy): ");
        String dateInput = getDate(userInput);
        DateTimeFormatter correctDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateOfShow = LocalDate.parse(dateInput, correctDate);

        int ticketCount = getTicketCount(userInput);

        getShowInfo(dateOfShow, ticketCount, lastName, firstName);

        userInput.close();
    }


    // method for name input
    public static String getname2(Scanner userInput) {
        String name2 = "";

        // Do not allow user to input only one name.
        while (name2.split(" ").length < 2) {
            System.out.println("What is your first and last name: ");
            name2 = userInput.nextLine();

            // if the user types only one name, then process an error message.
            if (name2.split(" ").length < 2) {
                System.out.println("Please enter both first and last name.");
            }
        }
        // use return name2 since the input will return to the main method with a valid input of the name.
        return name2;
    }

    // method for date input
    public static String getDate(Scanner userInput) {
        // return the date input.
        return userInput.nextLine();
    }


    // method for ticket gathering
    public static int getTicketCount(Scanner userInput) {
        int ticketCount;

        // Loop until a valid ticket count is provided
        while (true) {
            System.out.print("How many tickets would you like to reserve? ");
            if (userInput.hasNextInt()) {
                ticketCount = userInput.nextInt();
                // Consume the leftover newline character
                userInput.nextLine();

                if (ticketCount >= 1) {
                    break;  // Valid input, break the loop
                } else {
                    System.out.println("You must reserve at least one ticket.");
                }
            } else {
                System.out.println("Please enter a valid number for the ticket count.");
                userInput.nextLine();  // Consume the invalid input to avoid infinite loop
            }
        }
        return ticketCount;
    }

    // Method to display the show information
    public static void getShowInfo(LocalDate dateOfShow, int ticketCount, String lastName, String firstName) {
        System.out.println("------------------------------");

        DateTimeFormatter correctDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = dateOfShow.format(correctDate);

        System.out.println(ticketCount + " " + (ticketCount == 1 ? "ticket" : "tickets"));
        System.out.println("For: " + formattedDate);
        System.out.println("Under: " + lastName + ", " + firstName);
    }
}
