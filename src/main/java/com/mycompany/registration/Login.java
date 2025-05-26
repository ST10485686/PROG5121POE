/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

import java.util.Scanner;

public class Login {

   
    public String username;
    public String password;
    private String firstName;
    private String lastName;
    public String cellPhoneNumber;
    private boolean isRegistered = false;
    
    //Constructor
    public Login(String username, String password, String cellNumber){
        this.username = username;
        this.password = password;
        
      }

    Login() {
       
    }
    //Username validation
    public boolean checkUsername() {
       if (username == null)return false;
       return username.contains("_")&& username.length() <= 5;
    }
    // Password complexity validation
    public boolean checkPasswordComplexity(){
        if(password == null)return false;
        
        boolean hasMinLength = password.length() >=9;
        boolean hasCapital = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches("[A-Za-z0-9]*");
        
        return hasMinLength && hasCapital && hasNumber && hasSpecialChar;
    }
    // Phone number validation (basic implementation)
    public boolean checkCellPhoneNumber(){
        if (cellPhoneNumber == null)return false;
        // Basic check for country code(starts with +27) and length(between 0-9 digits)
        return cellPhoneNumber.matches("^\\+[0-9]{8}$");
    }
     
    // Registration method 
    public String registerUser(String username, String password, String cellPhoneNumber){
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        
        
        
        boolean usernameValid = checkUsername();
        boolean passwordValid = checkPasswordComplexity();
        boolean cellPhoneNumberValid = checkCellPhoneNumber();
        
        if (!usernameValid){
            return"Username is incorrectly formatted. PLease ensure it contains an underscore and is no more than 5 characters ";
        }
        if (!passwordValid){
            return "Password does not meet complexity requirements. It must be at least 8 characters, with a capital letter, a number, and special character.";
        }
        if (!cellPhoneNumberValid){
            return "Cell phone number is invalid. Please include country code and ensure correct length.";
        }
         isRegistered = true;
        return "User registered successfully!";
    }
    // Login verification
    public static boolean loginUser(String inputUsername, String inputPassword, Login registeredUser) {
        return inputUsername.equals(registeredUser.getUsername()) &&
               inputPassword.equals(registeredUser.getPassword());
    }
    
    
     // Getter and Setters
    public String getUsername(){return username; }
    public String getFirstname(){return firstName;}
    public String getLastName(){return lastName;}
    public String getPassword(){return password; }
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    
   public static boolean performLogin(Scanner scanner, Login userLogin) {
    System.out.println("\n=== Login ===");

    while (true) {
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (userLogin.getUsername().equals(inputUsername) &&
            userLogin.getPassword().equals(inputPassword)) {
            System.out.println("Login successful! Welcome, " + inputUsername + ".");
            return true;
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }
}
       
   
   boolean loginUser(String ivi_3, String pass123) {
    String correctUsername = "user123";
    String correctPassword = "password";

    return ivi_3.equals(correctUsername) && pass123.equals(correctPassword);
}
}  
    

    
 
            
        
            
          
         

    

