package com.pluralsight;

import java.util.Arrays;

public class LoopsAndArrays {
    public static void main(String[] args) throws InterruptedException {

 //---------------------------------------------------------------------------------------------------------------------
        // USING A FOR LOOP TO COUNTDOWN

        // The for loop is saying "We will countdown from the integer of 10.
        // The countdown will end at the number 1. (only activate numbers greater than or equal to 1.
        // The "countdown--" just activates the countdown after the rules are set.
        for (int countDown = 10; countDown >=1; countDown--){
            // This built-in function waits a certain amount of time before each print statement occurs.
            // in this case, we will put 1000 milliseconds.
            Thread.sleep(1000);
            // Now we print the countdown
            System.out.println(countDown);
        }



 //---------------------------------------------------------------------------------------------------------------------
        // A FOR LOOP FORMULA FOR SKIPPING VALUES AUTOMATICALLY.

        int sum = 0;

        for(int i = 1; i <=10; i++){
            if(i % 3 == 0){
                continue;
            }
            sum += i;
        }
        System.out.println("Sum " + sum);

//----------------------------------------------------------------------------------------------------------------------
        // HOW TO RUN A LOOP IN AN ARRAY.

        // The "int[]" works like the "String[]" function, but with integers. It makes an Array.
        // In this example, we are just putting the numbers set inside the function that we're making an Array of.
        int[] numbers = {4, 8, 15, 16, 23, 43};
        // Now that we've made the Array, let's find and print the numbers in the Array.
        // We initialize a new variable that creates the counting of the Array called "f".
        // The next function is the condition that states to not list numbers that are more than the length of the Array.
        // The f++ function tells us to list the numbers going up the list.
        for (int f = 0; f < numbers.length; f++){
            // Now we will print out the "f" function inside of brackets.
            // Doing this will print how the "f" function is working rather than just what the f function is initialized as (0).
            System.out.print(numbers[f] + " ");
        }

        // HERE'S ANOTHER EXAMPLE

        String[] statements = {"\nDavid", "Eyob", "Bilenie", "Abraham"};

        // Create a variable for each item in the list. "student" is saying that each item in the list is called a "student".
        // While the variable "statements" is the name of the Array as a whole.
        // This function and the print statement will print out the same exact way as the example above,
        // The only difference is that this function is better for printing a whole list and not specific index's inside the list.
        for(String student : statements){
            System.out.println(student);
        }

        // YOU CAN SORT AN ARRAY FROM A-Z OR IN ORDER OF NUMBERING.
        Arrays.sort(statements);

        // MAKE A SEPARATE COPY OF THE ARRAY
        String[] studentCopy = new String[4];

        for(int c = 0; c < statements.length; c++){
            studentCopy[c] = statements[c];
        }
        studentCopy[0] = "Jack";
        System.out.println("\n" + statements[0]);
        System.out.println(studentCopy[0]);

        // USING A METHOD WITH AN ARRAY
        String[] names = {"Tim", "Edeb", "Eyob"};
        // The function below creates a pathway from one method to another.
        // In this case, we want to print an array. So we use the built-in Java function called "printArray".
        printArray(names);
    }
    // Create a new public static void method to grab a "String[]" called "array".
    public static void printArray(String[] array){
        // The Java function "Arrays.toString" converts the array to a string.
        System.out.println(Arrays.toString(array));

    }

    // HERE'S ANOTHER METHOD EXAMPLE THAT WORKS THAT WILL BE COMMENTED OUT.

    /*

    public class Program
{
public static void main(String args[])
{
int[] nums = getNumbers();
for (int i = 0; i < nums.length; i++) {
System.out.print(nums[i]+ " ");
}
System.out.println();
}
public static int[] getNumbers()
{
int[] nums = {63, 65, 60, 53, 58, 37, 35, 31};
return nums;
}
}

     */
//----------------------------------------------------------------------------------------------------------------------
    }

