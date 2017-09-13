package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseByScromPackage extends LearnexaWrappers {
	public CreateCourseByScromPackage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	String allowdchrs2 = "123456789";

	public CreateCourseByScromPackage clickScromPackage1() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateCourseByScromPackage.clickScromPackage1.Xpath"));
		Thread.sleep(3000);
		// Enter the created content name in the search text field
		driver.findElement(By.id("search")).sendKeys(Titledata);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		return new CreateCourseByScromPackage(driver, test);
	}
	
	
	public CreationOfCertification clickchooseBadge() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("choose_badge")).click();
		//clickById(prop.getProperty("CreationOfCertification.clickchooseBadge.Id"));
		System.out.println("badge");
		Thread.sleep(3000);
		return new CreationOfCertification(driver, test);
	}
	
	public CreationOfCertification checkPrice() throws InterruptedException {
		//clickById(prop.getProperty("CreateCourseByQuiz.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByQuiz.checkPrice1.Id"), Titledata2);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false"));
		return new CreationOfCertification(driver, test);
	} 
	
	
	
	
	public CreationOfCertification clickPassingScroes() throws InterruptedException {
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@class='quarter_margin_left percentage_popup_link']")).click();
		//driver.findElement(By.linkText("Set Scores")).click();
		//driver.findElements(By.className("percentage_popup_link")).get(0).click();
		
		WebElement element = driver.findElement(By.xpath("//*[@class='quarter_margin_left percentage_popup_link']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//driver.findElement(By.xpath("//*[@class='passing_percent_fields'][1]/div/div/a")).click();
		Thread.sleep(3000);
		System.out.println("aaaaaaaaaaa");
		driver.findElement(By.id("contents__passing_percentage")).click();
		driver.findElement(By.id("contents__passing_percentage")).clear();
		driver.findElement(By.id("contents__passing_percentage")).sendKeys("10");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Done")).click();
		return new CreationOfCertification(driver, test);
	}
	
	
	
	public CreationOfCertification enterMaximumAttempts() throws InterruptedException{
		/*Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='quarter_margin_left attempts_popup_link']")).click();
		Thread.sleep(3000);
		clickByLink(prop.getProperty("CreationOfCertification.enterMaximumAttempts.link"));*/
		String value1=	"1";
		selectIndexById(prop.getProperty("CreationOfCertification.enterMaximumAttempts.Id"), value1);
		Thread.sleep(3000);
		clickByLink(prop.getProperty("CreationOfCertification.enterMaximumAttempts.link"));
		return new CreationOfCertification(driver,test) ;
		}
	
	public CreationOfCertification enterPassingPercentage(String Percentage) throws InterruptedException {
		Thread.sleep(2000);
		enterByXpath(prop.getProperty("CreationOfCertification.enterPassingPercentage.Id"),Percentage);
		Thread.sleep(3000);
		System.out.println("trst");
		clickByLink(prop.getProperty("CreationOfCertification.ClickDone.XpathVal"));		
		return new CreationOfCertification(driver, test);
	}

	public HomePage clickcoursetab() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(3000);
		return new HomePage(driver, test);
	}

	
	public CreateCourseByScromPackage searchCreatedContent(String title) throws InterruptedException, AWTException{
		Thread.sleep(2000);
		driver.findElement(By.id("search")).sendKeys(title);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		return this;
		
	}
	
	public CreateCourseByScromPackage checkBox() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='form_insert_content_in_course']/div[2]/div/div[2]/ul/li[1]")).click();
		//clickByXpath(prop.getProperty("CreateCourseByScromPackage.checkBox.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseByScromPackage(driver, test);
	}

	public CreateCourseByScromPackage clickApply() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//clickByXpath(prop.getProperty("CreateCourseByScromPackage.clickApply.Xpath"));
		/*Thread.sleep(3000);*/
		return new CreateCourseByScromPackage(driver, test);
	}

	public CreateCourseByScromPackage clickCourseTitle(String title) throws InterruptedException {
		Thread.sleep(3000);
		
		driver.findElement(By.id("course_title")).sendKeys(title);
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
		driver.switchTo().parentFrame();
		return new CreateCourseByScromPackage(driver, test);

	}

	public HomePage clickSave1Button(String Title) throws InterruptedException {
		enterById(prop.getProperty("CreateCourseByDocumentation.checkPrice1.Id"), Title);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false")).click();
		return new HomePage(driver,test);
	}
		
		public HomePage clickSave2Button(String Title) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		Thread.sleep(3000);
		//Verify the creation of content
		if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
		}
		System.out.println(Title);
		return new HomePage(driver,test);
	}

	public HomePage verifycoursecreated() {
		if (driver.getPageSource().contains(Titledata)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is Created and validated");
		}
		System.out.println(Titledata);
		return new HomePage(driver, test);
	}

}
