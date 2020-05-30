package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.ValueConsts;
import com.decepticon.module.utils.UiUtility;
import com.decepticon.module.utils.Utility;
import cucumber.api.java.sl.In;
import lombok.experimental.var;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchPage extends PageObject {
    Utility utility = new Utility();
    UiUtility uiUtility = new UiUtility();
    //filter by user rating
    @FindBy(xpath = "//input[@id='search']")
    WebElementFacade searchBox;
    private String filterByUserRating = "//label[contains(text(),'%s')]";
    @FindBy(xpath = "//p[@class=\"whiteText latoBlack font22\"]")
    WebElementFacade popUpOnSearchResult;
    @FindBy(className = "mmBackdrop wholeBlack")
    WebElementFacade backDrop;
    @FindBy(id = "hlistpg_fr_star_category")
    WebElementFacade userRatingFilter;
    @FindBy(xpath = "//ul[@class=\"appliedFilters\"]/li/span[@class=\"latoBold\"]")
    List<WebElementFacade> appliedFilters;
    @FindBy(xpath = "//span[@class=\"minValue\"]")
    WebElementFacade minPrice;
    @FindBy(xpath = "//span[@class=\"maxValue\"]")
    WebElementFacade maxPrice;

    //filter by price
    @FindBy(xpath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div")
    WebElementFacade priceFilter;
    private String priceSliderPath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div/div/div/span";

    //element locators to select the hotel
    @FindBy(xpath = "//p[@class='appendBottom15']")
    WebElementFacade moveToBottomOfThePage;
    String loadingRequest="//p[@class='appendBottom15']";
    @FindBy(className = "appendTop20 appendBottom20 font22 latoBlack blackText textCenter")
    WebElementFacade endPageMessage;
    @FindBy(xpath = "//div[@class='listingRowOuter']/a")
    List<WebElementFacade> listOfHotels;


    public void openPage() {
        openUrl("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&checkin=05312020&checkout=06012020&city=RGPUDD&country=IN&locusId=RGPUDD&locusType=region&roomStayQualifier=2e0e3e0e&searchText=Puducherry%2C%20India&visitorId=86609899-567a-479b-8c6e-5238de82f0c3");
    }

    public void filterByUserRating(String userRating) {
        //filter by userRating
        if (popUpOnSearchResult.isVisible()) {
            getDriver().navigate().refresh();
            waitForAngularRequestsToFinish();
        }
        utility.scrollToElement(getDriver(), userRatingFilter);
        utility.waitTillPageLoads(getDriver());
        uiUtility.fromXpathtoWebElement(String.format(filterByUserRating, userRating)).click();
        waitForAngularRequestsToFinish();
    }

    public void filterByPrice(String price) {
        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath(priceSliderPath));
        utility.scrollToElement(getDriver(), priceFilter);
        if (Integer.valueOf(price) > 0) {
            Integer currentDivision = Integer.valueOf(price) / 500;
//            for (int i = 0; i < currentDivision; i++) {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                actions.clickAndHold(element).moveByOffset(3, 0).release().perform();
//            }

            Integer min = 0;
            while (min < Integer.valueOf(price) || min > 30000) {
                minPrice.waitUntilVisible();
                actions.clickAndHold(element).moveByOffset(3, 0).release().perform();
//                System.out.println(minPrice.getText());
                String minPriceNumber = minPrice.getText().split(Consts.SPACE)[1];
                min = Integer.valueOf(minPriceNumber);
                System.out.println(price + " != " + min + " is " + (min < Integer.valueOf(price)));
            }
        }
    }
    public void assertion(String price,String userRating)
    {
        utility.waitTillPageLoads(getDriver());
        String appliedFilter = "";
        for (WebElementFacade element : appliedFilters)
        {
            if (element.getText().startsWith(ValueConsts.INR))
            {
                String currentValue = element.getText().split(" ")[1];
                String minSelected = currentValue.split("-")[0];
                String maxSelected = currentValue.split("-")[1];
                if (minSelected.equalsIgnoreCase(price)) {
                    appliedFilter = minSelected;
                }
                assertEquals(price, appliedFilter);
            }
            if(element.getText().contains(userRating))
            {
                appliedFilter=element.getText();
                assertEquals(userRating,appliedFilter);
            }
            appliedFilter="";
        }
    }
    public void selectHotel()
    {
//        utility.scrollToElement(getDriver(),moveToBottomOfThePage);
//        if(getDriver().findElements(By.className("appendTop20 appendBottom20 font22 latoBlack blackText textCenter")).size()!=0)
//        {
//            utility.scrollToElement(getDriver(),moveToBottomOfThePage);
//        }
        int i=0;
        while (i==0)
        {
            if(endPageMessage.isVisible())
            {
                i=1;
            }
            else {
                utility.scrollToElement(getDriver(), moveToBottomOfThePage);
            }
        }
    }

}
