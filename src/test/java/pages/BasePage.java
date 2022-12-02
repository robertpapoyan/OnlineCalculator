package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static tests.BaseTest.getDriver;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 15);
    }
}
