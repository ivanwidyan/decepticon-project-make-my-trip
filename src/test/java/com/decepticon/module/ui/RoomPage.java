package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RoomPage extends UiUtility {

  @FindBy(xpath = "//input[@id='fName']")
  WebElementFacade textBoxFirstName;

  @FindBy(xpath = "//input[@id='lName']")
  WebElementFacade textBoxLastName;

  @FindBy(xpath = "//input[@id='email']")
  WebElementFacade textBoxEmail;

  @FindBy(xpath = "//select[@id='mCode']")
  WebElementFacade sectionMobileCode;

  @FindBy(xpath = "//select[@id='mCode']//option[@value='+62']")
  WebElementFacade listMobileCode;

  @FindBy(xpath = "//input[@id='mNo']")
  WebElementFacade textBoxMobileNumber;

  @FindBy(xpath = "//input[@id='pan']")
  WebElementFacade textBoxPan;

  @FindBy(xpath = "//div[@class='_SpecialRequest']")
  WebElementFacade sectionOptionalRequest;

  @FindBy(xpath = "//label[@for='donation']")
  WebElementFacade checkBoxDonation;

  @FindBy(xpath = "//a[@class='primaryBtn btnPayNow']")
  WebElementFacade buttonPaynow;

  String checkListOptions = "//div[@class='_SpecialRequest']//ul//li//label[contains(text(),'%s')]";

  public void openPage() {
    openUrl("https://www.makemytrip.com/hotels/hotel-review?_uCurrency=INR&checkin=06112020&checkout=06122020&city=CTBAL9d5bd6c3&country=IDN&hotelId=4190725563788205&lat=-8.766871&lng=115.22274&locusId=CTBAL9d5bd6c3&locusType=city&mobius=false&mtKey=N%24%24s9rHC9RN7n8gUHwweiFaA%252FlK3e4puJWQT%252FKxyESArvI3xl0flo6%252FuRs%252FY5TW%252F7wspxjyqxH5JQJLM94Oumx8wnqhB%252BnDf40tcRA66Ui7K60x64uCpSqAlWjpCxqA547AoKCmT%252Fs7cxdGfj%252FMRtjvYbCc5VbqdVx4iuctP5iCy23BkOjs85h37CSNtrlLuwQghi1Bx%252FG02RgyZe3x7kXop0tZQSj09MBSli2END8Rsko8%252Byb6Y3h63VQtCIC91Cz7d1bt%252B9KlQKi16JZ65wpoDfSwh6Csj7vIR99YzxwytABBVgEVsYaR%252FkNWGDgJ%252Bd6aPJRVVHULwoi%252BlCBJkZyyWtjdkgGbGO%252BDSF7Na4OZoKE%253D&mtkeys=defaultMtkey&payMode=PAS&rank=2&roomCriteria=967698~%7C~990000786920%3AMSE%3A1120%3AMSE%3AINGO~%7C~2e0e&roomStayQualifier=2e0e&searchText=Bali%2C%20Indonesia&searchType=E&suppDetail=INGO&visitorId=cdd039fb-49ed-43a6-97e8-39cdf7eb09a7");
  }

  public void typeTextBoxFirstName(String value){
    textBoxFirstName.type(value);
  }

  public void typeTextBoxLastName(String value){
    textBoxLastName.type(value);
  }

  public void typeTextBoxEmail(String value){
    textBoxEmail.type(value);
  }

  public void clickSectionMobileCode(){
    JSExecutorUtility.clickByWebElement(sectionMobileCode, getDriver());
  }

  public void clickListMobileCode(){
    JSExecutorUtility.clickByWebElement(listMobileCode, getDriver());
  }

  public void typeTextBoxMobileNumber(String value){
    textBoxMobileNumber.type(value);
  }

  public void typeTextBoxPanString(String value){
    textBoxPan.type(value);
  }

  public void clickCheckListOptions(String value){
    JSExecutorUtility.clickByWebElement(fromXpathtoWebElement(String.format(checkListOptions, value)), getDriver());
  }

  public void clickCheckBoxDonation(){
    JSExecutorUtility.clickByWebElement(checkBoxDonation, getDriver());
  }

  public void clickButtonPayNow(){
    JSExecutorUtility.clickByWebElement(buttonPaynow, getDriver());
  }
}