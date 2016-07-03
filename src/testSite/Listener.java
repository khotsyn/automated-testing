package testSite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Listener {
protected static WebDriver driverLis;
	
	@BeforeClass
	public void beforeClassListener() throws Exception {		
		driverLis = BaseSuite.driverBase;
		driverLis.get(Parameters.baseUrl + "/");
		Functions.loginUser(driverLis, Parameters.emailEnter , Parameters.passwordAdmin);
		driverLis.findElement(Locators.buttonAddUser).click();
		driverLis.findElement(Locators.fieldNewName).sendKeys(Parameters.nameListener2);
		Thread.sleep(200);
		driverLis.findElement(Locators.fieldEmail).sendKeys(Parameters.emailListener2);
		driverLis.findElement(Locators.buttonSubmit).click();
		Functions.explicitWaits(driverLis, Locators.linkLogout);
	}
	
	@AfterClass
	public void afterClassListener() throws Exception {
		Functions.loginUser(driverLis, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.deleteUser(driverLis, Parameters.emailListener2);
		driverLis.findElement(Locators.linkLogout).click();
	}
	
	@BeforeMethod
	public void BeforeMethodListener() throws Exception {
		Functions.loginUser(driverLis, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminCreateGroup(driverLis);
		Functions.adminAddListenerToGroup(driverLis, Parameters.nameListener);
	}
	
	@AfterMethod
	public void afterMethodListener() throws Exception {		
		driverLis.findElement(Locators.linkLogout).click();
		Functions.loginUser(driverLis, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminDeleteCourse(driverLis);		
		driverLis.findElement(Locators.linkLogout).click();
		
	}
	
	@Test
	public void reviewCourse() throws Exception {
		driverLis.findElement(Locators.linkLogout).click();
		Functions.loginUser(driverLis, Parameters.emailListener, Parameters.password);		
		driverLis.findElement(Locators.linkCourseOfListener).click();
		assertEquals(driverLis.findElement(Locators.listenerClassesCount).getText(), Parameters.courseClassesCount);
	}
	
	@Test
	public void reviewProfileGroupmate() throws Exception {
		System.out.println("before");
		Functions.adminAddListenerToGroup(driverLis, Parameters.nameListener2);
		System.out.println("after");
		driverLis.findElement(Locators.linkLogout).click();
		System.out.println("after2");
		Functions.loginUser(driverLis, Parameters.emailListener, Parameters.password);		
		driverLis.findElement(Locators.linkCourseOfListener).click();
		driverLis.findElement(Locators.linkGroupmate).click();
		assertEquals(driverLis.findElement(Locators.profile).getText(), Parameters.nameListener2);
	}
	
	@Test
	public void reviewProfileLector() throws Exception {
		driverLis.findElement(Locators.linkLogout).click();
		Functions.loginUser(driverLis, Parameters.emailListener, Parameters.password);
		driverLis.findElement(Locators.linklector).click();
		assertEquals(driverLis.findElement(Locators.profile).getText(), Parameters.nameLector);
		
	}
	
}

