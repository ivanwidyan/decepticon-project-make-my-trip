package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.ValueConsts;
import com.decepticon.module.utils.UiUtility;
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
    @FindBy(xpath = "//div[@id=\"hotelListingContainer\"]/p")
    WebElementFacade endPageMessage;
    @FindBy(id="hotelListingContainer")
    WebElementFacade listingContainer;
    @FindBy(id="back_to_top_button")
    WebElementFacade backToTopButton;
    private String hotelList="//p[@id=\"hlistpg_hotel_name\"]";


    public void openPage() {
        openUrl("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&checkin=05312020&checkout=06012020&city=RGCJB&country=IN&locusId=RGCJB&locusType=region&reference=hotel&roomStayQualifier=2e0e2e0e&searchText=Coimbatore%20District%2C%20Tamil%20Nadu%2C%20India&type=region");
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
            Integer min = 0;
            while (min < Integer.valueOf(price) || min > 30000) {
                minPrice.waitUntilVisible();
                actions.clickAndHold(element).moveByOffset(3, 0).release().perform();
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
    public void selectHotel(Integer numberOfHotel)
    {
//        Actions actions = new Actions(getDriver());
        String hotelName="";
//        Integer hotelNumber;
//        int count=numberOfHotel;
//        while (count>0)
//        {
//            utility.scrollToTheEndOfThePage(getDriver());
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            count--;
//        }

        List<WebElement> listOfHotels = getDriver().findElements(By.xpath(hotelList));
        for (int j = 0; j < listOfHotels.size(); j++) {
            if (j == numberOfHotel - 1) {
                hotelName = listOfHotels.get(j).getText();
                listOfHotels.get(j).click();
            }
            System.out.println("Hotel Name" + j + listOfHotels.get(j).getText());
        }
        System.out.println(hotelName);
    }

}
