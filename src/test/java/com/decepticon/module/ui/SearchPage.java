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

import static com.decepticon.module.utils.Utility.waitTillPageLoads;
import static junit.framework.TestCase.assertTrue;

public class SearchPage extends UiUtility {

    // Text Elements
    @FindBy(xpath = "//span[@class=\"minValue\"]")
    private WebElementFacade textMinPrice;
    //Filter
    @FindBy(xpath = "//span[@class=\"latoBold font20 blackText appendBottom10\"]")
    private WebElementFacade textSelectFilters;

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
    @FindBy(xpath = "//div[@id=\"hlistpg_fr_price_per_night\"]/div[1]")
    private WebElementFacade textForPriceFilter;

    // Popup Elements
    @FindBy(xpath = "//p[@class=\"whiteText latoBlack font22\"]")
    private WebElementFacade popUpOnSearchResult;

    //currecny selection
    @FindBy(xpath = "//div[@class=\"makeFlex column currencyBox font12\"]")
    private WebElementFacade currencyDropDown;
    @FindBy(xpath = "//div[@class=\"currencyWrap\"]/ul/li")
    private List<WebElementFacade> listOfCurrency;
    @FindBy(xpath = "//div[@class=\"makeFlex column currencyBox font12\"]/span")
    private WebElementFacade selectedCurrency;

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
        waitTillPageLoads(getDriver());
        if (popUpOnSearchResult.isVisible()) {
            getDriver().navigate().refresh();
        }
        try {
            fromXpathtoWebElement(String.format(buttonFilterByUserRatings, userRating)).click();
        } catch (Exception e) {
            if (popUpOnSearchResult.isVisible()) {
                getDriver().navigate().refresh();
            }
        }
    }

    //select currency
    public void selectCurrency() {
        if (popUpOnSearchResult.isVisible()) {
            getDriver().navigate().refresh();
        }
        currencyDropDown.waitUntilClickable();
        currencyDropDown.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (WebElementFacade element : listOfCurrency) {
            if (element.getText().contains(ValueConsts.CURRENCY_INR)) {
                element.click();
                break;
            }
        }
        waitForAngularRequestsToFinish();
    }

    public void assertCurrency(String currency) {
        assertTrue(selectedCurrency.getText().toUpperCase().contains(currency));
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
        JSExecutorUtility.scrollToElement(getDriver(), textForPriceFilter);
        if (Integer.valueOf(minPrice) > 0) {
            Integer min = 0;
            while (min < Integer.valueOf(minPrice) || min > ValueConsts.DEFAULT_FILTER_MAX_PRICE) {
                textMinPrice.waitUntilVisible();
                actions.clickAndHold(sliderFilterMinPrice).moveByOffset(2, 0).release().perform();
                String minPriceNumber = textMinPrice.getText().split(Consts.SPACE)[Consts.SECOND_INDEX];
                min = Integer.valueOf(minPriceNumber);
            }
        }
    }
}
