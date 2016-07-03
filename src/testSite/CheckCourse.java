package testSite;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckCourse {
	
protected static WebDriver driverCr;
	
	@BeforeClass
	public void beforeClassCourse (){
		driverCr = BaseSuite.driverBase;
		driverCr.get(Parameters.baseUrl + "/");
	}
	
	@BeforeMethod
	public void BeforeMethodCourse() throws Exception {
		Functions.loginUser(driverCr, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminCreateCourse(driverCr);
		Thread.sleep(200);
	}
	
	@AfterMethod
	public void afterMethodCourse() throws Exception {
		List<WebElement> courses = driverCr.findElements(By.xpath("//tbody/tr/td[1]"));
		String s;
		for (WebElement web : courses) {
			s = web.getText();
			if (s.equals(Parameters.nameCourse)) {
				Functions.adminDeleteCourse(driverCr);
				Thread.sleep(200);
				break;
			}				
		}				
		driverCr.findElement(Locators.linkLogout).click();
	}
	
	@Test
	public void checkCreatCourse() {				
		assertEquals(Parameters.nameCourse, driverCr.findElement(Locators.courseNameRow).getText());		
	}
	
	@Test
	public void checkEditCourse() {		
		driverCr.findElement(Locators.buttonEditCourse).click();
		driverCr.findElement(Locators.fieldCourseEditClasses).clear();
		driverCr.findElement(Locators.fieldCourseEditClasses).sendKeys(Parameters.courseEditClasses);
		driverCr.findElement(Locators.buttonSubmit).click();
		assertEquals(Parameters.courseEditClasses, driverCr.findElement(Locators.courseClassesRow).getText());		
	}
	
	@Test (expectedExceptions = NoSuchElementException.class)
	public void checkDeleteCourse() throws Exception {		
		Functions.adminDeleteCourse(driverCr);		
		Thread.sleep(200);		
		driverCr.findElement(Locators.courseNameRow);	
	}

}
