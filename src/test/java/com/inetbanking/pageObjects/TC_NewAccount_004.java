package com.inetbanking.pageObjects;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_NewAccount_004 {
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addExtensions(new File("C:\\Adblock\\AdBlock-—-best-ad-blocker.crx"));
	    driver=new ChromeDriver(options);
	   
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	public String baseURL = "https://demo.guru99.com/V4/";
	public String username = "mngr530468";
	public String password = "uzaqaty";
	public static WebDriver driver;
	@Test
	
	public void NewAccount() throws Exception {
	
	driver.get(baseURL);
	 driver.navigate().refresh();
	driver.findElement(By.name("uid")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("btnLogin")).click();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	System.out.println(driver.getCurrentUrl());
	driver.findElement(By.xpath("//a[text()=\"New Account\"]")).click();
    driver.switchTo().defaultContent();
	driver.findElement(By.name("cusid")).sendKeys("62413");
	driver.findElement(By.name("inideposit")).sendKeys("5000");
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	String text1 = driver.findElement(By.xpath("//p[text()=\"Account Generated Successfully!!!\"]")).getText();
	String accountid = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
	System.out.println(accountid);
	TakesScreenshot ts1 = (TakesScreenshot) driver;
	File srcfile1 = ts1.getScreenshotAs(OutputType.FILE);
	File dstfile1 = new File("D:\\Desktop\\Selenium\\Account_Generated_Successfully.jpg");
	FileUtils.copyFile(srcfile1, dstfile1);
	
	}
	
	
}
