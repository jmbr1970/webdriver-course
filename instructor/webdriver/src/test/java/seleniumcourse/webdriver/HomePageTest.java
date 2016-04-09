package seleniumcourse.webdriver;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageTest extends BaseTest {
	
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


}
