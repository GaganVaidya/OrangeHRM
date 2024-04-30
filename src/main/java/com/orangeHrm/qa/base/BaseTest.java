package com.orangeHrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties property;
	
	public BaseTest() throws IOException {
		
		try {
			property=new Properties();
			FileInputStream fi=new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\OrangeHrmAutomation\\src\\main\\java"
					+ "\\com\\orangeHrm\\qa\\config\\config.properties");
			property.load(fi);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName=property.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void captureScreenshot(String fileName) {
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File fileType=takeScreenshot.getScreenshotAs(OutputType.FILE);
		File storagePath=new File("./Screenshot/"+fileName);
		try {
			FileUtils.copyFile(fileType, storagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
}


