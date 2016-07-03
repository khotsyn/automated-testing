package testSite;

import org.openqa.selenium.By;

public class Locators {
	
	public static By linkFile = By.cssSelector("p.name>a");
	public static By buttonUploadFile = By.xpath("//form/div/div/button[1]");
	public static By inputFile = By.xpath("//input[@type='file']");
	public static By fieldLogin = By.id("username");
	public static By fieldPass = By.id("password");
	public static By buttonLogin = By.name("submit");
	public static By buttonSubmit = By.cssSelector("button[type='submit']");
	public static By linkLogout = By.linkText("Выйти");
	public static By buttonAddUser = By.id("newUser");
	public static By fieldNewName = By.name("name");
	public static By fieldEmail = By.name("email");
	public static By buttonCreateCourse = By.id("newCourse");
	public static By fieldNameCourse = By.name("title");
	public static By fieldCourseHoursCount = By.name("lessons_duration");
	public static By fieldCourseClassesCount = By.name("lessons_qty");	
	public static By listLectors = By.id("lector");	
	public static By courseNameRow = By.xpath("//tbody/tr/td[text()='" + Parameters.nameCourse + "']");
	public static By courseClassesRow = By.xpath("//tbody/tr/td[text()='" + Parameters.courseEditClasses + "']");
	public static By buttonDeleteCourse = By.xpath("//tr/td[text()='" + Parameters.nameCourse + "']/../td[5]/div/button[2]");
	public static By confirmDelete = By.id("approvedDelete");
	public static By buttonEditCourse = By.xpath("//tr/td[text()='" + Parameters.nameCourse + "']/../td[5]/div/button[1]");
	public static By buttonEditGroup = By.xpath("//tr/td[text()='" + Parameters.nameGroup + "']/../td//button[1]");
	public static By buttonAddListener = By.id("addLearners");
	public static By addListenerToGroup = By.xpath("//button[text()='Добавить']");
	public static By closeGroup = By.xpath("//button[text()='Закрыть']");
	public static By fieldCourseEditClasses = By.id("qty");
	public static By userLector = By.cssSelector("option[value='ROLE_LECTOR']");
	public static By userListener = By.cssSelector("option[value='ROLE_LEARNER']");
	public static By userAccountant = By.cssSelector("option[value='ROLE_ACCOUNTANT']");
	public static By buttonCreateGroup = By.id("newGroup");
	public static By listCourses = By.id("course");
	public static By listListeners = By.id("allLearnersList");
	public static By fieldGroupDate = By.name("date_start");
	public static By groupCurrentDate = By.cssSelector("td.xdsoft_current>div");
	public static By groupWeekDayDate = By.cssSelector("input[value='2']");
	public static By groupNameRow = By.xpath("//tbody/tr/td[text()='" + Parameters.nameGroup + "']");
	public static By buttonDeleteGroup = By.xpath("//tr/td[text()='" + Parameters.nameGroup + "']/../td//button[2]");
	public static By groupAddedListener = By.xpath("//div[text()='" + Parameters.nameListener + "']");
	public static By fieldSearch = By.cssSelector("input[ng-model='search']");
	public static By buttonDeleteUser = By.id("approvedDelete");
	public static By linkGroups = By.linkText("Группы");
	public static By linkCourses = By.linkText("Курсы");	
	public static By buttonSettingUser = By.cssSelector("li>a>img");
	public static By settingEmail = By.id("input-email");
	public static By linkCourseOfLector = By.partialLinkText(Parameters.nameCourse);
	public static By linkListenerOfLector = By.partialLinkText(Parameters.nameListener);
	public static By profile = By.cssSelector("h1");
	public static By fieldMessage = By.name("comment");
	public static By buttonSubmitMessage = By.cssSelector("form>button[type='submit']");
	public static By linkCourseOfListener = By.linkText(Parameters.nameCourse);
	public static By groupMessage = By.xpath("//tr[7]/td");
	public static By listenerClassesCount = By.xpath("//tr[5]/td");
	public static By linkGroupmate = By.linkText(Parameters.nameListener2);
	public static By linklector = By.linkText(Parameters.nameLector);
	public static By linkCertificate = By.linkText("Сертификаты");
	
}