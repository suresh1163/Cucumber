package org.test1;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class OneMap {
	WebDriver driver;
	
	@Given("Booking screen details")
	public void booking_screen_details() {
		  System.setProperty("webdriver.chrome.driver","E:\\Java\\workspace\\Cucumber\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://demo.guru99.com/telecom/addcustomer.php");
	}

	@When("Enter all details")
	public void enter_all_details(DataTable dataTable) throws InterruptedException {
		  Map<String,String> li=dataTable.asMap(String.class,String.class);
	      driver.findElement(By.xpath("//label[@for='done']")).click();
	      driver.findElement(By.id("fname")).sendKeys(li.get("fname"));
		  driver.findElement(By.id("lname")).sendKeys(li.get("lname"));
		  driver.findElement(By.id("email")).sendKeys(li.get("email"));
		  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(li.get("loc"));
		  driver.findElement(By.id("telephoneno")).sendKeys(li.get("mobno"));
		  Thread.sleep(2000);
	      driver.findElement(By.name("submit")).click();
	}

	@Then("validate all")
	public void validate_all() {
		  String url=driver.getCurrentUrl();
		  boolean check=url.contains("uid");
		  Assert.assertTrue(check);
	}
}
