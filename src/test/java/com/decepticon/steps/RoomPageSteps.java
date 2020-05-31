package com.decepticon.steps;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.data.RoomData;
import com.decepticon.module.ui.RoomPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

public class RoomPageSteps extends ScenarioSteps {

    private RoomPage roomPage;

    @Given("open room page")
    public void openRoomPage() {
        roomPage.openPage();
    }

    @Given("at room page store the check in date to the data")
    public void atRoomPageStoreTheCheckInDateToTheData() {
        RoomData.setCheckinDate(roomPage.getTextDate(String.valueOf(Consts.SECOND_INDEX)));
    }

    @And("at room page store the check out date to the data")
    public void atRoomPageStoreTheCheckOutDateToTheData() {
        RoomData.setCheckoutDate(roomPage.getTextDate(String.valueOf(Consts.THRID_INDEX)));
    }

    @And("at room page store the hotel name date to the data")
    public void atRoomPageStoreTheHotelNameDateToTheData() {
        RoomData.setHotelName(roomPage.getTextHotelName());
    }

    @And("at room page store the total amount date to the data")
    public void atRoomPageStoreTheTotalAmountDateToTheData() {
        String[] arrTotalAmount = roomPage.getTextTotalAmount().split(Consts.SPACE);
        RoomData.setTotalAmount(arrTotalAmount[Consts.SECOND_INDEX]);
    }

    @And("at room page store the total guests date to the data")
    public void atRoomPageStoreTheTotalGuestsDateToTheData() {
        RoomData.setGuest(roomPage.getTextGuest());
    }

    @And("at room page store the room name date to the data")
    public void atRoomPageStoreTheRoomNameDateToTheData() {
        RoomData.setRoomName(roomPage.getTextRoomName());
    }

    @When("at room page fill text box first name with {string}")
    public void atRoomPageFillTextBoxFirstNameWithWeAre(String value) {
        roomPage.typeTextBoxFirstName(value);
    }

    @When("at room page fill text box last name with {string}")
    public void atRoomPageFillTextBoxLastNameWithDeception(String value) {
        roomPage.typeTextBoxLastName(value);
    }

    @When("at room page fill text box email with {string}")
    public void atRoomPageFillTextBoxEmailWithEmail(String value) {
        roomPage.typeTextBoxEmail(value);
    }

    @When("at room page select option code phone number with {string}")
    public void atRoomPageClickListButtonCodePhoneNumberWith(String value) {
        roomPage.selectMobileCode(value);
    }

    @When("at room page fill text box phone number with {string}")
    public void atRoomPageFillTextBoxPhoneNumberWith(String value) {
        roomPage.typeTextBoxMobileNumber(value);
    }

    @When("at room page fill text box pan with {string}")
    public void atRoomPageFillTextBoxPanWith(String value) {
        roomPage.typeTextBoxPanString(value);
    }

    @When("at room page click checkbox special request equals {string} if visible")
    public void atRoomPageFillClickCheckboxSpecialRequestEqualsSmokingRoom(String value) {
        if(roomPage.isSectionSpecialRequestIsVisible())
            roomPage.clickCheckListOptions(value);
    }

    @When("at room page click checkbox donation")
    public void atRoomPageFillClickCheckboxDonation() {
        roomPage.clickCheckBoxDonation();
    }

    @When("at room page click button paynow")
    public void atRoomPageClickButtonPaynow() {
        roomPage.clickButtonPayNow();
    }

    @When("at room page click popup leaving page if show up")
    public void atRoomPageClickPopupLeavingPageIfShowUp() {
        if(roomPage.isPopupLeavingPageVisible())
            roomPage.clickButtonClose();
    }
}
