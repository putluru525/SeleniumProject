package com.inetbanking.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_LoginTest_001 {
	public String baseURL = "https://demo.guru99.com/V4/";
	public String username = "mngr530468";
	public String password = "uzaqaty";
	public static WebDriver driver;
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
@Test
public void loginTest() {
	driver.get(baseURL);
	driver.findElement(By.name("uid")).sendKeys(username);;
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("btnLogin")).click();
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
		
	}
}
}