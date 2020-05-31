package com.decepticon.module.ui;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.constant.ValueConsts;
import com.decepticon.module.utils.CommonAction;
import com.decepticon.module.utils.JSExecutorUtility;
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

public class SearchPage extends UiUtility {
    @FindBy(xpath = "//p[@class=\"whiteText latoBlack font22\"]")
    private WebElementFacade popUpOnSearchResult;

    @FindBy(xpath = "//ul[@class=\"appliedFilters\"]/li/span[@class=\"latoBold\"]")
    private List<WebElementFacade> appliedFilters;

    @FindBy(xpath = "//span[@class=\"minValue\"]")
    private WebElementFacade minPrice;

    @FindBy(xpath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div")
    private WebElementFacade priceFilter;

    @FindBy(xpath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div/div/div/span")
    private WebElementFacade priceSliderPath;

    @FindBy(xpath = "//p[@id=\"hlistpg_hotel_name\"]")
    private List<WebElementFacade> hotelList;

    private String filterByUserRating = "//label[contains(text(),'%s')]";

    public void openPage() {
        openUrl("https://www.makemytrip.com/hotels/hotel-listing/?_uCurrency=INR&checkin=05312020&checkout=06012020&city=RGCJB&country=IN&locusId=RGCJB&locusType=region&reference=hotel&roomStayQualifier=2e0e2e0e&searchText=Coimbatore%20District%2C%20Tamil%20Nadu%2C%20India&type=region");
    }

    public void filterByUserRating(String userRating) {
        if (popUpOnSearchResult.isVisible()) {
            getDriver().navigate().refresh();
        }
        fromXpathtoWebElement(String.format(filterByUserRating, userRating)).click();
    }

    public void filterByPrice(String price) {
        Actions actions = new Actions(getDriver());
//        JSExecutorUtility.scrollToElement(getDriver(), priceFilter);
        if (Integer.valueOf(price) > 0) {
            Integer min = 0;
            while (min < Integer.valueOf(price) || min > ValueConsts.MAX_PRICE) {
                minPrice.waitUntilVisible();
                actions.clickAndHold(priceSliderPath).moveByOffset(3, 0).release().perform();
                String minPriceNumber = minPrice.getText().split(Consts.SPACE)[Consts.SECOND_INDEX];
                min = Integer.valueOf(minPriceNumber);
            }
        }
    }

    public void assertFilters(String price, String userRating) {
        String appliedFilter = "";
        for (WebElementFacade element : appliedFilters) {
            if (element.getText().startsWith(ValueConsts.INR))
            {
                String currentValue = element.getText().split(Consts.SPACE)[Consts.SECOND_INDEX];
                String minSelected = currentValue.split(Consts.DASH)[Consts.FIRST_INDEX];
                if (minSelected.equalsIgnoreCase(price)) {
                    appliedFilter = minSelected;
                }
                assertEquals(price, appliedFilter);
            }
            if (element.getText().contains(userRating)) {
                appliedFilter = element.getText();
                assertEquals(userRating, appliedFilter);
            }
            appliedFilter = "";
        }
    }

    public String newSelectHotel(Integer numberOfHotel) {
        String hotelName = "";
        Integer hotelIndex = numberOfHotel - 1;

        Integer loadedHotel = ValueConsts.DEFUALT_LOADER_VALUE;
        while (numberOfHotel > loadedHotel) {
            JSExecutorUtility.scrollToTheEndOfThePage(getDriver());
            loadedHotel = hotelList.size();
            System.out.println("scrolling with " + hotelList.size() + " hotel");
        }

        JSExecutorUtility.scrollToElement(getDriver(), hotelList.get(numberOfHotel - 2));
        System.out.println("found the hotel! = " + hotelList.get(hotelIndex).getText());
        Utility.takeScreenshot(getDriver());

        hotelList.get(hotelIndex).click();
        for (int i = 0; i < hotelList.size(); i++) {
            hotelList.get(i).getText();
            System.out.println((i + 1) + " = " + hotelList.get(i).getText());
        }
        return hotelName;
    }
}
