package com.pluralsight;

public class Main {
    public static void main(String[] args) {
     // set a new strig builder.
        StringBuilder skills = new StringBuilder();



     // append strings to the stringbuilder object. Another way of concatinating.
        skills.append("HTML, ");
        skills.append("CSS, ");
        skills.append("and Bootstrap ");
        skills.append("some ");
        skills.append("more ");
        skills.append("random ");
        skills.append("to ");
        skills.append("use ");

        // use another variable to convert the string builder variable into one string.
        String skillString = skills.toString();
        //split the converted variable into another variable called skillsParts.
        String[] skillsParts = skillString.split(" ");


        // prints out everything that starts with "skills.append"
        System.out.println(skillsParts[skillsParts.length - 2] + " " + skillsParts[2]);





















    }
}