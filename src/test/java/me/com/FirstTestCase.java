package me.com;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Objects.PageObject;
import PFObject.PageFactoryClass;
import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(Lifecycle.PER_CLASS)
class FirstTestCase {

	public WebDriver driver;
	public PageObject pageObj;
	public PageFactoryClass pageFact;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		WebDriverManager.chromedriver().setup();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
		pageObj = new PageObject(driver);
		pageFact = new PageFactoryClass(driver);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		driver.quit();
	}

	@Test
	void test() {
		pageObj.SearchOnGoogle("Emerson");
		Assertions.assertEquals("Images", pageFact.ImagesTab());
		Assertions.assertTrue(driver.getTitle() != null);
	}
	
	@Test
	void test2(){
		pageObj.SearchOnGoogle("Microsoft");
		Assertions.assertEquals("Images", pageFact.ImagesTab());
		Assertions.assertTrue(driver.getTitle() != null);
	}

}
