package com.adamchilds.daycare.web.login.validator;

import com.adamchilds.daycare.test.util.UnitTestUtil;
import com.adamchilds.daycare.web.login.form.LoginForm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the {@link LoginFormValidator}
 */
public class LoginFormValidatorTest {

    private static final LoginFormValidator VALIDATOR = new LoginFormValidator();
    private LoginForm loginForm;
    private static final String VALID_USERNAME = "ron_burgundy";
    private static final String VALID_PASSWORD = "val1dp4ssw0rd";

    /*
     * Fields
     */
    private static final String USERNAME_FIELD = "username";
    private static final String PASSWORD_FIELD = "password";

    @Before
    public void setup() {
        loginForm = resetLoginFormWithValidValues();
    }

    @Test
    public void testSupports() {
        assertFalse(VALIDATOR.supports(Integer.class));
        assertTrue(VALIDATOR.supports(LoginForm.class));
    }

    @Test
    public void testValidate() {
        // Valid username and password
        UnitTestUtil.testForm(loginForm, VALIDATOR);

        // Null loginForm
        loginForm = createLoginForm(null, null);
        UnitTestUtil.testForm(loginForm, VALIDATOR, USERNAME_FIELD, PASSWORD_FIELD);

        // Null username
        loginForm = createLoginForm(null, VALID_PASSWORD);
        UnitTestUtil.testForm(loginForm, VALIDATOR, USERNAME_FIELD);

        // Empty username
        loginForm = createLoginForm("", VALID_PASSWORD);
        UnitTestUtil.testForm(loginForm, VALIDATOR, USERNAME_FIELD);

        // Whitespace username
        loginForm = createLoginForm("    ", VALID_PASSWORD);
        UnitTestUtil.testForm(loginForm, VALIDATOR, USERNAME_FIELD);

        // Username length > 24
        loginForm = createLoginForm("abcdefghijklmnopqrstuvwxyz", VALID_PASSWORD);
        UnitTestUtil.testForm(loginForm, VALIDATOR, USERNAME_FIELD);

        // Username length = 1
        loginForm = createLoginForm("a", VALID_PASSWORD);
        UnitTestUtil.testForm(loginForm, VALIDATOR);

        // Null password
        loginForm = createLoginForm(VALID_USERNAME, null);
        UnitTestUtil.testForm(loginForm, VALIDATOR, PASSWORD_FIELD);

        // Empty password
        loginForm = createLoginForm(VALID_USERNAME, "");
        UnitTestUtil.testForm(loginForm, VALIDATOR, PASSWORD_FIELD);

        // Whitespace password
        loginForm = createLoginForm(VALID_USERNAME, "    ");
        UnitTestUtil.testForm(loginForm, VALIDATOR, PASSWORD_FIELD);

        // Password length < 7
        loginForm = createLoginForm(VALID_USERNAME, "1234fs");
        UnitTestUtil.testForm(loginForm, VALIDATOR, PASSWORD_FIELD);

        // Password length > 30
        loginForm = createLoginForm(VALID_USERNAME, "abcdefghijklmnopqrstuvwxyz12345");
        UnitTestUtil.testForm(loginForm, VALIDATOR, PASSWORD_FIELD);

        // Password length = 7
        loginForm = createLoginForm(VALID_USERNAME, "abcdef7");
        UnitTestUtil.testForm(loginForm, VALIDATOR);

        // Password length = 30
        loginForm = createLoginForm(VALID_USERNAME, "abcdefghijklmnopqrstuvwxyz1234");
        UnitTestUtil.testForm(loginForm, VALIDATOR);
    }

    /**
     * Resets the {@link LoginForm} with valid values
     *
     * @return a new {@link LoginForm} with values that will pass validation
     */
    private LoginForm resetLoginFormWithValidValues() {
        return createLoginForm("ron_burgundy", "news4ever");
    }

    /**
     * Creates a LoginForm object with the given username and password values.
     *
     * @param username the username to set on the {@link LoginForm} object
     * @param password the password to set on the {@link LoginForm} object
     */
    private LoginForm createLoginForm(String username, String password) {
        LoginForm form = new LoginForm();

        form.setUsername(username);
        form.setPassword(password);

        return form;
    }

}