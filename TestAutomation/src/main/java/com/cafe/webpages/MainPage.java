package com.cafe.webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cafe.base.BasePageObject;

public class MainPage extends BasePageObject<MainPage> {

	private By createCustomerButton = By.xpath("//a[@id='bAdd']");
	private By customerGreetings = By.xpath("//p[@id='greetings']");
	private By createButton = By.xpath("//a[@id='bAdd']");

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void waitUntilLoad() {
		waitUntilLoad(createCustomerButton, 10);
	}

	public boolean isCorrectProfileLoaded(String correctProfileName) {
		if (getText(customerGreetings).equals(correctProfileName)) {
			return true;
		}
		return false;
	}

	public CreatePage clickCreateButton() {
		click(createButton);
		return new CreatePage(driver);

	}

}
