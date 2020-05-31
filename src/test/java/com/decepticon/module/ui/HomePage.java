package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.ParamConsts;
import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends UiUtility {

    // Button Elements
    @FindBy(xpath = "//div[@class='chHeaderContainer']//nav//li[2]")
    private WebElementFacade buttonHotel;

    @FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']")
    private WebElementFacade buttonLogin;

    @FindBy(xpath = "//button[@class='capText font16']")
    private WebElementFacade buttonSubmit;

    @FindBy(xpath = "//span[@class='crossIcon popupSprite popupCrossIcon']")
    private WebElementFacade buttonClose;

    @FindBy(xpath = "//label[@for='city']")
    private WebElementFacade buttonCity;

    @FindBy(xpath = "//label[@for='guest']")
    private WebElementFacade buttonRoom;

    @FindBy(xpath = "//div[@class='roomsGuestsBottom']/button[2]")
    private WebElementFacade buttonApplyRoom;

    @FindBy(xpath = "//div[@class='roomsGuestsBottom']/button[1]")
    private WebElementFacade buttonAddRooms;

    @FindBy(xpath = "//label[@for='travelFor']")
    private WebElementFacade buttonTravelFor;

    @FindBy(xpath = "//button[@id='hsw_search_button']")
    private WebElementFacade buttonSearch;

    @FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    private WebElementFacade buttonNextDate;

    // Text Box Elements
    @FindBy(xpath = "//input[@id='username']")
    private WebElementFacade textBoxEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElementFacade textBoxPassword;

    @FindBy(xpath = "//input[contains(@placeholder,'Enter city/ Hotel/ Area/ Building')]")
    private WebElementFacade textBoxCity;

    // Text Element
    @FindBy(xpath = "//label[@for='guest']//p/span/span[1]")
    private WebElementFacade textNumberOfGuests;


    private String buttonDate = "//div[contains(text(),'%s')]/ancestor::div[@class='DayPicker-Month']//div[@aria-disabled='false' and .='%s']";

    private String buttonNumberOfAdults = "//div[contains(@class,'hsw_inner')]//ul[1]//li[%s]";

    private String buttonNumberOfChildren = "//div[contains(@class,'minContainer')]//ul[2]//*[.='%s']";

    private String buttonAgeChildren = "//select[@id='%s']";

    private String listButtonTravelFor = "//ul[contains(@class,'travelForPopup')]//*[.='%s']";

    private String listButtonCity = "//ul[contains(@class,'react-autosuggest__suggestions-list')]//p[contains(text(),'%s')]";

    private String listButtonAgeChildren = "//select[@id='%s']/option[%s]";

    public void openPage() {
        openUrl("https://www.makemytrip.com/");
    }

    // Get Text
    public String getTextDate(String month, String date){
        return fromXpathtoWebElement(String.format(buttonDate, month, date)).getAttribute(ParamConsts.ARIA_LABEL);
    }

    public String getTextNumberOfGuest(){
        return textNumberOfGuests.getText();
    }

    // Click Actions
    public void clickButtonLogin() {
        clickByWebElement(buttonLogin);
    }

    public void clickButtonSubmit() {
        clickByWebElement(buttonSubmit);
    }

    public void clickButtonClose() {
        clickByWebElement(buttonClose);
    }

    public void clickButtonHotel() {
        clickByWebElement(buttonHotel);
    }

    public void clickButtonCity() {
        clickByWebElement(buttonCity);
    }

    public void clickButtonDate(String month, String date) {
        JSExecutorUtility.clickByWebElement(
                fromXpathtoWebElement(String.format(buttonDate, month, date)), getDriver());
    }

    public void clickButtonRoom() {
        clickByWebElement(buttonRoom);
    }

    public void clickButtonNumberOfAdults(String value) {
        clickByWebElement(
                fromXpathtoWebElement(String.format(buttonNumberOfAdults, value)));
    }

    public void clickButtonNumberOfChildren(String value) {
        clickByWebElement(
                fromXpathtoWebElement(String.format(buttonNumberOfChildren, value)));
    }

    public void clickButtonApplyRoom() {
        clickByWebElement(buttonApplyRoom);
    }

    public void clickButtonTravelFor() {
        clickByWebElement(buttonTravelFor);
    }

    public void clickButtonSearch() {
        clickByWebElement(buttonSearch);
    }

    public void clickButtonNextDate() {
        clickByWebElement(buttonNextDate);
    }

    public void clickButtonAddRooms() {
        clickByWebElement(buttonAddRooms);
    }

    public void clickButtonAgeChildren(String value) {
        clickByWebElement(
                fromXpathtoWebElement(String.format(buttonAgeChildren, value)));
    }

    public void clickListButtonCity(String value) {
        fromXpathtoWebElement(String.format(listButtonCity, value)).click();
    }

    public void clickListButtonTravelFor(String value) {
        clickByWebElement(fromXpathtoWebElement(String.format(listButtonTravelFor, value)));
    }

    public void clickListButtonAgeChildren(String children, String age) {
        clickByWebElement(
                fromXpathtoWebElement(String.format(listButtonAgeChildren, children, age)));
    }

    // Type Action
    public void typeTextBoxEmail(String value) {
        textBoxEmail.type(value);
    }

    public void typeTextBoxPassword(String value) {
        textBoxPassword.type(value);
    }

    public void typeTextBoxCity(String value) {
        textBoxCity.type(value);
    }

    // Check Action
    public boolean isDateMatch(String month, String date) {
        return fromXpathtoWebElement(String.format(buttonDate, month, date)).isCurrentlyVisible();
    }

    public boolean isButtonCloseVisible() {
        buttonClose.waitUntilPresent();
        return buttonClose.isCurrentlyVisible();
    }
}