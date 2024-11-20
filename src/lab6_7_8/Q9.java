package lab6_7_8;

import java.util.Scanner;

//Q.9) We need to write the function to check the password entered is correct or not based on the following
//conditions.
//a) It must have atleast one lower case character and one digit. done
//b) It must not have any Upper case characters and any special characters //done
//c) length should be b/w 5-12. done
//d) It should not have any same immediate patterns like
//abcanan1 : not acceptable coz of an an pattern
//abc11se: not acceptable, coz of pattern 11
//123sd123 : acceptable, as not immediate pattern
//adfasdsdf : not acceptable, as no digits
//Aasdfasd12: not acceptable, as have uppercase character


class checkPassword {
    public static boolean isValidPassword(String password) {
        // Check length condition
        if (password.length() < 5 || password.length() > 12) {
            System.out.println("password length too small or too large");
            return false;
        }

        // Check for lowercase and digit, and disallow uppercase/special characters
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isUpperCase(ch) || !Character.isLetterOrDigit(ch)) {
                // If any character is uppercase or special character, return false
                System.out.println("Contains uppercase or special symbols");
                return false;
            }
        }

        // Check if at least one lowercase and one digit is present
        if (!hasLowercase || !hasDigit) {
            System.out.println("Does not contain at least one lowercase letter or digit");
            return false;
        }

        for (int length = 1; length <= 6; length++) {
            for (int i = 0; i < password.length() - length; i++) {
                String pattern = password.substring(i, i + length);
                if (i + length < password.length() && password.substring(i + length).startsWith(pattern)) {
                    System.out.println("Found repeated pattern of length " + length + ": " + pattern);
                    return false; // Found immediate repeated pattern
                }
            }
        }

        // If all conditions are met, return true
        return true;
    }
}

public class Q9 {
    public static void main(String[] args) {
        System.out.println("Please Enter a strong password");
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();
        if(checkPassword.isValidPassword(pass)){
            System.out.println("Accepted");
        }else{
            System.out.println("Rejected");
        }
    }
}
