package testcases;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import wrappers.GenericWrappers;
import wrappers.LearnexaWrappers;

public class Chat extends GenericWrappers{
	/*
	WebDriver driver;
	private WebElement talkbox;
	  private WebElement chatlog;
	  private WebElement sendbutton;*/
	  
	/*public Chat(WebDriver passed_in_driver){
	      driver = passed_in_driver;
	      
	      talkbox = driver.findElement("name", "talkbox");
	      sendbutton = driver.find_element("name", "send");
	      chatlog = driver.find_element("name", "chatlog");
	      driver.get("http://www.yoursite.com");
	  }
	*/
	@Test
	public static void testcases() throws InterruptedException, AWTException, FindFailed, IOException {
				
		//login details
		/*String loginURL = "https://radham.dev01.learnexa.com/login";
		String userAName = "radham@expertus.com";
		String userAPassword = "password";
		String userBName = "divyas@expertus.com";
		String userBPassword = "password";		
		*/
		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver", sChromiumDriver);
		System.setProperty("webdriver.gecko.driver", sChromiumDriver1);
		
		//initialze the user A browser
		WebDriver userADriver = new FirefoxDriver();
		userADriver.manage().window().maximize();
		userADriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		//initialze the user B browser		
		WebDriver userBDriver = new ChromeDriver();
		userBDriver.manage().window().maximize();
		userBDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		// Navigate to URL
		userADriver.get(sUrl);
		userBDriver.get(sUrl);
		
		//singin using user credentials
		userADriver.findElement(By.id("email")).sendKeys(sUserName);
		userADriver.findElement(By.id("password")).sendKeys(sPassword);
		userADriver.findElement(By.xpath("//*[@class='orange button']")).click();
		
		userBDriver.findElement(By.id("email")).sendKeys(sUserName1);
		userBDriver.findElement(By.id("password")).sendKeys(sPassword1);
		userBDriver.findElement(By.xpath("//*[@class='orange button']")).click();

		/*// Closing the popup
		userADriver.findElement(By.xpath("/html/body/div[10]/div/a")).click();
		userBDriver.findElement(By.xpath("/html/body/div[10]/div/a")).click();*/
		Thread.sleep(7000);
				
		//Open the chat window
		userADriver.findElement(By.xpath(".//*[@id='chat_user_list']/div/div[1]/div")).click();
		userBDriver.findElement(By.xpath(".//*[@id='chat_user_list']/div/div[1]/div")).click();
		
		//get first user information
		int totalScriptTagA = userADriver.findElements(By.tagName("script")).size();
		WebElement userAScriptElem = userADriver.findElements(By.tagName("script")).get(totalScriptTagA-1);
		String userAHtmlCode = (String) ((JavascriptExecutor) userADriver).executeScript("return arguments[0].innerHTML;", userAScriptElem);
		
		int totalScriptTagB = userBDriver.findElements(By.tagName("script")).size();
		WebElement userBScriptElem = userBDriver.findElements(By.tagName("script")).get(totalScriptTagB-1);
		String userBHtmlCode = (String) ((JavascriptExecutor) userBDriver).executeScript("return arguments[0].innerHTML;", userBScriptElem);
		
		int userAStartIndex = userAHtmlCode.indexOf("\"id\":");
		int userAEndIndex = userAHtmlCode.indexOf(",\"groups\"");
		String userAId = userAHtmlCode.substring(userAStartIndex+5, userAEndIndex);
		
		int userBStartIndex = userBHtmlCode.indexOf("\"id\":");
		int userBEndIndex = userBHtmlCode.indexOf(",\"groups\"");
		String userBId = userBHtmlCode.substring(userBStartIndex+5, userBEndIndex);
		
		System.out.println("UserAId:::" + userAId);
		System.out.println("UserBId:::" + userBId);
		
		userADriver.findElement(By.id("chat_list_user_item_" + userBId)).findElements(By.tagName("div")).get(0).click();
		userBDriver.findElement(By.id("chat_list_user_item_" + userAId)).findElements(By.tagName("div")).get(0).click();
		
		System.out.println("aaaaaaaaaaaaaaaAA");
		//userADriver.findElement(By.id("balloon_user_" + userAId + "_" + userBId)).findElements(By.xpath(".//*[@id='message_id_356_357']")).get(1).findElements(By.className("columns")).get(1).findElement(By.name("message_" + userBId)).sendKeys("Hello UserB");
		//userBDriver.findElement(By.id("balloon_user_" + userBId + "_" + userAId)).findElements(By.xpath(".//*[@id='message_id_357_356']")).get(1).findElements(By.className("columns")).get(1).findElement(By.tagName("message_" + userBId)).sendKeys("Hello UserA");
		
		//userADriver.findElement(By.className("message_" + userBId)).sendKeys("Heeloooo");
		String userASendMessage = "Hellooooo " + sUserName1;
		userADriver.findElement(By.name("message_" + userBId)).sendKeys(userASendMessage);
		userADriver.findElement(By.name("message_" + userBId)).sendKeys(Keys.RETURN);
		
		String userBSendMessage = "Hellooooo " + sUserName;
		userBDriver.findElement(By.name("message_" + userAId)).sendKeys(userBSendMessage);
		userBDriver.findElement(By.name("message_" + userAId)).sendKeys(Keys.RETURN);
		
		Thread.sleep(7000);
		
		 List<WebElement> userAMsgList = userADriver.findElement(By.id("chat_user_" + userAId + "_" + userBId)).findElements(By.cssSelector("div[class='columns half_margin_right ']"));
	     List<WebElement> userBMsgList = userBDriver.findElement(By.id("chat_user_" + userBId + "_" + userAId)).findElements(By.cssSelector("div[class='columns half_margin_right ']"));
	        
		int totalUserAMsgList = userAMsgList.size();
		int totalUserBMsgList = userBMsgList.size();
		
		System.out.println("totalUserAMsgList:::" + totalUserAMsgList);
		System.out.println("totalUserBMsgList:::" + totalUserBMsgList);
		
		
		String userAReceiveMessage = userAMsgList.get(totalUserAMsgList - 1).findElements(By.className("chat_message_inside_box")).get(0).getText().trim();
		String userBReceiveMessage = userBMsgList.get(totalUserBMsgList - 2).findElements(By.className("chat_message_inside_box")).get(0).getText().trim();
		
		System.out.println("UserA Sends:::" + userASendMessage);
		System.out.println("UserB Sends:::" + userBSendMessage);
		
		System.out.println("UserA Receives:::" + userAReceiveMessage);
		System.out.println("UserB Receives:::" + userBReceiveMessage);
		
		if(userASendMessage.equals(userBReceiveMessage)) {
			System.out.println("aaaaaaaaaaaaaaa");
			System.out.println(userBSendMessage);
			System.out.println(userAReceiveMessage);
			if(userAReceiveMessage.equals(userBSendMessage)) {
				System.out.println("bbbbbbbbbbbbb");
				System.out.println("Chat message has been verified successfully");
			}
		} else {
			System.out.println("Chat message has not verified successfully");
		}
		
		
		//closing the windows
		
		userADriver.quit();
		userBDriver.quit();
		
			
		
		
		
	      
	   
		
	}
	
	/*public void sendChatMessage(String message)
	{
		
	}
	
	public void readChatMessage()
	{
		
	}*/
}
