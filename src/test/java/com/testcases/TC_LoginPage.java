package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utilities.ProjectListeners;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.pageObject.TestLoggedInSuccess;
import com.pageObject.TestLoginPage;

@Listeners(ProjectListeners.class)
public class TC_LoginPage extends BaseClass {

	
	@Test
	public void verifyLoginSucc() throws InterruptedException {
		TestLoginPage tlp = new TestLoginPage(driver);
		TestLoggedInSuccess tlin = new TestLoggedInSuccess(driver);

		driver.get(url);
		tlp.sendUserId();
		tlp.sendpassword();
		tlp.clickSubmit();
		Thread.sleep(2000);

		Assert.assertEquals(tlin.succMsg(), "Logged In Successfully");
		tlin.clickLogOut();
	}

	@Test
	public void verifyLoginFailed() throws InterruptedException {
		TestLoginPage tlp = new TestLoginPage(driver);
		TestLoggedInSuccess tlin = new TestLoggedInSuccess(driver);

		driver.get(url);
		tlp.sendUserId();
		tlp.sendpassword();
		tlp.clickSubmit();
		Thread.sleep(2000);

		Assert.assertEquals(tlin.succMsg(), "Logged In Successfully1");
	}

	 @Test(enabled = false)
	public void skippedTest() {
		System.out.println("This test will be skipped.");
	}
}
