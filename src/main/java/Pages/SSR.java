package Pages;

import Base.Base;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Util.CommonUtils;
import Util.constants;
import Util.lib;

/**
 * @author Arnab
 * Description :- This Class will contain all the web elements and methods related to iAudit application 'Sample Schedule Request' page. 
 *
 */
public class SSR extends Base{
	
	@FindBy(xpath="//*[@id='pui_filter'][1]")
	WebElement FilterIcon;
	
	@FindBy(id = "pySearchText")
	WebElement SearchText;
	
	@FindBy(xpath = ".//*[@id='pob0']/div/button[1]")
	WebElement ApplyButton;
	
	@FindBy(xpath = "//a[@title='Next Page']")
	WebElement NextIcon;

	@FindBy(xpath = "//*[text()='Actions']")
	WebElement AButton;

	@FindBy(xpath = "//*[text()='Cancel Request']")
	WebElement CancelRequest;
	
	@FindBy(xpath = "//*[text()='Submit']")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//*[text()='Close']")
	WebElement CloseButton;
	
	@FindBy(xpath = "//*[text()='Update Request']")
	WebElement UpdateRequest;
	
	@FindBy(id="AudFromDt")
	WebElement auditFromDate;

	@FindBy(id="AudToDt")
	WebElement auditToDate;
	
	@FindBy(id="AudRunDt")
	WebElement auditRunDate;
	
	@FindBy(id="SampleCnt")
	WebElement totalSampleCount;

	@FindBy(id ="MeasureType(REQ_S1)")
	WebElement valueofS1;
	
	@FindBy(id ="MeasureType(REQ_S2)")
	WebElement valueofS2;
	
	@FindBy(id ="MeasureType(REQ_S3)")
	WebElement valueofS3;
	
	@FindBy(id ="MeasureType(REQ_S4)")
	WebElement valueofS4;
	
	@FindBy(id ="MeasureType(REQ_S5)")
	WebElement valueofS5;
	
	@FindBy(id = "MeasureType(REQ_CALLS)")
	WebElement valueofCALLS;
	
	@FindBy(id = "MeasureType(REQ_CORRESPONDENCE)")
	WebElement valueofCORRESPONDENCE;
	
	@FindBy(id = "MeasureType(REQ_WALKIN)")
	WebElement valueofWALKIN;
	
	@FindBy(id = "MeasureType(REQ_CHATS)")
	WebElement valueofCHATS;
	

	@FindBy(id= "MeasureType(REQ_MEMBERPORTALS)")
	WebElement valueofMEMBERPORTALS;
	
	@FindBy(id= "MeasureType(REQ_PROVIDERPORTALS)")
	WebElement valueofPROVIDERPORTALS;
	
	@FindBy(id= "MeasureType(REQ_BX)")
	WebElement valueofBX;
	
	@FindBy(id= "MeasureType(REQ_HWS)")
	WebElement valueofHWS;
	
	@FindBy(id= "MeasureType(REQ_EIVRMEMBER)")
	WebElement valueofEIVRMEMBER;
	
	@FindBy(id= "MeasureType(REQ_EIVRPROVIDER)")
	WebElement valueofEIVRPROVIDER;
	
	public SSR(){
		PageFactory.initElements(driver, this);
	}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Enrollment' 
 * 					and run date is future date then cancel
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForEnrollmentCancelSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{

	// TODO Auto-generated method stub
	String SSRid="";
	//-----------------------  SSRID Click---------------
	/*
	if(testdata.get("SSRID"+constants.i).isEmpty())
	{
		constants.test.log(LogStatus.INFO, "No data entered for 'SSRID' as there is no data in test data excel");
	}
	else
	{
		//not running
		constants.test.log(LogStatus.PASS, "Data present for 'SSRID'");
	}*/
		String SSRNO = testdata.get("SSRID"+constants.i);
		if(SSRNO == SSRid)
		{
			constants.test.log(LogStatus.INFO, "No data entered for 'SSRID' as there is no data in test data excel");
		}
		else
		{
			constants.test.log(LogStatus.INFO, "Will test further");
		}
		CommonUtils.switchToStandardObjFrame(FilterIcon);
		FilterIcon.click();
		Thread.sleep(3000);
		SearchText.clear();
		SearchText.sendKeys(testdata.get("SSRID"+constants.i));
		constants.test.log(LogStatus.INFO, "'SSRID' = '"+testdata.get("SSRID"+constants.i)+"'");
		ApplyButton.click();
		Thread.sleep(3000);
		System.out.println(SSRNO);
	
		
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=5; a++)
		{
			WebElement numberpath = driver.findElement(By.xpath("//div[text()='Scheduling ID']/following::tr["+a+"]/td[1]/descendant::a[1]"));
			String number = numberpath.getText();
			//System.out.println(number);
			if(number.equals(SSRNO))
			{
				numberpath.click();
				constants.test.log(LogStatus.PASS, "SSR is selcted");
				result = true;
				break;
			}
			else if(a==5)
			{
				NextIcon.click();
				break;
			}
		}
		
		}

		Thread.sleep(5000);
		CommonUtils.switchToStandardObjFrame(AButton);
		AButton.click();
		Thread.sleep(3000);
		CancelRequest.click();
		constants.test.log(LogStatus.PASS, "Cancel request is selected");
		Thread.sleep(3000);
		SubmitButton.click();
		
		Thread.sleep(3000);
		CloseButton.click();
		System.out.println("Cancel is successful");
		constants.test.log(LogStatus.PASS, "Cancel is successful");
		return SSRid;
}

/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Claim' 
 * 					and run date is future date then cancel
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForClaimCancelSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{

	// TODO Auto-generated method stub
	String SSRid="";
	//-----------------------  SSRID Click---------------
	if(testdata.get("SSRID"+constants.i).isEmpty())
	{
		constants.test.log(LogStatus.INFO, "No data entered for 'SSRID' as there is no data in test data excel");
	}
	else
	{
		//not running
	}
		CommonUtils.switchToStandardObjFrame(FilterIcon);
		FilterIcon.click();
		Thread.sleep(3000);
		SearchText.clear();
		SearchText.sendKeys(testdata.get("SSRID"+constants.i));
		constants.test.log(LogStatus.INFO, "'SSRID' = '"+testdata.get("SSRID"+constants.i)+"'");
	
		ApplyButton.click();
		Thread.sleep(3000);
		String SSRNO = testdata.get("SSRID"+constants.i);
		System.out.println(SSRNO);
	
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=5; a++)
		{
			WebElement numberpath = driver.findElement(By.xpath("//div[text()='Scheduling ID']/following::tr["+a+"]/td[1]/descendant::a[1]"));
			String number = numberpath.getText();
			//System.out.println(number);
			if(number.equals(SSRNO))
			{
				numberpath.click();
				constants.test.log(LogStatus.PASS, "SSR is selcted");
				result = true;
				break;
			}
			else if(a==5)
			{
				NextIcon.click();
				break;
			}
		}
		
		}

		Thread.sleep(5000);
		CommonUtils.switchToStandardObjFrame(AButton);
		AButton.click();
		Thread.sleep(3000);
		CancelRequest.click();
		constants.test.log(LogStatus.PASS, "Cancel request is selected");
		Thread.sleep(3000);
		SubmitButton.click();
		
		Thread.sleep(3000);
		CloseButton.click();
		System.out.println("Cancel is successful");
		constants.test.log(LogStatus.PASS, "Cancel is successful");
		return SSRid;
}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'ManualInquiry' 
 * 					and run date is future date then cancel
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForManualInquiryCancelSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{

	// TODO Auto-generated method stub
	String SSRid="";
	//-----------------------  SSRID Click---------------
	if(testdata.get("SSRID"+constants.i).isEmpty())
	{
		constants.test.log(LogStatus.INFO, "No data entered for 'SSRID' as there is no data in test data excel");
	}
	else
	{
		//not running
	}
		CommonUtils.switchToStandardObjFrame(FilterIcon);
		FilterIcon.click();
		Thread.sleep(3000);
		SearchText.clear();
		SearchText.sendKeys(testdata.get("SSRID"+constants.i));
		constants.test.log(LogStatus.INFO, "'SSRID' = '"+testdata.get("SSRID"+constants.i)+"'");
	
		ApplyButton.click();
		Thread.sleep(3000);
		String SSRNO = testdata.get("SSRID"+constants.i);
		System.out.println(SSRNO);
	
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=5; a++)
		{
			WebElement numberpath = driver.findElement(By.xpath("//div[text()='Scheduling ID']/following::tr["+a+"]/td[1]/descendant::a[1]"));
			String number = numberpath.getText();
			System.out.println(number);
			if(number.equals(SSRNO))
			{
				numberpath.click();
				constants.test.log(LogStatus.PASS, "SSR is selcted");
				result = true;
				break;
			}
			else if(a==5)
			{
				NextIcon.click();
				break;
			}
		}
		
		}

		Thread.sleep(5000);
		CommonUtils.switchToStandardObjFrame(AButton);
		AButton.click();
		Thread.sleep(3000);
		CancelRequest.click();
		constants.test.log(LogStatus.PASS, "Cancel request is selected");
		Thread.sleep(3000);
		SubmitButton.click();
		
		Thread.sleep(3000);
		CloseButton.click();
		System.out.println("Cancel is successful");
		constants.test.log(LogStatus.PASS, "Cancel is successful");
		return SSRid;
}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'SelfServiceInquiry' 
 * 					and run date is future date then cancel
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForSelfServiceInquiryCancelSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{

	// TODO Auto-generated method stub
	String SSRid="";
	//-----------------------  SSRID Click---------------
	if(testdata.get("SSRID"+constants.i).isEmpty())
	{
		constants.test.log(LogStatus.INFO, "No data entered for 'SSRID' as there is no data in test data excel");
	}
	else
	{
		//not running
	}
		CommonUtils.switchToStandardObjFrame(FilterIcon);
		FilterIcon.click();
		Thread.sleep(3000);
		SearchText.clear();
		SearchText.sendKeys(testdata.get("SSRID"+constants.i));
		constants.test.log(LogStatus.INFO, "'SSRID' = '"+testdata.get("SSRID"+constants.i)+"'");
	
		ApplyButton.click();
		Thread.sleep(3000);
		String SSRNO = testdata.get("SSRID"+constants.i);
		System.out.println(SSRNO);
	
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=5; a++)
		{
			WebElement numberpath = driver.findElement(By.xpath("//div[text()='Scheduling ID']/following::tr["+a+"]/td[1]/descendant::a[1]"));
			String number = numberpath.getText();
			System.out.println(number);
			if(number.equals(SSRNO))
			{
				numberpath.click();
				constants.test.log(LogStatus.PASS, "SSR is selcted");
				result = true;
				break;
			}
			else if(a==5)
			{
				NextIcon.click();
				break;
			}
		}
		
		}

		Thread.sleep(5000);
		CommonUtils.switchToStandardObjFrame(AButton);
		AButton.click();
		Thread.sleep(3000);
		CancelRequest.click();
		constants.test.log(LogStatus.PASS, "Cancel request is selected");
		Thread.sleep(3000);
		SubmitButton.click();
		
		Thread.sleep(3000);
		CloseButton.click();
		System.out.println("Cancel is successful");
		constants.test.log(LogStatus.PASS, "Cancel is successful");
		return SSRid;
}



/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Enrollment' 
 * 					and run date is future date then Edit
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForEnrollmentEditSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{

	// TODO Auto-generated method stub
	String SSRid="";
	//-----------------------  SSRID Click---------------

		CommonUtils.switchToStandardObjFrame(FilterIcon);
		FilterIcon.click();
		Thread.sleep(3000);
		SearchText.clear();
		SearchText.sendKeys(testdata.get("SSRID"+constants.i));
		constants.test.log(LogStatus.INFO, "'SSRID' = '"+testdata.get("SSRID"+constants.i)+"'");
	
		ApplyButton.click();
		Thread.sleep(3000);
		String SSRNO = testdata.get("SSRID"+constants.i);
		System.out.println(SSRNO);
	
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=5; a++)
		{
			WebElement numberpath = driver.findElement(By.xpath("//div[text()='Scheduling ID']/following::tr["+a+"]/td[1]/descendant::a[1]"));
			String number = numberpath.getText();
			System.out.println(number);
			if(number.equals(SSRNO))
			{
				numberpath.click();
				result = true;
				break;
			}
			else if(a==5)
			{
				NextIcon.click();
				break;
			}
		}
		
		}

		Thread.sleep(5000);
		CommonUtils.switchToStandardObjFrame(AButton);
		AButton.click();
		Thread.sleep(3000);
		UpdateRequest.click();

		//Enter Data for Enrollment 
		if(testdata.get("Audit From Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit From Date' as there is no data in test data excel");
		}else{
			auditFromDate.clear();
			auditFromDate.sendKeys(testdata.get("Audit From Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit From Date' = '"+testdata.get("Audit From Date"+constants.i)+"'");
		}
		
		if(testdata.get("Audit To Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit To Date' as there is no data in test data excel");
		}else{
			auditToDate.clear();
			auditToDate.sendKeys(testdata.get("Audit To Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit To Date' = '"+testdata.get("Audit To Date"+constants.i)+"'");
		}
		
		if(testdata.get("Audit Run Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit Run Date' as there is no data in test data excel");
		}else{
			auditRunDate.clear();
			auditRunDate.sendKeys(testdata.get("Audit Run Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+testdata.get("Audit Run Date"+constants.i)+"'");
		}

		if(testdata.get("Total Sample Count"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Total Sample Count' as there is no data in test data excel");
		}else{
			totalSampleCount.clear();
			totalSampleCount.sendKeys(testdata.get("Total Sample Count"+constants.i));
			constants.test.log(LogStatus.PASS, "'Total Sample Count' = '"+testdata.get("Total Sample Count"+constants.i)+"'");
		}

		SubmitButton.click();
		Thread.sleep(3000);
		CloseButton.click();
		System.out.println("Update successful");
		constants.test.log(LogStatus.PASS, "Update is successful");
				
		return SSRid;
}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Claim' 
 * 					and run date is future date then Edit
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForClaimEditSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{

	// TODO Auto-generated method stub
	String SSRid="";
	//-----------------------  SSRID Click---------------

		CommonUtils.switchToStandardObjFrame(FilterIcon);
		FilterIcon.click();
		Thread.sleep(3000);
		SearchText.clear();
		SearchText.sendKeys(testdata.get("SSRID"+constants.i));
		constants.test.log(LogStatus.INFO, "'SSRID' = '"+testdata.get("SSRID"+constants.i)+"'");
	
		ApplyButton.click();
		Thread.sleep(3000);
		String SSRNO = testdata.get("SSRID"+constants.i);
		System.out.println(SSRNO);
	
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=5; a++)
		{
			WebElement numberpath = driver.findElement(By.xpath("//div[text()='Scheduling ID']/following::tr["+a+"]/td[1]/descendant::a[1]"));
			String number = numberpath.getText();
			System.out.println(number);
			if(number.equals(SSRNO))
			{
				numberpath.click();
				result = true;
				break;
			}
			else if(a==5)
			{
				NextIcon.click();
				break;
			}
		}
		
		}

		Thread.sleep(5000);
		CommonUtils.switchToStandardObjFrame(AButton);
		AButton.click();
		Thread.sleep(3000);
		UpdateRequest.click();

		//Enter Data for Claim 
		if(testdata.get("Audit From Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit From Date' as there is no data in test data excel");
		}else{
			auditFromDate.clear();
			auditFromDate.sendKeys(testdata.get("Audit From Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit From Date' = '"+testdata.get("Audit From Date"+constants.i)+"'");
		}
		
		if(testdata.get("Audit To Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit To Date' as there is no data in test data excel");
		}else{
			auditToDate.clear();
			auditToDate.sendKeys(testdata.get("Audit To Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit To Date' = '"+testdata.get("Audit To Date"+constants.i)+"'");
		}
		
		if(testdata.get("Audit Run Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit Run Date' as there is no data in test data excel");
		}else{
			auditRunDate.clear();
			auditRunDate.sendKeys(testdata.get("Audit Run Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+testdata.get("Audit Run Date"+constants.i)+"'");
		}
		///Adding  S1, S2, S3, S4 and S5
		
		if(testdata.get("valueofS1"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofS1' as there is no data in test data excel");
		}else{
			valueofS1.click();
			Thread.sleep(2000);
			valueofS1.clear();
			Thread.sleep(2000);
			valueofS1.sendKeys(testdata.get("valueofS1"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofS1' = '"+testdata.get("valueofS1"+constants.i)+"'");
		}
		
		if(testdata.get("valueofS2"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofS2' as there is no data in test data excel");
		}else{
			valueofS2.click();
			Thread.sleep(2000);
			valueofS2.clear();
			Thread.sleep(2000);
			valueofS2.sendKeys(testdata.get("valueofS2"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofS2' = '"+testdata.get("valueofS2"+constants.i)+"'");
		}
		
		if(testdata.get("valueofS3"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofS3' as there is no data in test data excel");
		}else{
			valueofS3.click();
			Thread.sleep(2000);
			valueofS3.clear();
			Thread.sleep(2000);
			valueofS3.sendKeys(testdata.get("valueofS1"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofS3' = '"+testdata.get("valueofS3"+constants.i)+"'");
		}
		
		if(testdata.get("valueofS4"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofS4' as there is no data in test data excel");
		}else{
			valueofS4.click();
			Thread.sleep(2000);
			valueofS4.clear();
			Thread.sleep(2000);
			valueofS4.sendKeys(testdata.get("valueofS4"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofS4' = '"+testdata.get("valueofS4"+constants.i)+"'");
		}
		
		if(testdata.get("valueofS5"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofS5' as there is no data in test data excel");
		}else{
			valueofS5.click();
			Thread.sleep(2000);
			valueofS5.clear();
			Thread.sleep(2000);
			valueofS5.sendKeys(testdata.get("valueofS5"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofS5' = '"+testdata.get("valueofS5"+constants.i)+"'");
		}
		
		SubmitButton.click();
		Thread.sleep(3000);
		CloseButton.click();
		System.out.println("Update successful");
		constants.test.log(LogStatus.PASS, "Update is successful");
				
		return SSRid;
}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Manual Inquiry' 
 * 					and run date is future date then Edit
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForManualInquiryEditSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{
	
	// TODO Auto-generated method stub
	String SSRid="";
	//-----------------------  SSRID Click---------------

		CommonUtils.switchToStandardObjFrame(FilterIcon);
		FilterIcon.click();
		Thread.sleep(3000);
		
		SearchText.clear();
		SearchText.sendKeys(testdata.get("SSRID"+constants.i));
		constants.test.log(LogStatus.INFO, "'SSRID' = '"+testdata.get("SSRID"+constants.i)+"'");
	
		ApplyButton.click();
		Thread.sleep(3000);
		String SSRNO = testdata.get("SSRID"+constants.i);
		System.out.println(SSRNO);
	
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=5; a++)
		{
			WebElement numberpath = driver.findElement(By.xpath("//div[text()='Scheduling ID']/following::tr["+a+"]/td[1]/descendant::a[1]"));
			String number = numberpath.getText();
			System.out.println(number);
			if(number.equals(SSRNO))
			{
				numberpath.click();
				result = true;
				break;
			}
			else if(a==5)
			{
				NextIcon.click();
				break;
			}
		}
		
		}

		Thread.sleep(5000);
		CommonUtils.switchToStandardObjFrame(AButton);
		AButton.click();
		Thread.sleep(3000);
		UpdateRequest.click();

		//Enter Data for Manual Inquiry 
		if(testdata.get("Audit From Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit From Date' as there is no data in test data excel");
		}else{
			auditFromDate.clear();
			auditFromDate.sendKeys(testdata.get("Audit From Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit From Date' = '"+testdata.get("Audit From Date"+constants.i)+"'");
		}
		
		if(testdata.get("Audit To Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit To Date' as there is no data in test data excel");
		}else{
			auditToDate.clear();
			auditToDate.sendKeys(testdata.get("Audit To Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit To Date' = '"+testdata.get("Audit To Date"+constants.i)+"'");
		}
		
		if(testdata.get("Audit Run Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit Run Date' as there is no data in test data excel");
		}else{
			auditRunDate.clear();
			auditRunDate.sendKeys(testdata.get("Audit Run Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+testdata.get("Audit Run Date"+constants.i)+"'");
		}
		///Adding  Values
		

		Thread.sleep(5000);
		
		if(testdata.get("valueofCALLS"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofCALLS' as there is no data in test data excel");
		}else{
			valueofCALLS.click();
			Thread.sleep(2000);
			valueofCALLS.clear();
			Thread.sleep(2000);
			valueofCALLS.sendKeys(testdata.get("valueofCALLS"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofCALLS' = '"+testdata.get("valueofCALLS"+constants.i)+"'");
		}

		if(testdata.get("valueofCORRESPONDENCE"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofCORRESPONDENCE' as there is no data in test data excel");
		}else{
			valueofCORRESPONDENCE.click();
			Thread.sleep(2000);
			valueofCORRESPONDENCE.clear();
			Thread.sleep(2000);
			valueofCORRESPONDENCE.sendKeys(testdata.get("valueofCORRESPONDENCE"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofCORRESPONDENCE' = '"+testdata.get("valueofCORRESPONDENCE"+constants.i)+"'");
		}
		
		if(testdata.get("valueofWALKIN"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofWALKIN' as there is no data in test data excel");
		}else{
			valueofWALKIN.click();
			Thread.sleep(2000);
			valueofWALKIN.clear();
			Thread.sleep(2000);
			valueofWALKIN.sendKeys(testdata.get("valueofWALKIN"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofWALKIN' = '"+testdata.get("valueofWALKIN"+constants.i)+"'");
		}
		
		if(testdata.get("valueofCHATS"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofCHATS' as there is no data in test data excel");
		}else{
			valueofCHATS.click();
			Thread.sleep(2000);
			valueofCHATS.clear();
			Thread.sleep(2000);
			valueofCHATS.sendKeys(testdata.get("valueofCHATS"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofCHATS' = '"+testdata.get("valueofCHATS"+constants.i)+"'");
		}

		SubmitButton.click();
		Thread.sleep(3000);
		CloseButton.click();
		System.out.println("Update successful");
		constants.test.log(LogStatus.PASS, "Update is successful");
				
		return SSRid;
}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Self Service
 * 					 Inquiry' and run date is future date then Edit
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForSelfServiceInquiryEditSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{
	
	// TODO Auto-generated method stub
	String SSRid="";
	//-----------------------  SSRID Click---------------

		CommonUtils.switchToStandardObjFrame(FilterIcon);
		FilterIcon.click();
		Thread.sleep(4000);
		System.out.println("Text clear");
		SearchText.clear();
		SearchText.sendKeys(testdata.get("SSRID"+constants.i));
		constants.test.log(LogStatus.INFO, "'SSRID' = '"+testdata.get("SSRID"+constants.i)+"'");
	
		ApplyButton.click();
		Thread.sleep(3000);
		String SSRNO = testdata.get("SSRID"+constants.i);
		System.out.println(SSRNO);
	
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=5; a++)
		{
			WebElement numberpath = driver.findElement(By.xpath("//div[text()='Scheduling ID']/following::tr["+a+"]/td[1]/descendant::a[1]"));
			String number = numberpath.getText();
			System.out.println(number);
			if(number.equals(SSRNO))
			{
				numberpath.click();
				result = true;
				break;
			}
			else if(a==5)
			{
				NextIcon.click();
				break;
			}
		}
		
		}

		Thread.sleep(5000);
		CommonUtils.switchToStandardObjFrame(AButton);
		AButton.click();
		Thread.sleep(3000);
		UpdateRequest.click();

		//Enter Data for Self Service Inquiry 
		if(testdata.get("Audit From Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit From Date' as there is no data in test data excel");
		}else{
			auditFromDate.clear();
			auditFromDate.sendKeys(testdata.get("Audit From Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit From Date' = '"+testdata.get("Audit From Date"+constants.i)+"'");
		}
		
		if(testdata.get("Audit To Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit To Date' as there is no data in test data excel");
		}else{
			auditToDate.clear();
			auditToDate.sendKeys(testdata.get("Audit To Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit To Date' = '"+testdata.get("Audit To Date"+constants.i)+"'");
		}
		
		if(testdata.get("Audit Run Date"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Audit Run Date' as there is no data in test data excel");
		}else{
			auditRunDate.clear();
			auditRunDate.sendKeys(testdata.get("Audit Run Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+testdata.get("Audit Run Date"+constants.i)+"'");
		}
		///Adding  Values
		Thread.sleep(3000);
		

		if(testdata.get("valueofMEMBERPORTALS"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofMEMBERPORTALS' as there is no data in test data excel");
		}else{
			valueofMEMBERPORTALS.click();
			Thread.sleep(2000);
			valueofMEMBERPORTALS.clear();
			Thread.sleep(2000);
			valueofMEMBERPORTALS.sendKeys(testdata.get("valueofMEMBERPORTALS"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofMEMBERPORTALS' = '"+testdata.get("valueofMEMBERPORTALS"+constants.i)+"'");
		}

		if(testdata.get("valueofPROVIDERPORTALS"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofPROVIDERPORTALS' as there is no data in test data excel");
		}else{
			valueofPROVIDERPORTALS.click();
			Thread.sleep(2000);
			valueofPROVIDERPORTALS.clear();
			Thread.sleep(2000);
			valueofPROVIDERPORTALS.sendKeys(testdata.get("valueofPROVIDERPORTALS"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofPROVIDERPORTALS' = '"+testdata.get("valueofPROVIDERPORTALS"+constants.i)+"'");
		}
		
		if(testdata.get("valueofBX"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofBX' as there is no data in test data excel");
		}else{
			valueofBX.click();
			Thread.sleep(2000);
			valueofBX.clear();
			Thread.sleep(2000);
			valueofBX.sendKeys(testdata.get("valueofBX"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofBX' = '"+testdata.get("valueofBX"+constants.i)+"'");
		}
		
		if(testdata.get("valueofHWS"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofHWS' as there is no data in test data excel");
		}else{
			valueofHWS.click();
			Thread.sleep(2000);
			valueofHWS.clear();
			Thread.sleep(2000);
			valueofHWS.sendKeys(testdata.get("valueofHWS"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofHWS' = '"+testdata.get("valueofHWS"+constants.i)+"'");
		}
		
		if(testdata.get("valueofEIVRMEMBER"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofEIVRMEMBER' as there is no data in test data excel");
		}else{
			valueofEIVRMEMBER.click();
			Thread.sleep(2000);
			valueofEIVRMEMBER.clear();
			Thread.sleep(2000);
			valueofEIVRMEMBER.sendKeys(testdata.get("valueofEIVRMEMBER"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofEIVRMEMBER' = '"+testdata.get("valueofEIVRMEMBER"+constants.i)+"'");
		}
		
		if(testdata.get("valueofEIVRPROVIDER"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'valueofEIVRPROVIDER' as there is no data in test data excel");
		}else{
			valueofEIVRPROVIDER.click();
			Thread.sleep(2000);
			valueofEIVRPROVIDER.clear();
			Thread.sleep(2000);
			valueofEIVRPROVIDER.sendKeys(testdata.get("valueofEIVRPROVIDER"+constants.i));
			constants.test.log(LogStatus.PASS, "'valueofEIVRPROVIDER' = '"+testdata.get("valueofEIVRPROVIDER"+constants.i)+"'");
		}

		SubmitButton.click();
		Thread.sleep(3000);
		CloseButton.click();
		System.out.println("Update successful");
		constants.test.log(LogStatus.PASS, "Update is successful");
				
		return SSRid;
}


}