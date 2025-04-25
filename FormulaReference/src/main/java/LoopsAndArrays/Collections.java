package LoopsAndArrays;

import LibrarySimulator.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class Collections {
    public static void main(String[] args) {

        Book[] availableBooks = new Book[20];

        // I took the time to add a bunch of different books with different ID's and ISBN numbers.
        availableBooks[0] = new Book(1, "ISBN: 1001", "Harry Potter");
        availableBooks[1] = new Book(2, "ISBN: 1002", "To Kill a Mockingbird");
        availableBooks[2] = new Book(3, "ISBN: 1003", "Pride and Prejudice");
        availableBooks[3] = new Book(4, "ISBN: 1004", "The Lord of the Flies");
        availableBooks[4] = new Book(5, "ISBN: 1005", "The Hobbit");
        availableBooks[5] = new Book(6, "ISBN: 1006", "Narnia: The Lion, The Witch, and The Wardrobe");
        availableBooks[6] = new Book(7, "ISBN: 1007", "Frankenstein");
        availableBooks[7] = new Book(8, "ISBN: 1008", "Dune");
        availableBooks[8] = new Book(9, "ISBN: 1009", "The Lord of The Rings");
        availableBooks[9] = new Book(10, "ISBN: 1010", "The Da Vinci Code");
        availableBooks[10] = new Book(11, "ISBN: 1011", "Pinocchio");
        availableBooks[11] = new Book(12, "ISBN: 1012", "Catcher in the Rye");
        availableBooks[12] = new Book(13, "ISBN: 1013", "The Alchemist");
        availableBooks[13] = new Book(14, "ISBN: 1014", "The Great Gatsby");
        availableBooks[14] = new Book(15, "ISBN: 1015", "The Hunger Games");
        availableBooks[15] = new Book(16, "ISBN: 1016", "Twilight");
        availableBooks[16] = new Book(17, "ISBN: 1017", "The Fault in Our Stars");
        availableBooks[17] = new Book(18, "ISBN: 1018", "The Bible");
        availableBooks[18] = new Book(19, "ISBN: 1019", "The Art of War");
        availableBooks[19] = new Book(20, "ISBN: 1020", "Dora the Explorer");



        // This is saying: create and array list that contains Strings and we will call these series of string "books".
        ArrayList<String> books = new ArrayList<>();


        // Now we can add things to this new list
        books.add("Harry Potter");
        books.add("The art of war");

        // I can even add a new item that's not even on the original list.
        books.add("something");



        // This is how we get things from the list.
        // Since Harry potter is the first on the new array list we made, then we put 0 for Harry Potter.
        System.out.println(books.get(0));

        // I am printing out the item on the list that I added into the new array.
        System.out.println(books.get(2));


        // Now lets print out a numbered list of the array list.
        // use a for loop and say this:
        // the integer we create called "i" starts at 0 since the first item on every array starts at 0.
        // "i" is less than the size of the array list called books. not greater than because it won't be possible to print more than what's already on the list.
        // "i++" is just saying that the list will count in chronological numerical order
        for (int i = 1; i < books.size(); i++){
            // Now we print the i variable and add 1 since the list starts at 1, not 0. If we don do this then the printed list will show 0 instead of 1 as the first item.
            System.out.println(i + 1 + " : " + books.get(i));
        }

        // Just seeing if I can access the books array outside  the brackets above.
        System.out.println(books.get(1));

    }







}
