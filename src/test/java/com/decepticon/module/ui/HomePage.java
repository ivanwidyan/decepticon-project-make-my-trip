package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
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


  public void openPage() {
    openUrl("https://www.makemytrip.com/");
  }

  public void doLogin(){
    clickLogin.click();;
    typeEmail.type("Satutesting2@gmail.com");
    clickContinue.waitUntilEnabled();
    JSExecutorUtility.clickByWebElement(clickContinue, getDriver());
    typePassword.type("mytripbolot1!");
    clickContinue.click();
    closeLogin.click();

  }

  public void doSearch(){
    clickHotels.click();
  }
}