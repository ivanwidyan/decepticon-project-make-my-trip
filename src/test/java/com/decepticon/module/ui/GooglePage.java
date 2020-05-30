package com.decepticon.module.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;

public class GooglePage extends PageObject {

  @FindBy(xpath = "//input[@name='q']")
  WebElementFacade searchBox;

  @FindBy(xpath = "//input[@value='Google Search']")
  WebElementFacade searchButton;

  @FindBy(xpath = "//div[@class='srg']//h3")
  List<WebElementFacade> searchData;

  public void openHomePage() {
    openUrl("https://www.google.com/");
  }

  public void doSearch(){
    searchBox.click();
    searchBox.typeAndEnter("food");
  }

  public List<String> getSearchData() {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < searchData.size(); i++) {
      list.add(searchData.get(i).getText());
    }
    return list;
  }
}