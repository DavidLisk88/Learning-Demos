package com.pluralsight;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends JFrame {

    // I initialize static variables to call things in multiple methods.
    static Scanner userInput = new Scanner(System.in);
    static ArrayList<Product> inventory = new ArrayList<>();

    // I am going to add a HashMap.
    // It works like an ArrayList but for larger portions of data.
    // This HashMap will be for searching through product ID's which is why we say that the key will be an integer.
    // We use "Product" because everything about our products is stored inside the Product class we created
    static HashMap<Integer, Product> inventoryMap = new HashMap<>();


    // I am going to make another HashMap for searching through prices
    // We are saying that what we want will be a double and what we are pulling that double from will be from the ArrayList of products we created.
    static HashMap<Double, ArrayList<Product>> priceMap = new HashMap<>();


    // This HashMap will be for finding the character of a product name.
    // We are going to grab a character from the array list.
    static HashMap<Character, ArrayList<Product>> characterMap = new HashMap<>();


    static int currentMaxId = 0;



    // set the path of the file we want to manipulate.
    static String searchFile = "src/main/resources/inventory.csv";
    // I make a new variable for the file located in the searchfile stream.
    static File logFile = new File(searchFile);



    // THE MAIN METHOD WILL ASK IF THE USER WANTS TO START THE PROGRAM.
    public static void main(String[] args) {



        // Before we even start, we need to read the file.
        readTheFileFirst();


        System.out.println("----------WELCOME----------\n");

        System.out.println("Hello there, friend...");
        waiting();

        // Use a while loop for the users choice to move forward.
        while (true) {

            System.out.println("Would you like to start the program or exit? ");
            System.out.println("Y or N");
            System.out.print("Please enter here: ");

            String userChoice1 = userInput.nextLine();

            if (userChoice1.equalsIgnoreCase("Y")) {
                System.out.println("\nTaking you to the store...");
                waiting();
                mainMenu();
                break;
            } else if (userChoice1.equalsIgnoreCase("N")) {
                System.out.println("Okay, thank you for your time.");
                waiting();
                userInput.close();
                return;
            }
            else {
                System.out.println("Invalid input. Please try again.");
                divider();
            }
        }

    }




    // THIS METHOD WILL READ THE FILE.
    public static void readTheFileFirst(){

        try(BufferedReader readTheFile = new BufferedReader(new FileReader(logFile))){
            String productLine;
            readTheFile.readLine();

            while((productLine = readTheFile.readLine()) != null){
                String[] productParts = productLine.split("\\|");
                if (productParts.length == 3){
                    int id = Integer.parseInt(productParts[0].trim());
                    if(id > currentMaxId){
                        currentMaxId = id;
                    }
                    String name = productParts[1].trim();
                    double price = Double.parseDouble(productParts[2].trim().replace("$", ""));

                    // I am adding this function for the HashMap to be able to read price ranges easier.
                    double roundedPrice = Math.round(price * 100.0) / 100.0;


                    Product splitProduct = new Product(id, name, roundedPrice);
                    inventory.add(splitProduct);

                    // I make this next function to also add the split product to the new HashMap I made above.
                    // The ID is the key and the splitProduct is the value.
                    // The Key (ID) is what we want. The Variable "splitProduct" is where we are pulling what we want from.
                    // We use the "put" method to "put" the ID key and splitProduct variable inside the HashMap.
                    inventoryMap.put(id, splitProduct);




                    // This if statement is saying
                    if (!priceMap.containsKey(roundedPrice)){
                        priceMap.put(roundedPrice, new ArrayList<>());
                    } priceMap.get(roundedPrice).add(splitProduct);


                    char firstLetter = name.charAt(0);
                    firstLetter = Character.toUpperCase(firstLetter);

                    if (!characterMap.containsKey(firstLetter)){
                        characterMap.put(firstLetter, new ArrayList<>());
                    } characterMap.get(firstLetter).add(splitProduct);


                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    // THIS METHOD ALLOWS THE USER TO CHOOSE WHAT TO DO WITH THE FILE.
    public static void mainMenu() {
        divider();
        System.out.println("---------- MAIN MENU ----------");
        System.out.println("1. List all products.");
        System.out.println("2. Look up a product by ID.");
        System.out.println("3. Find all products within a price range.");
        System.out.println("4. Add a new product.");
        System.out.println("5. Search products by first letter.");
        System.out.println("6. Exit the application.");
        System.out.print("Enter Here: ");


        String userMenuChoice = userInput.nextLine();

        while (true) {
            switch(userMenuChoice){
                case "1":
                    divider();
                    listProducts();
                    break;

                case "2":
                    divider();
                    waiting();
                    searchById();
                    break;

                case "3":
                    waiting();
                    searchByPrice();
                    break;

                case "4":
                    System.out.println("\nSounds great...");
                    waiting();
                    divider();
                    addProduct();
                    break;

                case "5":
                    System.out.println("Loading...");
                    waiting();
                    searchByFirstLetter();
                    break;

                case "6":
                    divider();
                    System.out.println("\nOkay thank you for your time.");
                    waiting();
                    userInput.close();
                    return;

                default:
                    System.out.println("Invalid input...");
                    waiting();
            }
        }
    }




    // THIS METHOD WILL ALLOW THE USER TO SEE ALL THE LISTED PRODUCTS IN INVENTORY.
    public static void listProducts(){
        divider();
        if(inventory.isEmpty()){
            System.out.println("No products at this time.");
        } else {
            System.out.println("We carry the following inventory:");
            for(Product prod : inventory){
                System.out.printf("%d | %s | $%.2f\n", prod.getId(), prod.getName(), prod.getPrice());
            }
        }
        divider();
        waiting();
        doSomethingElse();
        userInput.close();
    }



    // THIS METHOD WILL ALLOW THE USER TO SEARCH FOR A PRODUCT BY PRICE.
    public static void searchByPrice(){


        divider();

        try {
            System.out.println("Enter minimum price: ");
            double minPrice = Double.parseDouble(userInput.nextLine().trim());
            System.out.println("Enter maximum price: ");
            double maxPrice = Double.parseDouble(userInput.nextLine().trim());

            System.out.println("Please wait...");
            waiting();
            divider();
            System.out.println("----------  RESULTS  ---------- ");

            // We use a boolean variable to let the computer know that the file isn't found yet.
            boolean found = false;

            // Lets change the for loop around for the HashMap.
            // For the double inside the that HashMap we now call priceKey, (we put ".keySet" because we are grabbing from the keysset of the HashMap.
            for (double priceKey : priceMap.keySet()) {
                // we should know what this means by now.
                if (priceKey >= minPrice && priceKey <= maxPrice) {
                    // we have to set another for loop that states:
                    // for the product inside the HashMap that we are grabbing the priceKey from,
                    for(Product p : priceMap.get(priceKey)) {
                        // print out the message.
                        System.out.printf("\n          %d | %s | $%.2f\n", p.getId(), p.getName(), p.getPrice());
                        // Now we let the computer know that the file is found and we move forward.
                        found = true;
                    }
                }
            }
            // This is a function for when we are unable to find any products.
            if (!found) {
                System.out.println("No products in this price range.");
                mainMenu();
            }


        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        divider();
        waiting();
        doSomethingElse();
        userInput.close();
    }





    // THIS METHOD WILL ALLOW THE USER TO SEARCH FOR A PRODUCT BY ID.
    public static void searchById() {
        while (true) {
            try {
                System.out.println("\nPlease enter an ID ");
                System.out.println("Press 0 to exit at any time.");
                // I use an integer for user input but parse it since the computer is reading the ID as a string.
                int idSearch = Integer.parseInt(userInput.nextLine());

                // If the user enters 0, then we exit and go to the next method.
                if (idSearch == 0) {
                    System.out.println("\nExiting....");
                    waiting();
                    doSomethingElse();
                    break;
                }

                // Always use a boolean value when checking something because we need to let the code know that what we are looking for is not found yet.


                    // I am going to create a new variable for the HashMap so we can use it to srt through the list instead of what we had before.
                    Product productMap = inventoryMap.get(idSearch);

                    // Now I replace the for loop with a simple if statement.
                    // if the users input for the ID is found in the HashMap (not null),
                    if (productMap !=null) {
                        // then we print the following.
                        System.out.println("Here are your results:");
                        System.out.printf("\n%d | %s | $%.2f\n", productMap.getId(), productMap.getName(), productMap.getPrice());
                        break;
                    } else {
                        System.out.println("Product not found.");
                    }



            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }

            waiting();
        }
    }



    // THIS METHOD ALLOWS THE USER TO CREATE A NEW PRODUCT.
    public static void addProduct(){

        // Let's start asking the user for product information.
        try {

            // this function will be used to auto generate the next product ID number to the new product that the user adds.
            int id = ++currentMaxId;

            // so the user will only need to type in the product name and price.
            System.out.println("Product Name: ");
            String name = userInput.nextLine().trim();
            System.out.println("Price of product: ");
            double price = Double.parseDouble(userInput.nextLine().trim());

            // We create a new variable for the new product we are about to create.
            Product newProduct = new Product(id, name, price);
            // And we store that new product in the inventory array.
            inventory.add(newProduct);

            // We call the "logActions" method and hand it this print format for when it logs the new product.
            // What we hand it will be called "theAction" which is what we initialized in the parentheses of the "logAction" method.
            logActions(String.format("%d | %s | $%.2f", id, name, price));
            waiting();
            System.out.println("Product added ------>  " + newProduct + "\n");


        } catch (NumberFormatException e) {
            System.out.println("There was an error...");
            throw new RuntimeException(e);
        }
        divider();
        waiting();
        doSomethingElse();
        userInput.close();
    }



    // THIS IS AN EXTRA METHOD TO SEARCH BY THE FIRST LETTER OF PRODUCTS
    public static void searchByFirstLetter() {
        divider();
        System.out.print("Enter the first letter of the product name: ");
        String input = userInput.nextLine().trim().toUpperCase();
        waiting();

        // This if statement is saying that if the users input is more than one character, then they will have to try again.
        if (input.length() != 1) {
            System.out.println("Please enter only one letter.");
            return;
        }

        // now we create a variable to identify that the users input is one character.
        char letter = input.charAt(0);

        // if the key of the  HashMap contains the users input (letter),
        if (characterMap.containsKey(letter)) {
            // Then we make a brand new array list that will contain the ketter we grabbed from the HashMap.
            ArrayList<Product> products = characterMap.get(letter);
            // print a statement
            System.out.println("Products that start with '" + letter + "':\n");
            // print the format of the products.
            // for the products inside the new array list we just made, we will grab the data from the product class. and name the variable prod to do this.
            for (Product prod : products) {
                System.out.printf("          %d | %s | $%.2f\n", prod.getId(), prod.getName(), prod.getPrice());
            }
        } else {
            System.out.println("No products found starting with '" + letter + "'.");
        }

        divider();
        waiting();
        doSomethingElse();
    }



    // THIS METHOD ALLOWS THE USERS NEW PRODUCT INPUT TO BE WRITTEN TO THE FILE.
    public static void logActions(String theAction) {
        // Since the logged action of the user is a string, we will initialize a string variable called "theAction" in the parentheses.



        // Adding "true" next to the file means that you are appending the logs.
        // appending the logs just means each log will be logged below the previous one.
        // adding true means the old information stays preserved.
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(logFile, true))) {

            // Tell the Buffered Writer to write what we brought inside "theAction" variable.
            writer1.write(theAction);
            // This just tells the writer to write on a new line. We have to be very specific with instructions.
            writer1.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    // THIS METHOD IS WHERE THE USER WILL FREQUENTLY GO AFTER COMPLETING A TASK.
    public static void doSomethingElse(){
        System.out.println("Would you like to do something else?");
        System.out.print("Please enter Y or N: ");

        String doSomething = userInput.nextLine().trim().toUpperCase();

        while(true){
            switch (doSomething){
                case "Y":
                    System.out.println("\nOkay, one moment...");
                    waiting();
                    mainMenu();
                    return;
                case "N":
                    System.out.println("\nOkay, have a good day!");
                    waiting();
                    userInput.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input....");
            }

        }




    }







    // THIS METHOD CREATES A DIVIDER IN BETWEEN PROMPTS.
    public static void divider () {
        System.out.println("-".repeat(10));
    }


    // THIS METHOD IS FOR WAITING IN BETWEEN PROMPTS FOR USER EXPERIENCE.
    public static void waiting () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong while loading...");
        }
    }






    public static ArrayList<Product>  searchByPrice(double min, double max) {
        ArrayList<Product> found = new ArrayList<>();
        for (Product p : inventory) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                found.add(p);
            }
        }
        return found;
    }







}



