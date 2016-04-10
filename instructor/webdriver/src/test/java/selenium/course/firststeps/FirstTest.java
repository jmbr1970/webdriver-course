package selenium.course.firststeps;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {
	
	private WebDriver driver;
	private String baseUrl;
	private String browserPath;

	@Before
	public void setUp() throws Exception {
		
		baseUrl = "http://demo.icebergcommerce.com";
		browserPath = "E:/Program Files (x86)/Mozilla Firefox/firefox.exe";
		
		File pathToFirefoxBinary = new File(browserPath);
		FirefoxBinary binary = new FirefoxBinary(pathToFirefoxBinary);
		
		//Setting up a new firefox profile
		FirefoxProfile profile = new FirefoxProfile();
		
		driver = new FirefoxDriver(binary, profile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	@Ignore
	public void testTitle() {
		
		openHomePage();
		openElectronicsSectionPage();

		assertEquals("The title wasn't the expected", "Electronics", driver.getTitle());
		
	}
	
	@Test
	public void testSearch() {
		
		openHomePage();
		WebElement searchInput = driver.findElement(By.id("search"));
		
		searchInput.sendKeys("samsung");
		searchInput.submit();
		
		WebElement amount = driver.findElement(By.className("amount"));
		assertEquals("5 Item(s)",amount.getText());
	}
	
	@Test
	@Ignore
	public void testTextInElectronics() {
		
		openHomePage();
		openElectronicsSectionPage();
		
		WebElement text = driver.findElement(By.cssSelector("h1"));
		assertEquals("The expected text is not correct", "Electronics", text.getText());
		
	}
	
	@Test
	@Ignore
	public void testLanguageSelector() {
		
		List<String> expectedOptions = Arrays.asList("English", "French", "German");
		List<String> actualOptions;
				
		openHomePage();
		
		Select languageSelector = new Select(driver.findElement(By.id("select-language")));
		
		actualOptions = new ArrayList<String>(languageSelector.getOptions().size());
		
		assertEquals("The number of languages in the select is wrong", 
				expectedOptions.size(), 
				languageSelector.getOptions().size());
		
		for (WebElement option : languageSelector.getOptions()) {
			actualOptions.add(option.getText());
		}		
		
		assertEquals("The languages expected is wrong" , expectedOptions, actualOptions);
	}

	
	@Ignore
	@Test
	public void testNumberOfElectronicItemsDisplayedPerPage() {
		
		openHomePage();
		openElectronicsSectionPage();
		openComputersPage();
		
		List<WebElement> productImages = driver.findElements(By.className("product-image"));
		Select itemsPerPage = getShowItemsByPageSelect();
		
		assertEquals("9", itemsPerPage.getFirstSelectedOption().getText());
		
	}
	
	private void openComputersPage() {
		
		WebElement cellComputersPageLink = driver.findElement(By.linkText("Computers"));
		cellComputersPageLink.click();
	}
	
	private void openElectronicsSectionPage() {
		
		WebElement menuElectronics = driver.findElement(By.xpath("//ul[@id='nav']/li[2]/a/span"));
		menuElectronics.click();
	}
	
	private void openHomePage(){
		driver.get(baseUrl);
	}
	
	
	private Select getShowItemsByPageSelect(){
		
		return new Select(driver.findElement(By.className("limiter")).
				                 findElement(By.cssSelector("select")));
		
	}
}