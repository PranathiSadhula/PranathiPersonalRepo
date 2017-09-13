package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class VideoStreaming {

	@Test
	public static void testcases() throws InterruptedException, AWTException {

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
		WebElement element7 = driver.findElement(By.xpath("//*[@id='popupTitleLink']/a"));
		JavascriptExecutor executor7 = (JavascriptExecutor)driver;
		executor7.executeScript("arguments[0].click()", element7);
		//driver.findElement(By.xpath("//*[@id='popupTitleLink']/a")).click();

		// Enter the link in the on embed URL
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='embed_url']")).sendKeys("https://www.youtube.com/watch?v=gh3oGJrQw8Y");

		// click on embed button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@value='Embed']")).click();

		// click on title for creation of video
		Thread.sleep(3000);
		driver.findElement(By.id("document_title")).sendKeys("Bunny Videos Content");

		// click on save button
		driver.findElement(By.id("submit_document")).click();
		Thread.sleep(3000);

		// click on apply button
		Thread.sleep(5000);
		WebElement element3 = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click()", element3);
		//driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a")).click();
		Thread.sleep(3000);

		// click on course video title and description
		driver.findElement(By.id("course_title")).sendKeys("Bunny Videos Courses");
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Videos Description");
		driver.switchTo().parentFrame();

		// click on save button
		driver.findElement(By.xpath("//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		Thread.sleep(3000);

		// click on add to learning button
		driver.findElement(
				By.xpath("//*[@id='catalog_items_container']/div/div/div/div[2]/div/div[2]/div/li/a/span/div[2]"))
				.click();
		Thread.sleep(3000);

		// click on go to learning page
		driver.findElement(By.xpath("//*[@id='lightbox_panel_content']/div/div[2]/div/div/div/ul/li[3]/a")).click();
		Thread.sleep(3000);

		// click on my learning
		// driver.findElement(By.id("tab_my_learnings")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Thread.sleep(10000);

		// click on play button
		driver.findElement(
				By.xpath("//*[@id='upcoming_courses']/div/div/div/div/div/div/div/div/ul/li[2]/div/div/div/a")).click();
		Thread.sleep(5000);

		// Video Streaming for play and pause
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='vjs-tech']")));
		System.out.println("frame switched");
		Thread.sleep(8000);

		WebElement subMenu = driver.findElement(By.xpath("//*[@class='ytp-thumbnail-overlay-image']"));
		JavascriptExecutor executor4 = (JavascriptExecutor) driver;
		executor4.executeScript("arguments[0].click()", subMenu);
		// actions.moveToElement(subMenu).click().build().perform();
		Thread.sleep(10000);

		WebElement subMenu1 = driver.findElement(By.xpath("//*[@class='ytp-thumbnail-overlay-image']"));
		JavascriptExecutor executor5 = (JavascriptExecutor) driver;
		executor5.executeScript("arguments[0].click()", subMenu1);
		Thread.sleep(5000);

		WebElement subMenu2 = driver.findElement(By.xpath("//*[@class='ytp-thumbnail-overlay-image']"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click()", subMenu2);
		Thread.sleep(10000);

		driver.switchTo().defaultContent();

		// click on done button
		driver.findElement(By.xpath("//*[@id='lightbox']/div/div/div[2]/div/div[2]/div[4]/div/div/ul/li/a[1]")).click();
		Thread.sleep(5000);
		driver.quit();

	}
}
