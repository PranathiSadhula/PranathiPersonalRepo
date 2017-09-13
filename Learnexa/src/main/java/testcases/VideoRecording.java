package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class VideoRecording {
	
	@Test
	public static void testcases() throws InterruptedException, AWTException, FindFailed {

		// initialize the user browser
		System.setProperty("webdriver.gecko.driver", "/home/user/geckodriver");
		FirefoxProfile profile = new FirefoxProfile();
		
		// This will set the true value
		profile.setAcceptUntrustedCertificates(true);
		WebDriver driver;
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		// Navigate to the login
		driver.get("https://qa01.learnexa.com/login");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("divyas@expertus.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//*[@class='submitButton']")).click();

		// click on the catalog menu
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.id("tab_catalog"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);

		// Click on the create course sub menu

		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//*[@id='create_items_tour']/a"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element1);
		// driver.findElement(By.xpath("//*[@id='create_items_tour']/a")).click();

		// click on the course drop down
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='create_product_menu']/div/div/div/div/div/a")).click();

		// click on video and audio
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='select_content_popup']/div/div/div/div/div[2]/div[1]/div[3]/ul/li[2]"))
				.click();

		// click on create content
		Thread.sleep(3000);
		WebElement element2 = driver.findElement(By.xpath(".//*[@id='popupTitleLink']/a"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click()", element2);
		//driver.findElement(By.xpath("//*[@id='popupTitleLink']/a")).click();
																																																																																							
		//click on Recording 
		Thread.sleep(3000);
		driver.findElement(By.id("tabber_parentnav3")).click();
		
		driver.findElement(By.xpath(".//*[@id='record']/div[1]/div/a")).click();
	
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		
		Screen s=new Screen();
		//s.click("/home/user/workspace/Learnexa/src/main/java/allow2.png");
		Thread.sleep(5000);
		s.click("/home/user/workspace/Learnexa/src/main/java/click.png");
		Thread.sleep(5000);
		s.click("/home/user/workspace/Learnexa/src/main/java/allow.png");
		Thread.sleep(5000);
/*		Robot r = new Robot();																																																																																																																																																																																																																																																																																																																																																																																								
		r.delay(6000);
		r.keyPress(KeyEvent.VK_TAB);		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(6000);*/
		//s.click("/home/user/workspace/Learnexa/src/main/java/close.png");
/*		
		//r.keyRelease(KeyEvent.VK_TAB);
		r.delay(6000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
	
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(6000);																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.delay(5000);*/
		/*s.click("/home/user/workspace/Learnexa/src/main/java/allow.png");
		Thread.sleep(5000);
		s.click("/home/user/workspace/Learnexa/src/main/java/close.png");
		Thread.sleep(5000);
		s.click("/home/user/workspace/Learnexa/src/main/java/allow2.png");
		Thread.sleep(5000);
		s.click("/home/user/workspace/Learnexa/src/main/java/Record.png");
		Thread.sleep(5000);
		s.click("/home/user/workspace/Learnexa/src/main/java/Done1.png");
*/
}
}
