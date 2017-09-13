package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreationOfInPersonEvent extends LearnexaWrappers {
	
	public CreationOfInPersonEvent(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}
	
	public CreationOfInPersonEvent clickEvents() throws InterruptedException{
		clickById(prop.getProperty("CreateEvents.clickCreaticn.Id"));
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateEvents.clickEvents.Xpath"));
		return this ;	
	}
	
	
	
	
	
	public CreationOfInPersonEvent clickInPersonEvent() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateEvents.clickInPersonEvent.Xpath"));
		return this ;	
	}
	
	public CreationOfInPersonEvent enterTitle(String title) throws InterruptedException{
		Thread.sleep(5000);
		enterById(prop.getProperty("CreationOfInPersonEvent.enterTitle.Id"),title);
		return this ;	
	}
	
	public CreationOfInPersonEvent clickDays() throws InterruptedException{
		Thread.sleep(5000);
		clickById(prop.getProperty("CreationOfInPersonEvent.clickDays.Id1"));
		clickById(prop.getProperty("CreationOfInPersonEvent.clickDays.Id2"));
		return this ;	
	}
	
	public CreationOfInPersonEvent clickLocation(){
		 String title="Chennai";
		enterById(prop.getProperty("CreationOfInPersonEvent.clickLocation.Id"), title);
		return this;
	}
	
	public CreationOfInPersonEvent clickSave() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateEvents.clickSave.Xpath"));
		Thread.sleep(5000);
		return this ;	
	}
	
	public CreationOfLiveEvents clickCreation() throws InterruptedException{
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='create_product_menu_close_button']")).click();
		//clickById(prop.getProperty("CreateEvents.clickCreaticn.Id"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='create_product_menu']/div/div/div/div/div[1]/a")).click();
		return new CreationOfLiveEvents(driver,test);
	}
	
	public CreationOfLiveEvents clickCreation1() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='create_product_menu_close_button']")).click();
		//clickById(prop.getProperty("CreateEvents.clickCreaticn.Id"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='create_product_menu']/div/div/div/div/div[2]/a")).click();
		return new CreationOfLiveEvents(driver,test);
	}
	
	
	public CreationOfLiveEvents clickInPerson() throws InterruptedException{
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateEvents.clickInPerson.Id"));
		
		return new CreationOfLiveEvents(driver,test);
	}
	
	public CreationOfInPersonEvent verifyEvent(String Title) throws InterruptedException{
		Thread.sleep(3000);
		if(driver.findElement(By.xpath(".//*[@class='my_learnings_in_person_events columns']/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("InPerson Event is Created and validated");
			}else{
			System.out.println("InPerson Event is not Created and validated");
		}
		System.out.println(Title);
		return this;
	}
	
	public CreationOfInPersonEvent verifyEvent1(String Title) throws InterruptedException{
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//*[@id='catalog_listings_tour']/div/div[2]/div/div[1]/div[1]/ul[1]/li/a"))!= null){
			System.out.println("InPerson Event is Created and validated");
			}else{
			System.out.println("InPerson Event is not Created and validated");
		}
		System.out.println(Title);
		return this;
	}





}
