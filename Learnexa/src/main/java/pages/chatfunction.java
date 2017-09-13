package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class chatfunction extends LearnexaWrappers {

	public chatfunction(RemoteWebDriver driver, RemoteWebDriver driver1, ExtentTest test) {
		this.driver = driver;
		this.driver1 = driver1;
		this.test = test;

	}

	// Click on the Documentation
	public chatfunction clickChat() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='chat_user_list']/div/div[1]/div")).click();
		driver1.findElement(By.xpath(".//*[@id='chat_user_list']/div/div[1]/div")).click();		Thread.sleep(3000);
		return this;
	}
	
	public chatfunction getinfo() throws InterruptedException {
		
		int totalScriptTagA = driver.findElements(By.tagName("script")).size();
		WebElement userAScriptElem = driver.findElements(By.tagName("script")).get(totalScriptTagA-1);
		String userAHtmlCode = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", userAScriptElem);
		
		int totalScriptTagB = driver1.findElements(By.tagName("script")).size();
		WebElement userBScriptElem = driver1.findElements(By.tagName("script")).get(totalScriptTagB-1);
		String userBHtmlCode = (String) ((JavascriptExecutor) driver1).executeScript("return arguments[0].innerHTML;", userBScriptElem);
		
	
		int userAStartIndex = userAHtmlCode.indexOf("\"id\":");
		int userAEndIndex = userAHtmlCode.indexOf(",\"groups\"");
		String userAId = userAHtmlCode.substring(userAStartIndex+5, userAEndIndex);
		
		int userBStartIndex = userBHtmlCode.indexOf("\"id\":");
		int userBEndIndex = userBHtmlCode.indexOf(",\"groups\"");
		String userBId = userBHtmlCode.substring(userBStartIndex+5, userBEndIndex);
		
		System.out.println("UserAId:::" + userAId);
		System.out.println("UserBId:::" + userBId);
		
		driver.findElement(By.id("chat_list_user_item_" + userBId)).findElements(By.tagName("div")).get(0).click();
		driver1.findElement(By.id("chat_list_user_item_" + userAId)).findElements(By.tagName("div")).get(0).click();
		
		
		String userASendMessage = "Hellooooo " + sUserName1;
		driver.findElement(By.name("message_" + userBId)).sendKeys(userASendMessage);
		driver.findElement(By.name("message_" + userBId)).sendKeys(Keys.RETURN);
		
		String userBSendMessage = "Hellooooo " + sUserName1;
		driver1.findElement(By.name("message_" + userAId)).sendKeys(userBSendMessage);
		driver1.findElement(By.name("message_" + userAId)).sendKeys(Keys.RETURN);
		
		Thread.sleep(2000);
		
		 List<WebElement> userAMsgList = driver.findElement(By.id("chat_user_" + userAId + "_" + userBId)).findElements(By.cssSelector("div[class='columns half_margin_right ']"));
	     List<WebElement> userBMsgList = driver1.findElement(By.id("chat_user_" + userBId + "_" + userAId)).findElements(By.cssSelector("div[class='columns half_margin_right ']"));
	        
		int totalUserAMsgList = userAMsgList.size();
		int totalUserBMsgList = userBMsgList.size();
		
		System.out.println("totalUserAMsgList:::" + totalUserAMsgList);
		System.out.println("totalUserBMsgList:::" + totalUserBMsgList);
		
		
		String userAReceiveMessage = userAMsgList.get(totalUserAMsgList - 1).findElements(By.className("chat_message_inside_box")).get(0).getText();
		String userBReceiveMessage = userBMsgList.get(totalUserBMsgList - 2).findElements(By.className("chat_message_inside_box")).get(0).getText();
		
		System.out.println("UserA Sends:::" + userASendMessage);
		System.out.println("UserB Sends:::" + userBSendMessage);
		
		System.out.println("UserA Receives:::" + userAReceiveMessage);
		System.out.println("UserB Receives:::" + userBReceiveMessage);
		
		if(userASendMessage.equals(userBReceiveMessage) && userBSendMessage.equals(userAReceiveMessage)) {
			System.out.println("Chat message has been verified successfully");
		} else {
			System.out.println("Chat message has not verified successfully");
		}
		return this;
		
			}

}
