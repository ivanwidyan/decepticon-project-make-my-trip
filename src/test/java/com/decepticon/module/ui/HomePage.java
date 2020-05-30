package com.decepticon.module.ui;

import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {
  public void openPage() {
    openUrl("https://www.youtube.com/");
  }
}