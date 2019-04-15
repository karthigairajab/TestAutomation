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
		loginPage.openLoginPage();
		loginPage.waitUntilLoad();
		loginPage.loginDetails("Luke", "Skywalker");
		MainPage mainPage = loginPage.signInButton();
		mainPage.waitUntilLoad();
		Assert.assertTrue(mainPage.isCorrectProfileLoaded(correctProfileName), "Profile Name not expected");
		// driver.get("http://cafetownsend-angular-rails.herokuapp.com/");
		// System.out.println("Hi");
	}

}
