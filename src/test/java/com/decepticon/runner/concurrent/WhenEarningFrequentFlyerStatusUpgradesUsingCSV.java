package com.decepticon.runner.concurrent;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/status-levels.csv")
public class WhenEarningFrequentFlyerStatusUpgradesUsingCSV {

    private int kilometersTravelled;
    private String expectedStatus;

    public void setKilometersTravelled(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    public void setExpectedStatus(String expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    @Qualifier
    public String qualifier() {
        return kilometersTravelled + "=>" + expectedStatus;
    }

    @Test
    public void reallyhouldEarnNextStatusWithEnoughPoints() {
        System.out.println(kilometersTravelled + "=>" + expectedStatus);
    }
}
