package com.decepticon.module.ui;

import com.decepticon.module.utils.JSExecutorUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

public class HotelDetailPage extends PageObject {

    JSExecutorUtility jsExecutorUtility;


    @FindBy(xpath = "//input[@id='search']")
    WebElementFacade searchBox;


    //masih static
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/a[1]")
    WebElementFacade selecRoomButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[1]")
    WebElementFacade roomDetails;

    @FindBy(xpath = "//div[@class='roomLeft']//h2")
    List<WebElementFacade> listcobacoba;

    public String moreAboutButton = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//a";

//    public String boxBankTopupVA = "//li[@id='bli-pay-%s-arrow']//div[@class='accordion-parent']";


    public String roomSelectionOption = "//div[@class='roomWrap'][%s]//div[@class='roomLeft']//h2";


    public void openPage() {
        openUrl("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563795492&mtkeys=N$$s9rHC9RN7n%2BtxSsswnSoHwtIG2ZXRQX%2BEQVi8%2FHcIacg8r77xn3fu0GQ%2FDsihjOxlCFQ578uL1FfL5xjKNkNiPVjAjX%2FNMibEJrdqVxuWh6JuqE3%2BGKoT5ZCEJcL5f%2BGpAA2qn9Fwa206j6hWkbhqhgqypMexh2DQttMEVaod62qMai45AO3FsJt7jhcoeBJOgg0BU82t5zLwqYpfCVzpw9Tdm4Nsk1R6OnUFmeWv36sAorfIIaAiieEw1oEwVUfgNrtxE1WE0lUkuEfwCGzK2eajPwJ8K4HVJ1u9uS6QodDBDENnNevN4PW%2FdCS8SgRIP0kfRnBbibXvcFWvMMrOQ%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTJAKA&country=IDN&lat=-6.146592&lng=106.87957&locusId=CTJAKA&locusType=city&rank=8&roomStayQualifier=2e0e&searchText=Jakarta");
        waitABit(15000);
    }

    public String getRoomName(Integer roomnumber) {
        List<String> stringList = new ArrayList<>();
        for (WebElementFacade wf : listcobacoba) {
            stringList.add(wf.getText());
        }
//        System.out.println("jumlah " + stringList.size());

        String webElementFacade = find(By.xpath(String.format(roomSelectionOption, roomnumber))).getText();
        System.out.println("Room name : " + webElementFacade);



        return webElementFacade;

    }


    public void doSearch() {

        searchBox.waitUntilVisible();
        searchBox.type("step-inforum");
        searchBox.sendKeys(Keys.ENTER);


    }
}