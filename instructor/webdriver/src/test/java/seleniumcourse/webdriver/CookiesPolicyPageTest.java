package seleniumcourse.webdriver;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * This is the first test... Nothing optimized.
 * Just to learn some commands.
 * We are using JUnit as testing library
 *   
 *   
 * @author Jose Blesa
 *
 */
public class CookiesPolicyPageTest extends BaseTest{
	
	/**
	 * Once we are in the cookies information page, let's check that
	 * the div element showing the province selector is displayed
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
		
		assertThat("We haven't got two handlers", handlers.length, equalTo(2));
		driver.switchTo().window((String)handlers[1]);
		
		WebElement seleccionProvincia =
				driver.findElement(By.id("seleccionProvincia"));
		
		assertThat("The province selector is not displayed", seleccionProvincia.isDisplayed(), equalTo(true));
	}

}