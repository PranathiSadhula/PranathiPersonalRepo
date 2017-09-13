package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class HomePage  extends LearnexaWrappers{
	

	public Object clickSave2Button;

	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
	}

	public LoginPage enterUserName1() {
		driver1.findElement(By.id("email")).sendKeys(sUserName1);
		//enterById(prop.getProperty("Login.UserName.id"), sUserName1);
		return new LoginPage(driver,test);
	}
	
	
		
	//closing the popup
	public HomePage closePopup() throws InterruptedException{
		clickByXpath(prop.getProperty("Home.ClosePopup.Xpath"));
		Thread.sleep(6000);
		return this;
		}
	
	
	public HomeScreen homeTab() throws InterruptedException {
		clickById(prop.getProperty("HomeScreen.homeTab.Id"));
		Thread.sleep(3000);
		return new HomeScreen(driver,test);
	}
	//click on content
	public HomePage clickContent() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("Home.ClickContent.Xpath"));
		Thread.sleep(3000);
		return this;
		}
	//click on create content button
	public CreateContentByDocumentation clickCreateContent() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("Home.ClickCreateContent.Xpath"));
		return new CreateContentByDocumentation(driver, test);
		}
	
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(2000);
		return this;	
	}
	
	
	public CreateCourseByDocumentation clickApply() throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByDocumentation(driver, test);
	}
	
	public CreationOfInPersonEvent clickEvents() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateEvents.clickEvents.Xpath"));
		Thread.sleep(3000);
		return new CreationOfInPersonEvent(driver,test);	
	}
	
	
	public CreateContentByVideoAudioEmbeded enterCourseTitle(String Title) throws InterruptedException {
		Thread.sleep(5000);
		enterById(prop.getProperty("CreateContentByVideoAudioEmbeded.enterCourseTitle.Id"),Title);
		return new CreateContentByVideoAudioEmbeded(driver,test);
	}
	
	
	public CreationOfLiveEvents clickCreation(){
		clickById(prop.getProperty("CreateEvents.clickCreaticn.Id"));
		return new CreationOfLiveEvents(driver,test);
	}
	
	public CreationOfInPersonEvent clickEvents1() throws InterruptedException{
		clickById(prop.getProperty("CreateEvents.clickCreaticn.Id"));
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateEvents.clickEvents.Xpath"));
		return new CreationOfInPersonEvent(driver,test) ;	
	}
	
	public CreateCourseByDocumentation clickCourseDocumentation() throws InterruptedException {
		Thread.sleep(4000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickDocuementation.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByDocumentation(driver, test);
	}
	
	public CreateCourseByDocumentation clickCreateCourse() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("Home.ClickCreateCourse.Xpath"));
		return new CreateCourseByDocumentation(driver, test);	
	}
	
	
	public CreateCourseByPresentation clickCreateCourse1() throws InterruptedException{
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("Home.ClickCreateCourse.Xpath"));
		return new CreateCourseByPresentation(driver, test);	
	}

	public HomePage verifycontentcreated(String title) throws InterruptedException {
		Thread.sleep(3000);

		if(driver.findElement(By.xpath("//*[@id='my_learning_contents_by_me']/div/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Content is Created and validated");
			}else{
			System.out.println("Content is not Created and validated");
			}
		/*if (driver.getPageSource().contains(title)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is not Created and validated");
		}*/
		System.out.println(title);
		return new HomePage(driver, test);
	}
	
	public HomePage verifycoursecreated1(String title) throws InterruptedException {
		Thread.sleep(3000);
		

		if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
		}
		return this;
		
	}
	public HomePage verifycoursecreated(String title) throws InterruptedException {
		Thread.sleep(3000);
		

		if(driver.findElement(By.xpath("//*[@class='my_learnings_bundle columns']/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Bundle is Created and validated");
			}else{
			System.out.println("Bundle is not Created and validated");
		}
		/*if (driver.getPageSource().contains(title)) {
			System.out.println("Course is Created and validated");
		} else {
			System.out.println("Course is not Created and validated");
		}*/
		System.out.println(title);
		
		return new HomePage(driver, test);
	}
	
	public CreationOfBundle clickBundle() throws InterruptedException {
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreationOfBundle.clickBundle.Xpath"));
		return new CreationOfBundle(driver,test) ;
	}
	
	public HomePage verifyCatalogPage(String title) throws InterruptedException, AWTException{
		//Click on Catalog Menu
		Thread.sleep(4000);
		driver.findElement(By.id("tab_catalog")).click();
		
		//Click on Search Button
		driver.findElement(By.id("search_input")).sendKeys(title);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		
		//Click to Add to Learning
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='loud color_white line_2']")).click();
		
		//Click on My Learning
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lightbox_panel_content']/div[2]/div[2]/div[2]/div[1]/div/ul/li[3]/a")).click();
		
		return this;
	}
	
	public CreateContentByQuiz clickContentQuiz(){
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickContentQuiz.Xpath"));
		return new CreateContentByQuiz(driver,test);
	}
	
	public CreateCourseFromCatalog clickCatalog() throws InterruptedException {
		//Thread.sleep(6000);
		   /*WebDriverWait wait = new WebDriverWait(driver,30);
		    WebElement element = wait.until(ExpectedConditions
		    					.visibilityOfElementLocated(By.id("CreateCourseFromCatalog.clickCatalog.Id")));*/ WebDriverWait wait = new WebDriverWait(driver,30);
		  
//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("CreateCourseFromCatalog.clickCatalog.Id")));
	clickById(prop.getProperty("CreateCourseFromCatalog.clickCatalog.Id"));
		//Thread.sleep(6000);
		return new CreateCourseFromCatalog(driver, test);
	}

	
	public Payments clickCatalogMenu() throws InterruptedException {
		Thread.sleep(3000);
		clickById(prop.getProperty("Payments.clickCatalogMenu.Id"));
		Thread.sleep(6000);
		return new Payments(driver,test);
	}
	
	public HomePage clickEdit() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div[3]/div/ul/li[3]/a[1]").click();
		return new HomePage(driver, test);
	}
	
	
	public CreateOfLiveEventFromCatalog clickCatalog1() throws InterruptedException {
		clickById(prop.getProperty("CreateCourseFromCatalog.clickCatalog.Id"));
		Thread.sleep(6000);
		return new CreateOfLiveEventFromCatalog(driver, test);
	}
	
	
public CreateCourseByPresentation clickCourseTitle1(String Title) {
		
		enterById(prop.getProperty("CreateCourseByPresentation.ClickCourseTitle.Id"), Title);
		return new CreateCourseByPresentation(driver, test);

	}

public CreationOfCertification clickCertification() throws InterruptedException{
	Thread.sleep(5000);
	clickByXpath(prop.getProperty("CreationOfCertification.clickCertification.Xpath"));
	return new CreationOfCertification(driver,test);
	
}
	
	public CreateCourseByPresentation clickUpdateSave(){
		clickByXpath("CreateCourseByPresentation.clickUpdateSave.Xpath");
		return new CreateCourseByPresentation(driver, test);
		
	}
	
	public HomePage clickSave2Button(String Title) throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("HomePage.clickSave1Button.Xpath"));
		//driver.findElement(By.xpath("//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		Thread.sleep(3000);
		//Verify the creation of content

//		/*if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
//			System.out.println("Course is Created and validated");
//			}else{
//			System.out.println("Course is not Created and validated");*/
//		}
		System.out.println(Title);
		return new HomePage(driver,test);
	
	}
}
