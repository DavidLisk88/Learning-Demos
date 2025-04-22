package LibrarySimulator;
// Create the book under a "book" class.
// This first block are the labels we will put on the book later on.
public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;
    // This next block of code is saying
    // "okay now that we have established each TYPE of label we will put on, lets make sure the computer knows that we need to SHOW each label."
    // The reason why checkedOutTo is blank is because we won't know who the book is checked out to until the user inputs it.
    // This is also the order that the information will show in each item info in the main method (id, ISBN, Title)
    // You can also right click, go to generate --> constructor -- > and highlight your labels above so it can set everything automatically below.
    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        // Books are checked out as false because there are no books checked out until someone checks it out.
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    // This is how we set the getters
    public int getId(){
        return id;}
    public String getIsbn(){
        return isbn;}
    public String getTitle(){
        return title; }
    public boolean isCheckedOut(){
        return isCheckedOut;
    }
    public String getCheckedOutTo(){
        return checkedOutTo;
    }

    // Set the setters
    public void setId(int id){
        this.id = id;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public void setTitle(String title){
        this.title = title;
    }



    // Create the methods
    // this method checks out the book.
    public void checkOut(String name){
        if (!isCheckedOut){
            isCheckedOut = true;
            checkedOutTo = name;
        }
    }

    // This method returns the book to the library. (check in)
    public void checkIn(){
        if (isCheckedOut){
            isCheckedOut = false;
            checkedOutTo = "";
        }
    }

}





