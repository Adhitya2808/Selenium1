package com.Tohsaka.ecom.utils;

import org.openqa.selenium.WebDriver;

@Deprecated(since = "Provide driver manager.")
public class DriverUtils {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            DriverManager dm = new DriverManager();
            driver = dm.getDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
