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
    private List<WebElementFacade> listRoomDetails;

    @FindBy(xpath = "//span[contains(@class,'close')]")
    private WebElementFacade closeModalButton;

    private String selectRoomButton = "//div[@class='roomWrap'][%s]//div[%s]//a[@class='primaryBtn appendBottom15 ']";

    private String price = "//div[@class='roomWrap'][%s]//div[@class='roomRight']/div[%s]//span[@class='bxNegotiate appendBottom5']";

    private String listOptions = "//div[@class='roomWrap'][%s]//div[%s]//div[@class='makeFlex  appendBottom15']";

    private String includeList = "//div[@class='roomWrap'][%s]//div[%s]//ul[@class='includeList']//li";

    private String moreAboutButton = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//a";

    private String roomSelectionOption = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//h2";


    public void openPage() {
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563795492&mtkeys=N$$s9rHC9RN7n%2BtxSsswnSoHwtIG2ZXRQX%2BEQVi8%2FHcIacg8r77xn3fu0GQ%2FDsihjOxlCFQ578uL1FfL5xjKNkNiPVjAjX%2FNMibEJrdqVxuWh6JuqE3%2BGKoT5ZCEJcL5f%2BGpAA2qn9Fwa206j6hWkbhqhgqypMexh2DQttMEVaod62qMai45AO3FsJt7jhcoeBJOgg0BU82t5zLwqYpfCVzpw9Tdm4Nsk1R6OnUFmeWv36sAorfIIaAiieEw1oEwVUfgNrtxE1WE0lUkuEfwCGzK2eajPwJ8K4HVJ1u9uS6QodDBDENnNevN4PW%2FdCS8SgRIP0kfRnBbibXvcFWvMMrOQ%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTJAKA&country=IDN&lat=-6.146592&lng=106.87957&locusId=CTJAKA&locusType=city&rank=8&roomStayQualifier=2e0e&searchText=Jakarta");
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563806581&mtkeys=N$$s9rHC9RN7n8Tiq%2BKJh0FX%2FfHJk6RdDmpkJOB2277P8XMPGSAG8X64rvF9KVWXO%2Fr7ISdY8D3x4xLAYFMoMUjG0VKoF7fPJCXHVSV9fsUkF2fmz1uEw%2FQQ%2FCs72G9nzYOariuMD%2FfgcMFtL07wStkdKdprU%2BxJ6BTmtTIfnMU8YL4dfsj2fVK7ZdFymAI0ckCvHklWVcF7xPPP4rQ1EdL4BNUwJBJeaWX9Gbv%2Fjtz2O13UWb9Pj0KbqrkqpmWCQGCSzEUD5IoQ0NNNFc7cluKhsBuN2s%2FSQaQaqKimkSzwvOtFGkanGFbqBml04%2FIv3wlgo82QsHHrJ6ipZhMjSxQ3%2BAyZpa1nElwOqMdYsE9LlA%2FMkv92GDloBG2sxkACWIjdRz1r2szJZHX9oo48eHqDw%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTSINGAP&country=SGP&lat=1.24669&lng=103.8424&locusId=CTSINGAP&locusType=city&rank=3&reference=hotel&roomStayQualifier=2e0e&searchText=Singapore&type=city" +
//                "");
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563806581&mtkeys=N$$s9rHC9RN7n8Tiq%2BKJh0FX%2FfHJk6RdDmpkJOB2277P8XMPGSAG8X64rvF9KVWXO%2Fr7ISdY8D3x4xLAYFMoMUjG0VKoF7fPJCXHVSV9fsUkF2fmz1uEw%2FQQ%2FCs72G9nzYOariuMD%2FfgcMFtL07wStkdKdprU%2BxJ6BTmtTIfnMU8YL4dfsj2fVK7ZdFymAI0ckCvHklWVcF7xPPP4rQ1EdL4BNUwJBJeaWX9Gbv%2Fjtz2O13UWb9Pj0KbqrkqpmWCQGCSzEUD5IoQ0NNNFc7cluKhsBuN2s%2FSQaQaqKimkSzwvOtFGkanGFbqBml04%2FIv3wlgo82QsHHrJ6ipZhMjSxQ3%2BAyZpa1nElwOqMdYsE9LlA%2FMkv92GDloBG2sxkACWIjdRz1r2szJZHX9oo48eHqDw%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTSINGAP&country=SGP&lat=1.24669&lng=103.8424&locusId=CTSINGAP&locusType=city&rank=3&reference=hotel&roomStayQualifier=2e0e&searchText=Singapore&type=city");
        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563791786&mtkeys=N$$s9rHC9RN7n%2FSITW3aioWYAamjV3A5q0o6JgRVoqfDgFJldy%2FgqAaPmNcr3yihC1JWwPYKWo%2F4DW4qRZ4fzeiI9Ncp0xCuGAVhjM36ZFZJTMqaXMa9eJga6%2FCGYD8210Ssw7N450jmDbKKiNDeifrVHqUXyaOm6sk4mxk2E9Gm4sBMiENUCFQ7h2XOGOT%2BcKiJhqPbk%2Fw1uZI8PWQlyFJoqNJ7oQAo7S8tS%2FnwOUw4xUlviPmn%2FqM%2BEon6N6cEIpO0XLNKKKU8ES0HTs%2BAsDLvK6sg3loXK0hVfACzdfFrdjQqzpbPIGOZWZnVbnZTBsevTkoemfKFsXQo8stegoHcg8gcKDeNORZ&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTSINGAP&country=SGP&lat=1.306668&lng=103.83281&locusId=CTSINGAP&locusType=city&rank=6&reference=hotel&roomStayQualifier=2e0e&searchText=Singapore&type=city");
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

    public void getOption(int room, int option) {
        System.out.println("list option : ");
        ListWebElement(xpathToWebElement(String.format(listOptions, room, option)));
    }

    public void getIncludeList(int room, int option) {
        System.out.println(" include list :");
        ListWebElement(xpathToWebElement(String.format(includeList, room, option)));


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

    public void selectRoom(int room, int option) {
        JSExecutorUtility.clickByWebElement(find(By.xpath(String.format(selectRoomButton, room, option))), getDriver());
    }

    public void getRoomName(Integer roomnumber) {
        String webElementFacade = find(By.xpath(String.format(roomSelectionOption, roomnumber))).getText();
        System.out.println("Room name : " + webElementFacade);
    }


}