package com.decepticon.steps;

import com.decepticon.module.ui.BookingSummaryPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class BookingSummaryPageSteps extends ScenarioSteps {

    BookingSummaryPage bookingSummaryPage;

    @Given("open book page")
    public void openBookPage() {
        bookingSummaryPage.openPage();
    }

    @Then("at book page hotel name should correct")
    public void atBookPageHotelNameShouldCorrect() {
        assertThat("text hotel name is wrong",
                bookingSummaryPage.getTextHotelName(), equalTo("Grand Zuri Kuta Bali"));

    }


    @And("at book page room name should correct")
    public void atBookPageRoomNameShouldCorrect() {
        assertThat("text room name is wrong",
                bookingSummaryPage.getTextRoomName(), equalToIgnoringCase("Superior Room"));

    }

    @And("at book page text address should correct")
    public void atBookPageTextAddressShouldCorrect() {
    }

    @And("at book page rating should correct")
    public void atBookPageRatingShouldCorrect() {
    }

    @And("at book page check in date should correct")
    public void atBookPageCheckInDateShouldCorrect() {
        assertThat("text check in date is wrong",
                bookingSummaryPage.getTextCheckInDate(), equalToIgnoringCase("Wed 17 Jun 2020"));

    }

    @And("at book page check in day should correct")
    public void atBookPageCheckInDayShouldCorrect() {

    }

    @And("at book page check out date should correct")
    public void atBookPageCheckOutDateShouldCorrect() {
        assertThat("text check out date is wrong",
                bookingSummaryPage.getTextCheckOutDate(), equalToIgnoringCase("Sat 20 Jun 2020"));

    }

    @And("at book page total adult guest should correct")
    public void atBookPageTotalGuestShouldCorrect() {
        assertThat("number adult is wrong",
                bookingSummaryPage.getNumberGuestsAmounts().get("adult"), equalTo(4));

    }

    @And("at book page total children guest should correct")
    public void atBookPageTotalChildredGuestShouldCorrect() {
        assertThat("number children is wrong",
                bookingSummaryPage.getNumberGuestsAmounts().get("child"), equalTo(4));
    }

    @And("at book page total amount should correct")
    public void atBookPageTotalAmountShouldCorrect() {
        assertThat("text total amount is wrong",
                bookingSummaryPage.getTextTotalAmount(), equalTo("8,404"));

    }
}
