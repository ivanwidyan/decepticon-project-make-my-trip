package com.decepticon.module.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.List;

public class BookingSummaryPage extends PageObject {

  // Text Elements
  @FindBy(xpath = "//p[@class='cityName']")
  private WebElementFacade textCityName;

  @FindBy(xpath = "//p[@class='ellipsis light_gray hidden-xs']")
  private WebElementFacade textAdress;

  @FindBy(xpath = "//div[@class='col-sm-2 col-xs-2 hidden-xs grt_arrow_aligment']//p[@class='inOut_date append_bottom5']")
  private WebElementFacade textCheckInMonthDay;

  @FindBy(xpath = "//div[@class='col-sm-2 col-xs-2 hidden-xs grt_arrow_aligment']//p[@class='inOut_date append_bottom5']//span")
  private WebElementFacade textCheckInDate;

  @FindBy(xpath = "//div[@class='col-sm-2 col-xs-2 hidden-xs']//p[@class='inOut_date append_bottom5']")
  private WebElementFacade textCheckOutMonthDay;

  @FindBy(xpath = "//div[@class='col-sm-2 col-xs-2 hidden-xs']//p[@class='inOut_date append_bottom5']//span")
  private WebElementFacade textCheckOutDate;

  @FindBy(xpath = "//p[@class='travel_price append_bottom5']//span[@class='formattedCurrency grandTotal']")
  private WebElementFacade textTotalAmount;

  // Image Elements
  @FindBy(xpath = "//p[@class='star_category append_bottom5']//span[@class='glyphicon glyphicon-star active-star']")
  private List<WebElementFacade> listImageActiveStars;

  public void openPage() {
    openUrl("https://m-securepay.makemytrip.com/common-payment-web-iframe/loadCheckoutPage.pymt?checkoutId=465696416581428");
  }

  // Get Text
  public String getTextCityName(){
    return textCityName.getText();
  }

  public String getTextAdress(){
    return textAdress.getText();
  }

  public String getTextCheckInMonthDay(){
    return textCheckInMonthDay.getText();
  }

  public String getTextCheckInDate(){
    return textCheckInDate.getText();
  }

  public String getTextCheckOutMonthDay(){
    return textCheckOutMonthDay.getText();
  }

  public String getTextCheckOutDate(){
    return textCheckOutDate.getText();
  }

  public String getTextTotalAmount(){
    return textTotalAmount.getText();
  }

  // Get Number
  public Integer getNumberActiveStars(){
    return listImageActiveStars.size();
  }
}