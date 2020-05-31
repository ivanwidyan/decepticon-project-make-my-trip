package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.ValueConsts;
import com.decepticon.module.utils.CommonAction;
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
import static org.junit.Assert.assertTrue;

public class SearchPage extends PageObject {
    Utility utility = new Utility();
    UiUtility uiUtility = new UiUtility();
    CommonAction commonAction = new CommonAction();

    //filter by user rating
    @FindBy(xpath = "//input[@id='search']")
    private WebElementFacade searchBox;

    private String filterByUserRating = "//label[contains(text(),'%s')]";

    @FindBy(xpath = "//p[@class=\"whiteText latoBlack font22\"]")
    private WebElementFacade popUpOnSearchResult;

    @FindBy(className = "mmBackdrop wholeBlack")
    private WebElementFacade backDrop;

    @FindBy(id = "hlistpg_fr_star_category")
    private WebElementFacade userRatingFilter;

    @FindBy(xpath = "//ul[@class=\"appliedFilters\"]/li/span[@class=\"latoBold\"]")
    private List<WebElementFacade> appliedFilters;

    @FindBy(xpath = "//span[@class=\"minValue\"]")
    private WebElementFacade minPrice;

    @FindBy(xpath = "//span[@class=\"maxValue\"]")
    private WebElementFacade maxPrice;

    //filter by textPrice
    @FindBy(xpath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div")
    private WebElementFacade priceFilter;

    private String priceSliderPath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div/div/div/span";

    //element locators to select the hotel
    @FindBy(xpath = "//p[@class='appendBottom15']")
    private WebElementFacade moveToBottomOfThePage;

    private String loadingRequest="//p[@class='appendBottom15']";

    @FindBy(xpath = "//div[@id=\"hotelListingContainer\"]/p")
    private WebElementFacade endPageMessage;

    @FindBy(id="hotelListingContainer")
    private WebElementFacade listingContainer;

    @FindBy(id="back_to_top_button")
    private WebElementFacade backToTopButton;

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
//                System.out.println(price + " != " + min + " is " + (min < Integer.valueOf(price)));
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
        if(numberOfHotel>0) {
            String hotelName = "";
            utility.scrollToTheEndOfThePage(getDriver());
            while (!endPageMessage.isVisible() && numberOfHotel>3)//3 is the hardcoded value can be made to the default values based on number of data loaded
            {
                utility.scrollToTheEndOfThePage(getDriver());
            }
            List<WebElement> listOfHotels = getDriver().findElements(By.xpath(hotelList));
            if (listOfHotels.size() < numberOfHotel) {
                System.out.println("Requested hotel number is not found under this filter");
            }
            for (int j = 0; j < listOfHotels.size(); j++)
            {
                if(j==0 && j == numberOfHotel - 1)
                {
                    backToTopButton.click();
                    hotelName = listOfHotels.get(j).getText();
                    utility.takeScreenshot(getDriver());
                    listOfHotels.get(j).click();
                }
                else if (j == numberOfHotel - 1 && j !=0) {
                    utility.scrollToElement(getDriver(), listOfHotels.get(j - 1));
                    hotelName = listOfHotels.get(j).getText();
                    utility.takeScreenshot(getDriver());
                    listOfHotels.get(j).click();
                }
            }
            System.out.println(hotelName);
            commonAction.switchToOpenedTab(getDriver());
            utility.waitTillPageLoads(getDriver());
        }
        else
        {
            System.out.println("Requested hotel number is not found under this filter");
        }
    }

}
