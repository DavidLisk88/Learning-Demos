package FileReading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFilesOne {
    public static void main(String[] args) throws FileNotFoundException {
        // I will put a variable to the file name itself.
        String file1 = "goldilocks.txt";
        // This will create the stream of the file input. Where is the file located?
        FileInputStream fileInput = new FileInputStream("src/main/resources/" + file1);
        // The scanner will be created to read the text file linn by line.
        Scanner fileScanner = new Scanner(fileInput);

        // We want to let the scanner know to start counting at 1.
        // But we can change this number to start counting on any line we want
        int howManyLines = 1;

        while(fileScanner.hasNextLine()){  // While the filescanner has a new line,
            // Tell that line to enter what the file scanner is reading.
            String line = fileScanner.nextLine();
            // and then print out whats on the line until there are no more lines.
            System.out.println(howManyLines + ": " + line);
            // we just want to count up in numerical order:
            howManyLines++;
        }

        fileScanner.close();

    }
}
