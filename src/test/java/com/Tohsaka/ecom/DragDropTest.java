package com.Tohsaka.ecom;

import com.Tohsaka.ecom.repositories.JQueryDragDropRepository;
import com.Tohsaka.ecom.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragDropTest {

    @Test(enabled = false)
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

    @Test
    public void resizeTest() throws InterruptedException {
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.getDriver();
        driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
        Actions builder = new Actions(driver);
        WebElement resize = driver.findElement(By.xpath("/html/body/div/div[3]"));
        builder.moveToElement(resize).pause(Duration.ofSeconds(1)).clickAndHold().moveByOffset(10,150).release().perform();

        driverManager.quitDriver();
    }
}
