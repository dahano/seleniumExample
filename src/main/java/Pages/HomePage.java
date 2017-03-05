package Pages;

import BaseTestSetup.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by ofirdahan on 2/20/17.
 */
public class HomePage extends TestSetup{
    WebDriver driver;
    WebDriverWait wait;

    By navigation = By.xpath("//html/body/header/div/nav");
    By socialMediaLinks = By.xpath("//html/body/footer/div[1]/ul");
    By redeemCodeLink = By.xpath("//html/body/header/div/div[1]/div/span/a");
    By iFrameTutorialVideo = By.xpath("//html/body/div[5]/div/div/div[2]/div/iframe");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isNavigationDisplayed(){
        return driver.findElement(navigation).isDisplayed();
    }

    public boolean isSocialMediaLinksDisplayed(){
        return driver.findElement(socialMediaLinks).isDisplayed();
    }


    public void clickRedeemCodeLink(){
        driver.findElement(redeemCodeLink).click();
    }


}
