package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

public class HotelDetailPage extends PageObject {


    //masih static
    @FindBy(xpath = "//div[@class='roomWrap'][1]//div[@class='roomRight']//div[@class='makeFlex bdrBottom   '][2]//div[@class='makeFlex column titleLastWidth']//a[@class='primaryBtn appendBottom15 ']")
    WebElementFacade selecRoomButton;

    @FindBy(xpath = "//div[@class='popWrapper']//div[@class='popRight']//ul//li")
    List<WebElementFacade> listRoomDetails;

    @FindBy(xpath = "//span[contains(@class,'close')]")
    WebElementFacade closeModalButton;

    //masih static
    @FindBy(xpath = "//div[@class='roomWrap'][1]//div[@class='roomRight']//div[@class='makeFlex bdrBottom   '][2]//div[@class='makeFlex column titleLastWidth']//div[@class='makeFlex appendTop40 roomTypePrice']")
    WebElementFacade price;

    @FindBy(xpath = "//div[@class='roomWrap'][1]//div[@class='roomRight']//div[@class='makeFlex bdrBottom  recRoom ']")
    WebElementFacade recomendedOption;

    @FindBy(xpath = "//div[@class='roomWrap'][1]//div[@class='roomRight']//div[@class='makeFlex bdrBottom   ']")
    WebElementFacade totalOptions;

    @FindBy(xpath = "//div[@class='roomWrap'][1]//div[@class='roomRight']//div[@class='makeFlex bdrBottom   '][1]//div[@class='makeFlex column titleWidth']//div[@class='makeFlex  appendBottom15']")
    List<WebElementFacade> listoptions;

    public String moreAboutButton = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//a";


    public String roomSelectionOption = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//h2";


    public void openPage() {
        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563795492&mtkeys=N$$s9rHC9RN7n%2BtxSsswnSoHwtIG2ZXRQX%2BEQVi8%2FHcIacg8r77xn3fu0GQ%2FDsihjOxlCFQ578uL1FfL5xjKNkNiPVjAjX%2FNMibEJrdqVxuWh6JuqE3%2BGKoT5ZCEJcL5f%2BGpAA2qn9Fwa206j6hWkbhqhgqypMexh2DQttMEVaod62qMai45AO3FsJt7jhcoeBJOgg0BU82t5zLwqYpfCVzpw9Tdm4Nsk1R6OnUFmeWv36sAorfIIaAiieEw1oEwVUfgNrtxE1WE0lUkuEfwCGzK2eajPwJ8K4HVJ1u9uS6QodDBDENnNevN4PW%2FdCS8SgRIP0kfRnBbibXvcFWvMMrOQ%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTJAKA&country=IDN&lat=-6.146592&lng=106.87957&locusId=CTJAKA&locusType=city&rank=8&roomStayQualifier=2e0e&searchText=Jakarta");
//        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563795370&mtkeys=N$$s9rHC9RN7n%2BeEsfa3QMqL7vsU4f5Bhoy23fwGX8PUPknWkbLaOc042f9tWI2nBGN7zReQY2rMzxH1jby7Xdumc8RR02%2Fl23rRDLUE5gaNrtTnymZqq9Dv5EDDlcSF86uhO6uKHRQwNXyitRFt1CvlAB4lAcWoFK4xiRyOSCe0leBBgBMMakQvt2dROF02T%2Fa9Mcf2oiy%2B%2BKXGhLBJpZFnQgg%2BAYMxDsNVXJuClTDNlJSdfma4RkmDeFT%2BPPsRiSho0KNZ0dtFWQC23dx7kfnUhk3WE0VzrPFoJQCfgzdZsJQnZKz0wjX10yy43siJBB%2BYvVXFvfO0wGyDDJMivBbZuKKocnnddweWDHTpd5E%2BaQ%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTJAKA&country=IDN&lat=-6.195607&lng=106.82226&locusId=CTJAKA&locusType=city&rank=13&roomStayQualifier=2e0e&searchText=Jakarta");
//        waitABit(7000);
    }

    public void getRoomName(Integer roomnumber) {
        int a = 0;
        //get room name
        String webElementFacade = find(By.xpath(String.format(roomSelectionOption, roomnumber))).getText();
        System.out.println("Room name : " + webElementFacade);

        //get price
        price.getText();
        System.out.println(" price : " + price.getText());

        //get options
        List<String> listoption = new ArrayList<>();
        for (WebElementFacade wf : listoptions) {

            listoption.add(wf.getText());
            System.out.println(a + 1 + ". " + listoption.get(a));
            a++;
        }

        //click more about button and get the room details
        if (find(By.xpath(String.format(moreAboutButton, roomnumber))).isPresent()) {
           a=0;
            find(By.xpath(String.format(moreAboutButton, roomnumber))).click();

            List<String> detailRoom = new ArrayList<>();
            for (WebElementFacade wf : listRoomDetails) {

                detailRoom.add(wf.getText());
                System.out.println(a + 1 + ". " + detailRoom.get(a));
                a++;
            }
            System.out.println("jumlah " + detailRoom.size());
            JSExecutorUtility.clickByWebElement(closeModalButton,getDriver());
//            closeModalButton.click();
        }

    }


}