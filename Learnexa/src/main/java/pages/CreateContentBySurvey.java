package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateContentBySurvey extends LearnexaWrappers{
	
	public CreateContentBySurvey(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public CreateContentBySurvey clickSurvey() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateContentBySurvey.clickSurvey.Xpath"));
		return this;
	}
	
	public CreateContentBySurvey clickOnSingleQuestion() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickOnMultipleQuestion1.Xpath"));
		Thread.sleep(3000);
		return this;
	}
	
	public CreateContentBySurvey applyButton() throws InterruptedException{
		clickByXpath(prop.getProperty("CreateContentBySurvey.applyButton.Xpath"));
		Thread.sleep(2000);	
		String data2="what is Selenium?";
		enterById(prop.getProperty("CreateContentBySurvey.question.Xpath"), data2);
		/*Thread.sleep(2000);*/
		List<WebElement> answerElems = driver.findElements(By.tagName("textarea").className("answer"));
		int totalAnswerElem = answerElems.size();
		System.out.println("Total Answer:::" + totalAnswerElem);
		if (totalAnswerElem > 0) {
			for (int i = 0; i < totalAnswerElem; i++) {
				String answer = "Testing " + i;
				answerElems.get(i).sendKeys(answer);
				}
			}
		
		return this;
	}
		
		
	public CreateContentBySurvey courseTitle(String Title) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.id("questionnaire_title")).sendKeys(Title);
		Thread.sleep(2000);
		return this;
	}
	
	
	public CreateContentBySurvey saveButton(String Title2) throws InterruptedException{
		driver.findElement(By.id("submit_questionnaire")).click();
		System.out.println("Save clicked");
		Thread.sleep(5000);
			// Verify the creation of content
		if(driver.findElement(By.xpath("//*[@id='my_learning_contents_by_me']/div/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Content is Created and validated");
			}else{
			System.out.println("Content is not Created and validated");
			}
			
		System.out.println(Title2);
		return this;
	}	
	
	public CreateCourseBySurvey clickSurveybutton() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickSurveybutton.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseBySurvey(driver, test);
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(3000);
		return new HomePage(driver,test);	
	}
	public  CreateCourseBySurvey clickSearch() throws InterruptedException, AWTException {
		driver.findElement(By.id("search")).sendKeys(Titledata);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		return new CreateCourseBySurvey(driver, test);
		
	}
	public CreateCourseBySurvey clickcheckBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickcheckBox.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseBySurvey(driver, test);
	}

	public CreateCourseBySurvey clickApply() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseBySurvey(driver, test);
	}

	public CreateCourseBySurvey clickCourseTitle() throws InterruptedException {
/*		Thread.sleep(3000);*/
		String allowdchrs2 = "1234567890";
		WebElement Titlename1 = driver.findElement(By.id("course_title"));
		String Titledata1 = "TESTING" + RandomStringUtils.random(2, allowdchrs2);
		Titlename1.sendKeys(Titledata1);
	return new CreateCourseBySurvey(driver, test);

	}
	
	public CreateCourseBySurvey clickDescription() {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		driver.switchTo().parentFrame();
		return new CreateCourseBySurvey(driver, test);
	}
	
	public CreateCourseBySurvey checkPrice() {
		clickById(prop.getProperty("CreateCourseByQuiz.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByQuiz.checkPrice1.Id"), Titledata1);
		return new CreateCourseBySurvey(driver, test);
	} 
	
	public HomePage clickSave1Button(String title) throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")));
		savebutton1.click();
		//Verify the creation of content
		Thread.sleep(3000);
		if(driver.getPageSource().contains(title)){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
			}
		System.out.println(title);
		return new HomePage(driver, test);
			
			}
		
public HomePage verifycoursecreated(String title1) {
		if (driver.getPageSource().contains(title1)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is Created and validated");
		}
		System.out.println(title1);
		return new HomePage(driver, test);
	}
	

}
