package com.Tohsaka.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class JQueryResizePage {
    private WebDriver driver;
    private JavascriptExecutor jse;
    private By resizer = By.xpath("/html/body/div/div[3]");
    private Actions builder;

    public JQueryResizePage(WebDriver driver) {
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
        builder = (Actions) driver;
    }

    public void resizing(int x, int y){
        builder.moveToElement(driver.findElement(resizer))
                .pause(Duration.ofSeconds(1)).clickAndHold()
                .moveByOffset(x, y).release().perform();
    }

    public  void resizing(){
        resizing(100,100);
    }

    public String getHeight(){
        return (String) jse.executeScript("return document.querySelector('#resizable').style.height");
    }

    public String getWidth(){
        return (String) jse.executeScript("return document.querySelector('#resizable').style.width");
    }
}
