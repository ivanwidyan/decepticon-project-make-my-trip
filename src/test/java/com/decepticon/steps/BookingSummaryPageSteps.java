package com.decepticon.steps;

import com.decepticon.module.constant.Consts;
import com.decepticon.module.data.HomeData;
import com.decepticon.module.data.HotelDetailData;
import com.decepticon.module.data.RoomData;
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
                bookingSummaryPage.getTextHotelName(), equalTo(RoomData.getHotelName()));
    }

    @And("at book page room name should correct")
    public void atBookPageRoomNameShouldCorrect() {
        assertThat("text room name is wrong room name page",
                bookingSummaryPage.getTextRoomName(), equalToIgnoringCase(HotelDetailData.getRoomName()));

        assertThat("text room name is wrong roon name",
                bookingSummaryPage.getTextRoomName(), equalToIgnoringCase(RoomData.getRoomName()));
    }

    @And("at book page check in date should correct")
    public void atBookPageCheckInDateShouldCorrect() {
        String[] arrDate = HomeData.getDateCheckIn().split(Consts.SPACE);
        String dateCheckin = arrDate[Consts.FIRST_INDEX] + Consts.SPACE +
                arrDate[Consts.THIRD_INDEX] + Consts.SPACE +
                arrDate[Consts.SECOND_INDEX] + Consts.SPACE +
                arrDate[Consts.FOURTH_INDEX];
        assertThat("text check in date is wrong",
                bookingSummaryPage.getTextCheckInDate(), equalToIgnoringCase(dateCheckin));
    }

    @And("at book page check out date should correct")
    public void atBookPageCheckOutDateShouldCorrect() {
        String[] arrDate = HomeData.getDateCheckOut().split(Consts.SPACE);
        String dateCheckout = arrDate[Consts.FIRST_INDEX] + Consts.SPACE +
                arrDate[Consts.THIRD_INDEX] + Consts.SPACE +
                arrDate[Consts.SECOND_INDEX] + Consts.SPACE +
                arrDate[Consts.FOURTH_INDEX];
        assertThat("text check out date is wrong",
                bookingSummaryPage.getTextCheckOutDate(), equalToIgnoringCase(dateCheckout));
    }

    @And("at book page total adult guest should correct")
    public void atBookPageTotalGuestShouldCorrect() {
        assertThat("number adult is wrong",
                bookingSummaryPage.getNumberGuestsAmounts().get("adult"), equalTo(HomeData.getNumberOfAdults()));

    }

    @And("at book page total children guest should correct")
    public void atBookPageTotalChildredGuestShouldCorrect() {
        assertThat("number children is wrong",
                bookingSummaryPage.getNumberGuestsAmounts().get("child"), equalTo(HomeData.getNumberOfChildren()));
    }

    @And("at book page total amount should correct")
    public void atBookPageTotalAmountShouldCorrect() {
        assertThat("text total amount is wrong",
                bookingSummaryPage.getTextTotalAmount(), equalTo(RoomData.getTotalAmount()));

    }
}
