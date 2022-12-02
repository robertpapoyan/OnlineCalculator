package tests;

import constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Browser;
import utils.DriverFactory;

import java.io.File;

public abstract class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void baseSetUp() {
        driver = DriverFactory.getDriver(Browser.CHROME);
        driver.get(Locators.URL);
    }

    @AfterClass
    public void finishOp(){
        driver.quit();
    }
}
