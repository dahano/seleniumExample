package CommonObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class TestSetup {

    public static WebDriver driver;


    @BeforeSuite
    public void setUpDefault() throws IOException {
        setBrowser();
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        driver.get("https://www.headspace.com");
    }


    private void setBrowser() {
        String path = "/Applications/Firefox.app/Contents/MacOS/geckodriver";
        System.setProperty("webdriver.gecko.driver", path);
        //String path = "/Users/ofirdahan/chromedriver";
        //System.setProperty("webdriver.chrome.driver", path);
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
