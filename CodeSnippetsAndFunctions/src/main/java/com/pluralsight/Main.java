package com.pluralsight;

import java.util.Scanner;

public class Main {

    // using a while loop and a boolean if statement to confirm a name.
    public static String userInputName () {
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


        return nameToPartsToName(userName);
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

    public static void introduceTheSystem (String introMessage) {
        System.out.println("\nHello User! This is a program to help you " + introMessage);
        System.out.println("We will do this one line at a time!");
        System.out.println("\nFirst Step: ");
    }

    public static String userInputPhoneNumber () {
        String userPhoneNumber = "";
        boolean confirmed = false;
        Scanner scanner = new Scanner(System.in);
        while (!confirmed) {
            System.out.println("\nWhat is your Phone Number?");
            System.out.println("Enter: ");
            try {
                userPhoneNumber = scanner.nextLine().toLowerCase().trim();
                userPhoneNumber = userPhoneNumber.replaceAll("[^0-9]", "");

                if (userPhoneNumber.length() < 10) {
                    System.out.println("-------------------------------");
                    System.out.println("Invalid Input: NEED MORE NUMBERS");
                    System.out.println("-------------------------------");
                    continue;
                } else {
                    userPhoneNumber = "(" + userPhoneNumber.substring(0, 3) + ") " + userPhoneNumber.substring(3, 6) + "-" + userPhoneNumber.substring(6, 10);
                }
            } catch (ArithmeticException e) {
                System.out.println("-------------------------------");
                System.out.println("Invalid Input: NUMBERS ONLY");
                System.out.println("-------------------------------");
            } catch (NumberFormatException e) {
                System.out.println("-------------------------------");
                System.out.println("Invalid Input: NUMBERS ONLY");
                System.out.println("-------------------------------");
            }

            // Confirm Number -------------------------------------------------------------------------------------------
            System.out.println("\nIs [" + userPhoneNumber+ "] correct? (Y) or (N).");
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


        return userPhoneNumber;
    }

    public static String customInputName (String objectName) {
        String userName = "";
        boolean confirmed = false;
        Scanner scanner = new Scanner(System.in);
        while (!confirmed) {
            System.out.println("\nWhat is your " + objectName + "?");
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


        return nameToPartsToName(userName);
    }

    // this makes sure user ony inputs numbers in an inout,
    public static double customDoubleInput(String doubleName) {
        double customNumberInput = 0;
        boolean confirmed = false;
        Scanner scanner = new Scanner(System.in);
        while (!confirmed) {
            System.out.println("What is your " + doubleName + "?");
            System.out.println("Enter: ");
            try {
                customNumberInput = Double.parseDouble(scanner.nextLine().toLowerCase().trim());

            } catch (ArithmeticException e){

            } catch (NumberFormatException e) {
                System.out.println("-------------------------------");
                System.out.println("Invalid Input: NUMBERS ONLY");
                System.out.println("-------------------------------");
            }

            // Confirm Number -------------------------------------------------------------------------------------------
            System.out.println("\nIs [" + customNumberInput+ "] correct? (Y) or (N).");
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


        return customNumberInput;
    }

    public static long customLongInput(String longName) {
        long customNumberInput = 0;
        boolean confirmed = false;
        Scanner scanner = new Scanner(System.in);
        while (!confirmed) {
            System.out.println("\nWhat is your " + longName + "?");
            System.out.println("Enter: ");
            try {
                customNumberInput = Long.parseLong(scanner.nextLine().toLowerCase().trim());

            } catch (ArithmeticException e){

            } catch (NumberFormatException e) {
                System.out.println("-------------------------------");
                System.out.println("Invalid Input: NUMBERS ONLY");
                System.out.println("-------------------------------");
            }

            // Confirm Number -------------------------------------------------------------------------------------------
            System.out.println("\nIs [" + customNumberInput+ "] correct? (Y) or (N).");
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


        return customNumberInput;
    }

    // how to make a simple formula for asking and confirming questions
    public static String questionnaire () {
        String userName = "";
        String userColor = "";
        String userShape = "";
        String userNumber = "";
        boolean confirmed = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        System.out.println("Enter: ");
        userName = scanner.nextLine().toLowerCase().trim();

        System.out.println("What is your favorite color?");
        System.out.println("Enter: ");
        userColor = scanner.nextLine().toLowerCase().trim();

        System.out.println("What is your favorite shape?");
        System.out.println("Enter: ");
        userShape = scanner.nextLine().toLowerCase().trim();

        System.out.println("What is your favorite number?");
        System.out.println("Enter: ");
        userNumber = scanner.nextLine().toLowerCase().trim();

        // Confirm All -------------------------------------------------------------------------------------------
        while (!confirmed) {
            System.out.println("Is all of your info correct? (Y) or (N).");
            System.out.println("[" + nameToPartsToName(userName) + "]");
            System.out.println("[" + nameToPartsToName(userColor) + "]");
            System.out.println("[" + nameToPartsToName(userShape) + "]");
            System.out.println("[" + nameToPartsToName(userNumber) + "]");
            System.out.println("(Y)es");
            System.out.println("(N)o");
            char isRight = scanner.nextLine().toUpperCase().charAt(0);

            if (isRight == 'Y') {
                break;
            } else if (isRight == 'N') {
                boolean doubleCheck = false;
                while (!doubleCheck) {
                    System.out.println("Which part needs changing?");
                    System.out.println("(A) [" + nameToPartsToName(userName) + "]");
                    System.out.println("(B) [" + nameToPartsToName(userColor) + "]");
                    System.out.println("(C) [" + nameToPartsToName(userShape) + "]");
                    System.out.println("(D) [" + nameToPartsToName(userNumber) + "]");
                    char check = scanner.nextLine().toUpperCase().charAt(0);

                    if (check == 'A') {
                        System.out.println("What is your name?");
                        System.out.println("Enter: ");
                        userName = scanner.nextLine().toLowerCase().trim();
                        break;
                    } else if (check == 'B') {
                        System.out.println("What is your favorite color?");
                        System.out.println("Enter: ");
                        userColor = scanner.nextLine().toLowerCase().trim();
                        break;
                    } else if (check == 'C') {
                        System.out.println("What is your favorite shape?");
                        System.out.println("Enter: ");
                        userShape = scanner.nextLine().toLowerCase().trim();
                        break;
                    } else if (check == 'D') {
                        System.out.println("What is your favorite number?");
                        System.out.println("Enter: ");
                        userNumber = scanner.nextLine().toLowerCase().trim();
                        break;
                    } else {
                        System.out.println("-------------------------------");
                        System.out.println("Invalid Input: DO OVER");
                        System.out.println("-------------------------------");
                    }
                } continue;
            } else {
                System.out.println("-------------------------------");
                System.out.println("Invalid Input: DO OVER");
                System.out.println("-------------------------------");
            }
        }


        return nameToPartsToName(userName);
    }

    public static void confirmAllFive (String message, String messageTwo, String messageThree, String messageFour, String messageFive) {
        Scanner scanner = new Scanner(System.in);
        boolean confirmed = false;

        //Ask the questions -------------------------------------------------------------------------------------------
        String question = messageAndResponse(message);
        String questionTwo = messageAndResponse(messageTwo);
        String questionThree = messageAndResponse(messageThree);
        String questionFour = messageAndResponse(messageFour);
        String questionFive = messageAndResponse(messageFive);

        // Confirm All ------------------------------------------------------------------------------------------------
        while (!confirmed) {
            System.out.println("\nIs all of your info correct? (Y) or (N).");
            System.out.println("[" + nameToPartsToName(question) + "]");
            System.out.println("[" + nameToPartsToName(questionTwo) + "]");
            System.out.println("[" + nameToPartsToName(questionThree) + "]");
            System.out.println("[" + nameToPartsToName(questionFour) + "]");
            System.out.println("[" + nameToPartsToName(questionFive) + "]");
            System.out.println("\n(Y)es or (N)o ?");
            char isRight = scanner.nextLine().toUpperCase().charAt(0);

            if (isRight == 'Y') {
                break;
            } else if (isRight == 'N') {
                boolean doubleCheck = false;
                while (!doubleCheck) {
                    System.out.println("\nWhich part needs changing?");
                    System.out.println("(A) [" + nameToPartsToName(question) + "]");
                    System.out.println("(B) [" + nameToPartsToName(questionTwo) + "]");
                    System.out.println("(C) [" + nameToPartsToName(questionThree) + "]");
                    System.out.println("(D) [" + nameToPartsToName(questionFour) + "]");
                    System.out.println("(E) [" + nameToPartsToName(questionFive) + "]");
                    System.out.println("Enter here: ");
                    char check = scanner.nextLine().toUpperCase().charAt(0);

                    if (check == 'A') {
                        question = messageAndResponse(message);
                        break;
                    } else if (check == 'B') {
                        questionTwo = messageAndResponse(messageTwo);
                        break;
                    } else if (check == 'C') {
                        questionThree = messageAndResponse(messageThree);
                        break;
                    } else if (check == 'D') {
                        questionFour = messageAndResponse(messageFour);
                        break;
                    } else if (check == 'E') {
                        questionFive = messageAndResponse(messageFive);
                    } else {
                        System.out.println("-------------------------------");
                        System.out.println("Invalid Input: DO OVER");
                        System.out.println("-------------------------------");
                    }
                } continue;
            } else {
                System.out.println("-------------------------------");
                System.out.println("Invalid Input: DO OVER");
                System.out.println("-------------------------------");
            }
        }

    }

    static String messageAndResponse (String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

}























