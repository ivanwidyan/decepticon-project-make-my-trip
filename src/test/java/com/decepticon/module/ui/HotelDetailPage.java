package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class HotelDetailPage extends UiUtility {


    @FindBy(xpath = "//div[@class='popWrapper']//div[@class='popRight']//ul//li")
    List<WebElementFacade> listRoomDetails;

    @FindBy(xpath = "//span[contains(@class,'close')]")
    WebElementFacade buttonCloseModal;

    private String listPeopleCount = "//ul[1]//li[@class='ddListItem'][%s]";
    private String listmultioptions = "//div[@class='roomLeftContRow'][%s]//div[@class='multiRoomRow   '][%s]//div[@class='makeFlex  appendBottom15']";
    private String listOptions = "//div[@class='roomWrap'][%s]//div[%s]//div[@class='makeFlex  appendBottom15']";
    private String listIncluded = "//div[@class='roomWrap'][%s]//div[%s]//ul[@class='includeList']//li";
    private String listIncludedMultiOption = "//div[@class='roomLeftContRow'][%s]//div[@class='multiRoomRow   '][%s]//ul[@class='includeList']//li";

    private String buttonSelectRoom = "//div[@class='roomWrap'][%s]//div[%s]//a[@class='primaryBtn appendBottom15 ']";
    private String buttonSelectPeopleCount = "//div[@class='roomLeftContRow'][%s]//div[@class='multiRoomRow   '][%s]//div[@class='ddHeader']";
    private String butonMoreAbout = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//a";
    private String butonAddRoom = "//div[@class='roomLeftContRow'][%s]//div//div[%s]//div//a[@class='primaryBtn btnAddRoom']";
    private String butonReviewDetail = "//a[@id='detpg_confirm_booking_btn']";


    private String textPrice = "//div[@class='roomWrap'][%s]//div[@class='roomRight']/div[%s]//span[@class='bxNegotiate appendBottom5']";
    private String textMultiPrice = "//div[@class='roomLeftContRow'][1]//div//div[2]//div[@class='col4']//div[contains(@class, 'pricebreakupCont')]";
    private String textTotalPrice = "//span[@id='detpg_cart_total_price_per_night']";
    private String textRoomName = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//h2";
    private String textHotelName = "//h1[@id='detpg_hotel_name']";


    public void openPage() {
        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=201106011040491072&mtkeys=N$$s9rHC9RN7n%2FNCnK1MZUInmtEnDex85wWFO1LOYeiqOm9Yy9qa4gJJQHvtubmjB9KeQnt2ebiPXagZqgxPcmUSkv9LMFhP129drlkCVJajQP%2BkqsfY9G6kIxYlQri39cVQncj3w%2BK6WHp5mz8WYDM1bxzIGqRRAHYouasPjnWDdyazmJB5BcMDyKiEt5VS9EOiuKUf1Jd3d%2FrHBm5ZNsz6iSHBsoPx%2FJl4gH2bxxO5XU7mJUNOiOI1xHIeWVtXz5DA7vookzSJuPNCp2y6TjAjx86WzvtHLV4pO9DFO%2FID2eLcFjXWY%2BEkiqn3uO4Fb4ZRPa1SOFjNt7WUhvsMh9G67x2IWSCWXIgxGRIhD%2BF8HRMa6B4XFYZ8TAgzakYRib0PKzIfr3VlmN4rYni5Zn%2FarS2JnapNDZs&_uCurrency=INR&checkin=05312020&checkout=06012020&city=CTCJB&country=IN&filterData=HOTEL_PRICE%7C1000-30000%5EUSER_RATING%7C4&lat=11.057982&lng=77.07205&locusId=RGCJB&locusType=region&rank=5&reference=hotel&roomStayQualifier=2e0e2e0e&searchText=Coimbatore%20District%2C%20Tamil%20Nadu%2C%20India&type=region");
    }

    public void openPageMultiple() {
        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=20080802125928557&mtkeys=defaultMtkey&_uCurrency=INR&checkin=05312020&checkout=06012020&city=CTGOI&country=IN&lat=15.494905&lng=73.834175&locusId=CTGOI&locusType=city&rank=2&reference=hotel&roomStayQualifier=2e2e2e2e2e2e3e4e&searchText=Goa&type=city");
    }


    public void getTextPrice(String room, String option) {
        String result = fromXpathtoWebElementString(String.format(textPrice, room, option)).getText();

    }

    public void getTextPriceForMultiple(String room, String option) {
        String result = fromXpathtoWebElementString(String.format(textMultiPrice, room, option)).getText();

    }

    public void getTextTotalPriceForMultiple() {
        String result = fromXpathtoWebElementString(String.format(textTotalPrice)).getText();
    }

    public String getTextRoomName(String roomnumber) {
        String webElementFacade = find(By.xpath(String.format(textRoomName, roomnumber))).getText();
        return webElementFacade;
    }

    public String getTexthotelName() {
        String webElementFacade = find(By.xpath(String.format(textHotelName))).getText();
        return webElementFacade;
    }

    public void getListOption(String room, String option) {
        listWebElementsToListString(xpathToWebElement(String.format(listOptions, room, option)));
    }


    public void getListMultiOption(String room, String option) {
        listWebElementsToListString(xpathToWebElement(String.format(listmultioptions, room, option)));
    }

    public void getListIncludedMultiOption(String room, String option) {
        listWebElementsToListString(xpathToWebElement(String.format(listIncludedMultiOption, room, option)));
    }

    public void getListIncluded(String room, String option) {
        listWebElementsToListString(xpathToWebElement(String.format(listIncluded, room, option)));
    }

    public void getListRoomDetail(String roomnumber) {
        if (find(By.xpath(String.format(butonMoreAbout, roomnumber))).isPresent()) {
            find(By.xpath(String.format(butonMoreAbout, roomnumber))).click();
            listWebElementsToListString(listRoomDetails);

            if (listRoomDetails.size() != Consts.FIRST_INDEX) {
                clickByWebElement(buttonCloseModal);
            }
        }

    }

    public void clickButtonSelectRoom(String room, String option) {
        clickByWebElement(find(By.xpath(String.format(buttonSelectRoom, room, option))));
    }

    public void clickButtonSelectPeopleCountList(String option) {
        clickByWebElement(find(By.xpath(String.format(listPeopleCount, option))));
    }

    public void clickButtonReviewDetail() {
        clickByWebElement(find(By.xpath(String.format(butonReviewDetail))));
    }

    public void clickButtonAddRoom(String room, String option) {
        clickByWebElement(find(By.xpath(String.format(butonAddRoom, room, option))));
    }

    public void clickButtonPeopleCount(String room, String option) {
        clickByWebElement(find(By.xpath(String.format(buttonSelectPeopleCount, room, option))));
    }

}