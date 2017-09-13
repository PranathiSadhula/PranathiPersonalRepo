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

public class CreateContentByQuiz extends LearnexaWrappers {
	
	public CreateContentByQuiz(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public CreateContentByQuiz clickContentQuiz(){
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickContentQuiz.Xpath"));
		return this;
	}
	
	public CreationOfCertification clickCertification() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreationOfCertification.clickCertification.Xpath"));
		return new CreationOfCertification(driver,test);
		
	}
	
	public CreateContentByQuiz clickOnMultipleQuestion() throws InterruptedException{
		Thread.sleep(4000);
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickOnMultipleQuestion1.Xpath"));
		Thread.sleep(5000);
		//clickByLink(prop.getProperty("CreateContentByQuiz.clickOnMultipleQuestion1.Xpath"));
		Thread.sleep(2000);
		return this;
	}
	
	public CreateContentByQuiz typeQuestion(){
		String data1 = "What Is java?";
		enterById(prop.getProperty("CreateContentByQuiz.typeQuestion.Id"),data1);
		return this;
	}
	
	
	public CreateContentByQuiz typeAnswers(){
		List<WebElement> answerElems = driver.findElements(By.tagName("textarea").className("answer"));
		int totalAnswerElem = answerElems.size();
		System.out.println("Total Answer:::" + totalAnswerElem);
		if (totalAnswerElem > 0) {
			for (int i = 0; i < totalAnswerElem; i++) {
				String answer = "Answer - " + i;
				answerElems.get(i).sendKeys(answer);
				}
			}
		return this;
	}
	
	public CreateContentByQuiz courseTitle(String title) throws InterruptedException{
		WebElement Titlename = driver.findElement(By.id("questionnaire_title"));
		Titlename.sendKeys(title);
	/*	Thread.sleep(5000);*/
		return this;
	}
	
	
	public CreateContentByQuiz saveButton(String Title) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.id("submit_questionnaire")).click();
		Thread.sleep(5000);
			// Verify the creation of content
		if(driver.findElement(By.xpath("//*[@id='my_learning_contents_by_me']/div/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Content is Created and validated");
			}else{
			System.out.println("Content is not Created and validated");
			}
			System.out.println(Title);
				return this;
	}	
	
	
	public CreateCourseByQuiz clickQuiz() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickQuiz.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseByQuiz(driver, test);
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(2000);
		return new HomePage(driver,test);	
	}
	public  CreateCourseByQuiz clickSearch(String title) throws InterruptedException, AWTException {
		enterById(prop.getProperty("CreateContentByQuiz.clickSearch.Id"), title);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		/*Thread.sleep(3000);*/
		return new CreateCourseByQuiz(driver, test);
		
	}
	public CreateCourseByQuiz clickcheckBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByQuiz.clickcheckBox.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseByQuiz(driver, test);
	}

	public CreateCourseByQuiz clickApply() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByQuiz.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByQuiz(driver, test);
	}

	public CreateCourseByQuiz clickCourseTitle(String title1) throws InterruptedException {
		enterById(prop.getProperty("CreateCourseByQuiz.ClickCourseTitle.Id"), title1);
		Thread.sleep(3000);
	return new CreateCourseByQuiz(driver, test);

	}
	
	public CreateCourseByQuiz clickDescription() {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		driver.switchTo().parentFrame();
		return new CreateCourseByQuiz(driver, test);
	}
	
	public CreateCourseByQuiz checkPrice() {
		clickById(prop.getProperty("CreateCourseByQuiz.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByQuiz.checkPrice1.Id"), Titledata1);
		return new CreateCourseByQuiz(driver, test);
	} 
	
	public HomePage clickSave1Button() {
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")));
		savebutton1.click();
		return new HomePage(driver, test);
	}

	public HomePage verifycoursecreated(String Title1) {
		if(driver.findElement(By.xpath(".//*[@id='created_course_1797']/div[2]/div[1]/div/a"))!= null){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
			}
		System.out.println(Title1);
		return new HomePage(driver, test);
	}
	public CreationOfBundle clickBundle() throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreationOfBundle.clickBundle.Xpath"));
		return new CreationOfBundle(driver,test);
	}
	
	public CreateCourseFromCatalog clickCatalog() throws InterruptedException {
		Thread.sleep(5000);
		clickById(prop.getProperty("CreateCourseFromCatalog.clickCatalog.Id"));
		Thread.sleep(3000);
		return new CreateCourseFromCatalog(driver, test);
	}
	
	
	public CreationOfCertification clickPassingScroes() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElements(By.className("quarter_margin_left percentage_popup_link")).get(0).click();
		Thread.sleep(3000);
		System.out.println("aaaaaaaaaaa");
		driver.findElement(By.id("contents__passing_percentage")).click();
		driver.findElement(By.id("contents__passing_percentage")).clear();
		driver.findElement(By.id("contents__passing_percentage")).sendKeys("10");
		Thread.sleep(3000);
		return new CreationOfCertification(driver, test);
	}
	
	public CreationOfCertification enterPassingPercentage(String Percentage) throws InterruptedException {
		enterById(prop.getProperty("CreationOfCertification.enterPassingPercentage.Id"),Percentage);
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreationOfCertification.ClickDone.XpathVal"));		
		return new CreationOfCertification(driver, test);
	}
	
	
	

}
