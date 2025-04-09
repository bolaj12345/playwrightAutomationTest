package org.example;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ninjaLoginTest {


    @Test(priority = 1)
    public void loginTest() {
        System.out.println("WELCOME TO JAVA TESTING");

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
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
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
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