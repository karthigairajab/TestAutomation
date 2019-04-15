package com.cafe.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cafe.base.BasePageObject;

public class CreatePage extends BasePageObject<CreatePage> {

	private By firstNameField = By.cssSelector("input[ng-model='selectedEmployee.firstName']");
	private By lastNameField = By.cssSelector("input[ng-model='selectedEmployee.lastName']");
	private By startDateField = By.cssSelector("input[ng-model='selectedEmployee.startDate']");
	private By emailField = By.cssSelector("input[ng-model='selectedEmployee.email']");
	private By addCustomerButton = By.xpath("//button[text()='Add']");

	public CreatePage(WebDriver driver) {
		super(driver);
	}
	//enter customer details
	public void customerDetails(String firstName, String lastName, String startDate, String email) {
		type(firstName, firstNameField);
		type(lastName, lastNameField);
		type(startDate, startDateField);
		type(email, emailField);
	}

	public void waitUntilLoad() {
		waitUntilLoad(addCustomerButton, 20);
	}

	public MainPage clickAddButton() {
		click(addCustomerButton);
		return new MainPage(driver);

	}

}
