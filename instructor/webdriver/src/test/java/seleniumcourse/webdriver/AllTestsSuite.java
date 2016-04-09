package seleniumcourse.webdriver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CookiesPolicyPageTest.class, 
	HomePageTest.class 
	})
public class AllTestsSuite {}
