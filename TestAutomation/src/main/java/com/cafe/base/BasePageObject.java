package com.cafe.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	protected BasePageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	//load page URL
	@SuppressWarnings("unchecked")
	protected T getPage(String url) {
		driver.get(url);
		return (T) this;
	}
	//send keys function
	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}
	//find function
	private WebElement find(By element) {
		return driver.findElement(element);
	}
	//click function
	protected void click(By element) {
		find(element).click();
	}
	//wait until object in the page is loaded
	protected void waitUntilLoad(By locator, Integer... timeoutSec) {
		int attempt = 0;
		while (attempt < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeoutSec.length > 0 ? timeoutSec[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempt++;
		}
	}
	//wait for certain time
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutSec) {
		timeoutSec = timeoutSec != null ? timeoutSec : 20;
		WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
		wait.until(condition);
	}
	//get title of the page
	public String getPageTitle() {
		return driver.getTitle();
	}
	//get text value of the element in webpage
	protected String getText(By element) {
		return find(element).getText();
	}

}
