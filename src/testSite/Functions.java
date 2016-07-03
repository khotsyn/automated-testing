package testSite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Functions {
	
	public static void loginUser(WebDriver driver, String email, String pass) {
		driver.findElement(Locators.fieldLogin).sendKeys(email);
		driver.findElement(Locators.fieldPass).sendKeys(pass);
		driver.findElement(Locators.buttonLogin).click();
	}
	
	public static void createUser(WebDriver driver, String name, String email, By user) throws Exception {
		explicitWaits(driver, Locators.buttonAddUser);
		driver.findElement(Locators.fieldNewName).sendKeys(name);
		Thread.sleep(200);
		driver.findElement(Locators.fieldEmail).sendKeys(email);
		if (user != Locators.userListener) {
			driver.findElement(Locators.userListener).click();
			driver.findElement(user).click();			
		}
		driver.findElement(Locators.buttonSubmit).click();
		Thread.sleep(500);
	}
	
	public static void deleteUser(WebDriver driver, String email) throws Exception {		
		driver.findElement(Locators.fieldSearch).sendKeys(email);		
		Thread.sleep(200);
		driver.findElement(By.xpath("//tr/td[text()='" + email + "']/../td[4]//button[2]")).click();
		driver.findElement(Locators.buttonDeleteUser).click();
		Thread.sleep(200);
	}
	
	public static void checkLogin (WebDriver driver, String email) {
		driver.findElement(Locators.buttonSettingUser).click();
		assertEquals(email, driver.findElement(Locators.settingEmail).getAttribute("value"));
	}
	
	public static void adminCreateCourse(WebDriver driver) throws Exception {
		explicitWaits(driver, Locators.linkCourses);
		driver.findElement(Locators.buttonCreateCourse).click();	
		driver.findElement(Locators.fieldNameCourse).sendKeys(Parameters.nameCourse);
		new Select(driver.findElement(Locators.listLectors)).selectByVisibleText(Parameters.nameLector);
		driver.findElement(Locators.fieldCourseHoursCount).sendKeys(Parameters.courseHours);
		driver.findElement(Locators.fieldCourseClassesCount).sendKeys(Parameters.courseClassesCount);
		driver.findElement(Locators.buttonSubmit).click();
		
	}
	
	public static void adminDeleteCourse(WebDriver driver) throws Exception {
		explicitWaits(driver, Locators.linkCourses);
		driver.findElement(Locators.buttonDeleteCourse).click();
		driver.findElement(Locators.confirmDelete).click();
	}
	
	public static void adminCreateGroup(WebDriver driver) throws Exception {
		adminCreateCourse(driver);
		explicitWaits(driver, Locators.linkGroups);
		driver.findElement(Locators.buttonCreateGroup).click();
		driver.findElement(Locators.fieldGroupDate).click();
		explicitWaits(driver, Locators.groupCurrentDate);
		List<WebElement> course = driver.findElements(By.xpath("//select/option"));
		if (course.size() > 1) {
			new Select(driver.findElement(Locators.listCourses)).selectByVisibleText(Parameters.nameLectorCourse);
		} else {
			driver.findElement(Locators.listCourses).click();
		}		
		driver.findElement(Locators.groupWeekDayDate).click();
		driver.findElement(Locators.buttonSubmit).click();
	}
	
	public static void adminDeleteGroup(WebDriver driver) throws Exception {
		explicitWaits(driver, Locators.linkGroups);
		driver.findElement(Locators.buttonDeleteGroup).click();
		driver.findElement(Locators.confirmDelete).click();
	}
	
	public static void adminAddListenerToGroup(WebDriver driver, String name) throws Exception {
		explicitWaits(driver, Locators.buttonEditGroup);
		driver.findElement(Locators.buttonAddListener).click();
		Thread.sleep(1000);
		new Select(driver.findElement(Locators.listListeners)).selectByVisibleText(name);		
		driver.findElement(Locators.addListenerToGroup).click();
		explicitWaits(driver, Locators.buttonSubmit);
	}
	
	public static void explicitWaits(WebDriver driver, By locator) throws Exception {
		for (int i = 1; i <= 10; i++) {
			try {
				driver.findElement(locator).click();
				break;
			}
			catch (NoSuchElementException e) {
				Thread.sleep(200);
				if (i == 10) fail("Element " + locator + " is not found");
			}
		}
	}
	
	public static void createScreenshot(WebDriver driver) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "./screenshots/" + screenshot.getName();
		FileUtils.copyFile(screenshot, new File(path));
	}
}
