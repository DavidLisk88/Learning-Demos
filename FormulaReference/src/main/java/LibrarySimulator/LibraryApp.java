package LibrarySimulator;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) throws InterruptedException {
        // We create a user input scanner inside the main method.
        Scanner userInput = new Scanner(System.in);
        // Create an Array. This makes the list of 20 books.
        // Use the class "Book" to split the books
        Book[] availableBooks = new Book[20];

        // I took the time to add a bunch of different books with different ID's and ISBN numbers.
        availableBooks[0] = new Book(1, "ISBN: 1001", "Harry Potter");
        availableBooks[1] = new Book(2, "ISBN: 1002", "To Kill a Mockingbird");
        availableBooks[2] = new Book(3, "ISBN: 1003", "Pride and Prejudice");
        availableBooks[3] = new Book(4, "ISBN: 1004", "The Lord of the Flies");
        availableBooks[4] = new Book(5, "ISBN: 1005", "The Hobbit");
        availableBooks[5] = new Book(6, "ISBN: 1006", "Narnia: The Lion, The Witch, and The Wardrobe");
        availableBooks[6] = new Book(7, "ISBN: 1007", "Frankenstein");
        availableBooks[7] = new Book(8, "ISBN: 1008", "Dune");
        availableBooks[8] = new Book(9, "ISBN: 1009", "The Lord of The Rings");
        availableBooks[9] = new Book(10, "ISBN: 1010", "The Da Vinci Code");
        availableBooks[10] = new Book(11, "ISBN: 1011", "Pinocchio");
        availableBooks[11] = new Book(12, "ISBN: 1012", "Catcher in the Rye");
        availableBooks[12] = new Book(13, "ISBN: 1013", "The Alchemist");
        availableBooks[13] = new Book(14, "ISBN: 1014", "The Great Gatsby");
        availableBooks[14] = new Book(15, "ISBN: 1015", "The Hunger Games");
        availableBooks[15] = new Book(16, "ISBN: 1016", "Twilight");
        availableBooks[16] = new Book(17, "ISBN: 1017", "The Fault in Our Stars");
        availableBooks[17] = new Book(18, "ISBN: 1018", "The Bible");
        availableBooks[18] = new Book(19, "ISBN: 1019", "The Art of War");
        availableBooks[19] = new Book(20, "ISBN: 1020", "Dora the Explorer");

        // I created a boolean variable for the upcoming while loop
        boolean choosing = true;

        // Make a loop for all the outputs.
        // This while loop is Step 1 of the prompt.
        // It will make the user choose an option and make the user try again if they input something other than 1, 2, or 3.
        while (choosing) {
            int userChoice;
            while (true) {
                System.out.println("---------------------------------");
                System.out.println("----------  MAIN MENU  ----------\n");
                System.out.println("1. Show available Books.");
                System.out.println("2. Show checked out books.");
                System.out.println("3. Leave the store.");
                System.out.println("Please choose an option:\n");

                if (userInput.hasNextInt()) {
                    userChoice = userInput.nextInt();
                    userInput.nextLine();
                    // This is stating that the following statements will run if the user inputs a number between 1 and 3 or equal to 1 and 3.
                    // If they choose between 1 and 3, then the while loo will break and move us to what happens with their choice using the switch statement.
                    if (userChoice >= 1 && userChoice <= 3) {
                        break;
                    } else {
                        System.out.println("Invalid Input. Please choose an option (1, 2, or 3).");
                    }
                } else {
                    userInput.nextLine();
                    System.out.println("Invalid input. Please choose an option (1, 2, or 3).");
                }
            }

            // Use a switch statement to determine what happens after the use chooses an option
            // I use a switch statement because it is cleaner and more efficient.
            switch (userChoice) {
                case 1:
                    showAvailableBooks(userInput, availableBooks);
                    break;
                case 2:
                    showCheckedOutBooks(userInput, availableBooks);
                    break;
                case 3:
                    // If they choose 3, then "choosing" is false and the while loop won't even run.
                    choosing = false;
                    // The timer will wait 2000 milliseconds
                    error();
                    // Say thank you for coming
                    System.out.println("Thank you for coming!");
                    // and then break the switch to then close the store.
                    break;
            }
        }
        // We put this function last in the main method to close the store after the person exits the store.
        userInput.close();
    }

    // THIS METHOD SHOWS WHAT HAPPENS WHEN USER OPTION IS "1". IT SHOWS AVAILABLE BOOKS.
    public static void showAvailableBooks(Scanner userInput, Book[] books) throws InterruptedException {
        System.out.println("--------------OUR BOOKS:-----------------");

        // WE DO THIS UPCOMING IF STATEMENT TO MAKE SURE OUR LIST OF BOOKS SHOWS BEFORE WE ASK USER FOR ID.

        // I made a boolean variable for the if loop below.
        boolean areTheyHere = false;

        // this is giving the name "myBook" attached to the class "Book"
        // the reason we put "books" is because we set an array from the Book class called "books" at the top of this method.
        for (Book myBook : books) {
            // So, if myBook (the book the user wants) is not checked out, it will print the statement below to show that the user has checked out the book.
            if (!myBook.isCheckedOut()) {
                System.out.println("ID: " + myBook.getId() + "\n" + myBook.getIsbn() + "\nTitle:\n" + myBook.getTitle() + "\n------------------------------------------------------");
                // thhis boolean changes to true because the book they chose was available. so its just works like a confirmation.
                areTheyHere = true;
            }
        }
        // Now I made an if statement for if the book the user chose is not available.
        if (!areTheyHere) {
            System.out.println("There are no books available at the moment.");
            error();
        }
        // THIS IS THE ACTUAL FIRST PROMPT THE USER WILL SEE AFTER LIST OF BOOKS ARE LISTED ABOVE.
        System.out.println("\nWhat is your book ID?\nPress 0 to go back.");
        int bookId = userInput.nextInt();
        userInput.nextLine();

        // This if and return statement is here because we asked the user to press 0 to go back the previous menu,
        // so if the user inputs "0" as user ID, it will "return" them to the main menu.
        if (bookId == 0)
            return;

        // For myBook with the class "Book" attached while sorting through the array of "books",
        // if myyBook that i choose  is equal to an ID of a book AND the book is available, then do the following:
        for (Book myBook : books) {
            if (myBook.getId() == bookId && !myBook.isCheckedOut()) {
                System.out.println("\nEnter your full Name:");
                // we establish a string for the name input called "name" and it brings us to the getName method to fix the name input.
                String name = getName(userInput);
                // This brings the name back to the checkout method in the other "Book" class to confirm that the person checked out that book.
                myBook.checkOut(name);

                // The getName and capitalizedWords method returns us back here to these next statements
                System.out.println("------------------------------");
                System.out.println("\nSuccessfully checked out!");
                System.out.println("Title: " + myBook.getTitle());
                System.out.println("ID: " + myBook.getId());
                System.out.println(myBook.getIsbn());
                System.out.println("Checked out to: " + name);
                System.out.println("------------------------------");

                error();
                // after the timer above, we will be brought to the endOfMenu method.
                // we put "userInput" and "books" in parentheses because these are the tools that the method will use from the current method to do its job.
                endOfMenu(userInput, books);
                // after we are brought back from the "endOfMenu" method, or if we dont even go there, we will return to the main method.
                return;
            } // end of if statement
        } // end of for loop

        // This statement will appear if the user input an ID of a book that is not in stock.
        System.out.println("--- This book is not in stock right now. ---");
        error();
        // we will be brought to the endOfMenu method if the book the user wants is not available.
        endOfMenu(userInput, books);
    }

    // THIS METHOD WILL APPEAR WHEN USER HITS "2" ON THE MAIN MENU.
    public static void showCheckedOutBooks(Scanner userInput, Book[] books) throws InterruptedException {
        // We will show checked out books.
        System.out.println("\n--------------CHECKED OUT BOOKS: -----------------");
        // For myBook(users choice) attached to the "Book" class sorting through the array of "books".
        // If myBook is checked out, then the statement below wil appear.
        // If there are any books held in myBook from someone checking out books, this statement will appear as many times as however many books are checked out.
        for (Book myBook : books) {
            if (myBook.isCheckedOut()) {
                System.out.println("\nID: " + myBook.getId() + "\n" + myBook.getIsbn() + "\nTitle: " + myBook.getTitle() + "\nChecked out to:\n" + myBook.getCheckedOutTo());
            }
        }

        // The string askCheckIn is created to store the users input for "C" or "X" for the next prompts
        String askCheckIn;
        while(true) {
            System.out.println("\nPress C to check in a book.\nPress X to return to the main screen.\n");
            // The function below establishes that the askCheckIn variable will be used for the userInout and we will automatically uppercase the letter that the user inputs.
            askCheckIn = userInput.nextLine().toUpperCase();

            // If the user chooses "C", the user will be prompted to enter an ID.
            if (askCheckIn.equalsIgnoreCase("C")) {
                System.out.println("\nWhat is the ID of the book?:\n");
                int bookId = userInput.nextInt();
                userInput.nextLine();

                // We create the boolean bookFound to use as a tool to see if the book is in stock.
                boolean bookFound = false;

                // For myBook(users choice) attached to the "Book" class sorting through the array of "books".
                for (Book myBook : books) {
                    // If the ID of myBook is equal to a bookID thats available AND if the book is checked out, then the following statements will appear.
                    if (myBook.getId() == bookId && myBook.isCheckedOut()) {
                        // We make sure the users input moves from the checkOut method to the checkIn method.
                        myBook.checkIn();
                        System.out.println("\nYour book is checked in!\nTitle: " + myBook.getTitle() + "\nID: " + bookId);
                        // Now we will return to the main method.
                        return;
                    }
                }

                // If the book is not found in the stock, the following statement will appear.
                if (!bookFound) {
                    System.out.println("\nThat book is not currently checked out or doesn't exist.");
                    error();
                }
                // And then bring us to the endOfMenu prompts
                endOfMenu(userInput, books);
                return; // Exit this method after check-in
            } else if (askCheckIn.equals("X")) {        // This else if is for is=f the user hits "X" to go back to the main menu.
                return; // Return back to main menu if the user hits "X"
            } else {   // If the user inputs anything else, the input is invalid.
                System.out.println("\nInvalid input. Please press C or X.");
                error();
            }
        }
    }



    //----------------------------------------------------------------------------------

    // THESE NEXT TWO METHODS ARE THE NAME BLENDER. THESE FIX THE USERS NAME INPUT.
    public static String getName(Scanner scanner) {
        System.out.print("What is your name?\n");
        String name;
        while (true) {
            name = scanner.nextLine().toUpperCase();
            if (name.isEmpty()) {
                System.out.println("Please enter a name");
                System.out.println("What is your name?");
            } else {
                break;
            }
        }

        return capitalizedwords(name); // return the name.
    }

    public static String capitalizedwords(String input){
        String[] nameParts = input.trim().split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        for (String name : nameParts){
            if (!name.isEmpty()){
                char firstLetter = Character.toUpperCase(name.charAt(0));
                String restOfName = name.substring(1).toLowerCase();
                capitalized.append(firstLetter).append(restOfName).append(" ");
            }
        }
        return capitalized.toString().trim();
    }

    //----------------------------------------------------------------------------------



    // THIS METHOD PROMPTS ANOTHER MENU AFTER THE USER DOES SOME LOOKING AROUND FOR A WHILE
    public static void endOfMenu(Scanner userInput, Book[] books) throws InterruptedException {
        // These are the statements that will appear if the user is brought to this method.
        System.out.println("\nWould you like to do something else?\n");
        System.out.println("Press A to check out another book.");
        System.out.println("Press B to check in a book");
        System.out.println("Press X to return to the main menu\n");

        // We are establishing that the new variable "endOfMenuChoice" is going to store the users menu option, trim the white space, and automatically set uppercase.
        String endOfMenuChoice = userInput.nextLine().trim().toUpperCase();

        // Now we use a switch statement for what the users fate will be depending on which option they choose.
        switch (endOfMenuChoice) {
            case "A":
                showAvailableBooks(userInput, books);
                break;
            case "B":
                showCheckedOutBooks(userInput, books);
                break;
            case "X":
                System.out.println("Returning to the main menu...");
                // The "error();" brings us to the method below called error.
                error();
                break;
            // The default is for when the user inputs something other than A, B, of X.
            // no need to put "break" under the default since the default will automatically break out of the switch statement.
            default:
                System.out.println("Invalid input. Returning to the main menu...");
                error();
        }
    }

    // THIS METHOD IS USED FOR PAUSES IN BETWEEN PROMPTS AND WILL CATCH LOADING INTERRUPTIONS.
    public static void error(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println("Something went wrong while loading...");
        }
    }





} // end of books store class








