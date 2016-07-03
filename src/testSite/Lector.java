package testSite;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Lector {
	
protected static WebDriver driverL;
	
	@BeforeClass
	public void beforeLector() {		
		driverL = BaseSuite.driverBase;
		driverL.get(Parameters.baseUrl + "/");		
	}
	
	@AfterMethod
	public void afterMethodLector() throws Exception {		
		driverL.findElement(Locators.linkLogout).click();
		Functions.loginUser(driverL, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminDeleteCourse(driverL);
		driverL.findElement(Locators.linkLogout).click();
	}
	
	@Test
	public void reviewProfileListener() throws Exception {
		Functions.loginUser(driverL, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminCreateGroup(driverL);
		Functions.adminAddListenerToGroup(driverL, Parameters.nameListener);
		driverL.findElement(Locators.linkLogout).click();
		Functions.loginUser(driverL, Parameters.emailLector , Parameters.password);
		
		driverL.findElement(Locators.linkCourseOfLector).click();
		driverL.findElement(Locators.linkListenerOfLector).click();
		assertEquals(driverL.findElement(Locators.profile).getText(), Parameters.nameListener);
	}
	
	@Test
	public void createGroupMessage() throws Exception {
		
		Functions.loginUser(driverL, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminCreateGroup(driverL);
		Functions.adminAddListenerToGroup(driverL, Parameters.nameListener);
		driverL.findElement(Locators.linkLogout).click();		
		Functions.loginUser(driverL, Parameters.emailLector , Parameters.password);
		
		driverL.findElement(Locators.linkCourseOfLector).click();
		driverL.findElement(Locators.fieldMessage).sendKeys(Parameters.message);	
		driverL.findElement(Locators.buttonSubmitMessage).click();
		driverL.findElement(Locators.linkLogout).click();
		Functions.loginUser(driverL, Parameters.emailListener , Parameters.password);
		driverL.findElement(Locators.linkCourseOfListener).click();
		assertEquals(driverL.findElement(Locators.groupMessage).getText(), Parameters.message);
	}
	
	@Test
	public void addFile() throws Exception {
		
		Functions.loginUser(driverL, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminCreateGroup(driverL);
		Functions.adminAddListenerToGroup(driverL, Parameters.nameListener);
		driverL.findElement(Locators.linkLogout).click();
		Functions.loginUser(driverL, Parameters.emailLector , Parameters.password);
		driverL.findElement(Locators.linkCourseOfLector).click();
		
		WebElement fileInput = driverL.findElement(Locators.inputFile);
		fileInput.sendKeys(Parameters.filePath);
		driverL.findElement(Locators.buttonUploadFile).click();
		assertEquals(driverL.findElement(Locators.linkFile).getText(), Parameters.fileName);
	}
	
}
