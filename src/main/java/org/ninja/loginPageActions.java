package org.ninja;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class loginPageActions {

    Playwright playwright = Playwright.create();
    BrowserType browserType = playwright.chromium();
    Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
    // Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
    BrowserContext context = browser.newContext();
    Page page = context.newPage();

    public void setUp() {
        page.navigate("https://app.ninjarmm.com/auth/#/login");
        String title = page.title();
        assertThat(page).hasTitle("NinjaOne");
        assertThat(page.getByAltText("logo")).isVisible();
    }

    public void enterEmail(String username) {
        assertThat(page.getByText("Email")).isVisible();
        page.locator("xpath=//*[@id=\"email\"]").fill(username);
    }

    public void enterPassword(String password) {
        assertThat(page.getByText("Password").nth(1)).isVisible();
        page.locator("xpath=//*[@id=\"password\"]").fill(password);

    }

    public void clickOnSignInButton() {
        assertThat(page.getByText("Sign in")).isVisible();
        page.getByText("Sign in").click();
    }
}
