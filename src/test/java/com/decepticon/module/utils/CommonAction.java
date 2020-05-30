package com.decepticon.module.utils;

public class CommonAction extends UiUtility {

    // Open URL
    public void openPage(String url) {
        openAt(url);
    }

    // Verify Page is Opened
    public Boolean verifyPageIsOpened(String url) {
        return verifyUrlIsOpened(url);
    }
}
