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

public class HomeScreen extends LearnexaWrappers {

	public HomeScreen(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	public HomeScreen homeTab() throws InterruptedException {
		clickById(prop.getProperty("HomeScreen.homeTab.Id"));
		Thread.sleep(3000);
		return this;
	}

	public HomeScreen clickEdit() throws InterruptedException {
		clickByXpath(prop.getProperty("HomeScreen.clickEdit.Xpath"));
		return this;
	}

	public HomeScreen enterTitle(String Title) throws InterruptedException {
		Thread.sleep(3000);
		enterById(prop.getProperty("HomeScreen.enterTitle.Id"), Title);
		return this;
	}

	public HomeScreen uploadVideoAudio() throws InterruptedException {
		clickByLink(prop.getProperty("HomeScreen.uploadVideoAudio.Link"));
		return this;
	}

	public HomeScreen embededURL(String Title) throws InterruptedException {
		Thread.sleep(3000);
		enterByXpath(prop.getProperty("HomeScreen.embededURL.Xpath"), Title);
		Thread.sleep(3000);
		return this;
	}

	public HomeScreen embededURL1() throws InterruptedException {
		clickByXpath(prop.getProperty("HomeScreen.embededURL1.Xpath"));
		return this;
	}

	public HomeScreen saveButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.linkText("Save")).click();
		Thread.sleep(3000);
		//clickByXpath(prop.getProperty("HomeScreen.saveButton.Xpath"));
		return this;
	}

	public HomeScreen verifyMessage(String Title) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id='homepage_highlight_content']/div/div/img"));
		String path = element.getAttribute("src");
		System.out.println(path);
		if (path.equals(Title)) {
			System.out.println("Testcase Passed");
		}
		return this;
	}

	public HomeScreen clickEdit1() throws InterruptedException {
		Thread.sleep(4000);
		clickByXpath(prop.getProperty("HomeScreen.clickEdit1.Xpath"));
		Thread.sleep(4000);
		return this;
	}

	public HomeScreen uploadVideo2() throws InterruptedException {
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("HomeScreen.uploadVideo2.Xpath"));
		return this;
	}

	public HomeScreen enterTitlename(String Title) throws InterruptedException {
		enterById(prop.getProperty("HomeScreen.enterTitlename.Id"), Title);
		Thread.sleep(3000);
		return this;
	}
	public HomeScreen enterurl() throws InterruptedException {
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@class='tabbertab ']/div/div/div/form/ul/li[2]/div/input)")).sendKeys(sTESTDATAVIDEOEMBEDED);
		WebElement element = driver.findElement(By.xpath("//*[@class='tabbertab ']/div/div/div/form/ul/li[2]/div/input"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		element.sendKeys(sTESTDATAVIDEOEMBEDED);
		Thread.sleep(3000);
		//driver.findElement(By.id("embed_url")).sendKeys(sTESTDATAVIDEOEMBEDED);
		driver.findElement(By.xpath("//*[@class='tabbertab ']/div/div/div/form/ul/li[3]/input")).click();
		//enterById(prop.getProperty("HomeScreen.enterTitlename.Id"), Title);
		Thread.sleep(3000);
		return this;
	}

	public HomeScreen clickbrowse() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		clickById(prop.getProperty("HomeScreen.clickbrowse.Id"));
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
	/*	r.keyPress(KeyEvent.VK_UP);*/
		r.delay(4000);
		String path2 = "chat_functionality.m4v";
		sikuliObject.type(path2 + Key.ENTER);
	/*	r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return this;
	}

	public HomeScreen saveButton1() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.linkText("Save")).click();
		System.out.println("Save Clicked");
		Thread.sleep(5000);
		//clickByLink(prop.getProperty("HomeScreen.saveButton1.Link"));
		return this;
	}

	public HomeScreen verifyMessage1() throws InterruptedException {
		Thread.sleep(4000);
		WebElement element1 = driver
				.findElement(By.xpath("//*[@id='player_1492056980']/param[5]"));
		String path12 = element1.getAttribute("value");
		System.out.println(path12);
		if (path12.contains("chat_functionality")) {
			System.out.println("Testcase Passed");
		}
		return this;
	}
	
	
	public HomeScreen clickEdit2() throws InterruptedException {
		Thread.sleep(5000);	
		clickByXpath(prop.getProperty("HomeScreen.clickEdit2.Id"));
		Thread.sleep(4000);
		
		WebElement element = driver.findElement(By.xpath("//*[@class='tabberactive']/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//driver.findElement(By.xpath("//*[@class='tabberactive']/a")).click();
		Thread.sleep(4000);
		return this;
	}
	
	public HomeScreen Video1() throws InterruptedException {
		clickByLink(prop.getProperty("HomeScreen.Video1.Link"));
		return this;
	}
	
	
	public HomeScreen enterTitlename1(String Title) throws InterruptedException {
		enterById(prop.getProperty("HomeScreen.enterTitlename1.Id"), Title);
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement((By.id("tinymce"))).sendKeys("Testing Automation");
		driver.switchTo().parentFrame();
		driver.findElement(By.linkText("Save")).click();
		Thread.sleep(3000);
		return this;
	}
	
	
}
