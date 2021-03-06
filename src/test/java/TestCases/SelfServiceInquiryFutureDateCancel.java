package TestCases;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Base.Base;
import Pages.Login;
import Pages.SSR;
import Pages.SampleScheduleRequest;
import Util.constants;
import Util.lib;
import Pages.HomePage;


public class SelfServiceInquiryFutureDateCancel extends Base{
	
	public SelfServiceInquiryFutureDateCancel(){
		super();
	}
	
  @Test
  public void iAuditSampleScheduleRequestSelfServiceInquiryFutureDateCancel() throws Exception {
	  Login login=new Login();
	  HomePage home=new HomePage();
//	  SampleScheduleRequest sampleScheduleRequest = new SampleScheduleRequest();	
	  SSR ssr = new SSR();
	  
	  String testName=new Object(){}.getClass().getEnclosingMethod().getName();
	  
	  try{
		  //reading test data from excel
		  HashMap<String, String> hm=lib.GetDataFromExcel(constants.testDataPath+"\\\\"+configData.getProperty("TestDataExcelFileName"),
				  "Select * from SelfServiceInquiryFuturedate where TestName='"+testName+"'");
		  home=login.iAuditApplicationLogin(configData.getProperty("MTMAuditorLoginID"), configData.getProperty("MTMAuditorLoginPassword"));

		  //closing the welcome screen
		  home.welocmeToIAuditCloseDialoge();
		  
		  Thread.sleep(4000);
		  //clicking Sample Schedule Request link
		  home.navigateToSampleScheduleRequest();

	  ssr.dataEntryForSelfServiceInquiryCancelSampleScheduleRequest(hm);
		  
		  
	  }catch(Exception e){
//		  e.printStackTrace();
		  constants.test.log(LogStatus.FAIL, "Verify if Test" +testName+"Pass without Exception"+lib.getStackTrace(e));
		  lib.takeScreenshot();
	  }
  }
  
  
  @BeforeMethod
  public void beforeMethod(Method method) {
	  
	  ReadConfigData();
	  initiateWebdriver();
	  String methodName=method.getName();
	  lib.beforeMethod(methodName);
	  
  }

  @AfterMethod
  public void afterMethod(Method method) {
	  String methodName=method.getName();
	  lib.afterMethod(methodName);
	  driver.quit();

  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }


  @BeforeSuite
  public void beforesuite(){
	  //Extent Report
	  constants.extent=new ExtentReports(System.getProperty("user.dir").toString().replace("\\", "/")+
			  "/test-output/reports/testreport"+constants.dateFormat.format(constants.cal.getTime())+".html", true);
  }
  

}
