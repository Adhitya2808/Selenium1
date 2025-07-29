package com.Tohsaka.ecom.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernamefield;

    @FindBy(id = "password")
    private WebElement passwordfield;

    @FindBy(id="login-button")
    private WebElement loginbutton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsernamefield(String value){
        usernamefield.sendKeys(value);
    }

    public void setPasswordfield(String value){
        passwordfield.sendKeys(value);
    }

    public void clickLoginButton(){
        loginbutton.click();
    }

    public String getErrorMessage(){
        try {
            return errorMessage.getText();
        } catch(NoSuchElementException e){
            return null;
        }
    }

    public void performLogin(){
        setUsernamefield("standard_user");
        setPasswordfield("secret_sauce");
        clickLoginButton();
    }

    public void performLogin(String username, String password){
        setUsernamefield(username);
        setPasswordfield(password);
        clickLoginButton();
    }
}
