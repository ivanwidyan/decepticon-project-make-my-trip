package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.ParamConsts;
import com.decepticon.module.constant.URLConsts;
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

  @FindBy(xpath = "//span[@class='pull-right blank_icon']//span")
  private WebElementFacade imageActiveStars;

  public void openPage() {
    openUrl(URLConsts.URL_BOOKING_SUMMARY_PAGE);
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
            .replaceAll(Consts.SINGLE_QUOTE + Consts.SPACE, Consts.EMPTY_STRING);
    return date;
  }

  public String getTextCheckOutDate(){
    String date = getTextByWebElementWithNotFoundHandling(textCheckOutDay)
            + Consts.SPACE + getTextByWebElementWithNotFoundHandling(textCheckOutDate)
            .replaceAll(Consts.SINGLE_QUOTE + Consts.SPACE, Consts.EMPTY_STRING);
    return date;
  }

  public String getTextRoomName(){
    return getTextByWebElementWithNotFoundHandling(textRoomName).split(Consts.SPACE + Consts.PIPE + Consts.SPACE)[Consts.FIRST_INDEX];
  }

  public String getTextTotalAmount(){
    return getTextByWebElementWithNotFoundHandling(textTotalAmount).replace(Consts.PERIOD, Consts.COMMA);
  }

  // Get Number
  public String getNumberActiveStars(){
    return imageActiveStars.getAttribute(ParamConsts.CLASS);
  }

  public HashMap<String, Integer> getNumberGuestsAmounts(){
    List<String> listGuests = listWebElementsToListString(listTextGuests);
    System.out.println(listGuests);
    Integer adults = 0;
    Integer children = 0;
    for (int i = 0; i < listGuests.size(); i++) {
      String[] splitGuest = listGuests.get(i).split(Consts.COMMA + Consts.SPACE);
      for (int j = 0; j < splitGuest.length; j++) {
        String[] guest = splitGuest[j].split(Consts.SPACE);
        if (guest[Consts.SECOND_INDEX].equalsIgnoreCase(ParamConsts.CHILD)) {
          children += Integer.valueOf(guest[Consts.FIRST_INDEX]);
        } else {
          adults += Integer.valueOf(guest[Consts.FIRST_INDEX]);
        }
      }
    }

    HashMap<String, Integer> guestAmount = new HashMap<>();
    guestAmount.put(ParamConsts.CHILD, children);
    guestAmount.put(ParamConsts.ADULT, adults);
    return guestAmount;
  }

}