package com.inetbanking.pageObjects;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class TC_NewCustomer_003 {
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addExtensions(new File("C:\\Adblock\\AdBlock-—-best-ad-blocker.crx"));
	    driver=new ChromeDriver(options);
		//driver = new EdgeDriver();
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

private void addCustomer() throws Exception {
	driver.get(baseURL);
	 driver.navigate().refresh();
	driver.findElement(By.name("uid")).sendKeys(username);;
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("btnLogin")).click();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//a[text()=\"New Customer\"]")).click();
	driver.findElement(By.name("name")).sendKeys("Bhuvaneswari Putluru");
	driver.findElement(By.xpath("//input[@value=\"f\"]")).click();
	driver.findElement(By.id("dob")).sendKeys("30");
	driver.findElement(By.id("dob")).sendKeys("10");
	driver.findElement(By.id("dob")).sendKeys("1995");
	driver.findElement(By.name("addr")).sendKeys("Near Chowdamma Temple Gandhinagar Dharmavaram");
	driver.findElement(By.name("city")).sendKeys("Anantapur");
	driver.findElement(By.name("state")).sendKeys("AP");
	driver.findElement(By.name("pinno")).sendKeys("515671");
	driver.findElement(By.name("telephoneno")).sendKeys("9989747757");
	driver.findElement(By.name("emailid")).sendKeys("putluru5024@gmail.com");
	driver.findElement(By.name("password")).sendKeys("123456789");
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	String text = driver.findElement(By.xpath("//p[text()=\"Customer Registered Successfully!!!\"]")).getText();
	Assert.assertEquals(driver.getPageSource().contains("Customer Registered Successfully!!!"), true);
	String customerid = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
	System.out.println(customerid);
	TakesScreenshot ts = (TakesScreenshot) driver;
	File srcfile = ts.getScreenshotAs(OutputType.FILE);
	File dstfile = new File("D:\\Desktop\\Selenium\\Customer_Registered_Successfully.jpg");
	FileUtils.copyFile(srcfile, dstfile);
	editcustomerData(customerid);
}
	//Edit Customer Details
	private void editcustomerData(CharSequence customerid) throws Exception {
	driver.findElement(By.xpath("//a[text()=\"Edit Customer\"]")).click();
	driver.findElement(By.name("cusid")).sendKeys(customerid);
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	for(int i=0;i<10;i++){
	driver.findElement(By.name("telephoneno")).sendKeys(Keys.BACK_SPACE);
	}
	driver.findElement(By.name("telephoneno")).sendKeys("9182881862");
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.name("cusid")).sendKeys(customerid);
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	WebElement telephoneno = driver.findElement(By.name("telephoneno"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", telephoneno);
	TakesScreenshot ts = (TakesScreenshot) driver;
	File srcfile = ts.getScreenshotAs(OutputType.FILE);
	File dstfile = new File("D:\\Desktop\\Selenium\\telephone_no.jpg");
	FileUtils.copyFile(srcfile, dstfile);
	
	
	}
	
	
}

