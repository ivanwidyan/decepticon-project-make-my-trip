package com.decepticon.runner;

import com.decepticon.module.api.ApiController;
import com.decepticon.module.ui.HomePage;
import com.decepticon.module.utils.ReportHandler;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TestMain {

    // chrome, firefox, appium, remote
    @Managed(driver = "remote")
    WebDriver driver;

    HomePage homePage;

    @Test
    public void testRemote() {
        homePage.openPage();
        homePage.doSearch();
    }

    @Test
    public void report() {
        ReportHandler.generateDummyReport();
    }

    @Test
    public void testApi() {
        System.out.println(ApiController.createUser());
        System.out.println(ApiController.getUser());
    }

    /*@Test
    public void testUI() {
        googlePage.openPage();

        googlePage.searchGoogle( "dark magician fandom");
        String link = googlePage.getLinkAtTop();

        Handler.putCoreHashMap("keyname.link", link);
    }

    @Test
    public void testAPI() {
        EncoderConfig encoderconfig = new EncoderConfig();
        Headers headers =  SerenityRest.given()
                .config(RestAssured.config()
                        .encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .contentType("application/x-www-form-urlencoded")
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "32b8ced963msh62cd32deca7d711p139919jsn841c9a91a1fd")
                .body("inboundDate=2019-09-10&cabinClass=economy&children=0&infants=0&country=ID&currency=IDR&locale=id-ID&originPlace=CGKI-sky&destinationPlace=SUB-sky&outboundDate=2019-09-01&adults=1")
                .when()
                .post("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
                .getHeaders();
        System.out.println(headers.get("location"));

        Response response = SerenityRest.get("http://google.com/get").getBody().as(Response.class);
        System.out.println(response.test);
    }*/
}