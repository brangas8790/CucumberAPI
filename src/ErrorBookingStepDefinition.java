import static org.testng.Assert.assertEquals;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;
import cucumber.annotation.en.*;


public class ErrorBookingStepDefinition {
	
	WebDriver driver;
	String result; 
	
	@Given("^Customer open the given application$")
	public void Customer_open_the_application() {
		System.setProperty("webdriver.chrome.driver", "/Users/brangas/Documents/workspace/item_details/chromedriver");
		 driver = new ChromeDriver(); 
		driver.get("http://apps.qa2qe.cognizant.e-box.co.in/HallBooking/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@When("^Customer booking the hall by giving details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and clicks Book the hall button$")
	public void Verifying_the_error(String arg1, String arg2, String arg3, String arg4) {
	 
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(arg1);
		driver.findElement(By.xpath("//*[@id='contact']")).sendKeys(arg2);
		Select dropdown=new Select(driver.findElement(By.id("halltype")));
		dropdown.selectByVisibleText(arg3);
		driver.findElement(By.xpath("//*[@id='date']")).sendKeys(arg4);
		driver.findElement(By.xpath("//*[@id='hallBook']")).click();
	}

	@Then("^Verifying the booking \"([^\"]*)\"$")
	public void Verifying_the_booking(String arg1) {
		
		result =driver.findElement(By.xpath("//*[@id='message']")).getText();
		assertEquals(result, arg1);
		driver.close();
		
	}


}
