package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.URLConsts;
import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import com.decepticon.module.utils.Utility;
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
        openUrl(URLConsts.URL_HOTEL_DETAIL_PAGE);
    }

    public void openPageMultiple() {
        openUrl(URLConsts.URL_HOTEL_DETAIL_PAGE);
    }

    // Get Text
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
        WebElementFacade webElementFacade = find(By.xpath(String.format(textRoomName, roomnumber)));
        webElementFacade.waitUntilVisible();
        String hotelName = webElementFacade.getText();
        return hotelName;
    }

    public String getTexthotelName() {
        String webElementFacade = find(By.xpath(String.format(textHotelName))).getText();
        return webElementFacade;
    }

    public void getListOption(String room, String option) {
        Utility.takeScreenshot(getDriver());
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

    // Click Actions
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