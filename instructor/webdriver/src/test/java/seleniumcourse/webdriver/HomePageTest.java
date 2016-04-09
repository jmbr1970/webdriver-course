package seleniumcourse.webdriver;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class HomePageTest {
	
	private WebDriver driver;
	private String baseUrl;

	/**
	 * This method is executed before every @test annotated method
	 *    
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		baseUrl = "http://mango.es";
		
		//Locating the firefox program
		File pathToFirefoxBinary = new File("E:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		FirefoxBinary binary = new FirefoxBinary(pathToFirefoxBinary);
		
		//Setting up a new firefox profile
		FirefoxProfile profile = new FirefoxProfile();
		
		//Creating a firefox driver instance.
		driver = new FirefoxDriver(binary, profile);
		
	}
	
	@Test
	public void test3PartyCookiesDisclaimerTestIsDisplayed() {
		
		//opening the urlBase
		driver.get(baseUrl);
		
		//Locating the cookies disclaimer lines
		WebElement coockiesDisclaimerLine1 = 
				driver.findElement(By.cssSelector("span.cookieBar__line.cookieBar__line1"));
		WebElement coockiesDisclaimerLine2 = 
				driver.findElement(By.cssSelector("span.cookieBar__line.cookieBar__line2"));
		
		//Asserting that those lines are displayed
		assertThat("Line 1 is not displayed", coockiesDisclaimerLine1.isDisplayed(), equalTo(true));
		assertThat("Line 2 is not displayed", coockiesDisclaimerLine2.isDisplayed(), equalTo(true));
	}
	
	/**
	 * This method is called just after each @test method is executed. 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		//closing all browser windows opened during the test.
		driver.quit();
	}


}
