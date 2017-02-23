package Tests;

import CommonObjects.TestSetup;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    public void playTutorialVideo() throws InterruptedException {
        homeObj = new HomePage(driver);
        homeObj.playTutorialVideo();
    }

}
