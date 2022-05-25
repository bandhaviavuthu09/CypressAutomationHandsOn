package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Utilities {

	
	public void clickOnAccountIcon(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='tb_icon']//i[@class='fa fa-user-o']")).click();

	}
	public void clickOnLogin(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='tb_icon']//i[@class='fa fa-sign-in']")).click();

	}
	
	public void clickOnRegister(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='http://retailm1.upskills.in/account/register']")).click();

	}
	
	public void fillRegisterForm(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-firstname")).sendKeys("manzoor");
		driver.findElement(By.id("input-lastname")).sendKeys("mehadi");
		driver.findElement(By.id("input-email")).sendKeys("manzoor@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		driver.findElement(By.id("input-address-1")).sendKeys("yeshwanthapur");
		driver.findElement(By.id("input-address-2")).sendKeys("bangalore");
		driver.findElement(By.id("input-city")).sendKeys("bangalore");
		driver.findElement(By.id("input-postcode")).sendKeys("560022");
		Select sel = new Select(driver.findElement(By.id("input-country")));
		sel.selectByVisibleText("India");
		Thread.sleep(2000);
		Select sel1 = new Select(driver.findElement(By.id("input-zone")));
		sel1.selectByVisibleText("Karnataka");
		
		driver.findElement(By.id("input-password")).sendKeys("manzoor1");
		driver.findElement(By.id("input-confirm")).sendKeys("manzoor1");
		driver.findElement(By.xpath("//label[contains(text(),'No')]//input")).click();
		driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		Boolean isDisplayed = true;
		Boolean bol = driver.findElement(By.xpath("//div[@class='tb_text_wrap tb_sep']//p[contains(text(),'Congratulations!')]")).isDisplayed();
		Assert.assertEquals(bol, isDisplayed);

	}
	
	public void Login(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys("manzoor@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("manzoor1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Boolean isDisplayed = true;
		Boolean bol = driver.findElement(By.xpath("//div[@id='welcome_message']")).isDisplayed();
		Assert.assertEquals(bol, isDisplayed);
		
	}
	
}
