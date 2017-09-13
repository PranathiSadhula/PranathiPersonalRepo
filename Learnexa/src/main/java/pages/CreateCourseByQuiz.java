package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseByQuiz extends LearnexaWrappers {
	
	public CreateCourseByQuiz(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}

	public CreateCourseByQuiz clickQuiz() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickQuiz.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByQuiz(driver, test);
	}
	
/*	public  CreateCourseByQuiz clickSearch(String title1) throws InterruptedException, AWTException {
		enterById(prop.getProperty("CreateCourseByPresentation.searchCreatedContent.id"), title1);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		return new CreateCourseByQuiz(driver, test);
		}
	*/
	
	
	
	public CreateCourseByQuiz clickcheckBox() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='content_id_' and @name='content_id[]']")).click();
		//clickByXpath(prop.getProperty("CreateCourseByQuiz.clickcheckBox.Xpath"));
	/*	Thread.sleep(6000);*/
		return new CreateCourseByQuiz(driver, test);
	}

	public CreateCourseByQuiz clickApply() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//clickByXpath(prop.getProperty("CreateCourseByQuiz.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByQuiz(driver, test);
	}

	public CreateCourseByQuiz clickCourseTitle(String title2) throws InterruptedException {
		enterById(prop.getProperty("CreateCourseByQuiz.ClickCourseTitle.Id"), title2);
		/*Thread.sleep(3000);*/
	return new CreateCourseByQuiz(driver, test);

	}
	
	public CreateCourseByQuiz clickDescription() throws InterruptedException {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		return new CreateCourseByQuiz(driver, test);
	}
	
	public CreateCourseByQuiz checkPrice() throws InterruptedException {
		//clickById(prop.getProperty("CreateCourseByQuiz.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByQuiz.checkPrice1.Id"), Titledata2);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false"));
		return new CreateCourseByQuiz(driver, test);
	} 
	
	public HomePage clickSave1Button() throws InterruptedException {
		clickByXpath(prop.getProperty("HomePage.clickSave1Button.Xpath"));
	/*	Thread.sleep(5000);*/
		if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
		}
		return new HomePage(driver, test);
	}

	public CreateCourseByQuiz clickPassingScroes() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='passing_percent_fields'][1]/div/div/a")).click();
		Thread.sleep(3000);
		System.out.println("aaaaaaaaaaa");
		driver.findElement(By.id("contents__passing_percentage")).click();
		driver.findElement(By.id("contents__passing_percentage")).clear();
		driver.findElement(By.id("contents__passing_percentage")).sendKeys("10");
		Thread.sleep(3000);
		return new CreateCourseByQuiz(driver, test);
	}
	
	public CreateCourseByQuiz enterPassingPercentage(String Percentage) throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='quarter_margin_left attempts_popup_link'][1]")).click();
		Thread.sleep(4000);
		enterByXpath(prop.getProperty("CreationOfCertification.enterPassingPercentage.Id"),Percentage);
		Thread.sleep(2000);
		System.out.println("trst");
		clickByLink(prop.getProperty("CreationOfCertification.ClickDone.XpathVal"));		
		return new CreateCourseByQuiz(driver, test);
	}
	
	public CreateCourseByQuiz enterMaximumAttempts() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='quarter_margin_left attempts_popup_link']")).click();
		Thread.sleep(3000);
		clickByLink(prop.getProperty("CreationOfCertification.enterMaximumAttempts.link"));
		/*driver.findElement(By.id("contents__passing_percentage")).click();
		driver.findElement(By.id("contents__passing_percentage")).clear();
		driver.findElement(By.id("contents__passing_percentage")).sendKeys("10");*/
		/*Thread.sleep(3000);
		clickByLink(prop.getProperty("CreationOfCertification.enterMaximumAttempts.link"));*/
		System.out.println("Sucess");
	/*	String value1=	"1";
		clickByXpath(prop.getProperty("CreationOfCertification.ClickSetAttempts.Xpath"));
		Thread.sleep(3000);
		selectIndexByXpath(xpath, value);
		selectIndexById(prop.getProperty("CreationOfCertification.enterMaximumAttempts.Id"), value1);
		clickByLink(prop.getProperty("CreationOfCertification.enterMaximumAttempts.link"));*/
		return this;
		}
	
	public HomePage verifycoursecreated(String title) throws InterruptedException {
		Thread.sleep(3000);
		if (driver.getPageSource().contains(title)) {
			System.out.println("Course is Created and validated");
		} else {
			System.out.println("Course is not Created and validated");
		}
		System.out.println(title);
		return new HomePage(driver, test);
	}
	
}
