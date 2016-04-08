package seleniumcourse.webdriver;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class HomeTest {
	
	private WebDriver driver;
	private String baseUrl;
	

	@Before
	public void setUp() throws Exception {
		
		File pathToFirefoxBinary = new File("E:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		FirefoxBinary binary = new FirefoxBinary(pathToFirefoxBinary);
		FirefoxProfile profile = new FirefoxProfile();
		
		driver = new FirefoxDriver(binary, profile);
		baseUrl = "http://mango.es";
		
	}

	@Test
	public void test3PartyCookiesDisclaimerExists() {
		
		driver.get(baseUrl);
		WebElement coockiesDisclaimerLine1 = 
				driver.findElement(By.cssSelector("span.cookieBar__line.cookieBar__line1"));
		WebElement coockiesDisclaimerLine2 = 
				driver.findElement(By.cssSelector("span.cookieBar__line.cookieBar__line2"));
		
		assertTrue(coockiesDisclaimerLine1.isDisplayed());
		assertTrue(coockiesDisclaimerLine2.isDisplayed());
	}
	
	
	@Test
	public void testPolicyCookiesPopUp() {
		
		driver.get(baseUrl);
		WebElement policyCookiesLink = 
				driver.findElement(By.cssSelector("a.cookieBar__cookiePolicyLink"));
		
		policyCookiesLink.click();

		Object[] handlers = driver.getWindowHandles().toArray();
		
		driver.switchTo().window((String)handlers[1]);
		
		WebElement seleccionProvincia =
				driver.findElement(By.id("seleccionProvincia"));
		
		assertFalse("The province selector hasn't to be displayed in the cookie policy page", 
				     seleccionProvincia.isDisplayed());
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		//closing all browser windows opened during the test.
		driver.quit();
	}

}
