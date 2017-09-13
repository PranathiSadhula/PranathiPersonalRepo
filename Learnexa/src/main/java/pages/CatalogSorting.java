package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CatalogSorting extends LearnexaWrappers{
	public CatalogSorting(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	
	public CatalogSorting clickScromPackage() {
		clickById(prop.getProperty("CatalogSorting.clickScromPackage.Id"));
		return this;
	}
	
	public CatalogSorting clickTitle() {
		clickByXpath(prop.getProperty("CatalogSorting.clickTitle.Xpath"));
		return this;
	}
	public CatalogSorting getListValues() {
		List<WebElement> linkElements = driver.findElements(By.xpath("//*[@id='catalog_items_container']/div/div/div/div/div/div/div/div/ul[1]/li[1]/a"));
		System.out.println("Total List Count:::" + linkElements.size());
		String firstElement1=driver.findElement(By.xpath("//*[@id='catalog_items_container']/div/div/div/div/div/div/div/div/ul[1]/li[1]/a")).getText();
		System.out.println(firstElement1);
		List<String> linkElements1 = new ArrayList<String>();
		for(int k=0;k<linkElements.size();k++){		
			linkElements1.add(linkElements.get(k).getAttribute("title"));
			
		 }
		  System.out.println(linkElements1);
		  Collections.sort(linkElements1);
		  System.out.println(linkElements1);
		  System.out.println(linkElements1.size());
		  String firstElement = linkElements1.get(0);
		  String lastElement = linkElements1.get(linkElements1.size()-1);
		  System.out.println(lastElement);
		  System.out.println(firstElement);
		  if (firstElement1.equals(firstElement)){
			  System.out.println("Sorted Verified");
		  }
		
		
		
		return this;
	}
	


	
}
