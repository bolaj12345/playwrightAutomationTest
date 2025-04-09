package org.ninja;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class LoginTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true).setSlowMo(500));
        context = browser.newContext();
        page = context.newPage();
        loginPage = new LoginPage(page);
    }

    @Test()
    public void loginWithValidEmailAndPassword() {
        page.navigate("https://app.ninjarmm.com/auth/#/login");
        loginPage.enterUsername("botesting2025@gmail.com");
        loginPage.enterPassword("PASSWORDautomationtest2025");
        loginPage.clickLoginButton();
        page.waitForTimeout(1000);
        String pageTitle = page.title();
        Assert.assertEquals(pageTitle, "NinjaOne");
    }

    @Test
    public void loginWithInValidEmailAndPassword() {
        page.navigate("https://app.ninjarmm.com/auth/#/login");
        loginPage.enterUsername("botesting2025@gmail.com");
        loginPage.enterPassword("oooPASSWORDautomationtest2025");
        loginPage.clickLoginButton();
        loginPage.verifyErrorSignInMessage();
    }

    @Test
    public void testForgetYourPasswordLinkIsClickable() {
        page.navigate("https://app.ninjarmm.com/auth/#/login");
        loginPage.clickAndVerifyForgetYourPasswordLinkIsClickable();
    }

    @Test
    public void testFDoNotHaveAnAccountLinkIsClickable() {
        page.navigate("https://app.ninjarmm.com/auth/#/login");
        loginPage.clickAndVerifyCreateAnAccountLinkIsClickable();
    }

    @Test
    public void testFKeepMeSignedInCheckBoxIsFunction() {
        page.navigate("https://app.ninjarmm.com/auth/#/login");
        loginPage.clickAndVerifyKeepMeSignedInCheckBoxIsFunctional();
    }

    @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
