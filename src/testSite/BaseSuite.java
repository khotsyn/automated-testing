package testSite;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static org.testng.Assert.fail;

public class BaseSuite {

	protected static WebDriver driverBase;	
	protected static StringBuffer verificationErrors = new StringBuffer();

	@BeforeSuite
	public static void setUp() throws Exception {
		driverBase = new FirefoxDriver();		
		driverBase.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("text");
	}

	@AfterSuite
	public static void tearDown() throws Exception {
		driverBase.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);			
		}		
	}	
}
