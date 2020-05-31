package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.ValueConsts;
import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import com.decepticon.module.utils.Utility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class SearchPage extends UiUtility {

    // Text Elements
    @FindBy(xpath = "//span[@class=\"minValue\"]")
    private WebElementFacade textMinPrice;

    @FindBy(xpath = "//ul[@class=\"appliedFilters\"]/li/span[@class=\"latoBold\"]")
    private List<WebElementFacade> listTextAppliedFilters;

    // Button Elements
    @FindBy(xpath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div")
    private WebElementFacade buttonPriceFilter;

    @FindBy(xpath = "//p[@id=\"hlistpg_hotel_name\"]")
    private List<WebElementFacade> listButtonHotelName;

    // Slider Elements
    @FindBy(xpath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div/div/div/span")
    private WebElementFacade sliderFilterMinPrice;

    // Popup Elements
    @FindBy(xpath = "//p[@class=\"whiteText latoBlack font22\"]")
    private WebElementFacade popUpOnSearchResult;

    private String buttonFilterByUserRatings = "//label[contains(text(),'%s')]";

    public void openPage() {
        openUrl("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&checkin=05312020&checkout=06012020&city=RGCJB&country=IN&locusId=RGCJB&locusType=region&reference=hotel&roomStayQualifier=2e0e2e0e&searchText=Coimbatore%20District%2C%20Tamil%20Nadu%2C%20India&type=region");
    }

    // Get Text
    public List<String> getListTextFilter() {
        return listWebElementsToListString(listTextAppliedFilters);
    }

    // Click Actions
    public void clickButtonFilterByUserRatings(String userRating) {
        if (popUpOnSearchResult.isVisible()) {
            getDriver().navigate().refresh();
        }
        fromXpathtoWebElement(String.format(buttonFilterByUserRatings, userRating)).click();
    }
    public String clickButtonHotelName(Integer hotelNumber) {
        String hotelName = Consts.EMPTY_STRING;
        Integer hotelIndex = hotelNumber - 1;

        Integer loadedHotel = ValueConsts.DEFUALT_LOADER_VALUE;
        while (hotelNumber > loadedHotel) {
            JSExecutorUtility.scrollToTheEndOfThePage(getDriver());
            loadedHotel = listButtonHotelName.size();
            System.out.println("scrolling with " + listButtonHotelName.size() + " hotel");
        }

        JSExecutorUtility.scrollToElement(getDriver(), listButtonHotelName.get(hotelNumber - 2));
        System.out.println("found the hotel! = " + listButtonHotelName.get(hotelIndex).getText());
        Utility.takeScreenshot(getDriver());

        listButtonHotelName.get(hotelIndex).click();
        for (int i = 0; i < listButtonHotelName.size(); i++) {
            listButtonHotelName.get(i).getText();
            System.out.println((i + 1) + " = " + listButtonHotelName.get(i).getText());
        }
        return hotelName;
    }

    // Drag Actions
    public void dragSliderFilterMinPrice(String minPrice) {
        Actions actions = new Actions(getDriver());
        if (Integer.valueOf(minPrice) > 0) {
            Integer min = 0;
            while (min < Integer.valueOf(minPrice) || min > ValueConsts.DEFAULT_FILTER_MAX_PRICE) {
                textMinPrice.waitUntilVisible();
                actions.clickAndHold(sliderFilterMinPrice).moveByOffset(3, 0).release().perform();
                String minPriceNumber = textMinPrice.getText().split(Consts.SPACE)[Consts.SECOND_INDEX];
                min = Integer.valueOf(minPriceNumber);
            }
        }
    }
}
