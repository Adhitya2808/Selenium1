package com.Tohsaka.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class JQueryDragDropPage {
    private By draggable = By.id("draggable");
    private By droppable = By.id("droppable");
    private Actions builder;
    private WebDriver driver;

    public JQueryDragDropPage(WebDriver driver) {
        this.driver = driver;
    }
    public void dragAndDrop(){
        this.builder = new Actions(driver);
        builder.dragAndDrop(
                driver.findElement(draggable),
                driver.findElement(droppable)).perform();
    }

    public String getLabel(){
        try {
            return driver.findElement(droppable).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
