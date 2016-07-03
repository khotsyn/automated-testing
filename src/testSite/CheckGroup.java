package testSite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckGroup {
	
protected static WebDriver driverGr;
	
	@BeforeClass
	public void beforeClassGroup (){		
		driverGr = BaseSuite.driverBase;
		driverGr.get(Parameters.baseUrl + "/");
	}
	
	@BeforeMethod
	public void BeforeMethodGroup() throws Exception {
		Functions.loginUser(driverGr, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminCreateGroup(driverGr);
	}
	
	@AfterMethod
	public void afterMethodGroup() throws Exception {
		Functions.adminDeleteCourse(driverGr);
		driverGr.findElement(Locators.linkLogout).click();
	}
	
	@Test
	public void checkCreatGroup() throws Exception {		
		assertEquals(Parameters.nameGroup, driverGr.findElement(Locators.groupNameRow).getText());
	}
	
	@Test
	public void checkAddListenerGroup() throws Exception {
		Functions.adminAddListenerToGroup(driverGr, Parameters.nameListener);
		driverGr.findElement(Locators.buttonEditGroup).click();		
		assertEquals(driverGr.findElement(Locators.groupAddedListener).getText(), "×\n" + Parameters.nameListener);
		driverGr.findElement(Locators.closeGroup).click();
		Thread.sleep(200);
	}
	
	@Test (expectedExceptions = NoSuchElementException.class)
	public void checkDeleteGroup() throws Exception {
		Thread.sleep(500);
		Functions.adminDeleteGroup(driverGr);
		driverGr.findElement(Locators.linkGroups).click();
		driverGr.findElement(Locators.groupNameRow);
	}

}
