package com.Tohsaka.ecom;

import com.Tohsaka.ecom.pages.JQueryDragDropPage;
import com.Tohsaka.ecom.pages.JQueryResizePage;
import com.Tohsaka.ecom.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DragDropTest {

    @Test
    public void resizeTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://jqueryui.com/resources/demos/resizable/default.html");

        JQueryDragDropPage dragDropPage = new JQueryDragDropPage(driver);
        dragDropPage.dragAndDrop();

        String actual = dragDropPage.getLabel();
        String expected = "Dropped!";
        Assert.assertEquals(actual, expected);
        driverManager.quitDriver();
    }

    @Test
    public void ResizeElementTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://jqueryui.com/resources/demos/resizable/default.html");

        JQueryResizePage resizePage = new JQueryResizePage(driver);
        resizePage.resizing();

        String expected = "250px";

        Assert.assertNotNull(resizePage.getHeight(), expected);
        Assert.assertNotNull(resizePage.getWidth(), expected);
        driverManager.quitDriver();
    }
}
