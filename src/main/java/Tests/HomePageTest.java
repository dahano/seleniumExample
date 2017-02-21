package Tests;

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

public class HomePageTest {
    private WebDriver homeDriver;
    HomePage homeObj;

    @BeforeTest
    public void setup(){
        String path = "/Applications/Firefox.app/Contents/MacOS/geckodriver";
        System.setProperty("webdriver.gecko.driver", path);
        homeDriver = new FirefoxDriver();
        homeDriver.get("https://www.headspace.com");
    }


    @Test
    public void verifyLinks() throws InterruptedException {
        //instantiating new HomePage obj
        homeObj = new HomePage(homeDriver);
        homeObj.isNavigationDisplayed();
        homeObj.isSocialMediaLinksDisplayed();
    }

    @Test
    public void playTutorialVideo() throws InterruptedException {
        homeObj = new HomePage(homeDriver);
        homeObj.playTutorialVideo();
    }

    @AfterSuite
    public void tearDown() {
        homeDriver.quit();
    }

}
