package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.ScrollToWebElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class HotelDetailPage extends UiUtility {


    //masih static
    @FindBy(xpath = "//div[@class='roomWrap'][1]//div[@class='makeFlex bdrBottom   '][1]//a[@class='primaryBtn appendBottom15 ']")
    WebElementFacade selectRoomButton;

    @FindBy(xpath = "//div[@class='popWrapper']//div[@class='popRight']//ul//li")
    List<WebElementFacade> listRoomDetails;

    @FindBy(xpath = "//span[contains(@class,'close')]")
    WebElementFacade closeModalButton;

    @FindBy(xpath = "//div[@class='roomWrap'][1]//div[@class='roomRight']//div[@class='makeFlex bdrBottom  recRoom ']")
    WebElementFacade recomendedOption;

    @FindBy(xpath = "//div[@class='roomWrap'][1]//div[@class='roomRight']//div[@class='makeFlex bdrBottom   ']")
    WebElementFacade totalOptions;


    public String price = "//div[@class='roomWrap'][%s]//div[@class='makeFlex bdrBottom   '][%s]//span[@class='bxNegotiate appendBottom5']";
    public String listOptions = "//div[@class='roomWrap'][%s]//div[@class='makeFlex bdrBottom   '][%s]//div[@class='makeFlex  appendBottom15']";


    public String includeList="//div[@class='roomWrap'][%s]//div[@class='makeFlex bdrBottom   '][%s]//ul[@class='includeList']//li";
    public String moreAboutButton = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//a";


    public String roomSelectionOption = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//h2";


    public void openPage() {
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563795492&mtkeys=N$$s9rHC9RN7n%2BtxSsswnSoHwtIG2ZXRQX%2BEQVi8%2FHcIacg8r77xn3fu0GQ%2FDsihjOxlCFQ578uL1FfL5xjKNkNiPVjAjX%2FNMibEJrdqVxuWh6JuqE3%2BGKoT5ZCEJcL5f%2BGpAA2qn9Fwa206j6hWkbhqhgqypMexh2DQttMEVaod62qMai45AO3FsJt7jhcoeBJOgg0BU82t5zLwqYpfCVzpw9Tdm4Nsk1R6OnUFmeWv36sAorfIIaAiieEw1oEwVUfgNrtxE1WE0lUkuEfwCGzK2eajPwJ8K4HVJ1u9uS6QodDBDENnNevN4PW%2FdCS8SgRIP0kfRnBbibXvcFWvMMrOQ%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTJAKA&country=IDN&lat=-6.146592&lng=106.87957&locusId=CTJAKA&locusType=city&rank=8&roomStayQualifier=2e0e&searchText=Jakarta");
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563806581&mtkeys=N$$s9rHC9RN7n8Tiq%2BKJh0FX%2FfHJk6RdDmpkJOB2277P8XMPGSAG8X64rvF9KVWXO%2Fr7ISdY8D3x4xLAYFMoMUjG0VKoF7fPJCXHVSV9fsUkF2fmz1uEw%2FQQ%2FCs72G9nzYOariuMD%2FfgcMFtL07wStkdKdprU%2BxJ6BTmtTIfnMU8YL4dfsj2fVK7ZdFymAI0ckCvHklWVcF7xPPP4rQ1EdL4BNUwJBJeaWX9Gbv%2Fjtz2O13UWb9Pj0KbqrkqpmWCQGCSzEUD5IoQ0NNNFc7cluKhsBuN2s%2FSQaQaqKimkSzwvOtFGkanGFbqBml04%2FIv3wlgo82QsHHrJ6ipZhMjSxQ3%2BAyZpa1nElwOqMdYsE9LlA%2FMkv92GDloBG2sxkACWIjdRz1r2szJZHX9oo48eHqDw%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTSINGAP&country=SGP&lat=1.24669&lng=103.8424&locusId=CTSINGAP&locusType=city&rank=3&reference=hotel&roomStayQualifier=2e0e&searchText=Singapore&type=city" +
//                "");
        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=201904081604352311&mtkeys=N$$s9rHC9RN7n8QohaJbMdjldD%2FZ1vwE9b%2B%2F0KYhBZTUBamxc6Oo1E5E%2FpUMS%2BkYUWOU7uT7XFnOkzEjEC0kTVrI0B2RfycmwD4dT1i7%2BBwrWKHiqNU46EwxbzKyhICOQRipz6BEqGW7tgOrmD39ibOHX32Y2d2jPdw1CaKXMQlZj8FMBaFK4A5Qrm7dKyiRoKQOvYBSlzD5X%2F1cWlDgM%2F3mdjyXOiJmer5%2B7sP7EUMyQlHpdI4KGofX9Ap8DJMYWLOrzRwhsHVrf%2BxaUOnmQt7h6Qvmw2WzvEwd0WQRK4QxOkQ4oSshrFDFA%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTDEL&country=IN&lat=28.549498&lng=77.129074&locusId=CTDEL&locusType=city&rank=3&reference=hotel&roomStayQualifier=2e2e4e4e2e2e4e6e&searchText=Delhi&type=city");
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

    public void getPrice(int room, int option) {
        String result = fromXpathtoWebElementString(String.format(price, room, option)).getText();
        System.out.println(" price : " + result);

    }

    public void getOption(int room,int option) {
        System.out.println("list option : ");
        ListWebElement(xpathToWebElement(String.format(listOptions,room,option)));
    }

    public void getIncludeList(int room,int option) {
        System.out.println(" include list :");
        ListWebElement(xpathToWebElement(String.format(includeList,room,option)));


    }

    public void getRoomDetail(Integer roomnumber) {
        if (find(By.xpath(String.format(moreAboutButton, roomnumber))).isPresent()) {
            find(By.xpath(String.format(moreAboutButton, roomnumber))).click();
            System.out.println(" list room detail :");
            ListWebElement(listRoomDetails);

            System.out.println("jumlah " + listRoomDetails.size());
            if (listRoomDetails.size() != 0) {
                JSExecutorUtility.clickByWebElement(closeModalButton, getDriver());
            }
        }

    }

    public void selectRoom() {
        JSExecutorUtility.clickByWebElement(selectRoomButton, getDriver());


    }

    public void getRoomName(Integer roomnumber) {
        String webElementFacade = find(By.xpath(String.format(roomSelectionOption, roomnumber))).getText();
        System.out.println("Room name : " + webElementFacade);
    }

    public void all() {
        getRoomName(2);
        getPrice(2, 2);
        getOption(2,2);
        getIncludeList(2,2);
        getRoomDetail(2);
        selectRoom();

    }

}