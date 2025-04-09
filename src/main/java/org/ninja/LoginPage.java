package org.ninja;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class LoginPage {
    private Page page;

    // Locators
    private String usernameLocator = "input[name='email']";
    private String passwordLocator = "input[name='password']";
    private String loginButtonLocator = "button[type='submit']";
    private String KeepMeSignedInLocator = "xpath=//*[@id=\"root\"]/div/div/div/form/label/label";
    private String errorLoginMessageLocator = "xpath=//*[@id=\"root\"]/div/div/div/div[2]";

    public LoginPage(Page page) {
        this.page = page;
    }

    // Page Actions

    public void enterUsername(String username) {
        page.fill(usernameLocator, username);
    }

    public void enterPassword(String password) {
        page.fill(passwordLocator, password);
    }

    public void clickLoginButton() {
        page.click(loginButtonLocator);
    }

    public void clickKeepMeSignedInButton() {
        page.click(KeepMeSignedInLocator);
    }

    public void verifyErrorSignInMessage() {
        assertThat(page.locator(errorLoginMessageLocator)).isVisible();
    }

    public void clickAndVerifyForgetYourPasswordLinkIsClickable() {
        page.getByText("Forgot your password?").click();
        assertThat(page.getByText("Verify Identity By")).isVisible();
    }

    public void clickAndVerifyCreateAnAccountLinkIsClickable() {
        page.getByText("Do not have an account?").click();
        assertThat(page.getByText("Registration")).isVisible();
    }

    public void clickAndVerifyKeepMeSignedInCheckBoxIsFunctional() {
        assertThat(page.getByText("Keep me signed in")).isVisible();
        page.getByText("Keep me signed in").click();
        assertThat(page.getByText("Keep me signed in")).isChecked();
        page.getByText("Keep me signed in").click();
        page.waitForTimeout(1000);
        Assert.assertFalse((page.getByText("Keep me signed in")).isChecked());
    }
}
