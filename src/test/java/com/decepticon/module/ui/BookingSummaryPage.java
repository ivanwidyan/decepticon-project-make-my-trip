package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.HashMap;
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

  @FindBy(xpath = "//span[@class='black']")
  private WebElementFacade textRoomName;

  @FindBy(xpath = "//span[@id='top_rail_totalAmount']")
  private WebElementFacade textTotalAmount;

  @FindBy(xpath = "//span[@class='make_block lato-regular adult_info']")
  private List<WebElementFacade> listTextGuests;

  public void openPage() {
    openUrl("https://m-securepay.makemytrip.com/common-payment-web-iframe/loadCheckoutPage.pymt?checkoutId=465732626918207");
  }

  // Get Text
  public String getTextHotelName(){
    System.out.println((getTextByWebElementWithNotFoundHandling(textHotelName)));
    return getTextByWebElementWithNotFoundHandling(textHotelName);
  }

  public String getTextAdress(){
    return getTextByWebElementWithNotFoundHandling(textAdress);
  }

  public String getTextCheckInDate(){
    String date = getTextByWebElementWithNotFoundHandling(textCheckInDay)
            + Consts.SPACE + getTextByWebElementWithNotFoundHandling(textCheckInDate)
            .replaceAll("' ", Consts.EMPTY_STRING);
    return date;
  }

  public String getTextCheckOutDate(){
    String date = getTextByWebElementWithNotFoundHandling(textCheckOutDay)
            + Consts.SPACE + getTextByWebElementWithNotFoundHandling(textCheckOutDate)
            .replaceAll("' ", Consts.EMPTY_STRING);
    return date;
  }

  public String getTextRoomName(){
    return getTextByWebElementWithNotFoundHandling(textRoomName).split(" \\| ")[0];
  }

  public String getTextTotalAmount(){
    return getTextByWebElementWithNotFoundHandling(textTotalAmount).replace(Consts.PERIOD, Consts.COMMA);
  }

  public HashMap<String, Integer> getNumberGuestsAmounts(){
    List<String> listGuests = listWebElementsToListString(listTextGuests);
    System.out.println(listGuests);
    Integer adults = 0;
    Integer children = 0;
    for (int i = 0; i < listGuests.size(); i++) {
      String[] splitGuest = listGuests.get(i).split(", ");
      for (int j = 0; j < splitGuest.length; j++) {
        String[] guest = splitGuest[j].split(" ");
        if (guest[1].equalsIgnoreCase("child")) {
          children += Integer.valueOf(guest[0]);
        } else {
          adults += Integer.valueOf(guest[0]);
        }
      }
    }

    HashMap<String, Integer> guestAmount = new HashMap<>();
    guestAmount.put("child", children);
    guestAmount.put("adult", adults);
    return guestAmount;
  }

  // Get Number
  public String getNumberActiveStars(){
    return imageActiveStars.getAttribute("class");
  }
}