package testSite;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Accountant {
protected static WebDriver driverAc;
	
	@BeforeClass
	public void beforeClassAccountant() throws Exception {		
		driverAc = BaseSuite.driverBase;
		driverAc.get(Parameters.baseUrl + "/");
	}
	
	@AfterMethod
	public void afterMethodAccountant() throws Exception {		
		driverAc.findElement(Locators.linkLogout).click();
	}
	
	@Test
	public void reviewLectorList() throws Exception {
		Functions.loginUser(driverAc, Parameters.emailAccountant, Parameters.password);
		List<WebElement> lectors = driverAc.findElements(By.xpath("//tr/td[1]/a"));
		String s = "string";
		for (WebElement web : lectors) {
			if (web.getText().equals(Parameters.nameLector)) {
				s = web.getText();
				break;
			}				
		}
		if (s.equals("string")) {
			fail("Lector '" + Parameters.nameLector + "' is no in list");
		}
	}
	
	@Test (enabled = false)
	public void reviewListCertificate() throws Exception {
		Functions.loginUser(driverAc, Parameters.emailEnter , Parameters.passwordAdmin);
		Functions.adminCreateGroup(driverAc);
		driverAc.findElement(Locators.linkLogout).click();
		Functions.loginUser(driverAc, Parameters.emailAccountant, Parameters.password); 
	}
	
}
