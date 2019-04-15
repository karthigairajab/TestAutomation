package com.cafe;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.cafe.base.BaseTest;
import com.cafe.webpages.LoginPage;
import com.cafe.webpages.MainPage;

public class Login extends BaseTest {

	@Test
	public void LoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		String correctProfileName = "Hello Luke";
		loginPage.openLoginPage(); // open URL
		loginPage.waitUntilLoad(); // wait for page to load
		loginPage.loginDetails("Luke", "Skywalker"); // username and password
		MainPage mainPage = loginPage.signInButton(); // click on login
		mainPage.waitUntilLoad(); // wait for page to load
		Assert.assertTrue(mainPage.isCorrectProfileLoaded(correctProfileName), "Profile Name not expected"); // verification

	}

}
