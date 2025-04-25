package UserInputLoops;
import java.util.Scanner;
public class SwitchStatements {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What's your favorite fruit?: ");

        // allow user to input and ignore case sensitivity.
        String fruit = userInput.nextLine().toLowerCase();

        // switch statement for which fruit the user wants to input.
        switch (fruit) {
            case "apple":
                System.out.println("Apples are yummy!");
                break;
            case "banana":
                System.out.println("Bananas are yummy!");
                break;
            case "lemon":
                System.out.println("Lemons are sour!");
                break;
            default:
                System.out.println("I don't know this fruit!");
        }



















    }
}
