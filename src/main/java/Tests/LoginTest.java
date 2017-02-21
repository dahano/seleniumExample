package Tests;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by ofirdahan on 2/20/17.
 */
public class LoginTest {
    WebDriver loginDriver;
    LoginPage loginObj;

    String invalidLoginMessage = "Either your login email or password is incorrect, please try again";

    @BeforeTest
    public void setup(){
        String path = "/Applications/Firefox.app/Contents/MacOS/geckodriver";
        System.setProperty("webdriver.gecko.driver", path);
        loginDriver = new FirefoxDriver();
        loginDriver.get("https://www.headspace.com/");
    }

    @Test
    public void validateUrl() throws InterruptedException {
        loginObj = new LoginPage(loginDriver);
        loginObj.clickLoginLink();
        Thread.sleep(2000);
        loginObj.validateLoginUrl();
    }


    @Test
    public void updatedLoginFields() throws InterruptedException {
        loginObj = new LoginPage(loginDriver);
        loginObj.clickLoginLink();
        Thread.sleep(2000);
        loginObj.verifyAndAddLoginIinfo();
        loginObj.clickLoginButton();
        Thread.sleep(2000);
        Assert.assertTrue(loginDriver.findElement(By.xpath("//html/body/div[1]/section/div/form/fieldset/div[1]/p")).getText().contains(invalidLoginMessage));
    }

    @AfterSuite
    public void tearDown() {
        loginDriver.quit();
    }
}
