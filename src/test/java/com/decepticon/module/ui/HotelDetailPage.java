package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;
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
    private String textMultiPrice = "//div[@class='roomLeftContRow'][%s]//div//div[%s]//div//div[contains(text(),'INR')]";
    private String textTotalPrice = "//span[@id='detpg_cart_total_price_per_night']";
    private String textRoomName = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//h2";
    private String textHotelName = "//h1[@id='detpg_hotel_name']";


    public void openPage() {
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563795492&mtkeys=N$$s9rHC9RN7n%2BtxSsswnSoHwtIG2ZXRQX%2BEQVi8%2FHcIacg8r77xn3fu0GQ%2FDsihjOxlCFQ578uL1FfL5xjKNkNiPVjAjX%2FNMibEJrdqVxuWh6JuqE3%2BGKoT5ZCEJcL5f%2BGpAA2qn9Fwa206j6hWkbhqhgqypMexh2DQttMEVaod62qMai45AO3FsJt7jhcoeBJOgg0BU82t5zLwqYpfCVzpw9Tdm4Nsk1R6OnUFmeWv36sAorfIIaAiieEw1oEwVUfgNrtxE1WE0lUkuEfwCGzK2eajPwJ8K4HVJ1u9uS6QodDBDENnNevN4PW%2FdCS8SgRIP0kfRnBbibXvcFWvMMrOQ%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTJAKA&country=IDN&lat=-6.146592&lng=106.87957&locusId=CTJAKA&locusType=city&rank=8&roomStayQualifier=2e0e&searchText=Jakarta");
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563806581&mtkeys=N$$s9rHC9RN7n8Tiq%2BKJh0FX%2FfHJk6RdDmpkJOB2277P8XMPGSAG8X64rvF9KVWXO%2Fr7ISdY8D3x4xLAYFMoMUjG0VKoF7fPJCXHVSV9fsUkF2fmz1uEw%2FQQ%2FCs72G9nzYOariuMD%2FfgcMFtL07wStkdKdprU%2BxJ6BTmtTIfnMU8YL4dfsj2fVK7ZdFymAI0ckCvHklWVcF7xPPP4rQ1EdL4BNUwJBJeaWX9Gbv%2Fjtz2O13UWb9Pj0KbqrkqpmWCQGCSzEUD5IoQ0NNNFc7cluKhsBuN2s%2FSQaQaqKimkSzwvOtFGkanGFbqBml04%2FIv3wlgo82QsHHrJ6ipZhMjSxQ3%2BAyZpa1nElwOqMdYsE9LlA%2FMkv92GDloBG2sxkACWIjdRz1r2szJZHX9oo48eHqDw%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTSINGAP&country=SGP&lat=1.24669&lng=103.8424&locusId=CTSINGAP&locusType=city&rank=3&reference=hotel&roomStayQualifier=2e0e&searchText=Singapore&type=city ");
        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563806581&mtkeys=N$$s9rHC9RN7n8Tiq%2BKJh0FX%2FfHJk6RdDmpkJOB2277P8XMPGSAG8X64rvF9KVWXO%2Fr7ISdY8D3x4xLAYFMoMUjG0VKoF7fPJCXHVSV9fsUkF2fmz1uEw%2FQQ%2FCs72G9nzYOariuMD%2FfgcMFtL07wStkdKdprU%2BxJ6BTmtTIfnMU8YL4dfsj2fVK7ZdFymAI0ckCvHklWVcF7xPPP4rQ1EdL4BNUwJBJeaWX9Gbv%2Fjtz2O13UWb9Pj0KbqrkqpmWCQGCSzEUD5IoQ0NNNFc7cluKhsBuN2s%2FSQaQaqKimkSzwvOtFGkanGFbqBml04%2FIv3wlgo82QsHHrJ6ipZhMjSxQ3%2BAyZpa1nElwOqMdYsE9LlA%2FMkv92GDloBG2sxkACWIjdRz1r2szJZHX9oo48eHqDw%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTSINGAP&country=SGP&lat=1.24669&lng=103.8424&locusId=CTSINGAP&locusType=city&rank=3&reference=hotel&roomStayQualifier=2e0e&searchText=Singapore&type=city" +
                "");
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563806581&mtkeys=N$$s9rHC9RN7n8Tiq%2BKJh0FX%2FfHJk6RdDmpkJOB2277P8XMPGSAG8X64rvF9KVWXO%2Fr7ISdY8D3x4xLAYFMoMUjG0VKoF7fPJCXHVSV9fsUkF2fmz1uEw%2FQQ%2FCs72G9nzYOariuMD%2FfgcMFtL07wStkdKdprU%2BxJ6BTmtTIfnMU8YL4dfsj2fVK7ZdFymAI0ckCvHklWVcF7xPPP4rQ1EdL4BNUwJBJeaWX9Gbv%2Fjtz2O13UWb9Pj0KbqrkqpmWCQGCSzEUD5IoQ0NNNFc7cluKhsBuN2s%2FSQaQaqKimkSzwvOtFGkanGFbqBml04%2FIv3wlgo82QsHHrJ6ipZhMjSxQ3%2BAyZpa1nElwOqMdYsE9LlA%2FMkv92GDloBG2sxkACWIjdRz1r2szJZHX9oo48eHqDw%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTSINGAP&country=SGP&lat=1.24669&lng=103.8424&locusId=CTSINGAP&locusType=city&rank=3&reference=hotel&roomStayQualifier=2e0e&searchText=Singapore&type=city");
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=20080802125928557&mtkeys=defaultMtkey&_uCurrency=INR&checkin=05302020&checkout=05312020&city=CTGOI&country=IN&lat=15.494905&lng=73.834175&locusId=CTGOI&locusType=city&rank=2&reference=hotel&roomStayQualifier=2e2e3e2e2e2e3e4e&searchText=Goa&type=city");
//        waitABit(7000);
    }

    public void openPageMultiple() {
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=20080802125928557&mtkeys=defaultMtkey&_uCurrency=INR&checkin=05312020&checkout=06012020&city=CTGOI&country=IN&lat=15.494905&lng=73.834175&locusId=CTGOI&locusType=city&rank=2&reference=hotel&roomStayQualifier=2e2e2e2e2e2e3e4e&searchText=Goa&type=city");
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563795306&mtkeys=defaultMtkey&_uCurrency=INR&checkin=05312020&checkout=06012020&city=CTJAKA&country=IDN&lat=-6.16824&lng=106.787&locusId=CTJAKA&locusType=city&rank=2&reference=hotel&roomStayQualifier=3e2e2e2e3e2e3e4e&searchText=Jakarta%2C%20Indonesia&type=city");
        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=20080802125928557&mtkeys=defaultMtkey&_uCurrency=INR&checkin=05312020&checkout=06012020&city=CTGOI&country=IN&lat=15.494905&lng=73.834175&locusId=CTGOI&locusType=city&rank=2&reference=hotel&roomStayQualifier=2e2e2e2e2e2e3e4e&searchText=Goa&type=city");
//        waitABit(7000);
    }

    public List<String> ListWebElement(List<WebElementFacade> webElementFacade) {
        int a = 0;

        List<String> List = new ArrayList<>();
        for (WebElementFacade wf : webElementFacade) {

            List.add(wf.getText());
            System.out.println(a + 1 + ". " + List.get(a));
            a++;
        }
        return List;

    }


    public void getTextPrice(String room, String option) {
        String result = fromXpathtoWebElementString(String.format(textPrice, room, option)).getText();
        System.out.println(" textPrice : " + result);

    }

    public void getTextPriceForMultiple(String room, String option) {
        String result = fromXpathtoWebElementString(String.format(textMultiPrice, room, option)).getText();
        System.out.println(" textPrice : " + result);

    }

    public void getTextTotalPriceForMultiple() {
        waitABit(1500);
        String result = fromXpathtoWebElementString(String.format(textTotalPrice)).getText();
        System.out.println(" textPrice : " + result);

    }

    public void getTextRoomName(String roomnumber) {
        String webElementFacade = find(By.xpath(String.format(textRoomName, roomnumber))).getText();
        System.out.println("Room name : " + webElementFacade);
    }

    public void getTexthotelName() {
        String webElementFacade = find(By.xpath(String.format(textHotelName))).getText();
        System.out.println("Room name : " + webElementFacade);
    }

    public void getListOption(String room, String option) {
        System.out.println("list option : ");
        ListWebElement(xpathToWebElement(String.format(listOptions, room, option)));
    }


    public void getListMultiOption(String room, String option) {
        System.out.println("list option : ");
        ListWebElement(xpathToWebElement(String.format(listmultioptions, room, option)));
    }

    public void getListIncludedMultiOption(String room, String option) {
        System.out.println(" include list :");
        ListWebElement(xpathToWebElement(String.format(listIncludedMultiOption, room, option)));
    }

    public void getListIncluded(String room, String option) {
        System.out.println(" include list :");
        ListWebElement(xpathToWebElement(String.format(listIncluded, room, option)));
    }

    public void getListRoomDetail(String roomnumber) {
        if (find(By.xpath(String.format(butonMoreAbout, roomnumber))).isPresent()) {
            find(By.xpath(String.format(butonMoreAbout, roomnumber))).click();
            System.out.println(" list room detail :");
            ListWebElement(listRoomDetails);

            System.out.println("jumlah " + listRoomDetails.size());
            if (listRoomDetails.size() != 0) {
                JSExecutorUtility.clickByWebElement(buttonCloseModal, getDriver());
            }
        }

    }

    public void clickButtonSelectRoom(String room, String option) {
        JSExecutorUtility.clickByWebElement(find(By.xpath(String.format(buttonSelectRoom, room, option))), getDriver());
    }

    public void clickButtonSelectPeopleCountList(String option) {
        JSExecutorUtility.clickByWebElement(find(By.xpath(String.format(listPeopleCount, option))), getDriver());
    }

    public void clickButtonReviewDetail() {
        JSExecutorUtility.clickByWebElement(find(By.xpath(String.format(butonReviewDetail))), getDriver());
    }

    public void clickButtonAddRoom(String room, String option) {
        JSExecutorUtility.clickByWebElement(find(By.xpath(String.format(butonAddRoom, room, option))), getDriver());
    }

    public void clickButtonPeopleCount(String room, String option) {
        System.out.println(String.format(buttonSelectPeopleCount, room, option));
        JSExecutorUtility.clickByWebElement(find(By.xpath(String.format(buttonSelectPeopleCount, room, option))), getDriver());
    }

}