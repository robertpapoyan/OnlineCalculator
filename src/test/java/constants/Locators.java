package constants;

import pages.BasePage;


public abstract class Locators extends BasePage {

    public static final String URL = "https://www.paysera.com/v2/en-GB/fees/currency-conversion-calculator#/";
    public static final String SEE_ALL_RATES_BTN = "/html/body/main/article/section[1]/div/div/div/div/div[1]/div[3]/a";
    public static final String SELL_FIELD_BTN = "input[data-ng-model='currencyExchangeVM.filter.from_amount']";
    public static final String BUY_FIELD_BTN = "input[data-ng-model='currencyExchangeVM.filter.to_amount']";
    public static final String BUY_CURRENCY_DROPDOWN_BTN = "div[data-ng-model='currencyExchangeVM.filter.to']";
    public static final String BUY_CURRENCY_LIST_ITEM = "span[data-ng-bind='currency']";
    public static final String FILTER_BTN = "button[data-ng-click='currencyExchangeVM.filterExchangeRates()']";
    public static final String CLEAR_FILTER_BTN = "button[data-ng-click='currencyExchangeVM.clearFilter()']";
    public static final String TABLE_FIRST_ITEM = "//*[@id=\"currency-exchange-app\"]/div/div/div[2]/table/tbody/tr/td[1]";
    public static final String FOOTER_DROPDOWN_MENU_ELEMENT = "span[class='js-localization-popover']";
    public static final String FOOTER_DROPDOWN_MENU_LIST_BTN = "button[id='countries-dropdown']";
    public static final String FOOTER_DROPDOWN_MENU_POLAND_ITEM = "ul.dropdown-menu > li:nth-child(7) > a";
    public static final String SELL_FIELD_CURRENCY_ELEMENT = "span[data-ng-bind='$select.selected']";
    public static final String PAYSERA_RATE = "td[data-title='Paysera rate']";
    public static final String BANK_RATE = "td[data-title='mBank amount'] > span > span > span.ng-binding";
    public static final String RATES_DIFF = "td[data-title='mBank amount'] > span > span > span.other-bank-loss";

}
