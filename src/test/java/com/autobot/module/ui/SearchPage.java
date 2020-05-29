package com.autobot.module.ui;

import net.serenitybdd.core.pages.PageObject;

public class SearchPage extends PageObject {
  public void openPage() {
    openUrl("https://www.youtube.com/results?search_query=step-in+forum");
  }
}