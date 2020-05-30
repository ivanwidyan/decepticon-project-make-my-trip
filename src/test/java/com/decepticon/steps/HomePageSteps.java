package com.decepticon.steps;

import com.decepticon.module.ui.HomePage;
import com.decepticon.module.utils.CommonAction;
import cucumber.api.java.en.Given;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

    private CommonAction commonAction;

    private HomePage homePage;

    @Given("^open home page$")
    public void open_home_page() {
        commonAction.openPage("https://www.makemytrip.com/");
    }
}