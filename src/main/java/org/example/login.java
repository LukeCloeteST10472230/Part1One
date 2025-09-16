package org.example;

public class login {
    private final String username;
    private final String password;
    private final String cellNumber;
    private final String firstname;
    private final String lastname;

    private boolean registered = false;

    // Constructor includes first and last name
    public login(String username, String password, String cellNumber, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Username validation
    public boolean checkUserName() {
        // Must contain underscore and at least 3 chars before underscore
        return username.matches("^[a-zA-Z0-9]{3,}_[a-zA-Z0-9]{1,}$");
    }

    public String usernameFeedback() {
        return checkUserName() ? "Username successfully captured."
                : "Username is not correctly formatted, please ensure that your username contains an underscore" +
                " and is correctly structured.";
    }

    // Password validation
    public boolean checkPasswordComplexity() {
        // At least 8 chars, 1 uppercase, 1 lowercase, 1 digit, 1 special char
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    public String passwordFeedback() {
        return checkPasswordComplexity() ? "Password successfully captured."
                : "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    // Cellphone validation
    public boolean checkCellPhoneNumber() {
        // Must start with + and have 11–15 digits
        return cellNumber.matches("^\\+\\d{11,15}$");
    }

    public String cellFeedback() {
        return checkCellPhoneNumber() ? "Cellphone number successfully captured."
                : "Cellphone number is incorrectly formatted or does not contain international code.";
    }

    // Registration
    public String registerUser() {
        if (checkUserName() && checkPasswordComplexity() && checkCellPhoneNumber()) {
            registered = true;
            return "User registered successfully.";
        } else {
            return "Registration failed. Please check details.";
        }
    }

    // Login
    public boolean loginUser(String enteredUser, String enteredPass) {
        return registered && username.equals(enteredUser) && password.equals(enteredPass);
    }

    // Login greeting
    public String returnLoginStatus(boolean success) {
        return success ? "Welcome " + firstname + " " + lastname + ", it is great to see you again."
                : "Username or password incorrect, please try again.";
    }
}
