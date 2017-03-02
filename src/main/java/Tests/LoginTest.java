package Tests;

import CommonObjects.TestSetup;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by ofirdahan on 2/20/17.
 */
public class LoginTest extends TestSetup {
    LoginPage loginObj;

    String invalidLoginMessage = "Either your login email or password is incorrect, please try again";

    @Test
    public void validateLoginUrlSet() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.clickLoginLink();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginObj.validateLoginUrlcontains("login");
        Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[1]/section/div/h1")).getText().contains("LOGIN"));
    }

    @Test
    public void validateSignUpLinkUrl() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.clickSignUpLink();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginObj.validateLoginUrlcontains("register");
        Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[1]/section[2]/div[1]/h2")).getText().contains("SIGN UP"));
    }


    @Test
    public void updatedLoginFields() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.clickLoginLink();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginObj.verifyAndAddLoginIinfo();
        loginObj.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//html/body/div[1]/section/div/form/fieldset/div[1]/p")).getText().contains(invalidLoginMessage));
    }



}
