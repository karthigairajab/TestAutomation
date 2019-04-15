package com.cafe.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected static WebDriver driver;

	@BeforeMethod
	protected void methodSetup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	protected void methodTearDown() {
		 driver.quit();
	}
	//constructor
	public BaseTest()
    {
    }
	// to return driver
    public WebDriver getDriver()
    {
        return this.driver;
    }
	
}
