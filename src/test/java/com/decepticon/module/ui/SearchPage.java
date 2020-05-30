package com.decepticon.module.ui;

import com.decepticon.module.constant.ParamConsts;
import com.decepticon.module.constant.ValueConsts;
import com.decepticon.module.utils.Utility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchPage extends PageObject {
    Utility utility = new Utility();

    //filter by user rating
    @FindBy(xpath = "//input[@id='search']")
    WebElementFacade searchBox;
    private String filterByUserRating = "//div[@id=\"hlistpg_fr_user_rating\"]/ul/li";
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
    WebElementFacade maxValue;

    //filter by price
    @FindBy(id="hlistpg_fr_price_per_night")
    WebElementFacade priceFilter;
    private String priceSliderPath="//div[@id=\"hlistpg_fr_price_per_night\"]/div/div/div/span";

    //element locators to select the hotel
    @FindBy(xpath = "//p[@class='appendBottom15']")
    WebElementFacade moveToBottomOfThePage;
    @FindBy(className = "appendTop20 appendBottom20 font22 latoBlack blackText textCenter")
    WebElementFacade endPageMessage;
    @FindBy(xpath = "//div[@class='listingRowOuter']/a")
    List<WebElementFacade> listOfHotels;


    public void openPage() {
        openUrl("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&checkin=05312020&checkout=06012020&city=RGPUDD&country=IN&locusId=RGPUDD&locusType=region&roomStayQualifier=2e0e3e0e&searchText=Puducherry%2C%20India&visitorId=86609899-567a-479b-8c6e-5238de82f0c3");
    }

    public void filterByUserRating(String userRating)
    {
        //filter by userRating
        if (popUpOnSearchResult.isVisible()) {
            getDriver().navigate().refresh();
            waitForAngularRequestsToFinish();
        }
        utility.scrollToElement(getDriver(), userRatingFilter);
        utility.waitTillPageLoads(getDriver());
        List<WebElement> filterByUserRatings = getDriver().findElements(By.xpath(filterByUserRating));
        for (int i=0;i<filterByUserRatings.size();i++)
        {
            if (filterByUserRatings.get(i).getText().contains(userRating))
            {
                int value=i+1;
                getDriver().findElement(By.xpath(filterByUserRating+"["+value+"]")).click();
                break;
            }
        }
        waitForAngularRequestsToFinish();
        String appliedFilter="";
        for (WebElementFacade element:appliedFilters)
        {
            if(element.getText().equalsIgnoreCase(userRating))
            {
                appliedFilter=element.getText();
            }
        }
        assertEquals(userRating,appliedFilter);
    }
    public void filterByPrice(String price)
    {
        utility.scrollToElement(getDriver(),priceFilter);
        String [] min=minPrice.getText().split(ValueConsts.INR,1);
        if(Integer.valueOf(price)<Integer.valueOf(min[1]))
        {

        }
        Actions actions = new Actions(getDriver());
//        actions.dragAndDropBy()
    }
}

//Filter by price - working
//Filter by star rating -done
//Apply Filter - done
//Search for 5th hotel - xpath done
//Capture the name - xpath done
//Clickon it
