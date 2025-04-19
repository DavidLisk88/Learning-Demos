package com.pluralsight;

// import LocalDate from time library
import java.time.LocalDate;
// import DateTimeFormatter from time library
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        String userInput = "2000-02-19";

        // formula for converting userInput into local date format
        LocalDate birthday = LocalDate.parse(userInput);

        // print entire birthday.
        System.out.println(birthday);

        //print just the day of month. Java has a bunch of syntax for pulling different parts of dates.
        System.out.println(birthday.getDayOfMonth());


        // ----------------------------------------------------
        // ----------------------------------------------------


        // DateTimeFormatter changes format of date

        DateTimeFormatter formatterName = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String userInput2 = "02/19/2000";
        // same formula for local date but now add in the formatterName for Date Format conversion.
        LocalDate birthday2 = LocalDate.parse(userInput2, formatterName);

        // print and add " .format(format Name Variable) " so it can print out the correct date format you set above.
        System.out.println(birthday2.format(formatterName));

        // date formatter will detect new position of dayOfMonth and print the same day of month as above.
        System.out.println(birthday2.getDayOfMonth());


        // get today's date. LocalDate.now() universally grabs the actual current date.
        LocalDate today = LocalDate.now();
        System.out.println(today.format(formatterName));

        LocalDateTime todayTime = LocalDateTime.now();
        System.out.println(todayTime);























    }
}