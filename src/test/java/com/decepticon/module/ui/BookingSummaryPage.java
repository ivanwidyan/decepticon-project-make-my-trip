package com.decepticon.module.ui;

import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class BookingSummaryPage extends UiUtility {

  // Text Elements
  @FindBy(xpath = "//p[@class='hotel_name pymt-htlInfo-name lato-semibold append_bottom6']")
  private WebElementFacade textHotelName;

  @FindBy(xpath = "//p[@class='hotel_location pymt-htlInfo-loc lato-regular']")
  private WebElementFacade textAdress;

  @FindBy(xpath = "//span[@class='pull-right blank_icon']//span")
  private WebElementFacade imageActiveStars;

  @FindBy(xpath = "//div[@class='checkin pull-left']//span[@class='lato-semibold']")
  private WebElementFacade textCheckInDate;

  @FindBy(xpath = "//div[@class='checkin pull-left']//span[@class='lato-regular grey']")
  private WebElementFacade textCheckInDay;

  @FindBy(xpath = "//div[@class='checkout pull-right']//span[@class='lato-semibold']")
  private WebElementFacade textCheckOutDate;

  @FindBy(xpath = "//div[@class='checkout pull-right']//span[@class='lato-regular grey']")
  private WebElementFacade textCheckOutDay;

  @FindBy(xpath = "//span[@id='top_rail_totalAmount']")
  private WebElementFacade textTotalAmount;

  @FindBy(xpath = "//span[@class='make_block lato-regular adult_info']")
  private List<WebElementFacade> listTextGuests;

  public void openPage() {
    openUrl("https://m-securepay.makemytrip.com/common-payment-web-iframe/loadCheckoutPage.pymt?checkoutId=465726554443200");
  }

  // Get Text
  public String getTextHotelName(){
    return textHotelName.getText();
  }

  public String getTextAdress(){
    return textAdress.getText();
  }

  public String getTextCheckInDay(){
    return textCheckInDay.getText();
  }

  public String getTextCheckInDate(){
    return textCheckInDate.getText();
  }

  public String getTextCheckOutDay(){
    return textCheckOutDay.getText();
  }

  public String getTextCheckOutDate(){
    return textCheckOutDate.getText();
  }

  public String getTextTotalAmount(){
    return textTotalAmount.getText();
  }

  public List<String> getTextGuests(){
    return listWebElementsToListString(listTextGuests);
  }

  // Get Number
  public String getNumberActiveStars(){
    return imageActiveStars.getAttribute("class");
  }
}