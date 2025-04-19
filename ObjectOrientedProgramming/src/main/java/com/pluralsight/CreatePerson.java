package com.pluralsight;

public class CreatePerson {
    public static void main(String[] args) {

        Person david = new Person("David", "Lisk", "111-11-111", 43);

        david.sayHello();

        System.out.println(david.getFirstName());
        System.out.println(david.getLastName());
        System.out.println("Your social security number is: " + david.getSsn());

    }
}
