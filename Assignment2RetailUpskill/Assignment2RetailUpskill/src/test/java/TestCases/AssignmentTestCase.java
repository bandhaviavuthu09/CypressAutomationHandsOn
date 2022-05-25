package TestCases;

import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.Utilities;


public class AssignmentTestCase {

	WebDriver driver = new ChromeDriver();
	Utilities utl = new Utilities();
	
	@BeforeTest
	public void init() throws MalformedURLException, InterruptedException{

			System.setProperty("webdriver.chrome.driver","C:\\Users\\002TQO744\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");			
			driver.get("http://retailm1.upskills.in/");
			driver.manage().window().maximize();
	}
	 
	@Test(priority = 1)
	public void TestCaseOne(WebDriver driver) throws MalformedURLException, InterruptedException {
	 
		utl.clickOnAccountIcon(driver);
		utl.clickOnLogin(driver);
		utl.clickOnRegister(driver);	
		utl.fillRegisterForm(driver);
		System.out.println("Test Case One execution successful");

	 
	}
	
	@Test(priority = 2)
	public void TestCaseTwo() throws MalformedURLException, InterruptedException {
	 
		utl.clickOnAccountIcon(driver);
		utl.clickOnLogin(driver);
		utl.Login(driver);
		System.out.println("Test Case Two execution successful");
	 
	}
	

	@AfterTest
	public void teardown(WebDriver driver){
	     	   
		driver.close();
	 
	}

}
