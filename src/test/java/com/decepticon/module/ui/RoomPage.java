package com.decepticon.module.ui;

import com.decepticon.module.constant.URLConsts;
import com.decepticon.module.utils.JSExecutorUtility;
import com.decepticon.module.utils.UiUtility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RoomPage extends UiUtility {

    //Textbox Web Element
    @FindBy(xpath = "//input[@id='fName']")
    private WebElementFacade textBoxFirstName;

    @FindBy(xpath = "//input[@id='lName']")
    private WebElementFacade textBoxLastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElementFacade textBoxEmail;

    @FindBy(xpath = "//input[@id='mNo']")
    private WebElementFacade textBoxMobileNumber;

    @FindBy(xpath = "//input[@id='pan']")
    private WebElementFacade textBoxPan;

    @FindBy(xpath = "//a[contains(@class,'btnPayNow')]")
    private WebElementFacade buttonPaynow;

    @FindBy(xpath = "//span[@class='close']")
    private WebElementFacade buttonClose;

    // Section Web Element
    @FindBy(xpath = "//div[@class='_SpecialRequest']")
    private WebElementFacade sectionOptionalRequest;

    @FindBy(xpath = "//div[@class='_Modal modalCont']")
    private WebElementFacade sectionPopupLeavingPage;

    // Select Option Web Element
    @FindBy(xpath = "//select[@id='mCode']")
    private WebElementFacade selectOptionsMobileCode;

    // Checkbox Web Element
    @FindBy(xpath = "//label[@for='donation']")
    private WebElementFacade checkBoxDonation;

    // Text Element
    @FindBy(xpath = "//span[@id='revpg_total_payable_amt']")
    private WebElementFacade textTotalAmount;

    @FindBy(xpath = "//p[@class='latoBlack font22 appendBottom5']")
    private WebElementFacade textHotelName;

    @FindBy(xpath = "//p[contains(@class,'font12 appendTop5')]")
    private WebElementFacade textGuests;

    @FindBy(xpath = "//a[@class='latoBold font18 blueText']")
    private WebElementFacade textRoomName;


    private String checkBoxRequest = "//div[@class='_SpecialRequest']//ul//li//label[contains(text(),'%s')]";

    private String textDate = "//div[@class='makeFlex font12 appendTop20']//div[%s]//p[2]";

    public void openPage() {
        openUrl(URLConsts.URL_ROOM_PAGE);
    }

    // Type Action
    public void typeTextBoxFirstName(String value) {
        textBoxFirstName.type(value);
    }

    public void typeTextBoxLastName(String value) {
        textBoxLastName.type(value);
    }

    public void typeTextBoxEmail(String value) {
        textBoxEmail.type(value);
    }

    public void typeTextBoxMobileNumber(String value) {
        textBoxMobileNumber.type(value);
    }

    public void typeTextBoxPanString(String value) {
        textBoxPan.type(value);
    }

    // Click Action
    public void clickCheckListOptions(String value) {
        clickByWebElement(fromXpathtoWebElement(String.format(checkBoxRequest, value)));
    }

    public void clickCheckBoxDonation() {
        clickByWebElement(checkBoxDonation);
    }

    public void clickButtonPayNow() {
        clickByWebElement(buttonPaynow);
    }

    public void clickButtonClose() {
        clickByWebElement(buttonClose);
    }

    // Select Option Action
    public void selectMobileCode(String value) {
        selectOptionByWebElement(selectOptionsMobileCode, value);
    }

    // Get Text
    public String getTextDate(String value) {
        return getTextByWebElementWithNotFoundHandling(fromXpathtoWebElement(String.format(textDate, value)));
    }

    public String getTextTotalAmount() {
        return getTextByWebElementWithNotFoundHandling(textTotalAmount);
    }

    public String getTextHotelName() {
        return getTextByWebElementWithNotFoundHandling(textHotelName);
    }

    public String getTextGuest(){
        return getTextByWebElementWithNotFoundHandling(textGuests);
    }

    public String getTextRoomName(){
        return getTextByWebElementWithNotFoundHandling(textRoomName);
    }

    // Check Action
    public Boolean isPopupLeavingPageVisible(){
        return sectionPopupLeavingPage.isCurrentlyVisible();
    }

    public Boolean isTextBoxPanVisible(){
        return textBoxPan.isCurrentlyVisible();
    }

    public Boolean isSectionSpecialRequestIsVisible(){
        return sectionOptionalRequest.isCurrentlyVisible();
    }
}