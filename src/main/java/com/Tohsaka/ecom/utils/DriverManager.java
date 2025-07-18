package com.Tohsaka.ecom.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private WebDriver driver;

    public DriverManager() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}