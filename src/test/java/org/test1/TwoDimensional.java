package org.test1;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TwoDimensional {
 WebDriver driver;
	@Given("booking page")
	public void booking_page() {
		  System.setProperty("webdriver.chrome.driver","E:\\Java\\workspace\\Cucumber\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://demo.guru99.com/telecom/addcustomer.php");  
	}

	@When("enter details")
	public void enter_details(DataTable dataTable) throws InterruptedException {
		   List<List<String>> li=dataTable.asLists(String.class);
	      driver.findElement(By.xpath("//label[@for='done']")).click();
	      driver.findElement(By.id("fname")).sendKeys(li.get(1).get(0));
		  driver.findElement(By.id("lname")).sendKeys(li.get(1).get(1));
		  driver.findElement(By.id("email")).sendKeys(li.get(1).get(2));
		  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(li.get(1).get(3));
		  driver.findElement(By.id("telephoneno")).sendKeys(li.get(1).get(4));
		  Thread.sleep(1000);
	      driver.findElement(By.name("submit")).click();
		
	}

	@Then("booking no")
	public void booking_no() {
		String url=driver.getCurrentUrl();
		  boolean check=url.contains("uid");
		  Assert.assertTrue(check);
	   
	}


	


	
}
