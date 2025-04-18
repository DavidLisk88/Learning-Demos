package com.pluralsight;

import java.util.Scanner; // This lets us read what someone types on the keyboard

public class Main {

    public static void main(String[] args) {
        // We create a Scanner tool to read what the user types
        Scanner scanner = new Scanner(System.in);

        // Ask the user their name
        System.out.print("What is your name? ");
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
    public static String getName(Scanner scanner) {
        return scanner.nextLine(); // Reads a full line of text
    }

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




