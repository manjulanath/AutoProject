package Pages;

import Base.Base;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

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
public class SampleScheduleRequest extends Base{

	@FindBy(xpath="//label[text()='Measure']/following::select[1]")
	WebElement measureDropdown;
	
	@FindBy(id="AudFromDt1")
	WebElement auditFromDate;
	
	@FindBy(id="AudToDt1")
	WebElement auditToDate;
	
	@FindBy(id="AudRunDt1")
	WebElement auditRunDate;
	
	@FindBy(id="SamplingMethod1")
	WebElement samplingMethodDropdown;
	
	@FindBy(id="SampleCnt1")
	WebElement totalSampleCount;
	
	@FindBy(xpath="//button[text()='Schedule Request']")
	WebElement scheduleRequestButton;
	
	@FindBy(id="ModalButtonSubmit")
	WebElement createSSRSubmitButton;
	
	@FindBy(xpath="//div[text()='Scheduling ID']/following::td[1]/following::div[5]/child::span[contains(text(),'SSR')]")
	WebElement schedulingRequestID;
	
	@FindBy(xpath= "//span[@class='expandRowDetails']")
	WebElement expandIcon;
	
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
	
	@FindBy(id= "pui_filter")
	WebElement Filter;

	@FindBy(id = "pySearchText")
	WebElement Search;
	
	@FindBy(xpath = ".//*[@id='$PSSRCases$ppxResults$l1']/td[1]/div")
	WebElement SSRLink;
	
	
	public SampleScheduleRequest(){
		PageFactory.initElements(driver, this);
	}

	
 
//	public boolean switchtoIframe() throws Exception{
//		boolean result=false;
//		result=CommonUtils.switchToStandardObjFrame(measureDropdown);
//		return result;
//	}
	
	/**
	 * Author :- Arnab
	 * Description :- Selects the dropdown value of the field Measure
	 * @param dropdownValue
	 * @return :- true/false
	 * @throws Exception
	 */
	public boolean selectMeasureDropdown(String dropdownValue) throws Exception{
		boolean result=false;
		CommonUtils.switchToStandardObjFrame(measureDropdown);
		result=CommonUtils.selectDropdownValueByVisibleText(measureDropdown, dropdownValue);	
		/*
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement element;
		//int timeout = 20;
		//WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(expandIcon)); 
		element.click();
		*/
		return result;
	}

	/**
	 * Author :- Arnab
	 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Enrollment'
	 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
	 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
	 * @throws Exception
	 */
	public String dataEntryForEnrollmentSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{
		
		String SSRid="";
		
		//Switching to the iFrame. 
		CommonUtils.switchToStandardObjFrame(measureDropdown);
		
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
		
		//Audit Run Date will take current date.
		auditRunDate.clear();
		String auditRunDateData=lib.getCurrentDateInMMDDYYYFormat();
		System.out.println("auditRunDateData="+auditRunDate);
		auditRunDate.sendKeys(auditRunDateData);
		constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+auditRunDateData+"'");
		
		
		if(testdata.get("Sampling Method"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Sampling Method' as there is no data in test data excel");
		}else{
			
			if(CommonUtils.selectDropdownValueByVisibleText(samplingMethodDropdown, testdata.get("Sampling Method"+constants.i))){
				constants.test.log(LogStatus.PASS, "'Sampling Method' = '"+testdata.get("Sampling Method"+constants.i)+"'");
			}else{
				constants.test.log(LogStatus.FAIL, "'Sampling Method' dropdown value '"+testdata.get("Sampling Method"+constants.i)+"' cannot be selected.");
			}
		}
		
		if(testdata.get("Total Sample Count"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'Total Sample Count' as there is no data in test data excel");
		}else{
			totalSampleCount.clear();
			totalSampleCount.sendKeys(testdata.get("Total Sample Count"+constants.i));
			constants.test.log(LogStatus.PASS, "'Total Sample Count' = '"+testdata.get("Total Sample Count"+constants.i)+"'");
		}
		
		//click Schedule Request Button
		scheduleRequestButton.click();
		constants.test.log(LogStatus.PASS, "Clicked Schedule Request Button");
		
		//clicking submit (create SSR alert box)
		Thread.sleep(4000);
		createSSRSubmitButton.click();		
		constants.test.log(LogStatus.PASS, "Clicked Submit Button on the confirmation pop up for Create SSR dialog box");
		
		
		//Retrieving SSR id 
		Thread.sleep(4000);
		SSRid=schedulingRequestID.getText();
		constants.test.log(LogStatus.INFO, "Generated SSR ID='"+SSRid+"'");
		return SSRid;
		
	}

	
/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Claim'
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
	
public String dataEntryForClaimSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	Thread.sleep(5000);
	//Switching to the iFrame. 
	CommonUtils.switchToStandardObjFrame(measureDropdown);
	
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
	
	//Audit Run Date will take current date.
	auditRunDate.clear();
	String auditRunDateData=lib.getCurrentDateInMMDDYYYFormat();
	System.out.println("auditRunDateData="+auditRunDate);
	auditRunDate.sendKeys(auditRunDateData);
	constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+auditRunDateData+"'");
	
	
	if(testdata.get("Sampling Method"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'Sampling Method' as there is no data in test data excel");
	}else{
		
		if(CommonUtils.selectDropdownValueByVisibleText(samplingMethodDropdown, testdata.get("Sampling Method"+constants.i))){
			constants.test.log(LogStatus.PASS, "'Sampling Method' = '"+testdata.get("Sampling Method"+constants.i)+"'");
		}else{
			constants.test.log(LogStatus.FAIL, "'Sampling Method' dropdown value '"+testdata.get("Sampling Method"+constants.i)+"' cannot be selected.");
		}
		
	}
	
	///Adding  S1, S2, S3, S4 and S5
	expandIcon.click();
	Thread.sleep(5000);
	
	if(testdata.get("valueofS1"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofS1' as there is no data in test data excel");
	}else{
		valueofS1.clear();
		Thread.sleep(1000);
		valueofS1.sendKeys(testdata.get("valueofS1"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofS1' = '"+testdata.get("valueofS1"+constants.i)+"'");
	}
	//Thread.sleep(3000);
	if(testdata.get("valueofS2"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofS2' as there is no data in test data excel");
	}else{
		valueofS2.clear();
		Thread.sleep(1000);
		valueofS2.sendKeys(testdata.get("valueofS2"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofS2' = '"+testdata.get("valueofS2"+constants.i)+"'");
	}
	
	if(testdata.get("valueofS3"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofS3' as there is no data in test data excel");
	}else{
		valueofS3.clear();
		Thread.sleep(1500);
		valueofS3.sendKeys(testdata.get("valueofS1"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofS3' = '"+testdata.get("valueofS3"+constants.i)+"'");
	}
	
	if(testdata.get("valueofS4"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofS4' as there is no data in test data excel");
	}else{
		valueofS4.clear();
		Thread.sleep(1000);
		valueofS4.sendKeys(testdata.get("valueofS4"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofS4' = '"+testdata.get("valueofS4"+constants.i)+"'");
	}
	
	if(testdata.get("valueofS5"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofS5' as there is no data in test data excel");
	}else{
		valueofS5.clear();
		Thread.sleep(1000);
		valueofS5.sendKeys(testdata.get("valueofS5"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofS5' = '"+testdata.get("valueofS5"+constants.i)+"'");
	}
	
	//click Schedule Request Button
	scheduleRequestButton.click();
	constants.test.log(LogStatus.PASS, "Clicked Schedule Request Button");
	
	//clicking submit (create SSR alert box)
	Thread.sleep(4000);
	createSSRSubmitButton.click();		
	constants.test.log(LogStatus.PASS, "Clicked Submit Button on the confirmation pop up for Create SSR dialog box");
	
	
	//Retrieving SSR id 
	Thread.sleep(4000);
	SSRid=schedulingRequestID.getText();
	constants.test.log(LogStatus.INFO, "Generated SSR ID='"+SSRid+"'");
	return SSRid;
	
	}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'ManualInquiry'
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForManualInquirySampleScheduleRequest(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	Thread.sleep(5000);
	//Switching to the iFrame. 
	CommonUtils.switchToStandardObjFrame(measureDropdown);
	
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
	
	//Audit Run Date will take current date.
	auditRunDate.clear();
	String auditRunDateData=lib.getCurrentDateInMMDDYYYFormat();
	System.out.println("auditRunDateData="+auditRunDate);
	auditRunDate.sendKeys(auditRunDateData);
	constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+auditRunDateData+"'");
	
	
	if(testdata.get("Sampling Method"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'Sampling Method' as there is no data in test data excel");
	}else{
		
		if(CommonUtils.selectDropdownValueByVisibleText(samplingMethodDropdown, testdata.get("Sampling Method"+constants.i))){
			constants.test.log(LogStatus.PASS, "'Sampling Method' = '"+testdata.get("Sampling Method"+constants.i)+"'");
		}else{
			constants.test.log(LogStatus.FAIL, "'Sampling Method' dropdown value '"+testdata.get("Sampling Method"+constants.i)+"' cannot be selected.");
		}
		
	}
	
	///Adding values
	expandIcon.click();
	
	Thread.sleep(5000);
	
	if(testdata.get("valueofCALLS"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofCALLS' as there is no data in test data excel");
	}else{
		valueofCALLS.clear();
		Thread.sleep(1000);
		valueofCALLS.sendKeys(testdata.get("valueofCALLS"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofCALLS' = '"+testdata.get("valueofCALLS"+constants.i)+"'");
	}

	if(testdata.get("valueofCORRESPONDENCE"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofCORRESPONDENCE' as there is no data in test data excel");
	}else{
		valueofCORRESPONDENCE.clear();
		Thread.sleep(1000);
		valueofCORRESPONDENCE.sendKeys(testdata.get("valueofCORRESPONDENCE"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofCORRESPONDENCE' = '"+testdata.get("valueofCORRESPONDENCE"+constants.i)+"'");
	}
	
	if(testdata.get("valueofWALKIN"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofWALKIN' as there is no data in test data excel");
	}else{
		valueofWALKIN.clear();
		Thread.sleep(1000);
		valueofWALKIN.sendKeys(testdata.get("valueofWALKIN"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofWALKIN' = '"+testdata.get("valueofWALKIN"+constants.i)+"'");
	}
	
	if(testdata.get("valueofCHATS"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofCHATS' as there is no data in test data excel");
	}else{
		valueofCHATS.clear();
		Thread.sleep(1000);
		valueofCHATS.sendKeys(testdata.get("valueofCHATS"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofCHATS' = '"+testdata.get("valueofCHATS"+constants.i)+"'");
	}

	//click Schedule Request Button
	scheduleRequestButton.click();
	constants.test.log(LogStatus.PASS, "Clicked Schedule Request Button");
	
	//clicking submit (create SSR alert box)
	Thread.sleep(4000);
	createSSRSubmitButton.click();		
	constants.test.log(LogStatus.PASS, "Clicked Submit Button on the confirmation pop up for Create SSR dialog box");
	
	
	//Retrieving SSR id 
	Thread.sleep(4000);
	SSRid=schedulingRequestID.getText();
	constants.test.log(LogStatus.INFO, "Generated SSR ID='"+SSRid+"'");
	return SSRid;
	
	}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Self Service Inquiry'
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForSelfServiceInquirySampleScheduleRequest(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	Thread.sleep(5000);
	//Switching to the iFrame. 
	CommonUtils.switchToStandardObjFrame(measureDropdown);
	
	//Enter Data for Self service inquiry 
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
	
	//Audit Run Date will take current date.
	auditRunDate.clear();
	String auditRunDateData=lib.getCurrentDateInMMDDYYYFormat();
	System.out.println("auditRunDateData="+auditRunDate);
	auditRunDate.sendKeys(auditRunDateData);
	constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+auditRunDateData+"'");
	
	
	if(testdata.get("Sampling Method"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'Sampling Method' as there is no data in test data excel");
	}else{
		
		if(CommonUtils.selectDropdownValueByVisibleText(samplingMethodDropdown, testdata.get("Sampling Method"+constants.i))){
			constants.test.log(LogStatus.PASS, "'Sampling Method' = '"+testdata.get("Sampling Method"+constants.i)+"'");
		}else{
			constants.test.log(LogStatus.FAIL, "'Sampling Method' dropdown value '"+testdata.get("Sampling Method"+constants.i)+"' cannot be selected.");
		}
		
	}
	
	///Adding  Values 
	expandIcon.click();
	Thread.sleep(5000);
	
	if(testdata.get("valueofMEMBERPORTALS"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofMEMBERPORTALS' as there is no data in test data excel");
	}else{
		valueofMEMBERPORTALS.clear();
		Thread.sleep(1000);
		valueofMEMBERPORTALS.sendKeys(testdata.get("valueofMEMBERPORTALS"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofMEMBERPORTALS' = '"+testdata.get("valueofMEMBERPORTALS"+constants.i)+"'");
	}

	if(testdata.get("valueofPROVIDERPORTALS"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofPROVIDERPORTALS' as there is no data in test data excel");
	}else{
		valueofPROVIDERPORTALS.clear();
		Thread.sleep(1000);
		valueofPROVIDERPORTALS.sendKeys(testdata.get("valueofPROVIDERPORTALS"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofPROVIDERPORTALS' = '"+testdata.get("valueofPROVIDERPORTALS"+constants.i)+"'");
	}
	
	if(testdata.get("valueofBX"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofBX' as there is no data in test data excel");
	}else{
		valueofBX.clear();
		Thread.sleep(1000);
		valueofBX.sendKeys(testdata.get("valueofBX"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofBX' = '"+testdata.get("valueofBX"+constants.i)+"'");
	}
	
	if(testdata.get("valueofHWS"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofHWS' as there is no data in test data excel");
	}else{
		valueofHWS.clear();
		Thread.sleep(1000);
		valueofHWS.sendKeys(testdata.get("valueofHWS"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofHWS' = '"+testdata.get("valueofHWS"+constants.i)+"'");
	}
	
	if(testdata.get("valueofEIVRMEMBER"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofEIVRMEMBER' as there is no data in test data excel");
	}else{
		valueofEIVRMEMBER.clear();
		Thread.sleep(1000);
		valueofEIVRMEMBER.sendKeys(testdata.get("valueofEIVRMEMBER"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofEIVRMEMBER' = '"+testdata.get("valueofEIVRMEMBER"+constants.i)+"'");
	}
	
	if(testdata.get("valueofEIVRPROVIDER"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'valueofEIVRPROVIDER' as there is no data in test data excel");
	}else{
		valueofEIVRPROVIDER.clear();
		Thread.sleep(1000);
		valueofEIVRPROVIDER.sendKeys(testdata.get("valueofEIVRPROVIDER"+constants.i));
		constants.test.log(LogStatus.PASS, "'valueofEIVRPROVIDER' = '"+testdata.get("valueofEIVRPROVIDER"+constants.i)+"'");
	}

	//click Schedule Request Button
	scheduleRequestButton.click();
	constants.test.log(LogStatus.PASS, "Clicked Schedule Request Button");
	
	//clicking submit (create SSR alert box)
	Thread.sleep(4000);
	createSSRSubmitButton.click();		
	constants.test.log(LogStatus.PASS, "Clicked Submit Button on the confirmation pop up for Create SSR dialog box");
	
	
	//Retrieving SSR id 
	Thread.sleep(4000);
	SSRid=schedulingRequestID.getText();
	constants.test.log(LogStatus.INFO, "Generated SSR ID='"+SSRid+"'");
	return SSRid;
	
	}


/**
 * Author :- Manjula Nath
 * Description :- This method is used for entering Data in the Schedule Request Page with Measure Dropdown value is 'Enrollment' 
 * 					and run date is future date
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForEnrollmentFutureDateSampleScheduleRequest(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	
	//Switching to the iFrame. 
	CommonUtils.switchToStandardObjFrame(measureDropdown);
	
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
	//audit run date fetching from excel
	if(testdata.get("Audit Run Date"+constants.i).isEmpty())
	{
		constants.test.log(LogStatus.INFO, "No data entered for 'Audit Run Date' as there is no data in test data excel");
	}
	else
	{
		auditRunDate.clear();
		String auditRunDateData1=lib.getCurrentDateInMMDDYYYFormat();
		System.out.println("auditRunDateData="+auditRunDateData1);
		String auditRunDateData2 = testdata.get("Audit Run Date"+constants.i);
		System.out.println("auditRunDateData2="+auditRunDateData2);
		
		Date userdata = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).parse(auditRunDateData1);
		Date currdate = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).parse(auditRunDateData2);
		
		if (userdata.compareTo(currdate) > 0) 
		{
            System.out.println("Current date is greater");
            constants.test.log(LogStatus.FAIL, "Current date is greater than user input");
        }
		else if (userdata.compareTo(currdate) == 0) 
		{
            System.out.println("Current date is same");
            auditRunDate.sendKeys(testdata.get("Audit Run Date"+constants.i));
    		constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+testdata.get("Audit Run Date"+constants.i)+"'");
        }
		else if (userdata.compareTo(currdate) < 0) 
		{
			System.out.println("Current date is greater");
			auditRunDate.sendKeys(testdata.get("Audit Run Date"+constants.i));
			constants.test.log(LogStatus.PASS, "'Audit Run Date' = '"+testdata.get("Audit Run Date"+constants.i)+"'");
		}

	}
	
	if(testdata.get("Sampling Method"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'Sampling Method' as there is no data in test data excel");
	}else{
		
		if(CommonUtils.selectDropdownValueByVisibleText(samplingMethodDropdown, testdata.get("Sampling Method"+constants.i))){
			constants.test.log(LogStatus.PASS, "'Sampling Method' = '"+testdata.get("Sampling Method"+constants.i)+"'");
		}else{
			constants.test.log(LogStatus.FAIL, "'Sampling Method' dropdown value '"+testdata.get("Sampling Method"+constants.i)+"' cannot be selected.");
		}
	}
	
	if(testdata.get("Total Sample Count"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'Total Sample Count' as there is no data in test data excel");
	}else{
		totalSampleCount.clear();
		totalSampleCount.sendKeys(testdata.get("Total Sample Count"+constants.i));
		constants.test.log(LogStatus.PASS, "'Total Sample Count' = '"+testdata.get("Total Sample Count"+constants.i)+"'");
	}
	
	//click Schedule Request Button
	scheduleRequestButton.click();
	constants.test.log(LogStatus.PASS, "Clicked Schedule Request Button");
	
	//clicking submit (create SSR alert box)
	Thread.sleep(4000);
	createSSRSubmitButton.click();		
	constants.test.log(LogStatus.PASS, "Clicked Submit Button on the confirmation pop up for Create SSR dialog box");
	
	
	//Retrieving SSR id 
	Thread.sleep(4000);
	SSRid=schedulingRequestID.getText();
	constants.test.log(LogStatus.INFO, "Generated SSR ID='"+SSRid+"'");
	return SSRid;
	
}


}
