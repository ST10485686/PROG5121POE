package com.mycompany.registration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test 
    public void testCorrectUsernameFormat() {
        Login login = new Login("Iviwe", "Bakaqana", "0606462840");
        login.username = "ivi_3";
        assertTrue(login.checkUsername());
    }

    @Test
    public void testIncorrectUsernameFormat() {
        Login login = new Login("Iviwe", "Bakaqana", "0606462840");
        login.username = "iviwe!!!!!!!";
        assertFalse(login.checkUsername());
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Iviwe", "Bakaqana", "0606462840");
        login.password = "Pass123!";
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordFailsComplexity() {
        Login login = new Login("Iviwe", "Bakaqana", "0606462840");
        login.password = "simple";
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testValidCellPhoneNumber() {
        Login login = new Login("Iviwe", "Bakaqana", "0606462840");
        login.cellPhoneNumber = "+27606462840";
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testInvalidCellPhone() {
        Login login = new Login("Iviwe", "Bakaqana", "0606462840");
        login.cellPhoneNumber = "0606462840"; // Missing country code
        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    public void testSuccessfulLogin() {
        Login login = new Login("Iviwe", "Bakaqana", "0606462840");
        login.registerUser("ivi_3", "Pass123!", "+27606462840");
        assertTrue(login.loginUser("ivi_3", "Pass123!"));
        
    }

    @Test
    public void testFailedLogin() {
        Login login = new Login("Iviwe", "Bakaqana", "0606462840");
        login.registerUser("ivi_3", "Pass123!", "+27606462840");
        assertFalse(login.loginUser("wrong", "wrong"));
        
    }
}
