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
		login.LoginTest(); //login into website
		MainPage mainPage = new MainPage(driver);
		CreatePage createPage = mainPage.clickCreateButton(); //create
		createPage.waitUntilLoad();
		createPage.customerDetails("AMS", "NL", "2019-04-13", "amsnl@email.com"); //create new customer
		MainPage mainPageAgain = createPage.clickAddButton(); //add
		Assert.assertTrue(mainPageAgain.isCorrectProfileLoaded(correctProfileName), "Profile Name not expected");
	}

}
