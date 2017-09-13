package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfCourseByAudioVideo extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC009 Create Content And Course By VideoAudioEmbed";
		testDescription = "Creation of Content and then course using the content by VideoAudioEmbed";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
	System.out.println(userName + ":::" + password);
	
	String allowdchrs = "123456789";
	String Titledata = "Testing Content By AudioUpload automation" + RandomStringUtils.random(2, allowdchrs);
	String Titledata1 = "Testing Course By AudioUpload automation" + RandomStringUtils.random(1, allowdchrs);
	String Titledata2 = RandomStringUtils.random(1, allowdchrs);
	
	new LoginPage (driver,test)
	 .enterUserName()
	 .enterPassword()
	 .clickSubmit()
	 .clickcoursetab()
	 .clickCreateCourse()
	 .clickContentVideoAudio()  
	 .createContent() 
	 .clickUploadAVideo()
	 .clickUpload()
	 .enterTitle(Titledata)
	 .clickSave() 
	 .clickApply()
	 .enterCourseTitle(Titledata1)
	 .enterDescription()
	 .clickSave1(Titledata1)
	 ;

}
}


