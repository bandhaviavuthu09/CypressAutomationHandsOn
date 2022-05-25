package StepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.Timeout;
import junit.framework.Assert;

public class AssignmentStepDef2 {
	
	WebDriver driver = new ChromeDriver();
	
	@Given("user is on saucedemo homepage")
	public void user_is_on_saucedemo_homepage() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\002TQO744\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
	}

	@Given("user logged in using correct credential")
	public void user_logged_in_using_correct_credential(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(data.get(0).get("username"));
    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(data.get(0).get("password"));
    	
    	driver.findElement(By.xpath("//input[@id='login-button']")).submit();
	}


	@And("user adds required item to cart")
	public void user_adds_required_item_to_cart() {
	    driver.findElement(By.xpath("//div[contains(text(),'1 AAA battery included.')]/parent::div/following-sibling::div/button")).click();
	    
	}

	@And("user proceeds to checkout")
	public void user_proceeds_to_checkout() {
	    driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	    driver.findElement(By.xpath("//button[@id='checkout']")).click();
	}

	@And("user enters the following details for checkout")
	public void user_enters_the_following_details_for_checkout(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		driver.findElement(By.cssSelector("input#first-name")).sendKeys(data.get(0).get("FirstName"));
    	driver.findElement(By.cssSelector("input#last-name")).sendKeys(data.get(0).get("LastName"));
    	driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(data.get(0).get("PostalCode"));
	    
	}

	@When("user confirm checkout")
	public void user_confirm_checkout() throws InterruptedException {
	    driver.findElement(By.xpath("//input[@id='continue']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@id='finish']")).click();
	}

	@Then("user verify final confirmation messagge")
	public void user_verify_final_confirmation_messagge() throws InterruptedException {
	    String confMsg=driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2")).getText();
	    Thread.sleep(2000);
	    Assert.assertEquals("OrderPlaced", confMsg, "THANK YOU FOR YOUR ORDER");
	    driver.close();
	}

	@And("user adds one item and then remove that item to go back")
	public void user_adds_one_item_and_then_remove_that_item_to_go_back() throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(text(),'1 AAA battery included.')]/parent::div/following-sibling::div/button")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='remove-sauce-labs-bike-light']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='continue-shopping']")).click();
	    
	}

	@Then("user verify final confirmation message")
	public void user_verify_final_confirmation_message() throws InterruptedException {
		String confMsg=driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2")).getText();
	    Thread.sleep(2000);
	    Assert.assertEquals("OrderPlaced", confMsg, "THANK YOU FOR YOUR ORDER");
	    driver.close();
	}

	@And("user sorts item low to high")
	public void user_sorts_item_low_to_high() throws InterruptedException {
		
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//select[@class='product_sort_container']/option[@value='lohi']")).click();
		Thread.sleep(3000);
	}
	
	



}
