package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLoggedInSuccess {
	WebDriver driver;

	public TestLoggedInSuccess(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='Logged In Successfully']")
	WebElement msg;
	public String succMsg() {
		String text=msg.getText();
		//System.out.println("text "+text);
		return text;
	}
	@FindBy(linkText = "Log out")
	WebElement logOut;
	public void clickLogOut() {
		logOut.click();
	}
}
