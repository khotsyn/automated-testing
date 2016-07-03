package testSite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	protected static WebDriver driverTest;
	
	@BeforeTest
	public void createUsers() throws Exception {
		driverTest = BaseSuite.driverBase;
		driverTest.get(Parameters.baseUrl + "/");
		Functions.loginUser(driverTest, Parameters.emailEnter, Parameters.passwordAdmin);
		Functions.createUser(driverTest, Parameters.nameListener, Parameters.emailListener, Locators.userListener);
		Functions.createUser(driverTest, Parameters.nameLector, Parameters.emailLector, Locators.userLector);		
		Functions.createUser(driverTest, Parameters.nameAccountant, Parameters.emailAccountant, Locators.userAccountant);		
		driverTest.findElement(Locators.linkLogout).click();
	}
	
	@AfterTest
	public void deleteUsers() throws Exception {
		Functions.loginUser(driverTest, Parameters.emailEnter, Parameters.passwordAdmin);
		Functions.deleteUser(driverTest, Parameters.emailLector);
		Functions.deleteUser(driverTest, Parameters.emailListener);
		Functions.deleteUser(driverTest, Parameters.emailAccountant);
		driverTest.findElement(Locators.linkLogout).click();
	}
	
}

