package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLoginPage {
WebDriver driver;

public TestLoginPage(WebDriver driver) {
	
	this.driver = driver;
	
	PageFactory.initElements(driver, this);
}
//Identify Element
@FindBy(name= "username")
WebElement userName;

//Identify Action
public void sendUserId() {
	userName.sendKeys("student");
}

@FindBy(id= "password")
WebElement password;

public void sendpassword() {
	password.sendKeys("Password123");
}
@FindBy(id = "submit")
WebElement Submit;

public void clickSubmit() {
	Submit.click();
}


}
