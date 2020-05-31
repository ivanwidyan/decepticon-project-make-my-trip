package com.decepticon.steps;

import com.decepticon.module.data.HotelDetailData;
import com.decepticon.module.data.RoomData;
import com.decepticon.module.data.SearchData;
import com.decepticon.module.ui.HotelDetailPage;
import com.decepticon.module.utils.CommonAction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HotelDetailSteps {
    private CommonAction commonAction;


    private HotelDetailPage hotelDetailPage;

    @Given("open hotel Detail Page")
    public void openHotelDetailPage() {
        hotelDetailPage.openPage();
    }

    @Given("open hotel Detail Page Multiple Room")
    public void openHotelDetailPageMultipleRoom() {
        hotelDetailPage.openPageMultiple();
    }

    @When("at hotel detail page get text Price for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageGetTextPriceForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.getTextPrice(room, option);

    }

    @When("at hotel detail page get text Price For Multiple People for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageGetTextPriceForMultiplePeopleForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.getTextPriceForMultiple(room, option);
    }

    @When("at hotel detail page get text Total Price For Multiple People")
    public void atHotelDetailPageGetTextTotalPriceForMultiplePeople() {
        hotelDetailPage.getTextTotalPriceForMultiple();
    }

    @When("at hotel detail page get text Room Name for room number equals to {string}")
    public void atHotelDetailPageGetTextRoomNameForRoomNumberEqualsTo(String room) {
        hotelDetailPage.getTextRoomName(room);
        HotelDetailData.setRoomName(hotelDetailPage.getTextRoomName(room));
    }

    @When("at hotel detail page get list Option for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageGetListOptionForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.getListOption(room, option);
    }

    @When("at hotel detail page get list Multi Option for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageGetListMultiOptionForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.getListMultiOption(room, option);
    }

    @When("at hotel detail page get list Included in Fee for Multi People for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageGetListIncludedInFeeForMultiPeopleForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.getListIncludedMultiOption(room, option);
    }

    @When("at hotel detail page get list Included in Fee for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageGetListIncludedInFeeForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.getListIncluded(room, option);
    }

    @When("at hotel detail page get list Room Detail for room number equals to {string}")
    public void atHotelDetailPageGetListRoomDetailForRoomNumberEqualsTo(String room) {
        hotelDetailPage.getListRoomDetail(room);
    }

    @When("at hotel detail page click button Select Room for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageClickButtonSelectRoomForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.clickButtonSelectRoom(room, option);
    }

    @When("at hotel detail page click button Select People Count List for option number equals to {string}")
    public void atHotelDetailPageClickButtonSelectPeopleCountListForOptionNumberEqualsTo(String option) {
        hotelDetailPage.clickButtonSelectPeopleCountList(option);
    }

    @When("at hotel detail page click button Review Detail")
    public void atHotelDetailPageClickButtonReviewDetail() {
        hotelDetailPage.clickButtonReviewDetail();
    }

    @When("at hotel detail page click button Add Room for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageClickButtonAddRoomForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.clickButtonAddRoom(room, option);
    }

    @When("at hotel detail page click button People Count Selector for room number equals to {string} and option number equals to {string}")
    public void atHotelDetailPageClickButtonPeopleCountSelectorForRoomNumberEqualsToAndOptionNumberEqualsTo(String room, String option) {
        hotelDetailPage.clickButtonPeopleCount(room, option);
    }

    @When("at hotel detail page get text Hotel name")
    public void atHotelDetailPageGetTextHotelName() {
        hotelDetailPage.getTexthotelName();
    }

    @And("at hotel detail page Hotel name should be correct")
    public void atHotelDetailPageHotelNameShoulBeCorrect() {
        assertThat("text hotel name is wrong",
                hotelDetailPage.getTexthotelName(), equalTo(SearchData.getHotelName()));
    }
}
