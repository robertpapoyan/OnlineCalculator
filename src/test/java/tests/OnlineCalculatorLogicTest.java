package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OnlineCalculatorPage;


public class OnlineCalculatorLogicTest extends BaseTest {
    OnlineCalculatorPage onlineCalculatorPage;

    @Test(priority = 1)
    public void sellFieldDefaultValueValidation_Test()  {
        String amount = "100";
        onlineCalculatorPage = new OnlineCalculatorPage();
        onlineCalculatorPage.ratesBtnClick();
        Assert.assertTrue(onlineCalculatorPage.assertEmptyBuyField(amount));
    }

    @Test(priority = 2)
    public void sellAndBuyFieldsValidation_Test()  {
        String amount = "1000";
        onlineCalculatorPage = new OnlineCalculatorPage();
        onlineCalculatorPage.fillSellField(amount);
        Assert.assertTrue(onlineCalculatorPage.assertEmptyBuyField(amount));
        onlineCalculatorPage.fillBuyField(amount);
        Assert.assertTrue(onlineCalculatorPage.assertEmptySellField(amount));
    }

    @Test(priority = 3)
    public void filterCurrencyValidation_Test() {
        String text = "USD (US Dollar)";
        String amount = "100";
        int currencyIndex = 2;
        onlineCalculatorPage = new OnlineCalculatorPage();
        onlineCalculatorPage.fillSellField(amount);
        onlineCalculatorPage.buyCurrencyDropDownBtnClick(currencyIndex);
        Assert.assertTrue(onlineCalculatorPage.assertFilterResult(text));
    }

    @Test(priority = 4)
    public void clearFilterValidation_Test(){
        String text = "EUR (Euro)";
        onlineCalculatorPage = new OnlineCalculatorPage();
        onlineCalculatorPage.clearFilterResults(text);
        Assert.assertTrue(onlineCalculatorPage.assertClearFilter(text));
    }

    @Test(priority = 5)
    public void countrySellCurrencyValidation_Test(){
        String country = "PLN";
        onlineCalculatorPage = new OnlineCalculatorPage();
        onlineCalculatorPage.scrollFooterCountriesDropDownMenu();
        onlineCalculatorPage.countryChooseFooterCountriesDropDownMenu();
        onlineCalculatorPage.ratesBtnClick();
        Assert.assertTrue(onlineCalculatorPage.assertSellCurrencyValue(country));
    }

    @Test(priority = 6)
    public void payseraConvertValueValidation_Test() {
        int currencyIndex = 2;
        onlineCalculatorPage = new OnlineCalculatorPage();
        onlineCalculatorPage.buyCurrencyDropDownBtnClick(currencyIndex);
        Assert.assertTrue(onlineCalculatorPage.assertOtherBankValueExists());
        Assert.assertTrue(onlineCalculatorPage.assertPayseraRateBetterValue());
        Assert.assertTrue(onlineCalculatorPage.assertPayseraRateAndOtherBankRateDiff());
    }
}
