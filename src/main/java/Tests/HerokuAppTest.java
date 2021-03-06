package Tests;

import BaseTestSetup.TestSetup;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class HerokuAppTest extends TestSetup {

    String baseUrl = "http://the-internet.herokuapp.com/";

    @Test
    public void JavaScriptAlert(){
        driver.get(baseUrl+"javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(2) button")).click();
        Alert popup = driver.switchTo().alert();
        popup.accept();
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(result.equalsIgnoreCase("You clicked: Ok"));
    }

    @Test
    public void multipleWindows(){
        driver.get(baseUrl+"windows");
        driver.findElement(By.cssSelector(".example a")).click();
        Object[] allWindows = driver.getWindowHandles().toArray();

        driver.switchTo().window(allWindows[0].toString());
        MatcherAssert.assertThat(driver.getTitle(), is(not("New Window")));

        driver.switchTo().window(allWindows[1].toString());
        MatcherAssert.assertThat(driver.getTitle(), is("New Window"));
    }

    @Test
    public void verifyCheckboxes() throws InterruptedException {
        driver.get(baseUrl+"checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));

        for(WebElement checkbox: checkboxes){
            System.out.println("Original Values: "+checkbox.isSelected());
            if(!checkbox.isSelected()){
                checkbox.click();
            }
            System.out.println("New Values: "+checkbox.isSelected()+"\n");
        }
    }

    @Test
    public void forgotPasswordSendPassword() throws InterruptedException {
        driver.get(baseUrl+"forgot_password");
        WebElement emailField = driver.findElement(By.cssSelector("input[name=\"email\"]"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[id=\"form_submit\"]"));

        emailField.clear();
        emailField.sendKeys("testEmail123@gmail.com");
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http://the-internet.herokuapp.com/email_sent"));
    }

    @Test
    public void testBasicAuth() {
        //passing username:password for page through the URL since Selenium Web-Driver doesn't exactly
        //have a clean way of handling this type of Auth Alert.
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement welcomeBanner = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
        Assert.assertTrue(welcomeBanner.isDisplayed());
    }


}
