package com.Tohsaka.ecom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Tohsaka.ecom.pages.LoginPage;
import com.Tohsaka.ecom.pages.InventoryPage;
import com.Tohsaka.ecom.providers.DataTestProvider;
import com.Tohsaka.ecom.utils.DriverManager;

public class AuthenticationTest {

    @Test(dataProvider ="logindataprovider",dataProviderClass = DataTestProvider.class)
    public void loginTest(String username, String password, String expected) throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();

        driver.get("https://www.saucedemo.com/v1/index.html");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(username, password);
        String actual = loginPage.getErrorMessage();

        if(actual == null){
            InventoryPage inventoryPage = new InventoryPage(driver);
            actual = inventoryPage.getCurrentUrl();
        }

        Assert.assertEquals(actual, expected);

        driverManager.quitDriver();
    }
}