package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        if(oldPassword.equals(password)){
            if(newPassword.length() >= 8 && hasUppercase(newPassword) && hasLowercase(newPassword) && hasDigit(newPassword) && hasSpecialCharacter(newPassword)){
                this.password = newPassword;
            }
        }
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }

    // Checking 2nd condition if newPassword contains at least one uppercase letter.
    public boolean hasUppercase(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    // Checking 3rd condition if newPassword contains at least one lowercase letter.
    public boolean hasLowercase(String input){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    // Checking 4th condition if newPassword contains at least one digit.
    public boolean hasDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // Checking 5th condition if newPassword contains at least one special character.
    public boolean hasSpecialCharacter(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

}
