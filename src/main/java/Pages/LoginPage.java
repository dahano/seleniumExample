package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by ofirdahan on 2/20/17.
 */
public class LoginPage {
    WebDriver driver;

    By loginLink = By.xpath("//html/body/header/div/div[1]/div/a");
    By loginButton = By.xpath("//html/body/div[1]/section/div/form/fieldset/div[4]/div/button");
    By emailField = By.xpath("//html/body/div[1]/section/div/form/fieldset/div[1]/input");
    By passwordField = By.xpath("//html/body/div[1]/section/div/form/fieldset/div[2]/input");


    public LoginPage(WebDriver driver){
        this.driver = driver;

    }

    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }


    public void validateLoginUrl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    public void verifyAndAddLoginIinfo(){
        if(driver.findElement(emailField).isDisplayed()){
            driver.findElement(emailField).sendKeys("testSeleniumAccount123@gmail.com");
        }if(driver.findElement(passwordField).isDisplayed()){
            driver.findElement(passwordField).sendKeys("password");
        }
    }
}
