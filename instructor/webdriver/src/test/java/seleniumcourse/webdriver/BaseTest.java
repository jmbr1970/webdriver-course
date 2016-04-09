package seleniumcourse.webdriver;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Abstract class with all methods and attributes 
 * common to test cases
 * 
 * @author Jose Blesa
 *
 */
public abstract class BaseTest {

	protected WebDriver driver;
	protected String baseUrl;

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
