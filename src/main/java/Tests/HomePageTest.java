package Tests;

import BaseTestSetup.TestSetup;
import Pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ofirdahan on 2/20/17.
 */

public class HomePageTest extends TestSetup{

    HomePage homeObj;

    @Test
    public void verifyLinks() throws InterruptedException {
        //instantiating new HomePage obj
        homeObj = new HomePage(driver);
        homeObj.isNavigationDisplayed();
        homeObj.isSocialMediaLinksDisplayed();
    }

    @Test
    public void redeemCodeLink() throws InterruptedException {
        homeObj = new HomePage(driver);
        homeObj.clickRedeemCodeLink();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homeObj.redeemCodeTitleIsDisplayed();
    }


    @Test
    public void verifyNavigationLinks(){
        WebElement navList = driver.findElement(By.className("primary-nav"));

        List<WebElement> navigationLinks = navList.findElements(By.tagName("li"));

        List<String> expectedNavLinks = Arrays.asList("HOW IT WORKS", "THE SCIENCE", "AT WORK", "BLOG", "HELP", "SUBSCRIPTIONS", "SIGN UP FOR FREE");
        List<String> navigationLinksOnPage = new ArrayList<String>();

        for(WebElement navLinks : navigationLinks){
            navigationLinksOnPage.add(navLinks.getText());
        }

        Assert.assertTrue(expectedNavLinks.containsAll(navigationLinksOnPage) && navigationLinksOnPage.containsAll(expectedNavLinks));
    }
}
