package com.cafe.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cafe.base.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage> {

	private static final String URL = "http://cafetownsend-angular-rails.herokuapp.com/";
	private By userNameField = By.cssSelector("input[ng-model='user.name']");
	private By passwordField = By.cssSelector("input[ng-model='user.password']");
	private By loginButton = By.xpath("//button[@type='submit']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void openLoginPage() {
		getPage(URL);
	}
	//enter login details
	public void loginDetails(String email, String password) {
		type(email, userNameField);
		type(password, passwordField);
	}
	//signin button
	public MainPage signInButton() {
		click(loginButton);
		return new MainPage(driver);

	}

	public void waitUntilLoad() {
		waitUntilLoad(userNameField, 10);
	}

}
