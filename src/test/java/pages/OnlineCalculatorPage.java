package pages;

import constants.Locators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class OnlineCalculatorPage extends BasePage {

    public OnlineCalculatorPage() {
        super();
    }

    @FindBy(xpath = Locators.SEE_ALL_RATES_BTN)
    WebElement rates;

    @FindBy(css = Locators.SELL_FIELD_BTN)
    WebElement sellFieldBtn;

    @FindBy(css = Locators.BUY_FIELD_BTN)
    WebElement buyFieldBtn;

    @FindBy(css = Locators.BUY_CURRENCY_DROPDOWN_BTN)
    WebElement buyCurrencyDropDownBtn;

    @FindBy(xpath = Locators.TABLE_FIRST_ITEM)
    WebElement tableFirstItem;

    @FindBy(css = Locators.SELL_FIELD_CURRENCY_ELEMENT)
    WebElement sellFieldCurrency;

    @FindBy(css = Locators.FOOTER_DROPDOWN_MENU_ELEMENT)
    WebElement footerDropdownMenuElement;

    @FindBy(css = Locators.FOOTER_DROPDOWN_MENU_LIST_BTN)
    WebElement footerDropdownMenuListBtn;

    @FindBy(css = Locators.FOOTER_DROPDOWN_MENU_POLAND_ITEM)
    WebElement footerDropdownMenuPolandItem;

    @FindBy(css = Locators.FILTER_BTN)
    WebElement filterBtn;

    @FindBy(css = Locators.BUY_CURRENCY_LIST_ITEM)
    List<WebElement>  buyCurrencyList;

    @FindBy(css = Locators.CLEAR_FILTER_BTN)
    WebElement clearFilterBtn;

    @FindBy(css = Locators.BANK_RATE)
    WebElement bankRate;

    @FindBy(css = Locators.PAYSERA_RATE)
    WebElement payseraRate;

    @FindBy(css = Locators.RATES_DIFF)
    WebElement ratesDiff;


    /**Scenarios**/
    public void ratesBtnClick() {
        wait.until(ExpectedConditions.elementToBeClickable(rates));
        rates.click();
    }

    public void fillSellField(String amount) {
        wait.until(ExpectedConditions.elementToBeClickable(sellFieldBtn));
        sellFieldBtn.clear();
        sellFieldBtn.sendKeys(amount);
    }

    public void fillBuyField(String amount) {
        wait.until(ExpectedConditions.elementToBeClickable(buyFieldBtn));
        buyFieldBtn.sendKeys(amount);
    }

    public void buyCurrencyDropDownBtnClick(int currencyIndex) {
        wait.until(ExpectedConditions.elementToBeClickable(buyCurrencyDropDownBtn));
        buyCurrencyDropDownBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(buyCurrencyDropDownBtn));
        chooseWebElementFromCurrency(currencyIndex).click();
        filterBtn.click();
    }

    public void countryChooseFooterCountriesDropDownMenu()  {
        footerDropdownMenuElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(footerDropdownMenuListBtn));
        footerDropdownMenuListBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(footerDropdownMenuPolandItem));
        footerDropdownMenuPolandItem.click();
    }

    public void clearFilterResults(String text){
        clearFilterBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(clearFilterBtn));
        wait.until(ExpectedConditions.textToBePresentInElement(tableFirstItem,text));
    }

    public WebElement chooseWebElementFromCurrency(int currencyIndex){
        WebElement buyCurrencyListItem = buyCurrencyList.get(currencyIndex);
        return buyCurrencyListItem;
    }


   /**Scroll logic**/
    public void scrollFooterCountriesDropDownMenu() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.elementToBeClickable(footerDropdownMenuElement));
    }

    /**Assertion methods**/
    public boolean assertSellCurrencyValue(String country){
        wait.until(ExpectedConditions.elementToBeClickable(buyCurrencyDropDownBtn));
        wait.until(ExpectedConditions.textToBePresentInElement(sellFieldCurrency,country));
        if (sellFieldCurrency.getText().equals(country)) {
            return true;
        } else
            return false;
    }

    public boolean assertEmptyBuyField(String amount) {
        wait.until(ExpectedConditions.visibilityOf(tableFirstItem));
        if (sellFieldBtn.getAttribute("value").equals(amount) &&
                buyFieldBtn.getAttribute("value").equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean assertEmptySellField(String amount) {
        if (buyFieldBtn.getAttribute("value").equals(amount) &&
                sellFieldBtn.getAttribute("value").equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean assertClearFilter(String text){
        wait.until(ExpectedConditions.elementToBeClickable(buyCurrencyDropDownBtn));
        clearFilterResults(text);
        wait.until(ExpectedConditions.elementToBeClickable(buyCurrencyDropDownBtn));
        if (buyCurrencyDropDownBtn.getText().equals(""))
            return true;
        else return false;
    }

    public boolean assertFilterResult(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(buyCurrencyDropDownBtn));
        wait.until(ExpectedConditions.textToBePresentInElement(tableFirstItem,text));
        if (tableFirstItem.getText().equals(text)) {
            return true;
        } else
            return false;
    }

    public boolean assertOtherBankValueExists() {
        wait.until(ExpectedConditions.elementToBeClickable(filterBtn));
        wait.until(ExpectedConditions.visibilityOf(bankRate));
        if (bankRate.isDisplayed())
            return true;
        else
            return false;
    }

    public boolean assertPayseraRateBetterValue() {
        wait.until(ExpectedConditions.elementToBeClickable(buyCurrencyDropDownBtn));
        wait.until(ExpectedConditions.elementToBeClickable(filterBtn));
        wait.until(ExpectedConditions.visibilityOf(payseraRate));
        String payseraRateString = payseraRate.getText();
        String bankRateString = bankRate.getText();
        double payseraRateDouble = Double.parseDouble(payseraRateString);
        double bankRateDouble = Double.parseDouble(bankRateString);
        if (payseraRateDouble > bankRateDouble && ratesDiff.isDisplayed())
            return true;
        else
            return false;
    }

    public boolean assertPayseraRateAndOtherBankRateDiff() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        String payseraRateString = payseraRate.getText();
        String bankRateString = bankRate.getText();
        String ratesDiffString = ratesDiff.getText();

        ratesDiffString = ratesDiffString.substring(1, ratesDiffString.length() - 1);

        double payseraRateDouble = Double.parseDouble(payseraRateString);
        double bankRateDouble = Double.parseDouble(bankRateString);
        double ratesDiffDouble = Double.parseDouble(ratesDiffString);

        ratesDiffDouble = Double.parseDouble(formatter.format(ratesDiffDouble));

        if (formatter.format(bankRateDouble - payseraRateDouble).equals(formatter.format(ratesDiffDouble)))
            return true;
        else
            return false;
    }


}
