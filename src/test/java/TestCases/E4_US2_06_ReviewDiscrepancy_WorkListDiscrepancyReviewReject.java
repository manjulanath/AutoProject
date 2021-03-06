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
import Pages.MyTeam;
import Pages.MyWork;
import Pages.SampleScheduleRequest;
import Util.constants;
import Util.lib;
import Pages.HomePage;


public class E4_US2_06_ReviewDiscrepancy_WorkListDiscrepancyReviewReject extends Base{
	
	public E4_US2_06_ReviewDiscrepancy_WorkListDiscrepancyReviewReject(){
		super();
	}
	
  @Test
  public void iAuditE4_US2_06_ReviewDiscrepancy_WorkListDiscrepancyReviewReject() throws Exception {
	  Login login=new Login();
	  HomePage home=new HomePage();
	 // SampleScheduleRequest sampleScheduleRequest = new SampleScheduleRequest();	
	 // MyWork mywork = new MyWork();
	  MyTeam myteam = new MyTeam();
	  String testName=new Object(){}.getClass().getEnclosingMethod().getName();
	  
	  try{
		  //reading test data from excel
		  HashMap<String, String> hm=lib.GetDataFromExcel(constants.testDataPath+"\\\\"+configData.getProperty("TestDataExcelFileName"),
				  "Select * from E4_US2_06 where TestName='"+testName+"'");
		  
		  home=login.iAuditApplicationLogin(configData.getProperty("MTMReviewerLoginID"), configData.getProperty("MTMReviewerLoginPassword"));

		  //closing the welcome screen
		  home.welocmeToIAuditCloseDialoge();
		  
		  Thread.sleep(4000);
	  
		  home.navigateToMyTeam();
		  constants.test.log(LogStatus.PASS, "Navigated to My Team Page");
		  
		  //validate links in My team page
		  myteam.validateLinks(hm);
		  constants.test.log(LogStatus.PASS, "All links are validated in My team page");
		  /*
		  //Click on workbasket
		  myteam.clickWorkbasketReviewer(hm);
		  constants.test.log(LogStatus.PASS, "Workbasket items are visible");
		  */
		  
		  //Select case 
		  myteam.dataEntryForSelectingCase(hm);
		  constants.test.log(LogStatus.PASS, "Case is validated and opened in application");
		  
		  //reject case
		  myteam.rejectcase(hm);
		  constants.test.log(LogStatus.PASS, "Approve is done");
		  
		  //log off
		  home.logoff();
		  
		  //login again
		  home=login.iAuditApplicationLogin(configData.getProperty("MTMAuditorLoginID"), configData.getProperty("MTMAuditorLoginPassword"));
		  constants.test.log(LogStatus.PASS, "Log in with auditor's credential");
		  
		  //closing the welcome screen
		  home.welocmeToIAuditCloseDialoge();
		  constants.test.log(LogStatus.PASS, "Done closing screen");
		  
		  home.navigateToMyTeam();
		  constants.test.log(LogStatus.PASS, "Navigated to My Team Page");
		  
		//validate links in My team page
		  myteam.validateLinks(hm);
		  constants.test.log(LogStatus.PASS, "All links are validated in My team page");
		  /*
		   
		//Click on Work basket
		  myteam.clickWorkbasketErrorApprover(hm);
		  */
		  
		  //Select case 
		  myteam.dataEntryForSelectingCase(hm);
		  constants.test.log(LogStatus.PASS, "Case is present");
		  
		  		  
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
