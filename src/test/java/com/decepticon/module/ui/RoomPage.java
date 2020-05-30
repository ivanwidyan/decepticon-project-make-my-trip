package com.decepticon.module.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class RoomPage extends PageObject {

  @FindBy(xpath = "//input[@id='search']")
  WebElementFacade searchBox;

  public void openPage() {
    openUrl("https://www.youtube.com/");
  }

  public void doSearch(){

    searchBox.waitUntilVisible();
    searchBox.type("step-inforum");
    searchBox.sendKeys(Keys.ENTER);
  }
}