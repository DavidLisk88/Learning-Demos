package com.pluralsight;

public class Person {

    // this method sets the information about the person in stone
    public Person(String firstName, String lastName, String ssn, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.age = age;
    }
        // this describes the person
        private String firstName;
        private String lastName;
        private String ssn;
        private int age;


        // this is what the person can/will do
        public void sayHello () {
            System.out.println("Hello");
        }

        public String getFirstName () {
            return firstName;
        }
        public void setFirstName (String firstNam){
            this.firstName = firstNam;
        }
        public String getLastName () {
            return lastName;
        }
        public void setLastName (String lastName){
            this.lastName = lastName;
        }
        public String getSsn () {
            return ssn;
        }
        public void setSsn (String ssn){
            this.ssn = ssn;
        }
        public int getAge () {
            return age;
        }
        public void setAge ( int age){
            this.age = age;
        }
    }



