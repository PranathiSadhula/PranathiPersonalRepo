package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseByDocumentation extends LearnexaWrappers{
	
	//public String allowdchrs1 = "1234567890";
	//public String Titledata = "TESTING" + RandomStringUtils.random(2, allowdchrs1);
	
	public CreateCourseByDocumentation(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}
	
	
	public CreateContentByVideoAudioEmbeded enterCourseTitle(String Title) throws InterruptedException {
		Thread.sleep(5000);
		enterById(prop.getProperty("CreateContentByVideoAudioEmbeded.enterCourseTitle.Id"),Title);
		return new CreateContentByVideoAudioEmbeded(driver,test);
	}
	
	
	
	public CreateCourseByDocumentation clickCreateCourse() throws InterruptedException{
		clickByXpath(prop.getProperty("Home.ClickCreateCourse.Xpath"));
		Thread.sleep(4000);
		return new CreateCourseByDocumentation(driver, test);	
	}
	
	public CreateCourseByDocumentation clickCourseDocumentation() throws InterruptedException {
		/*Thread.sleep(3000);*/
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickDocuementation.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByDocumentation(driver, test);
	}
	

	public CreateCourseByDocumentation createContent() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		return new CreateCourseByDocumentation(driver, test);
	}
	
	public CreateContentByDocumentation enterTitle(String title1) throws InterruptedException {
		/*Thread.sleep(3000);*/
		driver.findElement(By.id("document_title")).sendKeys(title1);
		Thread.sleep(3000);
		//driver.findElement(By.id("submit_document"));
		//enterById(prop.getProperty("CreateContentByDocumentation.enterTitle.Id"),title1);
		return new CreateContentByDocumentation(driver,test);
	}
	
	public CreateContentByDocumentation clickUpload() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByDocumentation.Upload.Xpath"));
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);*/
	/*	r.delay(2000);*/
	/*	r.keyPress(KeyEvent.VK_UP);*/
		r.delay(4000);
		sikuliObject.type(sTESTDATA1+ Key.ENTER);
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return new CreateContentByDocumentation(driver, test);
		
	}
	
	

	public CreateCourseByAudioVideo clickUploadAVideo() throws InterruptedException {
		Thread.sleep(3000);
		clickById(prop.getProperty("CreateContentByVideoAudioEmbeded.clickUploadAVideo.Id"));
		return new CreateCourseByAudioVideo(driver,test);
	}
	
	public CreateContentByPresentation clickContentPresentation() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElementByXPath(".//*[@id='select_content_popup']/div/div/div/div/div[2]/div[1]/div[1]/ul/li[2]").click();
		//clickByXpath(prop.getProperty("CreateContentBy.clickContentPresentation.Xpath"));
		return new CreateContentByPresentation(driver,test);
	}
	
	public CreateCourseByDocumentation searchCreatedContent(String title) throws InterruptedException, AWTException {
		enterById(prop.getProperty("CreateCourseByDocumentation.SearchCreatedContent.id"), title);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		return new CreateCourseByDocumentation(driver, test);
	}

	
	
	public CreateCourseByDocumentation clickcheckBox() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.ClickcheckBox.Xpath"));
		Thread.sleep(5000);
		return new CreateCourseByDocumentation(driver, test);
	}

	public CreateCourseByDocumentation clickApply() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByDocumentation(driver, test);
	}

	public CreateCourseByDocumentation clickCourseTitle(String Title) throws InterruptedException {
		Thread.sleep(3000);
		enterById(prop.getProperty("CreateCourseByDocumentation.ClickCourseTitle.Id"), Title);
		return new CreateCourseByDocumentation(driver, test);

	}
	
	public CreateCourseByDocumentation clickCourseTitle1(String Title) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("course_title"));;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		element.sendKeys(Title);
		return new CreateCourseByDocumentation(driver, test);

	}
	
	public CreateCourseByDocumentation clickDescription() throws InterruptedException, AWTException {
		
		String parentHandle = driver.getWindowHandle();
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
		//switchToParentWindow();
		/*Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyRelease(KeyEvent.VK_TAB);*/
		//r1.delay(2000);
		System.out.println(driver.getTitle());
		//System.out.println(driver.switchTo().parentFrame().getTitle());
		//driver.switchTo().parentFrame();
		driver.switchTo().window(parentHandle);
		return new CreateCourseByDocumentation(driver, test);
		
	}
	
	public CreateCourseByDocumentation enterText(String Title) throws InterruptedException, AWTException {
		Thread.sleep(3000);
		enterById(prop.getProperty("Payments.enterText.Id"), Title);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		return this;
	}
	
	public CreateCourseByDocumentation clickpopup()throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickpopup.Xpath"));
	//driver.findElement(By.xpath("//*[@id='catalog_items_container']/div/div/div/div/div[2]/div/div[2]/div/li/a/span/div[2]")).click();
	Thread.sleep(2000);
	clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickpopup1.Xpath"));
	//driver.findElement(By.xpath("//*[@id='lightbox_panel_content']/div[2]/div[2]/div[2]/div[1]/div/ul/li[3]/a")).click();
	Thread.sleep(3000);
	clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickpopup2.Xpath"));
	//driver.findElement(By.xpath("//*[@id='upcoming_courses']/div/div/div/div/div/div/div/div/ul/li[2]/div/div/div/a")).click();
	Thread.sleep(10000);
	clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickpopup3.Xpath"));
	Thread.sleep(4000);
	//driver.findElement(By.xpath(".//*[@id='lightbox']/div/div/div[2]/div/div[2]/div[4]/div/div/ul/li/a[1]")).click();
	return this;
	}
	
	
	public CreateCourseByDocumentation clickpopup2(String title) throws InterruptedException{
		Thread.sleep(4000);
		String data1 = driver.findElement(By.xpath(".//*[@id='my_learnings_completed_items']/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a")).getText();
		if (data1.equals(title)){
			System.out.println("Course is completed");
		}
		return this;	
	}
	
	
	public CreateCourseByDocumentation clicksav()throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.clicksav.Xpath"));
		//driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		Thread.sleep(5000);
		return this;
	}
	
	public CreateContentByVideoAudioEmbeded enterEmbedUrl() throws InterruptedException {
		Thread.sleep(3000);
		enterById(prop.getProperty("CreateContentByVideoAudioEmbeded.enterEmbedUrl.Xpath"), sTESTDATAVIDEOEMBEDED);
		return new CreateContentByVideoAudioEmbeded(driver,test) ;
	}
	
	public CreateContentByVideoAudioEmbeded clickContentVideoAudio() throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateContentByVideoAudioEmbeded.clickContentVideoAudio.Xpath"));
		return new CreateContentByVideoAudioEmbeded(driver,test);
	}
	
	public CreateCourseByDocumentation checkPrice(String title) throws InterruptedException {
		//clickById(prop.getProperty("CreateCourseByDocumentation.checkPrice.Id"));
		//driver.findElementByXPath(".//*[@id='price_schedule__free_false']").click();
		//driver.findElement(By.id("price_schedule__free_false")).click();
		enterById(prop.getProperty("CreateCourseByDocumentation.checkPrice1.Id"), title);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false")).click();
		return new CreateCourseByDocumentation(driver, test);
	} 
	
	public HomePage clickSave1Button() throws InterruptedException {
		
				clickByXpath(prop.getProperty("HomePage.clickSave1Button.Xpath"));
				Thread.sleep(3000);
				return new HomePage(driver, test);
	}
	
	
	
	public CreateContentByWebPage clickWebPage() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='select_content_popup']/div/div/div/div/div[2]/div[1]/div[4]/ul/li[2]")).click();
		//clickByXpath(prop.getProperty("CreateContentByWebPage.clickWebPage.Xpath"));
		Thread.sleep(3000);
		return new CreateContentByWebPage(driver,test);
	}
	
	
	public CreateCourseByTinCan clickTinCan() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByTinCan.clickTinPackage1.Xpath"));
		Thread.sleep(3000);
		/*//Enter the created content name in the search text field
		driver.findElement(By.id("search")).sendKeys(Titledata);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);*/
		return new CreateCourseByTinCan(driver, test);
	}
	
	

	public CreateContentByWebPage switchframe() throws InterruptedException {

		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);*/
		driver.switchTo().frame("web_text_text_ifr");
		// click on webpage editing
		driver.findElement(By.id("tinymce"))
				.sendKeys("Birds are special " + "kind of animal species with certain "
						+ "specific characteristics that are common to all of them."
						+ " All of them are feathered, winged, bipedal"
						+ " (meaning: having two legs), egg-laying, warm blooded, vertebrate animals "
						+ "belonging to the class Aves. They are an important part of "
						+ "the ecosystem and are present across the globe from the" + " Arctic to the Antarctic.");
		//Thread.sleep(7000);
		driver.switchTo().defaultContent();
		return new CreateContentByWebPage(driver,test);
	}
	
	public CreateCourseByQuiz clickQuiz() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickQuiz.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByQuiz(driver, test);
	}
		
	public CreateCourseByPresentation clickCoursePresentaion() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByPresentation.clickPresentaion.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByPresentation(driver, test);
	}
	
	
	public CreateCourseByWebPage clickWebPageButton(){
		clickByXpath(prop.getProperty("CreateCourseByWebPage.clickWebPageButton.Xpath"));
		return new CreateCourseByWebPage(driver,test);
			}
	
	public CreateCourseByScromPackage clickScromPackage1() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickSurveybutton1.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByScromPackage(driver, test);
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(8000);
		return new HomePage(driver,test);	
	}
	
/*	public CreateCourseBySurvey clickSurveybutton() throws InterruptedException {
		Thread.sleep(6000);
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickSurveybutton.Xpath"));
		Thread.sleep(6000);
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		switchToParentWindow();
		return new CreateCourseBySurvey(driver, test);
	}*/

	public CreateCourseBySurvey clickSurveybutton() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickSurveybutton.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseBySurvey(driver, test);
	}
	
	
	
	
	public HomePage clickSaveButton1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("submit_document")).click();
			//clickById(prop.getProperty("HomePage.clickSaveButton.Id"));
/*		Thread.sleep(5000);*/
		return new HomePage(driver, test);
	}

	public HomePage verifycoursecreated(String Title) {
		if (driver.getPageSource().contains(Title)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is not Created and validated");
		}
		System.out.println(Title);
		return new HomePage(driver, test);
	}
	}
