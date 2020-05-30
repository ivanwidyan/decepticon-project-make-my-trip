package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePage extends UiUtility {

  @FindBy(xpath = "//div[@class='chHeaderContainer']//nav//li[2]")
  WebElementFacade menuHotel;

  @FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']")
  WebElementFacade buttonLogin;

  @FindBy(xpath = "//input[@id='username']")
  WebElementFacade textBoxEmail;

  @FindBy(xpath = "//button[@class='capText font16']")
  WebElementFacade buttonSubmit;

  @FindBy(xpath = "//input[@id='password']")
  WebElementFacade textBoxPassword;

  @FindBy(xpath = "//span[@class='crossIcon popupSprite popupCrossIcon']")
  WebElementFacade iconClose;

  @FindBy(xpath = "//label[@for='city']")
  WebElementFacade sectionCity;

  @FindBy(xpath = "//input[contains(@placeholder,'Enter city/ Hotel/ Area/ Building')]")
  WebElementFacade textBoxCity;

  @FindBy(xpath = "//label[@for='guest']")
  WebElementFacade sectionRoom;

  @FindBy(xpath = "//div[@class='roomsGuestsBottom']/button[2]")
  WebElementFacade buttonApplyRoom;

  @FindBy(xpath = "//div[@class='roomsGuestsBottom']/button[1]")
  WebElementFacade buttonAddRooms;

  @FindBy(xpath = "//label[@for='travelFor']")
  WebElementFacade sectionTravelFor;

  @FindBy(xpath = "//ul[contains(@class,'travelForPopup')]//li[1]")
  WebElementFacade selectTravelFor ;

  @FindBy(xpath = "//button[@id='hsw_search_button']")
  WebElementFacade buttonSearch ;

  @FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
  WebElementFacade buttonNextDate ;

  String listCity = "//ul[contains(@class,'react-autosuggest__suggestions-list')]//p[contains(text(),'%s')]";

  String dateCheck = "//div[contains(text(),'%s')]/ancestor::div[@class='DayPicker-Month']//div[@aria-disabled='false' and .='%s']";

  String numberOfAdults = "//div[contains(@class,'hsw_inner')]//ul[1]//li[%s]";

  String numberOfChildren = "//div[contains(@class,'minContainer')]//ul[2]//*[.='%s']";

  public void openPage() {
    openUrl("https://www.makemytrip.com/");
  }

  public void clickButtonLogin(){
    JSExecutorUtility.clickByWebElement(buttonLogin, getDriver());
  }

  public void typeTextBoxEmail(String value){
    textBoxEmail.type(value);
  }

  public void clickButtonSubmit(){
    JSExecutorUtility.clickByWebElement(buttonSubmit, getDriver());
  }

  public void typeTextBoxPassword(String value){
    textBoxPassword.type(value);
  }

  public void clickIconClose(){
    JSExecutorUtility.clickByWebElement(iconClose, getDriver());
  }

  public void clickMenuHotel(){
    JSExecutorUtility.clickByWebElement(menuHotel, getDriver());
  }

  public void clickSectionCity(){
    JSExecutorUtility.clickByWebElement(sectionCity, getDriver());
  }

  public void typeTextBoxCity(String value){
    textBoxCity.type(value);
  }

  public void clickListCity(String value){
    fromXpathtoWebElement(String.format(listCity, value)).click();
  }

  public void clickDate(String month, String date){
    JSExecutorUtility.clickByWebElement(fromXpathtoWebElement(String.format(dateCheck, month, date)), getDriver());
  }

  public void clickSectionRoom(){
    JSExecutorUtility.clickByWebElement(sectionRoom, getDriver());
  }

  public void clickNumberOfAdults(String value){
    JSExecutorUtility.clickByWebElement(
            fromXpathtoWebElement(String.format(numberOfAdults, value)), getDriver());
  }

  public void clickNumberOfChildren(String value){
    JSExecutorUtility.clickByWebElement(
            fromXpathtoWebElement(String.format(numberOfChildren, value)), getDriver());
  }

  public void clickButtonApplyRoom(){
    JSExecutorUtility.clickByWebElement(buttonApplyRoom, getDriver());
  }

  public void clickSectionTravelFor(){
    JSExecutorUtility.clickByWebElement(sectionTravelFor, getDriver());
  }

  public void clickSelectTravelFor(){
    JSExecutorUtility.clickByWebElement(selectTravelFor, getDriver());
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

  public boolean isDateIsMatch(String month, String date){
    return fromXpathtoWebElement(String.format(dateCheck, month, date)).isCurrentlyVisible();
  }

}