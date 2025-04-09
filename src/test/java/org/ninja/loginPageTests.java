package org.ninja;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class loginPageTests {


    @Test(priority = 1)
    public void loginTest() {
        System.out.println("WELCOME TO JAVA TESTING");

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true).setSlowMo(200));
        // Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://app.ninjarmm.com/auth/#/login");
        String title = page.title();
        assertThat(page).hasTitle("NinjaOne");
        assertThat(page.getByAltText("logo")).isVisible();
        page.close();
        browser.close();
        playwright.close();
    }

    @Test(priority = 2)
    public void loginTest_verifyKeepMeSignedInCheckboxState() {

        System.out.println("WELCOME TO JAVA TESTING");

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true).setSlowMo(200));
        // Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://app.ninjarmm.com/auth/#/login");
        String title = page.title();
        assertThat(page).hasTitle("NinjaOne");
        assertThat(page.getByAltText("logo")).isVisible();
        page.close();
        browser.close();
        playwright.close();

    }
}
