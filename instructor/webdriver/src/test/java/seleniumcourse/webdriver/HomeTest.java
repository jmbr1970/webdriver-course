package seleniumcourse.webdriver;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

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


/**
 * This is the first test... Nothing optimized.
 * Just to learn some commands.
 * We are using JUnit as testing library
 *   
 *   
 * @author Jose Blesa
 *
 */
public class HomeTest {
	
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
		assertThat("Line 1 is not displayed", coockiesDisclaimerLine1.isDisplayed(), is(true));
		assertThat("Line 2 is not displayed", coockiesDisclaimerLine2.isDisplayed(), is(true));
	}
	
	
	/**
	 * Once we are in the cookies information page, let's check that
	 * the div element showing the province selector is not displayed
	 * 
	 */	
	@Test
	public void testProvinceSelectorDivIsDisplayedOnCookiesInformationPage() {
		
		//opening the urlBase
		driver.get(baseUrl);
		
		//locating the link pointing to cookies information page
		WebElement policyCookiesLink = 
				driver.findElement(By.cssSelector("a.cookieBar__cookiePolicyLink"));
		
		//click on that link
		policyCookiesLink.click();
		
		//getting all the window handlers
		Object[] handlers = driver.getWindowHandles().toArray();
		
		assertThat("We haven't got two handlers", handlers.length, is(2));
		driver.switchTo().window((String)handlers[1]);
		
		WebElement seleccionProvincia =
				driver.findElement(By.id("seleccionProvincia"));
		
		assertThat("The province selector is not displayed", seleccionProvincia.isDisplayed(), is(true));
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