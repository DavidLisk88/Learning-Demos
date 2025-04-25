package DateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAndTime1 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("Today is " + today);


        LocalTime currentTime = LocalTime.now();

        System.out.println("Today is " + currentTime);


        // Create local date and time variable to get date and time at the same time
        LocalDateTime currebtDateAndTime = LocalDateTime.now();

        System.out.println("It is currently " + currebtDateAndTime);



        // Get day of month
        System.out.println("Current day of month " + currebtDateAndTime.getDayOfMonth());

        // Get day of the week
        System.out.println("Current day of week " +currebtDateAndTime.getDayOfWeek());

        // Get the whole month
        System.out.println("Current month " + currebtDateAndTime.getMonth());


        // Get seconds from the current date and time
        System.out.println("Current seconds: " + currebtDateAndTime.getSecond());



        // Date Time format to change the format of the dates output
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Use a formatter to display full spelling if day, with date format of choice, and then the time format of choice.
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEEE, MM d, yyyyy  HH:mm");
        System.out.println("Format 3: " + currebtDateAndTime.format(formatter3));

        // Create a string variable with a date.
        // Parse the date inside a local date variable so the computer knows this is a date.
        // Print out the month of the date from the Local date variable that the String date is stored in.
        String someDate = "2025-09-30";
        LocalDate dateFormatString = LocalDate.parse(someDate);
        System.out.println("Current month from string generated date: " + dateFormatString.getMonth());


    }
}
