package com.Tohsaka.ecom;
import com.Tohsaka.ecom.providers.DataTestProvider;
import com.Tohsaka.ecom.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest {

    @Test(dataProvider ="logindataprovider",dataProviderClass = DataTestProvider.class)
    public void loginTest(String username, String password) throws InterruptedException {
        WebDriver driver = DriverUtils.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        WebElement InputUsername = driver.findElement(By.id("user-name"));
        InputUsername.sendKeys(username);

        Thread.sleep(1000);
        WebElement InputPassword = driver.findElement(By.id("password"));
        InputPassword.sendKeys(password);

        Thread.sleep(1000);
        WebElement ButtonLogin = driver.findElement(By.id("login-button"));
        ButtonLogin.click();
        Thread.sleep(1000);
        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/v1/inventory.html";
        Assert.assertEquals(actual, expected);
    }

    @Test()
    public void loginInvalidUsernameTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        Thread.sleep(1000);
        WebElement InputUsername = driver.findElement(By.id("user-name"));
        InputUsername.sendKeys("standard");

        Thread.sleep(1000);
        WebElement InputPassword = driver.findElement(By.id("password"));
        InputPassword.sendKeys("secret_sauce");

        Thread.sleep(1000);
        WebElement ButtonLogin = driver.findElement(By.id("login-button"));
        ButtonLogin.click();

        Thread.sleep(1000);
        WebElement ErrorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = ErrorValidation.getText();
        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test()
    public void loginInvalidPasswordTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        Thread.sleep(1000);
        WebElement InputUsername = driver.findElement(By.id("user-name"));
        InputUsername.sendKeys("standard_user");

        Thread.sleep(1000);
        WebElement InputPassword = driver.findElement(By.id("password"));
        InputPassword.sendKeys("secret");

        Thread.sleep(1000);
        WebElement ButtonLogin = driver.findElement(By.id("login-button"));
        ButtonLogin.click();

        Thread.sleep(1000);
        WebElement ErrorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = ErrorValidation.getText();
        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test()
    public void loginWithoutPasswordTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        Thread.sleep(1000);
        WebElement InputUsername = driver.findElement(By.id("user-name"));
        InputUsername.sendKeys("standard");

        Thread.sleep(1000);
        WebElement ButtonLogin = driver.findElement(By.id("login-button"));
        ButtonLogin.click();

        Thread.sleep(1000);
        WebElement ErrorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Password is required";
        String actual = ErrorValidation.getText();
        Assert.assertEquals(actual, expected);
        driver.quit();
    }

    @Test()
    public void loginWithoutUsernameTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        Thread.sleep(1000);
        WebElement InputPassword = driver.findElement(By.id("password"));
        InputPassword.sendKeys("secret_sauce");

        Thread.sleep(1000);
        WebElement ButtonLogin = driver.findElement(By.id("login-button"));
        ButtonLogin.click();

        Thread.sleep(1000);
        WebElement ErrorValidation = driver.findElement(By.cssSelector("h3[data-test='error']"));

        String expected = "Epic sadface: Username is required";
        String actual = ErrorValidation.getText();
        Assert.assertEquals(actual, expected);
        driver.quit();
    }
}