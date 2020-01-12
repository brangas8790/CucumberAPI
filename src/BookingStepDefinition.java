

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.*;
import cucumber.annotation.en.*;
import cucumber.table.DataTable;
import static org.testng.Assert.assertEquals; 

public class BookingStepDefinition {
	WebDriver driver;
	private String Expectedresult;
	
	
	
	@Given("^Customer open the application$")
	public void Customer_open_the_application() {
		 System.setProperty("webdriver.chrome.driver", "/Users/brangas/Documents/workspace/item_details/chromedriver");
		 driver = new ChromeDriver(); 
		driver.get("http://apps.qa2qe.cognizant.e-box.co.in/HallBooking/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

		
	
	@When("^Customer booking the hall by giving details and clicks the button$")
	public void Customer_booking_the_hall_by_giving_details_and_clicks_the_button(DataTable data) {
		
		List<List<String>> row=data.raw();
			
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(row.get(1).get(0));
		driver.findElement(By.xpath("//*[@id='contact']")).sendKeys(row.get(1).get(1));
		Select dropdown=new Select(driver.findElement(By.id("halltype")));
		dropdown.selectByVisibleText(row.get(1).get(2));
		driver.findElement(By.xpath("//*[@id='date']")).sendKeys(row.get(1).get(3));
		driver.findElement(By.xpath("//*[@id='hallBook']")).click();
	}

	@Then("^Verifying the booking details$")
	public void Verifying_the_booking(DataTable data) {
	   
		List<List<String>> result=data.raw();
		Expectedresult=driver.findElement(By.xpath("//*[@id='message']")).getText();
		assertEquals(result.get(0).get(0), Expectedresult);
		driver.quit();
	}



	

	
	
	
	

	

	


}
