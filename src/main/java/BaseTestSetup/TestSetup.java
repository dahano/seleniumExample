package BaseTestSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestSetup {

    public static WebDriver driver;
    public String baseUrl = "https://www.headspace.com";

    @BeforeSuite
    public void setUpDefault() throws IOException {
        setBrowser();
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.get(baseUrl);


    }


    private void setBrowser() {
        //GECKO DRIVER
        String path = "./src/main/resources/geckodriver";
        System.setProperty("webdriver.gecko.driver", path);

        //CHROME DRIVER
        /*String path = "./src/main/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);*/
    }


    @AfterSuite
    public void suiteTearDown() {
        driver.quit();
    }

}
