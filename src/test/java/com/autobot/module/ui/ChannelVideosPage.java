package com.autobot.module.ui;

import net.serenitybdd.core.pages.PageObject;

public class ChannelVideosPage extends PageObject {
  public void openPage() {
    openUrl("https://www.youtube.com/user/stepinforum/videos");
  }
}