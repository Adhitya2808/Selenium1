package com.Tohsaka.ecom;

import com.Tohsaka.ecom.repositories.JQueryDragDropRepository;
import com.Tohsaka.ecom.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest {

    @Test
    public void dragDropTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://jquery-drag-drop-demo.webflow.io/");

        Actions builder = new Actions(driver);
        WebElement draggable = driver.findElement(JQueryDragDropRepository.draggable);
        WebElement droppable = driver.findElement(JQueryDragDropRepository.droppable);
        builder.dragAndDrop(draggable, droppable).perform();

        Thread.sleep(1000);
        String actual = droppable.getText();
        String expected = "Dropped!";
        Assert.assertEquals(actual, expected);
        driverManager.quitDriver();
    }
}
