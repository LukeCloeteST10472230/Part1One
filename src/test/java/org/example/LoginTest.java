//Luke John Cloete - ST10472230

package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testValidUsername() {
        login login = new login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testInvalidUsername() {
        login login = new login("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testValidPassword() {
        login login = new login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testInvalidPassword() {
        login login = new login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testValidCellphone() {
        login login = new login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testInvalidCellphone() {
        login login = new login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    public void testSuccessfulRegistration() {
        login login = new login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("User registered successfully.", login.registerUser());
    }

    @Test
    public void testFailedRegistration() {
        login login = new login("kyle", "password", "08966553", "Kyle", "Smith");
        assertNotEquals("User registered successfully.", login.registerUser());
    }

    @Test
    public void testSuccessfulLogin() {
        login login = new login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        login.registerUser();
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertEquals("Welcome Kyle Smith, it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    public void testFailedLogin() {
        login login = new login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        login.registerUser();
        assertFalse(login.loginUser("wrong", "wrong"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
}
