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
        commonAction.openPage("https://www.makemytrip.com/hotels/hotel-details/?hotelId=4190725563806581&mtkeys=N$$s9rHC9RN7n8Tiq%2BKJh0FX%2FfHJk6RdDmpkJOB2277P8XMPGSAG8X64rvF9KVWXO%2Fr7ISdY8D3x4xLAYFMoMUjG0VKoF7fPJCXHVSV9fsUkF2fmz1uEw%2FQQ%2FCs72G9nzYOariuMD%2FfgcMFtL07wStkdKdprU%2BxJ6BTmtTIfnMU8YL4dfsj2fVK7ZdFymAI0ckCvHklWVcF7xPPP4rQ1EdL4BNUwJBJeaWX9Gbv%2Fjtz2O13UWb9Pj0KbqrkqpmWCQGCSzEUD5IoQ0NNNFc7cluKhsBuN2s%2FSQaQaqKimkSzwvOtFGkanGFbqBml04%2FIv3wlgo82QsHHrJ6ipZhMjSxQ3%2BAyZpa1nElwOqMdYsE9LlA%2FMkv92GDloBG2sxkACWIjdRz1r2szJZHX9oo48eHqDw%3D%3D&_uCurrency=INR&checkin=06092020&checkout=06122020&city=CTSINGAP&country=SGP&lat=1.24669&lng=103.8424&locusId=CTSINGAP&locusType=city&rank=3&reference=hotel&roomStayQualifier=2e0e&searchText=Singapore&type=city");
    }

    @Given("open hotel Detail Page Multiple Room")
    public void openHotelDetailPageMultipleRoom() {
        commonAction.openPage("https://www.makemytrip.com/hotels/hotel-details/?hotelId=20080802125928557&mtkeys=defaultMtkey&_uCurrency=INR&checkin=05312020&checkout=06012020&city=CTGOI&country=IN&lat=15.494905&lng=73.834175&locusId=CTGOI&locusType=city&rank=2&reference=hotel&roomStayQualifier=2e2e2e2e2e2e3e4e&searchText=Goa&type=city");
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
