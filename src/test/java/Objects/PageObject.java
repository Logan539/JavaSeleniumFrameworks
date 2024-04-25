package Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageObject {

	WebDriver driver;
	By searchEntry = By.name("q");
	
	public PageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void SearchOnGoogle(String input)
	{
		driver.findElement(searchEntry).sendKeys(input, Keys.ENTER);
	}
}
