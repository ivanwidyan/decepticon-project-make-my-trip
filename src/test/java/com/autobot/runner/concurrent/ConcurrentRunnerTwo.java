package com.autobot.runner.concurrent;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads="3")
@UseTestDataFrom(value="src/test/resources/keyname.csv")
public class ConcurrentRunnerTwo {

    private String keyName;

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @Qualifier
    public String qualifier() {
        return keyName;
    }

    @Test
    public void test() {
        System.out.println(keyName);
    }
}