package LoopsAndArrays;

public class ConvertingStrings {
    public static void main(String[] args) {
        // String contains "id|description|quantity|price"
        String input2 = "111|Hot Chocolate (12 Count)|21|4.99";

        // breaks above string into pieces. Always use "\\". It is syntax that helps find the pipe ( | ).
        String[] stringPiecesArray = input2.split("\\|");

        // print out which part of the array list you want using [ number ].
        System.out.println(stringPiecesArray[3]);

        // how many characters are in the list.
        System.out.println(stringPiecesArray.length);

        // how to find last item on list. Since every list starts at 0, the last item on the list would subtract the length from 1. you can keep subtracting higher numbers to access lower on the list.
        System.out.println(stringPiecesArray[stringPiecesArray.length - 1]);



        // parseInt passes the integer and says that the integer came from a string.
        int id = Integer.parseInt(stringPiecesArray[0]);

        System.out.println(id);


        String name = stringPiecesArray[1];
        System.out.println(name);
        int quantity = Integer.parseInt(stringPiecesArray[2]);
        double price = Double.parseDouble(stringPiecesArray[3]);

        System.out.println(id + " " + quantity + " " + price + " " + name);

        System.out.println("----------------------------------------");





























    }
}