package Pages;

import CommonObjects.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by ofirdahan on 2/20/17.
 */
public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By navigation = By.xpath("//html/body/header/div/nav");
    By socialMediaLinks = By.xpath("//html/body/footer/div[1]/ul");
    By redeemCodeLink = By.xpath("//html/body/header/div/div[1]/div/span/a");
    By tutorialVideolink = By.xpath("//html/body/div[2]/section[5]/div/div/div[1]/h3/a");
    By tutorialVideo = By.xpath("//html/body/div[5]/div/div/div[2]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isNavigationDisplayed(){
        return driver.findElement(navigation).isDisplayed();
    }

    public boolean isSocialMediaLinksDisplayed(){
        return driver.findElement(socialMediaLinks).isDisplayed();
    }


    public boolean playTutorialVideo() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        if(driver.findElement(tutorialVideolink).isDisplayed()) {
            driver.findElement(tutorialVideolink).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(tutorialVideo));
        }
        return driver.findElement(tutorialVideo).isDisplayed();
    }

    public void clickRedeemCodeLink(){
        driver.findElement(redeemCodeLink).click();
    }


}
