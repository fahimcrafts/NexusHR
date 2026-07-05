package tests;

import utils.DataGenerator;

public class PIMEmployeeTest {
    public static void main(String[] args) {
        String firstName = DataGenerator.getFirstName();
        String lastName = DataGenerator.getLastName();

        System.out.println("Creating Employee:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
    }
}
