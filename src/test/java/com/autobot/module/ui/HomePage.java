package com.autobot.module.ui;

import com.autobot.module.utils.Handler;
import com.autobot.module.utils.ReportHandler;
import com.autobot.module.utils.Utility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageObject {
  public void openPage() {
    openUrl("https://www.youtube.com/");
  }
}