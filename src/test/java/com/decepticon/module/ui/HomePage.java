package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends PageObject {

  @FindBy(xpath = "//div[@class='chHeaderContainer']//nav//li[2]")
  WebElementFacade clickHotels;

  @FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']")
  WebElementFacade clickLogin;

  @FindBy(xpath = "//input[@id='username']")
  WebElementFacade typeEmail;

  @FindBy(xpath = "//button[@class='capText font16']")
  WebElementFacade clickContinue;

  @FindBy(xpath = "//input[@id='password']")
  WebElementFacade typePassword;

  @FindBy(xpath = "//span[@class='crossIcon popupSprite popupCrossIcon']")
  WebElementFacade closeLogin;

  @FindBy(xpath = "//label[@for='city']")
  WebElementFacade clickCity;

  @FindBy(xpath = "//input[contains(@placeholder,'Enter city/ Hotel/ Area/ Building')]")
  WebElementFacade typeLocation;

  @FindBy(xpath = "//ul[contains(@class,'react-autosuggest__suggestions-list')]//p[contains(text(),'Bali')]")
  WebElementFacade clickLocation;

  @FindBy(xpath = "//label[@for='checkin']")
  WebElementFacade clickcheckIn;

  @FindBy(xpath = "//div[@class = 'DayPicker-Month'][2]//div[@class = 'DayPicker-Week'][1]//div[@class = 'DayPicker-Day'][3]")
  WebElementFacade dateCheckin;

  @FindBy(xpath = "//label[@for='checkout']")
  WebElementFacade clickCheckout;

  @FindBy(xpath = "//div[@class = 'DayPicker-Month'][2]//div[@class = 'DayPicker-Week'][2]//div[@class = 'DayPicker-Day'][1]")
  WebElementFacade dateCheckout;

  @FindBy(xpath = "//label[@for='guest']")
  WebElementFacade clickRoom;

  @FindBy(xpath = "//div[contains(@class,'hsw_inner')]//ul[1]//li[2]")
  WebElementFacade selectAdults ;

  @FindBy(xpath = "//div[contains(@class,'minContainer')]//ul[2]//li[1]")
  WebElementFacade selectChildren ;

  @FindBy(xpath = "//div[@class='roomsGuestsBottom']/button[2]")
  WebElementFacade buttonApply ;

  @FindBy(xpath = "//label[@for='travelFor']")
  WebElementFacade clickTravelFor ;

  @FindBy(xpath = "//ul[contains(@class,'travelForPopup')]//li[1]")
  WebElementFacade selectTravelFor ;

  @FindBy(xpath = "//button[@id='hsw_search_button']")
  WebElementFacade buttonSearch ;


  public void openPage() {
    openUrl("https://www.makemytrip.com/");
  }



  public void doLogin(){
    clickLogin.click();;
    typeEmail.type("Satutesting2@gmail.com");
    clickContinue.waitUntilClickable();
    clickContinue.click();
    clickContinue.click();
    typePassword.type("mytripbolot1!");
    clickContinue.click();
    try{
      closeLogin.click();
    } catch (Exception e){
      e.printStackTrace();
    }

  }

  public void doSearch(){
    clickHotels.click();
    clickCity.click();
    typeLocation.type("Indonesia");
    clickLocation.waitUntilPresent();
    clickLocation.click();
    JSExecutorUtility.clickByWebElement(dateCheckin, getDriver());
    JSExecutorUtility.clickByWebElement(dateCheckout, getDriver());
    clickRoom.click();
    selectAdults.click();
    selectChildren.click();
    selectChildren.click();
    buttonApply.click();
    clickTravelFor.click();
    selectTravelFor.click();
    buttonSearch.click();
  }
}