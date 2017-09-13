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

public class CreationOfCertification extends LearnexaWrappers{
	
	public CreationOfCertification (RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public CreationOfCertification clickCertification() throws InterruptedException{
		Thread.sleep(4000);
		clickByXpath(prop.getProperty("CreationOfCertification.clickCertification.Xpath"));
		return new CreationOfCertification(driver,test);
		
	}
	
	public CreationOfCertification clickCertButton() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreationOfCertification.clickCertButton.Xpath"));
		return new CreationOfCertification(driver,test);
		
	}
	
	public CreationOfCertification AddButton() throws InterruptedException{
		Thread.sleep(4000);
		clickByXpath(prop.getProperty("CreationOfCertification.AddButton.Link"));
		return new CreationOfCertification(driver,test);
		
	}
	
	
	
	public CreationOfCertification searchCreatedContent(String title) throws InterruptedException, AWTException{
		Thread.sleep(2000);
		driver.findElement(By.id("search")).sendKeys(title);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		return this;
		
	}
	
	public CreationOfCertification checkBox() throws InterruptedException {
		Thread.sleep(4000);
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='content_id_']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//driver.findElement(By.xpath("CreateCourseByScromPackage.checkBox.Xpath")).click();
		//clickByXpath(prop.getProperty("CreateCourseByScromPackage.checkBox.Xpath"));
		return new CreationOfCertification(driver, test);
	}

	public CreationOfCertification clickApply() throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//clickByXpath(prop.getProperty("CreationOfCertification.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreationOfCertification(driver, test);
	}

	public CreateCourseByScromPackage clickCourseTitle(String title) throws InterruptedException {
		Thread.sleep(3000);

		WebElement Titlename1 = driver.findElement(By.id("certification_title"));
		Titlename1.sendKeys(title);
		System.out.println();
						
		driver.switchTo().frame("certification_description_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		System.out.println("testing");
		driver.switchTo().parentFrame();
		System.out.println("testing2");
	return new CreateCourseByScromPackage(driver, test);

	}
	
	public CreationOfCertification clickchooseBadge() throws InterruptedException {
		Thread.sleep(4000);
		clickById(prop.getProperty("CreationOfCertification.clickchooseBadge.Id"));
		System.out.println("testing3");
		Thread.sleep(3000);
		return new CreationOfCertification(driver, test);
	}
	
	public CreationOfCertification clickFirstImage() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreationOfCertification.ClickFirstImage.Xpath"));
		Thread.sleep(3000);
		driver.findElement(By.linkText("Done")).click();
		clickByXpath(prop.getProperty("CreationOfCertification.ClickDone.XpathVal"));		
		return new CreationOfCertification(driver, test);
	}
	
	public CreateCourseByQuiz checkPrice() throws InterruptedException {
		//clickById(prop.getProperty("CreateCourseByQuiz.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByQuiz.checkPrice1.Id"), Titledata2);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false"));
		return new CreateCourseByQuiz(driver, test);
	} 
	
	public CreationOfCertification clickPassingScroes() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElements(By.className("percentage_popup_link")).get(0).click();
		Thread.sleep(3000);
		driver.findElement(By.id("contents__passing_percentage")).click();
		driver.findElement(By.id("contents__passing_percentage")).clear();
		driver.findElement(By.id("contents__passing_percentage")).sendKeys("10");
		return new CreationOfCertification(driver, test);
	}
	
	public CreationOfCertification enterPassingPercentage(String Percentage) throws InterruptedException {
		Thread.sleep(4000);
		enterByXpath(prop.getProperty("CreationOfCertification.enterPassingPercentage.Id"),Percentage);
		Thread.sleep(3000);
		System.out.println("trst");
		clickByLink(prop.getProperty("CreationOfCertification.ClickDone.XpathVal"));		
		return new CreationOfCertification(driver, test);
	}
	
	
	public CreationOfCertification enterMaximumAttempts() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='quarter_margin_left attempts_popup_link']")).click();
		Thread.sleep(3000);
		clickByLink(prop.getProperty("CreationOfCertification.enterMaximumAttempts.link"));
		/*String value1=	"1";
		selectIndexById(prop.getProperty("CreationOfCertification.enterMaximumAttempts.Id"), value1);
		Thread.sleep(3000);
		clickByLink(prop.getProperty("CreationOfCertification.enterMaximumAttempts.link"));*/
		return this;
		}
	
	public HomePage clickSave2Button() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[2]/ul/li[2]/a")).click();
		Thread.sleep(4000);
		return new HomePage(driver,test);
	}
				
	public HomePage clickSave1Button(String Title) {
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("button orange save_button")));
		savebutton1.click();
		//Verify the creation of content

		if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
		}
		System.out.println(Title);
		return new HomePage(driver,test);
	}
	
		
}
