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

public class TwoMap {
	WebDriver driver;
	
	@Given("Booking screen")
	public void booking_screen() {
		 System.setProperty("webdriver.chrome.driver","E:\\Java\\workspace\\Cucumber\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("http://demo.guru99.com/telecom/addcustomer.php");
	}

	@When("enter all details")
	public void enter_all_details(DataTable dataTable) throws InterruptedException {
		 List<Map<String,String>> li=dataTable.asMaps(String.class,String.class);
	      driver.findElement(By.xpath("//label[@for='done']")).click();
	      driver.findElement(By.id("fname")).sendKeys(li.get(1).get("fname"));
		  driver.findElement(By.id("lname")).sendKeys(li.get(1).get("lname"));
		  driver.findElement(By.id("email")).sendKeys(li.get(1).get("email"));
		  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(li.get(1).get("loc"));
		  driver.findElement(By.id("telephoneno")).sendKeys(li.get(1).get("mobno"));
		  Thread.sleep(2000);
	      driver.findElement(By.name("submit")).click();
	   
	}

	@Then("validate the outcomes")
	public void validate_the_outcomes() {
		  String url=driver.getCurrentUrl();
		  boolean check=url.contains("uid");
		  Assert.assertTrue(check);
	}



}
