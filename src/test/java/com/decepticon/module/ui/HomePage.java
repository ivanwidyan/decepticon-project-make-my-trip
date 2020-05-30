package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends UiUtility {

  // Button Elements
  @FindBy(xpath = "//div[@class='chHeaderContainer']//nav//li[2]")
  WebElementFacade buttonHotel;

  @FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']")
  WebElementFacade buttonLogin;

  @FindBy(xpath = "//button[@class='capText font16']")
  WebElementFacade buttonSubmit;

  @FindBy(xpath = "//span[@class='crossIcon popupSprite popupCrossIcon']")
  WebElementFacade buttonClose;

  @FindBy(xpath = "//label[@for='city']")
  WebElementFacade buttonCity;

  @FindBy(xpath = "//label[@for='guest']")
  WebElementFacade buttonRoom;

  @FindBy(xpath = "//div[@class='roomsGuestsBottom']/button[2]")
  WebElementFacade buttonApplyRoom;

  @FindBy(xpath = "//div[@class='roomsGuestsBottom']/button[1]")
  WebElementFacade buttonAddRooms;

  @FindBy(xpath = "//label[@for='travelFor']")
  WebElementFacade buttonTravelFor;

  @FindBy(xpath = "//button[@id='hsw_search_button']")
  WebElementFacade buttonSearch ;

  @FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
  WebElementFacade buttonNextDate ;

  // Text Box Elements
  @FindBy(xpath = "//input[@id='username']")
  WebElementFacade textBoxEmail;

  @FindBy(xpath = "//input[@id='password']")
  WebElementFacade textBoxPassword;

  @FindBy(xpath = "//input[contains(@placeholder,'Enter city/ Hotel/ Area/ Building')]")
  WebElementFacade textBoxCity;

  String listButtonCity = "//ul[contains(@class,'react-autosuggest__suggestions-list')]//p[contains(text(),'%s')]";

  String buttonDate = "//div[contains(text(),'%s')]/ancestor::div[@class='DayPicker-Month']//div[@aria-disabled='false' and .='%s']";

  String buttonNumberOfAdults = "//div[contains(@class,'hsw_inner')]//ul[1]//li[%s]";

  String buttonNumberOfChildren = "//div[contains(@class,'minContainer')]//ul[2]//*[.='%s']";

  String listButtonTravelFor = "//ul[contains(@class,'travelForPopup')]//*[.='%s']";

  String buttonAgeChildren = "//select[@id='%s']";

  String listButtonAgeChildren = "//select[@id='%s']/option[%s]";

  public void openPage() {
    openUrl("https://www.makemytrip.com/");
  }

  // Click Action
  public void clickButtonLogin(){
    JSExecutorUtility.clickByWebElement(buttonLogin, getDriver());
  }

  public void clickButtonSubmit(){
    JSExecutorUtility.clickByWebElement(buttonSubmit, getDriver());
  }

  public void clickIconClose(){
    JSExecutorUtility.clickByWebElement(buttonClose, getDriver());
  }

  public void clickMenuHotel(){
    JSExecutorUtility.clickByWebElement(buttonHotel, getDriver());
  }

  public void clickSectionCity(){
    JSExecutorUtility.clickByWebElement(buttonCity, getDriver());
  }

  public void clickListCity(String value){
    fromXpathtoWebElement(String.format(listButtonCity, value)).click();
  }

  public void clickDate(String month, String date){
    JSExecutorUtility.clickByWebElement(fromXpathtoWebElement(String.format(buttonDate, month, date)), getDriver());
  }

  public void clickSectionRoom(){
    JSExecutorUtility.clickByWebElement(buttonRoom, getDriver());
  }

  public void clickNumberOfAdults(String value){
    JSExecutorUtility.clickByWebElement(
            fromXpathtoWebElement(String.format(buttonNumberOfAdults, value)), getDriver());
  }

  public void clickNumberOfChildren(String value){
    JSExecutorUtility.clickByWebElement(
            fromXpathtoWebElement(String.format(buttonNumberOfChildren, value)), getDriver());
  }

  public void clickButtonApplyRoom(){
    JSExecutorUtility.clickByWebElement(buttonApplyRoom, getDriver());
  }

  public void clickSectionTravelFor(){
    JSExecutorUtility.clickByWebElement(buttonTravelFor, getDriver());
  }

  public void clickSelectTravelFor(String value){
    JSExecutorUtility.clickByWebElement(fromXpathtoWebElement(String.format(listButtonTravelFor, value)), getDriver());
  }

  public void clickButtonSearch(){
    JSExecutorUtility.clickByWebElement(buttonSearch, getDriver());
  }

  public void clickButtonNextDate(){
    JSExecutorUtility.clickByWebElement(buttonNextDate, getDriver());
  }

  public void clickButtonAddRooms(){
    JSExecutorUtility.clickByWebElement(buttonAddRooms, getDriver());
  }

  public void clickbuttonAgeChildren(String value){
    System.out.println(String.format(buttonAgeChildren, value));
    JSExecutorUtility.clickByWebElement(
            fromXpathtoWebElement(String.format(buttonAgeChildren, value)),getDriver());
  }

  public void clickListButtonAgeChildren(String children, String age){
    JSExecutorUtility.clickByWebElement(
            fromXpathtoWebElement(String.format(listButtonAgeChildren, children, age)),getDriver());
  }

  // Type Action
  public void typeTextBoxEmail(String value){
    textBoxEmail.type(value);
  }

  public void typeTextBoxPassword(String value){
    textBoxPassword.type(value);
  }

  public void typeTextBoxCity(String value){
    textBoxCity.type(value);
  }

  // Is match
  public boolean isDateIsMatch(String month, String date){
    return fromXpathtoWebElement(String.format(buttonDate, month, date)).isCurrentlyVisible();
  }
}