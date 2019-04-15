package com.cafe;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cafe.base.BaseTest;
import com.cafe.webpages.CreatePage;
import com.cafe.webpages.MainPage;

public class Create extends BaseTest {

	@Test
	public void CreateCustomer() throws InterruptedException {
		String correctProfileName = "Hello Luke";
		Login login = new Login();
		login.LoginTest();
		MainPage mainPage = new MainPage(driver);
		CreatePage createPage = mainPage.clickCreateButton();
		createPage.waitUntilLoad();
		createPage.customerDetails("AMS", "NL", "2019-04-13", "amsnl@email.com");
		MainPage mainPageAgain = createPage.clickAddButton();
		Assert.assertTrue(mainPageAgain.isCorrectProfileLoaded(correctProfileName), "Profile Name not expected");
	}

}
