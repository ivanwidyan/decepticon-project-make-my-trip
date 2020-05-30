package com.decepticon.steps;

import com.decepticon.module.ui.HomePage;
import com.decepticon.module.utils.CommonAction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

    private CommonAction commonAction;

    private HomePage homePage;

    @Given("^open home page$")
    public void openHomePage() {
        commonAction.openPage("https://www.makemytrip.com/");
    }

    @When("at home page click button Hotel")
    public void atHomePageClickButtonHotel() {
    }

    @When("at home page click button City")
    public void atHomePageClickButtonCity() {
    }

    @When("at home page city section fill text box city with '{string}'")
    public void atHomePageCitySectionFillTextBoxCityWithIndonesia() {
    }

    @When("at home page city section click list button City equals to '{string}'")
    public void atHomePageCitySectionClickListButtonCityEqualsToBali() {
    }

    @When("at home page click button Check In equals to '{string}'")
    public void atHomePageClickButtonCheckInEqualsToJune(int arg0) {
    }

    @When("at home page click button Check Out equals to '{string}'")
    public void atHomePageClickButtonCheckOutEqualsToJune(int arg0) {
    }

    @When("at home page click button Room & Guest")
    public void atHomePageClickButtonRoomGuest() {
    }

    @When("at home page room section click button Adults equals to '{string}'")
    public void atHomePageRoomSectionClickButtonAdultsEqualsTo(int arg0) {
    }

    @When("at home page room section click button Children equals to '{string}'")
    public void atHomePageRoomSectionClickButtonChildrenEqualsTo(int arg0) {
    }

    @When("at home page room section click button Add Another Room")
    public void atHomePageRoomSectionClickButtonAddAnotherRoom() {
    }

    @When("at home page room section click button Apply")
    public void atHomePageRoomSectionClickButtonApply() {
    }

    @When("at home page click button Travelling For")
    public void atHomePageClickButtonTravellingFor() {
    }

    @When("at home page travel section click list button Travelling For equals to '{string}'")
    public void atHomePageTravelSectionClickListButtonTravellingForEqualsToWork() {
    }

    @When("at home page click button Search")
    public void atHomePageClickButtonSearch() {
    }
}