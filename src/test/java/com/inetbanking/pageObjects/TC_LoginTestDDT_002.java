package com.inetbanking.pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_LoginTestDDT_002 {
	public String baseURL = "https://demo.guru99.com/V4/";
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	public static WebDriver driver;
	@Test
	public void DDT() throws Exception {
		driver.get(baseURL);
		
		File file =    new File("D:\\Book1.xls");
		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook wb=new HSSFWorkbook(inputStream);
		HSSFSheet sheet = wb.getSheet("Sheet1");
		for(int i=0;i<=sheet.getLastRowNum();i++) {
		        System.out.println(i);
				HSSFRow row2=sheet.getRow(i);
				HSSFCell cell=row2.getCell(0);
				String address= cell.getStringCellValue();
				driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(address);
		        HSSFCell cell1 = row2.getCell(1);
		        String password = cell1.getStringCellValue();
		        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
		        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		        try {
		        String url = driver.getCurrentUrl();
		        if(url.equals("https://demo.guru99.com/V4/index.php")) {
		        String alert = driver.switchTo().alert().getText();
		        driver.switchTo().alert().accept();
		        } else {
		        driver.findElement(By.xpath("//a[text()=\"Log out\"]")).click();
		        driver.switchTo().alert().accept();
		        }
		        } catch(Exception e) {
		        	System.out.println(e);
		        }
				 
			}
	}

}
