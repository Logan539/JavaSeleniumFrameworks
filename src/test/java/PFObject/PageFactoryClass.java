package PFObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryClass {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='YmvwI' and text()='Images']")
	WebElement imagesTab;
	
	@FindBy(xpath = "//div[@selected='']")
	WebElement checkTrue;
	
	public PageFactoryClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String ImagesTab()
	{
		imagesTab.click();
		return checkTrue.getText();
	}
}
