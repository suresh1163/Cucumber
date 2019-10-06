package org.test1;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class oneDimensional {
	public WebDriver driver;
	@Given("customer is on Booking page")
	public void customer_is_on_Booking_page() {
			  System.setProperty("webdriver.chrome.driver","E:\\Java\\workspace\\Cucumber\\driver\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://demo.guru99.com/telecom/addcustomer.php");
				driver.manage().window().maximize();
	}

	@When("customer enters booking details with firstname lastname  email address mobno")
	public void customer_enters_booking_details_with_firstname_lastname_email_address_mobno(DataTable dataTable) throws InterruptedException {
      List<String> li=dataTable.asList(String.class);
      driver.findElement(By.xpath("//label[@for='done']")).click();
      driver.findElement(By.id("fname")).sendKeys(li.get(0));
	  driver.findElement(By.id("lname")).sendKeys(li.get(1));
	  driver.findElement(By.id("email")).sendKeys(li.get(2));
	  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(li.get(3));
	  driver.findElement(By.id("telephoneno")).sendKeys(li.get(4));
	  Thread.sleep(1000);
      driver.findElement(By.name("submit")).click();
      }

	@Then("custoomer will get customer ID")
	public void custoomer_will_get_customer_ID() {
	  String url=driver.getCurrentUrl();
	  boolean check=url.contains("uid");
	  Assert.assertTrue(check);
	  	}

	

}
