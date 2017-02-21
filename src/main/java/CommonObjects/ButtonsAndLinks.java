package CommonObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonsAndLinks extends TestSetup {
    private WebElement loginLink = TestSetup.driver.findElement(By.xpath("/html/body/header/div/div[1]/div/a"));
    private WebElement redeemCodeLink = TestSetup.driver.findElement(By.xpath("/html/body/header/div/div[1]/div/span/a"));


    public void clickLoginLink(){
        if(loginLink.isDisplayed()){
            loginLink.click();
        }
    }

    public void clickRedeemCodeLink(){
        if(redeemCodeLink.isDisplayed()){
            redeemCodeLink.click();
        }
    }






}
