package com.pluralsight;

// This is our class - it's like the LEGO instruction booklet
class Dog {
    // These are like the special pieces inside the box
    // They're private so no one can mess with them directly (Encapsulation 🛡)
    private String name;
    private int age;

    // Constructor 🛠 - this builds the dog with a name and age
    Dog(String dogName, int dogAge) {
        name = dogName;
        age = dogAge;
    }

    // These are methods (keys ) to safely get and set the private info
    String getName() {
        return name;
    }

    void setName(String newName) {
        name = newName;
    }

    // This is a method - it tells the dog to bark
    void bark() {
        System.out.println(name + " says: Woof!");
    }

    // Method overloading - another way to bark based on mood
    void bark(String mood) {
        if (mood.equals("angry")) {
            System.out.println(name + " says: WOOF WOOF!!");
        } else {
            bark(); // default barking
        }
    }
}

// Main class to run everything
public class Main {
    public static void main(String[] args) {
        // Instantiate an object - we're building our dog using the class (blueprint)
        Dog myDog = new Dog("Buddy", 3);  //  Now we have a dog named Buddy who is 3!

        // Call a method - make the dog do something (bark!)
        myDog.bark();  // Output: Buddy says: Woof!

        // Use method overloading - bark in a different mood
        myDog.bark("angry");  // Output: Buddy says: WOOF WOOF!!

        // Use encapsulation - get and set name safely using methods
        System.out.println("Current name: " + myDog.getName()); // Output: Buddy
        myDog.setName("Max");
        System.out.println("New name: " + myDog.getName());     // Output: Max

        // Bark again to show new name
        myDog.bark();  // Output: Max says: Woof!
    }
}
