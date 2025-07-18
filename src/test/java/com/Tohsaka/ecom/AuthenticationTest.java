package com.Tohsaka.ecom;
import com.Tohsaka.ecom.providers.DataTestProvider;
import com.Tohsaka.ecom.utils.DriverManager;
import com.Tohsaka.ecom.utils.LoginUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest {

    @Test(dataProvider ="logindataprovider",dataProviderClass = DataTestProvider.class)
    public void loginTest(String username, String password) throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        LoginUtil.performLogin(driver, username, password);
        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/v1/inventory.html";
        Assert.assertEquals(actual, expected);
        driverManager.quitDriver();
    }

    @Test()
    public void loginInvalidUsernameTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        LoginUtil.performLogin(driver, "invaliduser", "secret_sauce");
        WebElement ErrorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = ErrorValidation.getText();
        Assert.assertEquals(actual, expected);
        driverManager.quitDriver();
    }

    @Test()
    public void loginInvalidPasswordTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        LoginUtil.performLogin(driver, "standard_user", "secret");

        WebElement ErrorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = ErrorValidation.getText();
        Assert.assertEquals(actual, expected);
        driverManager.quitDriver();
    }

    @Test()
    public void loginWithoutPasswordTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        LoginUtil.performLogin(driver, "standard_user", "");

        WebElement ErrorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Password is required";
        String actual = ErrorValidation.getText();
        Assert.assertEquals(actual, expected);
        driverManager.quitDriver();
    }

    @Test()
    public void loginWithoutUsernameTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        LoginUtil.performLogin(driver, "", "secret_sauce");

        WebElement ErrorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Username is required";
        String actual = ErrorValidation.getText();
        Assert.assertEquals(actual, expected);
        driverManager.quitDriver();
    }
}