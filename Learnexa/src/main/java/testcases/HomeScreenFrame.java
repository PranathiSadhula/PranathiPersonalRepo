package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class HomeScreenFrame extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC020 Home Screen";
		testDescription = "Home Screen";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "123456789";
		String Title = "Automation Testing";
		String Titledata = "Home screen testing " + RandomStringUtils.random(2, allowdchrs);
		String Testdata1 = "http://core0.staticworld.net/images/article/2015/02/3922495716_f7384d98fd_o-100568069-primary.idge.jpg";
		
	new LoginPage (driver,test)
	 .enterUserName()
	 .login1()
	 .homeTab() 
	 .clickEdit()
	 .enterTitle(Title)
	 //.uploadVideoAudio()
	 .embededURL(Testdata1)
	 .embededURL1()
	 .saveButton();
	 /*//.verifyMessage(Testdata1) 
	 .clickEdit1() 
	 .uploadVideo2()
	 .enterTitlename(Titledata)
	 .enterurl()
	 .saveButton1();*/
	/* .clickEdit2() 
	 .Video1()
	 .enterTitlename1(Titledata);*/
	}

}
