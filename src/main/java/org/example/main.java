//Luke John Cloete - ST10472230

package org.example;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nQuick Chat Application");

        // Get user first and last name
        System.out.print("What is your first name: ");
        String firstName = sc.nextLine().trim();
        System.out.print("What is your last name: ");
        String lastName = sc.nextLine().trim();

        // Registration details
        System.out.print("Please enter your username: ");
        String username = sc.nextLine().trim();
        System.out.print("Please enter your password: ");
        String password = sc.nextLine().trim();
        System.out.print("Please enter your cellphone number (+27): ");
        String cell = sc.nextLine().trim();

        // Create Login object with names
        login login = new login(username, password, cell, firstName, lastName);

        // System verification
        System.out.println("\nSystem Verification:");
        System.out.println("Username: " + login.usernameFeedback());
        System.out.println("Password: " + login.passwordFeedback());
        System.out.println("Cellphone number: " + login.cellFeedback());

        // Register user
        String regMsg = login.registerUser();
        System.out.println("Registration: " + regMsg);
        if (!"User registered successfully.".equals(regMsg)) {
            System.out.println("Registration Failed. Please try again.");
            sc.close();
            return;
        }

        // Login stage
        System.out.println("\nLogin:");
        System.out.print("Enter username: ");
        String enteredUser = sc.nextLine().trim();
        System.out.print("Enter password: ");
        String enteredPass = sc.nextLine().trim();

        boolean success = login.loginUser(enteredUser, enteredPass);
        System.out.println(login.returnLoginStatus(success));

        sc.close();
    }
}
