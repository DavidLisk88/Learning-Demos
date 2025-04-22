package FileReading;

import java.io.FileInputStream;
import java.util.Scanner;

public class ReadFileTryCatch {
    public static void main(String[] args) {


        try {
            FileInputStream file = new FileInputStream("src/main/resources/david.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                System.out.println(fileScanner.nextLine());
            }

        } catch (Exception e) {
            System.out.println("File does not exist.");
        }

        try {

            String fileName = "inventory.csv";
            //create file input stream that kinda brings our file into our code
            //i put the file in the resources folder because technically thats where it should be
            FileInputStream fis1 = new FileInputStream("src/main/resources/" + fileName);
            Scanner fileScanner1 = new Scanner(fis1);

            //loop that checks to make sure we have a line or next lines in our file
            //prints the lines out if they exist
            int lineNumber = 1;
            while(fileScanner1.hasNextLine()) {
                //print out each line in the file
                System.out.println(lineNumber + ": " + fileScanner1.nextLine() );
                lineNumber++;
            }

        }catch (Exception e){
            System.out.println("That file did not exist");
        }

    }
}