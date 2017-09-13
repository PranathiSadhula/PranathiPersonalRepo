package testcases;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfCertificate extends LearnexaWrappers{
		
		@Parameters("browser")
		@BeforeClass
		public void setValues(String browser) {
			browserName = browser;
			testCaseName = "TC010 Create Quiz Content And Create a Certitifcation";
			testDescription = "Create Quiz Content And Create a Certitifcation";
			category="Sanity";
			dataSheetName = "TC001";
		}
		
		@Test(dataProvider="fetchData")
		public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
			String allowdchrs = "123456789";
			String Titledata = "Testing Content By Certification automation" + RandomStringUtils.random(2, allowdchrs);
			String Titledata1 = "Testing Course By Certification automation" + RandomStringUtils.random(1, allowdchrs);
		new LoginPage (driver,test)
		 .login1()
		 //.closePopup()
		 .clickContent()
		 .clickCreateContent()
		 .clickContentQuiz()
		 .clickOnMultipleQuestion()
		 .typeQuestion()
		 .typeAnswers()
		 .courseTitle(Titledata)
		 .saveButton(Titledata)
		 .clickCertification()
		 .clickCertButton()
		 .AddButton()
		 .checkBox() 
		 .clickApply()
		 .clickCourseTitle(Titledata1)
		 .clickPassingScroes()
		 .enterMaximumAttempts()
		 .clickSave1Button(Titledata1)
		 ;
		}		
	}

