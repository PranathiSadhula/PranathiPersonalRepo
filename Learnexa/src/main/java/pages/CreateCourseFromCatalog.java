package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseFromCatalog extends LearnexaWrappers{
	
	public CreateCourseFromCatalog(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}

	public CreateCourseFromCatalog clickCatalog() throws InterruptedException {
		clickById(prop.getProperty("CreateCourseFromCatalog.clickCatalog.Id"));
		Thread.sleep(6000);
		return new CreateCourseFromCatalog(driver, test);
	}

	public CreateCourseFromCatalog clickCreate() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseFromCatalog.clickCreate.Xpath"));
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseFromCatalog.ClickCourses.Xpath"));
		return this;		
	}
	
	public CreateCourseByDocumentation clickCourseTitle1(String Title) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("course_title"));;
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		element.sendKeys(Title);
		return new CreateCourseByDocumentation(driver, test);

	}

	public CreateCourseFromCatalog clickCreateWebPage(String Title) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='select_content_popup']/div/div/div/div/div[2]/div[1]/div[4]/ul/li[2]")).click();
		Thread.sleep(3000);
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath(".//*[@id='content_id_']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()", element1);
	/*	WebElement element = driver.findElement(By.xpath("//*[@id='popupTitleLink']/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='popupTitleLink']/a")).click();
		//clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		driver.switchTo().frame("web_text_text_ifr");
		//driver.switchTo().frame(2);
		driver.findElement(By.id("tinymce"))
				.sendKeys("Birds are special " + "kind of animal species with certain "
						+ "specific characteristics that are common to all of them."
						+ " All of them are feathered, winged, bipedal"
						+ " (meaning: having two legs), egg-laying, warm blooded, vertebrate animals "
						+ "belonging to the class Aves. They are an important part of "
						+ "the ecosystem and are present across the globe from the" + " Arctic to the Antarctic.");
		//Thread.sleep(7000);
*/		/*driver.switchTo().defaultContent();*/
		/*driver.findElement(By.id("web_text_title")).sendKeys(Title);
		Thread.sleep(2000);
		driver.findElement(By.id("submit_new_web_text")).click();*/
		Thread.sleep(2000);
		return this;		
	}
	
	
	public CatalogSorting clickTitle() {
		clickByXpath(prop.getProperty("CatalogSorting.clickTitle.Xpath"));
		return new CatalogSorting(driver,test);
	}
	public HomePage clickSaveButton1() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.linkText("Save"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//driver.findElement(By.id("submit_new_web_text")).click();
			//clickById(prop.getProperty("HomePage.clickSaveButton.Id"));
/*		Thread.sleep(5000);*/
		return new HomePage(driver, test);
	}
	
	
	
	
	public CreateCourseFromCatalog selectPresentation() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='select_content_popup']/div/div/div/div/div[2]/div[1]/div[1]/ul/li[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='popupTitleLink']/a")).click();
		return this;		
	}
	public CreateCourseByDocumentation enterText(String Title) throws InterruptedException, AWTException {
		Thread.sleep(3000);
		enterById(prop.getProperty("Payments.enterText.Id"), Title);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		return new CreateCourseByDocumentation(driver,test) ;
	}
	
	
	public CreateCourseByDocumentation createContent(String Title) throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		Thread.sleep(3000);
		driver.findElement(By.id("web_text_title")).sendKeys(Title);
		return new CreateCourseByDocumentation(driver, test);
	}
	
	public CreateCourseFromCatalog uploadoption() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='upload_button_container']/div/div[2]")).click();
		//clickByXpath(prop.getProperty("CreateContentByDocumentation.Upload.Xpath"));
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);*/
	/*	r.delay(2000);*/
	/*	r.keyPress(KeyEvent.VK_UP);*/
		r.delay(4000);
		sikuliObject.type(sTESTDATA3+ Key.ENTER);
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return this;
	
	}
	
	
	public CreateContentByDocumentation enterTitle(String title1) throws InterruptedException {
		/*Thread.sleep(3000);*/
		driver.findElement(By.id("document_title")).sendKeys(title1);
		Thread.sleep(3000);
		//driver.findElement(By.id("submit_document"));
		//enterById(prop.getProperty("CreateContentByDocumentation.enterTitle.Id"),title1);
		return new CreateContentByDocumentation(driver,test);
	}
	
	public CreateCourseFromCatalog clickCreateBundle() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseFromCatalog.clickCreate.Xpath"));
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseFromCatalog.ClickBundle.Xpath"));
		return this;		
	}
	
	public CreateCourseFromCatalog clickCreateCeritification() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseFromCatalog.clickCreate.Xpath"));
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseFromCatalog.clickCreateCeritification.Xpath"));
		return this;		
	}
	
	public CreationOfCertification AddButton() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreationOfCertification.AddButton.Link"));
		return new CreationOfCertification(driver,test);
		
	}
	
	
	
	public CreationOfBundle clickAddButton() throws InterruptedException {
		clickByXpath(prop.getProperty("CreationOfBundle.clickAddButton.Xpath"));
		return new CreationOfBundle(driver,test);
	}
		
	public CreateCourseByDocumentation clickCourseDocumentation() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickDocuementation.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByDocumentation(driver, test);
	}
	
	
	
}
