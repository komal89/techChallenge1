package Scenario2;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class uiAutomation {
	
	WebDriver driver;
	String chrome = "webdriver.chrome.driver";
	String location = "//Users//sumitchopra//Downloads//chromedriver";
	String baseUrl = "https://www.hostelworld.com/";
																									
	
	@Test()
	public void hostelWorldSearch() throws InterruptedException, IOException{	
		System.setProperty(chrome,location);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("//Users//sumitchopra//komal//eclipse-workspace//TechnicalChallenge//Scenario2//src//Scenario2//datadriven.properties");
		prop.load(fis);
		driver.findElement(By.id("home-search-keywords")).sendKeys(prop.getProperty("City"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class = 'suggestions-container']/ul[1]/li[2]")).click();
		driver.findElement(By.cssSelector("[class *= 'submit-search-form']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.cssSelector("[class *= 'location-field']")).getAttribute("value"), prop.getProperty("City"));
		System.out.println("Test Completed");	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
