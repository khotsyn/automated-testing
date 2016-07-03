package testSite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckLogin {
	
	protected static WebDriver driverLog;
	
	@BeforeClass
	public void beforeClassCheckLogin (){
		driverLog = BaseSuite.driverBase;
		driverLog.get(Parameters.baseUrl + "/");
	}
	
	@AfterMethod
	public void afterMethodCheckLogin() {
		driverLog.findElement(Locators.linkLogout).click();
	}
	
	@Test (dataProvider = "dateForLog", dataProviderClass = TestDataProvider.class)
	public void signIn(String dummy, String mail) throws Exception {	
		Functions.loginUser(driverLog, mail , Parameters.password);
		Functions.checkLogin(driverLog, mail);		
	}
}
