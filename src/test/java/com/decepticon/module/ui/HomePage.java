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

  @FindBy(xpath = "//div[@class = 'DayPicker-Month'][2]//div[@class = 'DayPicker-Week'][1]//div[@class = 'DayPicker-Day'][3]")
  WebElementFacade dateCheckin;

  @FindBy(xpath = "//div[@class = 'DayPicker-Month'][2]//div[@class = 'DayPicker-Week'][2]//div[@class = 'DayPicker-Day'][1]")
  WebElementFacade dateCheckout;

  @FindBy(xpath = "//label[@for='guest']")
  WebElementFacade sectionRoom;

  @FindBy(xpath = "//div[contains(@class,'hsw_inner')]//ul[1]//li[2]")
  WebElementFacade numberOfAdults;

  @FindBy(xpath = "//div[contains(@class,'minContainer')]//ul[2]//li[1]")
  WebElementFacade numberOfChildren;

  @FindBy(xpath = "//div[@class='roomsGuestsBottom']/button[2]")
  WebElementFacade buttonApplyRoom;

  @FindBy(xpath = "//label[@for='travelFor']")
  WebElementFacade sectionTravelFor;

  @FindBy(xpath = "//ul[contains(@class,'travelForPopup')]//li[1]")
  WebElementFacade selectTravelFor ;

  @FindBy(xpath = "//button[@id='hsw_search_button']")
  WebElementFacade buttonSearch ;

  String listCity = "//ul[contains(@class,'react-autosuggest__suggestions-list')]//p[contains(text(),'%s')]";


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
    fromXpathtoWebElement(listCity, value);
  }

  public void clickDateCheckIn(){
    JSExecutorUtility.clickByWebElement(dateCheckin, getDriver());
  }

  public void clickDateCheckOut(){
    JSExecutorUtility.clickByWebElement(dateCheckout, getDriver());
  }

  public void clickSectionRoom(){
    JSExecutorUtility.clickByWebElement(sectionRoom, getDriver());
  }

  public void clickNumberOfAdults(){
    JSExecutorUtility.clickByWebElement(numberOfAdults, getDriver());
  }

  public void clickNumberOfChildren(){
    JSExecutorUtility.clickByWebElement(numberOfChildren, getDriver());
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

}