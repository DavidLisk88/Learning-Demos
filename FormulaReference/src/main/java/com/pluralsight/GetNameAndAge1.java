package com.pluralsight;

import java.util.Scanner; // This lets us read what someone types on the keyboard

public class GetNameAndAge1 {

    public static void main(String[] args) {
        // We create a Scanner tool to read what the user types
        Scanner scanner = new Scanner(System.in);

        // Ask the user their name
//        System.out.print("What is your name? ");
        String name = getName(scanner); // Call a method to get the name

        // Ask the user how old they are
        int age = getAge(scanner); // Call a method to get the age

        // Ask the user their favorite color
        System.out.print("What is your favorite color? ");
        String color = getFavoriteColor(scanner); // Call a method to get the color

        // Now say hello to the user with all their info
        greetUser(name, age, color);

        scanner.close();
    }

    // This method takes the scanner and returns the name the user typed
    // I am going to make sure the user does not input a blank name.
    public static String getName(Scanner scanner) {
        System.out.print("What is your name? ");
        String name = "";
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

    //------------------------------------------------------------------------------------------------------------------
    // FORMULA FOR MAKING SURE THE FIRST LETTER OF EACH WORD IS CAPITALIZED IN A STRING.
    // 1. Create a method (capitalizedwords) so the name method above can return here first before it reaches the main method.
    // The "String input" in the parentheses is telling the method that what the user will type will be called the "input".
    public static String capitalizedwords(String input){
        // 2. Create a string splitter and give it a variable (words) so it can be used.
        // The "input.trim()" is telling the words variable to trim extra space.
        // The ".split(\\s+)" is telling the words variable to split the string into words by the space.
        String[] words =  input.trim().split("\\s+");
        // 3. Now we create a new String Builder and name that too (caapitalized).
        // This helps hold the String back together after splitting it.
        StringBuilder capitalized = new StringBuilder();
        // 4. Now, create a For Loop that says "If the users name input is NOT empty, then take the first letter of eac word that is split and capitalize it and then make all the other letters lowercase.
        for (String word : words){
            if (!word.isEmpty()){
                // Take the first letter of the word and capitalize it.
                char firstLetter = Character.toUpperCase(word.charAt(0));
                // make the rest of the word lowercase
                String restOfWord = word.substring(1).toLowerCase();
                // Now that we fixed the word, put the fixed word back together followed by a space.
                capitalized.append(firstLetter).append(restOfWord).append(" ");
            }
        }
        // 5. Now we return the fixed word back to the main method and the users input.
        return capitalized.toString().trim();
    }
    //------------------------------------------------------------------------------------------------------------------

    // This method takes the scanner and returns the age the user typed
    public static int getAge(Scanner scanner) {

        int age = 0;
        boolean validAge = false;

        while (!validAge) {
            System.out.println("-----------------------------");
            System.out.print("How old are you? ");
            if (scanner.hasNextInt()){
                age = scanner.nextInt(); // Reads a number
                scanner.nextLine(); // Clears out the "Enter" key they pressed after typing the number
                if (age > 0) {
                    validAge = true;
                } else {
                    System.out.println("Error. Invalid Age.");
                }
            } else {
                System.out.println("Error. Invalid Response.");
                scanner.hasNextInt();
            }
        }
        return age;
    }



    // This method takes the scanner and returns the color the user typed
    public static String getFavoriteColor(Scanner scanner) {
        return scanner.nextLine(); // Reads a full line of text
    }

    // This method prints a friendly message using the user's name, age, and color
    public static void greetUser(String name, int age, String color) {
        // Say hello to the person using their name
        System.out.println("----------------------------");
        System.out.println("Hello, " + name + "!");

        // Tell them how old they will be next year
        System.out.println("Next year, you will be " + (age + 1) + " years old.");

        // Say something nice about their favorite color
        System.out.println("Nice! " + color + " is a beautiful color.");


    }


}
