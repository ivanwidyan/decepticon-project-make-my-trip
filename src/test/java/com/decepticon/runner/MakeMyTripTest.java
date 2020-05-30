package com.decepticon.runner;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/makemytrip.csv")
public class MakeMyTripTest {

    private int email;
    private String password;

//    public void setEmail(int email) {
//        this.email = email;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    @Qualifier
    public String qualifier() {
        return email + "=>" + password;
    }

    @Test
    public void makeMyTripTest() throws Exception {
        System.out.println(email + "=>" + password);
        Thread.sleep(1000);
    }
}
