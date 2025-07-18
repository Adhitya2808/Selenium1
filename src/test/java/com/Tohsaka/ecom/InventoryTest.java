package com.Tohsaka.ecom;

import com.Tohsaka.ecom.repositories.InventoryRepository;
import com.Tohsaka.ecom.utils.DriverManager;
import com.Tohsaka.ecom.utils.DriverUtils;
import com.Tohsaka.ecom.utils.LoginUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryTest extends BaseTest {

    @Test()
    public void ProductDisplayTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        LoginUtil.performLogin(driver);

        int expected = 6;
        int  actual = DriverUtils.getDriver().findElements(InventoryRepository.inventoryItem).size();
        Assert.assertEquals(actual, expected, "Product Display Failed");
        driverManager.quitDriver();
    }

    @Test
    public void ProductSortFeatureTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        LoginUtil.performLogin(driver);
        Select select = new Select(DriverUtils.getDriver().findElement(
                InventoryRepository.productSortContainer));
        select.selectByValue("az");

        List<WebElement> products = DriverUtils.getDriver().findElements(InventoryRepository.inventoryItemName);
        List<String> actualTitles =  new ArrayList<String>();
        for (WebElement product : products) {
            actualTitles.add(product.getText());
        }

        List<String> expectedTitles = new ArrayList<String>(actualTitles);
        Collections.sort(expectedTitles);

        Assert.assertEquals(actualTitles, expectedTitles);
        DriverUtils.quitDriver();
    }
}
