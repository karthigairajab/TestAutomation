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

	@SuppressWarnings("unchecked")
	protected T getPage(String url) {
		driver.get(url);
		return (T) this;
	}

	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}

	private WebElement find(By element) {
		return driver.findElement(element);
	}

	protected void click(By element) {
		find(element).click();
	}

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

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutSec) {
		timeoutSec = timeoutSec != null ? timeoutSec : 20;
		WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
		wait.until(condition);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	protected String getText(By element) {
		return find(element).getText();
	}

}
