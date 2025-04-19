package com.pluralsight;

public class MathPrinter {

    public static void main(String[] args) {
        // Directly store the values
        int firstProblem = 4 * 7;
        int secondProblem = 15 - 18;
        int thirdProblem = 5 * 5;
        int lastProblem = 49 / 7;

        // Call the method to print them
        basicMath(firstProblem, secondProblem, thirdProblem, lastProblem);
    }

    // A method that prints and sums the values
    public static void basicMath(int first, int second, int third, int fourth) {
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
    }
}





