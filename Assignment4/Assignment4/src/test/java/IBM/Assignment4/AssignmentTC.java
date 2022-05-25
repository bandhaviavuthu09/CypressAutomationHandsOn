package IBM.Assignment4;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.Assert;

public class AssignmentTC {

		 
	DesiredCapabilities dc = new DesiredCapabilities();
	AndroidDriver<AndroidElement> and;
	
		@BeforeClass
		public void init() throws MalformedURLException, InterruptedException{
		     
			
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "2790165f");
			dc.setCapability("appPackage", "com.swaglabsmobileapp");
		    dc.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
  
	 
		}
		 
		@Test(priority = 1)
		public void scenario1() throws MalformedURLException, InterruptedException {
		 
			and = new AndroidDriver<AndroidElement>(dc);
			Thread.sleep(2000);	
			login();
			addItemToCart();
			clickCheckoutBtn();
			fillCheckoutForm();
			
			clickContinueBtn();
			clickFinishBtn();
			Boolean confMsg = true;
			Boolean confMsgReturned = and.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]").isDisplayed();
			System.out.println("Order placed successfully"+ confMsg);
			Assert.assertEquals(confMsgReturned, confMsg);
			System.out.println("Scenario 1 execution successful");

		 
		}
		
		@Test(priority = 2)
		public void scenario2() throws MalformedURLException, InterruptedException {
		 
			and = new AndroidDriver<AndroidElement>(dc);
			Thread.sleep(2000);
			login();
			addItemToCart();
			and.findElementByAccessibilityId("test-REMOVE").click();

			and.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]/android.widget.TextView").click();
			Thread.sleep(3000);
			addItemToCart();
			clickCheckoutBtn();
			fillCheckoutForm();
			
			clickContinueBtn();
			clickFinishBtn();
			Boolean confMsg = true;
			Boolean confMsgReturned = and.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]").isDisplayed();
			System.out.println("Order placed successfully"+ confMsg);
			Assert.assertEquals(confMsgReturned, confMsg);
			
			System.out.println("Scenario 2 execution successful");

		 
		}
		
		
		@Test(priority = 3)
		public void scenario3() throws MalformedURLException, InterruptedException {
		 
			and = new AndroidDriver<AndroidElement>(dc);
			Thread.sleep(2000);
			login();
			filterSort();
			addItemToCart();
			clickCheckoutBtn();
			fillCheckoutForm();			
			clickContinueBtn();
			Thread.sleep(3000);
			clickFinishBtn();
			Boolean confMsg = true;
			Boolean confMsgReturned = and.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]").isDisplayed();
			System.out.println("Order placed successfully"+ confMsg);
			Assert.assertEquals(confMsgReturned, confMsg);			
			System.out.println("Scenario 3 execution successful");

		}
		
		@AfterTest
		public void teardown(){
		     	   
			and.closeApp();
		 
		}
		
		public void login() throws InterruptedException {
			
			Thread.sleep(2000);
			and.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
			and.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");
			and.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView").click();
			Thread.sleep(3000);
		}
		
		public void fillCheckoutForm() throws InterruptedException {
			
			Thread.sleep(3000);
			and.findElementByAccessibilityId("test-First Name").sendKeys("User1");
			and.findElementByAccessibilityId("test-Last Name").sendKeys("Test1");
			and.findElementByAccessibilityId("test-Zip/Postal Code").sendKeys("540010");
		}
		
		public void addItemToCart() throws InterruptedException {
			
			Thread.sleep(3000);
			and.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView").click();
			and.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView").click();
			Thread.sleep(3000);
		}
		
		public void clickCheckoutBtn() throws InterruptedException {
			Thread.sleep(2000);
			and.findElementByAccessibilityId("test-CHECKOUT").click();
		}
		
		public void clickContinueBtn() throws InterruptedException {
			and.findElementByAccessibilityId("test-CONTINUE").click();
			Thread.sleep(3000);
		}
		
		public void clickFinishBtn() throws InterruptedException {
			and.findElementByAndroidUIAutomator("new UiScrollable("
			        + "new UiSelector().scrollable(true)).scrollIntoView("                      
			        + "new UiSelector().textContains(\"FINISH\"));");
			and.findElementByAccessibilityId("test-FINISH").click();
			Thread.sleep(3000);
		}
		
		public void filterSort() throws InterruptedException {
			
			Thread.sleep(3000);
			and.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView").click();
			Thread.sleep(3000);
			and.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView").click();
			
		}
}
