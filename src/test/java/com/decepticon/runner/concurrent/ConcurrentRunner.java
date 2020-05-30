package com.decepticon.runner.concurrent;

import com.decepticon.module.ui.HomePage;
import com.decepticon.module.utils.ReportHandler;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent()
public class ConcurrentRunner {

    @Managed(driver = "remote")
    WebDriver driver;

    HomePage homePage;

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"cats"},
                {"dogs"},
                {"ferrets"},
                {"rabbits"},
                {"canaries"}
        });
    }

    private final String searchTerm;

    public ConcurrentRunner(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Test
    public void test() {
        System.out.println("test");
        homePage.openPage();
    }

    @Test
    public void report() {
        ReportHandler.generateDummyReport();
    }
}