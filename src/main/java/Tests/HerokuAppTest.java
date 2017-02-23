package Tests;

import CommonObjects.TestSetup;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class HerokuAppTest extends TestSetup {

    @Test
    public void JavaScriptAlert(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(2) button")).click();
        Alert popup = driver.switchTo().alert();
        popup.accept();
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(result.equalsIgnoreCase("You clicked: Ok"));
    }

    @Test
    public void multipleWindows(){
        driver.get("http://the-internet.herokuapp.com/windows");

        driver.findElement(By.cssSelector(".example a")).click();
        Object[] allWindows = driver.getWindowHandles().toArray();

        driver.switchTo().window(allWindows[0].toString());
        MatcherAssert.assertThat(driver.getTitle(), is(not("New Window")));

        driver.switchTo().window(allWindows[1].toString());
        MatcherAssert.assertThat(driver.getTitle(), is("New Window"));
    }


}
