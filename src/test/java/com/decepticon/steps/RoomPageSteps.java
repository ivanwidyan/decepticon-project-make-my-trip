package com.decepticon.steps;

import com.decepticon.module.data.RoomData;
import com.decepticon.module.ui.RoomPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

public class RoomPageSteps extends ScenarioSteps {

    private RoomPage roomPage;
    private RoomData roomData;

    @Given("open room page")
    public void openRoomPage() {
        roomPage.openPage();
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

    @When("at room page click button code phone number")
    public void atRoomPageClickButtonCodePhoneNumber() {
        roomPage.clickButtonMobileCode();
    }

    @When("at room page click list button code phone number with {string}")
    public void atRoomPageClickListButtonCodePhoneNumberWith(String value) {
        roomPage.clickListButtonMobileCode(value);
    }

    @When("at room page fill text box phone number with {string}")
    public void atRoomPageFillTextBoxPhoneNumberWith(String value) {
        roomPage.typeTextBoxMobileNumber(value);
    }

    @When("at room page fill text box pan with {string}")
    public void atRoomPageFillTextBoxPanWith(String value) {
        roomPage.typeTextBoxPanString(value);
    }

    @When("at room page click checkbox special request equals {string}")
    public void atRoomPageFillClickCheckboxSpecialRequestEqualsSmokingRoom(String value) {
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
}
