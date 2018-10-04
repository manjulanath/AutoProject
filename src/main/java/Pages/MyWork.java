package Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base;
import Util.CommonUtils;
import Util.constants;
import Util.lib;

/**
 * @author Manjula
 * Description :- This Class will contain all the web elements and methods related to iAudit application 'MyWork' page.
 *
 */
public class MyWork extends Base{
	
	@FindBy(xpath="//h3[text()='Welcome to iAudit']/following::a[1]")
	WebElement welcomeIAuditCloseIcon;
	
	@FindBy(xpath="//div[text()='Case ID']")
	WebElement CaseID;
	
	@FindBy(xpath = "//a[@title='Next Page']")
	WebElement NextIcon;
	
	@FindBy(xpath = "//*[text()='Actions']")
	WebElement AButton;
	
	@FindBy(xpath = "//*[text()='Close']")
	WebElement CloseButton;
	
	@FindBy(xpath = "//*[text()='Refresh']")
	WebElement Refresh;
	
	@FindBy(xpath = "//*[text()='Mark As Complete']")
	WebElement MarkAsComplete;
	
	@FindBy(xpath = "//*[text()='Create RFI']")
	WebElement CreateRFI;
	
	@FindBy(xpath = "//*[text()='Create Discrepancy']")
	WebElement CreateDiscrepancy;

	@FindBy(xpath = "//h2[text()='Checklist']")
	WebElement Checklist;
	
	@FindBy(xpath = "(//*[text()='Cancel'])[2]")
	WebElement CancelButton;
	
	@FindBy(xpath = "(//*[text()='Save'])[2]")
	WebElement SaveButton;	
	
	@FindBy(xpath = "(//*[text()='Submit'])")
	WebElement SubmitButton;
	
	@FindBy(xpath = "//h2[text()='Enrollment Accuracy']")
	WebElement EnrollmentAccuracyOpenClose;
	
	@FindBy(xpath = "//h2[text()='Benefit']")
	WebElement BenefitOpenClose;
	
	@FindBy(xpath = "//h2[text()='COBRA Communication Process']")
	WebElement CobraCommunicationProcessOpenClose;
	
	@FindBy(xpath = "//h2[text()='Dependent Information']")
	WebElement DependentInformationOpenClose;
	
	@FindBy(xpath = "//h2[text()='Direct Pay']")
	WebElement DirectPayOpenClose;
	
	@FindBy(xpath = "//h2[text()='Group Information']")
	WebElement GroupInformationOpenClose;
	
	@FindBy(xpath = "//h2[text()='ID Card Process']")
	WebElement IDCardProcessOpenClose;
	
	@FindBy(xpath = "//h2[text()='Product']")
	WebElement ProductOpenClose;
	
	@FindBy(xpath = "//h2[text()='Subscriber Demographic']")
	WebElement SubscriberDemographicOpenClose;
	
	@FindBy(xpath = "//h2[text()='Claims Accuracy']")
	WebElement ClaimsAccuracyOpenClose;
	
	@FindBy(xpath = "//h2[text()='Claim Submission']")
	WebElement ClaimSubmissionOpenClose;
	
	@FindBy(xpath = "//h2[text()='Payment']")
	WebElement PaymentOpenClose;
	
	@FindBy(xpath = "//h2[text()='Pricing']")
	WebElement PricingOpenClose;
	
	@FindBy(xpath = "//h2[text()='Provider Contract']")
	WebElement ProviderContractOpenClose;
	
	@FindBy(xpath = "//h2[text()='Visible on EOB']")
	WebElement VisibleonEOBOpenClose;
	
	@FindBy(xpath = "//h2[text()='Self-Service Inquiry Accuracy']")
	WebElement SelfServiceInquiryAccuracyOpenClose;
	
	@FindBy(xpath = "//h2[text()='Benefit Transaction Accuracy']")
	WebElement BenefitTransactionAccuracyOpenClose;
	
	@FindBy(xpath = "//h2[text()='Claims Transaction Accuracy']")
	WebElement ClaimsTransactionAccuracyOpenClose;
	
	@FindBy(xpath = "//h2[text()='Eligibility Transaction Accuracy']")
	WebElement EligibilityTransactionAccuracyOpenClose;
	
	@FindBy(xpath = "//h2[text()='Transaction Demographic Information']")
	WebElement TransactionDemographicInformationOpenClose;
	
	@FindBy(xpath = "//a[contains(text(),'DIS-')]")
	WebElement DISCreate;
	
	public MyWork(){
		PageFactory.initElements(driver, this);
	}

	
/**
 * Author :- Manjula
 * Description :- Select Audit Case from list of cases
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForSelectingAuditCase(HashMap<String , String> testdata) throws Exception{
		
		String SSRid="";
		
		//Switching to the iFrame. 
		CommonUtils.switchToStandardObjFrame(CaseID);
				
		//Enter Data for Audit 
		if(testdata.get("AuditCase"+constants.i).isEmpty()){
			constants.test.log(LogStatus.INFO, "No data entered for 'AuditCase' as there is no data in test data excel");
	
		}
		
		String AuditNo = testdata.get("AuditCase"+constants.i);
		System.out.println(AuditNo);
		
		boolean result = false;
		while(result != true)
		{
		for(int a = 1; a<=10; a++)
		{
			Thread.sleep(2000);
			WebElement auditpath = driver.findElement(By.xpath("//div[text()='Case ID']/following::tr["+a+"]/td[2]/descendant::a[1]"));
			String audit = auditpath.getText();
			//System.out.println(audit);
			if(audit.equals(AuditNo))
			{
				//Thread.sleep(3000);
				System.out.println("Audit case is selcted");
				auditpath.click();
				constants.test.log(LogStatus.PASS, "Audit case is selcted");
				result = true;
				break;
			}
			else if(a==10)
			{
				Thread.sleep(7000);
				NextIcon.click();
				break;
			}
		}
		
		}
		constants.test.log(LogStatus.PASS, "Proceeded to Next");
		return SSRid;
		
	}

/**
 * Author :- Manjula
 * Description :- Validating Action drop down present in this page
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String actiondropdownlistvalidation(HashMap<String , String> testdata) throws Exception{
		
		String SSRid="";
		
		//Switching to the iFrame. 
		Thread.sleep(3000);
		CommonUtils.switchToStandardObjFrame(AButton);
		constants.test.log(LogStatus.PASS, "Frame is changed and currently in Action button");
		
		AButton.click();
		Thread.sleep(3000);
		
		if(Refresh.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Refresh is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Refresh is not present");
		}
		
		if(MarkAsComplete.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Mark as completed is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Mark as completed is not present");
		}
		
		if(CreateRFI.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Create RFI is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Create RFI is not present");
		}
		
		
		if(CreateDiscrepancy.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Create Discrepancy is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Create Discrepancy is not present");
		}
						return SSRid;
		
	}
/**
* Author :- Manjula
 * Description :- Create discrepancy and validate sections and buttons
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String createDiscrepancyAndvalidatesections(HashMap<String , String> testdata) throws Exception{
		
		String SSRid="";

		//Click Create Discrepancy
		CreateDiscrepancy.click();
		constants.test.log(LogStatus.PASS, "Create Discrepancy is clicked");
		Thread.sleep(3000);
		if(CreateDiscrepancy.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Create Discrepancy section is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Create Discrepancy section is not present");
		}
		
		if(Checklist.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Checklist section is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Checklist section is not present");
		}
		
		if(CancelButton.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Cancel Button is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Cancel Button is not present");
		}
		if(SaveButton.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Save Button is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Save Button is not present");
		}
		
		if(SubmitButton.isDisplayed())
		{
			constants.test.log(LogStatus.PASS, "Submit Button is present");
		}
		else{
			constants.test.log(LogStatus.INFO, "Submit Button is not present");
		}
		
			
		return SSRid;
	}

/**
 * Author :- Manjula
 * Description :- Cancel Create discrepancy
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String cancelCreateDiscrepancy(HashMap<String , String> testdata) throws Exception{
			
			String SSRid="";

			//Click cancel button
			CancelButton.click();
			constants.test.log(LogStatus.PASS, "Cancel Button is clicked");
			Thread.sleep(5000);
			
			/*
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			 */
			/*
			if(driver.findElement(By.xpath("//*[text()='Create Discrepancy']"))!= null){
				System.out.println("Element is Present");
				constants.test.log(LogStatus.FAIL, "Section is present");
				}else{
				System.out.println("Element is Absent");
				constants.test.log(LogStatus.PASS, "Section is not present");
				}
			*/
			/*
			if(CreateDiscrepancy.isDisplayed())
			{
				constants.test.log(LogStatus.PASS, "Create Discrepancy section is present");
				constants.test.log(LogStatus.FAIL, "Cancel is not successful");
			}
			else{
				constants.test.log(LogStatus.INFO, "Create Discrepancy section is not present");
				constants.test.log(LogStatus.FAIL, "Cancel is successful");
			}
			*/
			return SSRid;
		}

/**
 * Author :- Manjula
 * Description :- Save and submit discrepancy section and submit and validate that DIS case is created for CLAIM
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForUpdateSaveAndSubmitAuditCaseCLAIM(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	Thread.sleep(2000);
	Checklist.click();
	System.out.println("Open close button clicked for checklist for Claim");
	Thread.sleep(2000);
	
	ClaimSubmissionOpenClose.click();
	System.out.println("Open close button clicked for Claim Submission");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[1]")).click();
//	System.out.println("Selected 1");
	Thread.sleep(2000);
	
	PaymentOpenClose.click();
	System.out.println("Open close button clicked for Payment");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[2]")).click();
//	System.out.println("Selected 2");
//	Thread.sleep(2000);
	
	PricingOpenClose.click();
	System.out.println("Open close button clicked for Pricing");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[3]")).click();
//	System.out.println("Selected 3");
//	Thread.sleep(2000);
	
	ProviderContractOpenClose.click();
	System.out.println("Open close button clicked for Provider Contract");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[4]")).click();
//	System.out.println("Selected 4");
//	Thread.sleep(2000);
	
	
	
	VisibleonEOBOpenClose.click();
	System.out.println("Open close button clicked for Visible on EOB");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[5]")).click();
//	System.out.println("Selected 5");
//	Thread.sleep(2000);
	
	Thread.sleep(3000);
	SaveButton.click();
	System.out.println("Save button clicked");
	Thread.sleep(2000);
	
	SubmitButton.click();
	System.out.println("Submit button clicked");
	Thread.sleep(5000);
	
	if(DISCreate.isDisplayed())
	{
		System.out.println("DISCreate is present");

		//int iCount = 0;
		int iCount = driver.findElements(By.xpath("DISCreate")).size();
		//
		//constants.test.log(LogStatus.PASS, "'"+iCount+"'DISCreate is present");
		constants.test.log(LogStatus.PASS, "DISCreate is created");

	}
	else{
		constants.test.log(LogStatus.INFO, "DISCreate is not present");
	}
	constants.test.log(LogStatus.PASS, "Proceeded to Next");
	CloseButton.click();
	return SSRid;
	
}


/**
 * Author :- Manjula
 * Description :- Save and submit discrepancy section and submit and validate that DIS case is created for Enrollment
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForUpdateSaveAndSubmitAuditCaseENROLLMENT(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	Thread.sleep(2000);
	Checklist.click();
	System.out.println("Open close button clicked for checklist for Enrollment");
	Thread.sleep(2000);
	
	BenefitOpenClose.click();
	System.out.println("Open close button clicked for Benefit");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[1]")).click();
//	System.out.println("Selected 1");
	Thread.sleep(2000);
	
	CobraCommunicationProcessOpenClose.click();
	System.out.println("Open close button clicked for Cobra Communication Process");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[2]")).click();
//	System.out.println("Selected 2");
//	Thread.sleep(2000);
	
	DependentInformationOpenClose.click();
	System.out.println("Open close button clicked for Dependent Information");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[3]")).click();
//	System.out.println("Selected 3");
//	Thread.sleep(2000);
	
	DirectPayOpenClose.click();
	System.out.println("Open close button clicked for Direct Pay");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[4]")).click();
//	System.out.println("Selected 4");
//	Thread.sleep(2000);
	
	GroupInformationOpenClose.click();
	System.out.println("Open close button clicked for Group Information");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[5]")).click();
//	System.out.println("Selected 5");
//	Thread.sleep(2000);
	
	IDCardProcessOpenClose.click();
	System.out.println("Open close button clicked for ID Card Process");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[6]")).click();
//	System.out.println("Selected 5");
//	Thread.sleep(2000);
	
	ProductOpenClose.click();
	System.out.println("Open close button clicked for Product");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[7]")).click();
//	System.out.println("Selected 5");
//	Thread.sleep(2000);
	
	SubscriberDemographicOpenClose.click();
	System.out.println("Open close button clicked for Subscriber Demographic");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[8]")).click();
//	System.out.println("Selected 5");
//	Thread.sleep(2000);
	
	Thread.sleep(3000);
	SaveButton.click();
	System.out.println("Save button clicked");
	Thread.sleep(2000);
	
	SubmitButton.click();
	System.out.println("Submit button clicked");
	Thread.sleep(5000);
	
	if(DISCreate.isDisplayed())
	{
		System.out.println("DISCreate is present");

		//int iCount = 0;
		int iCount = driver.findElements(By.xpath("DISCreate")).size();
		//
		//constants.test.log(LogStatus.PASS, "'"+iCount+"' DISCreate is present");
		constants.test.log(LogStatus.PASS, "DISCreate is created");

	}
	else{
		constants.test.log(LogStatus.INFO, "DISCreate is not present");
	}
	constants.test.log(LogStatus.PASS, "Proceeded to Next");
	
	CloseButton.click();
	return SSRid;
	
}


/**
 * Author :- Manjula
 * Description :- Save and submit discrepancy section and submit and validate that DIS case is created for Self Service Inquiry
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForUpdateSaveAndSubmitAuditCaseSelfServiceInquiry(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	Thread.sleep(2000);
	Checklist.click();
	System.out.println("Open close button clicked for checklist for Self Service Inquiry");
	Thread.sleep(2000);
	
	BenefitTransactionAccuracyOpenClose.click();
	System.out.println("Open close button clicked for Benefit Transaction Accuracy");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[1]")).click();
//	System.out.println("Selected 1");
	Thread.sleep(2000);
	
	ClaimsTransactionAccuracyOpenClose.click();
	System.out.println("Open close button clicked for Claims Transaction Accuracy");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[2]")).click();
//	System.out.println("Selected 2");
//	Thread.sleep(2000);
	
	EligibilityTransactionAccuracyOpenClose.click();
	System.out.println("Open close button clicked for Eligibility Transaction Accuracy");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[3]")).click();
//	System.out.println("Selected 3");
//	Thread.sleep(2000);
	
	TransactionDemographicInformationOpenClose.click();
	System.out.println("Open close button clicked for Transaction Demographic Information");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[4]")).click();
//	System.out.println("Selected 4");
//	Thread.sleep(2000);
		
	Thread.sleep(3000);
	SaveButton.click();
	System.out.println("Save button clicked");
	Thread.sleep(2000);
	
	SubmitButton.click();
	System.out.println("Submit button clicked");
	Thread.sleep(5000);
	
	if(DISCreate.isDisplayed())
	{
		System.out.println("DISCreate is present");

		//int iCount = 0;
		int iCount = driver.findElements(By.xpath("DISCreate")).size();
		//
		//constants.test.log(LogStatus.PASS, "'"+iCount+"' DISCreate is present");
		constants.test.log(LogStatus.PASS, "DISCreate is created");

	}
	else{
		constants.test.log(LogStatus.INFO, "DISCreate is not present");
	}
	constants.test.log(LogStatus.PASS, "Proceeded to Next");
	
	CloseButton.click();
	return SSRid;
	
}


/**
 * Author :- Manjula
 * Description :- Save and submit discrepancy section and submit and validate that DIS case is created for ManualInquiry
 * @param testdata :- This method needs Test Data. User needs to pass data from main test case.
 * @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
 * @throws Exception
 */
public String dataEntryForUpdateSaveAndSubmitAuditCaseManualInquiry(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	Thread.sleep(2000);
	Checklist.click();
	System.out.println("Open close button clicked for checklist for Self Service Inquiry");
	Thread.sleep(2000);
	
	BenefitTransactionAccuracyOpenClose.click();
	System.out.println("Open close button clicked for Benefit Transaction Accuracy");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[1]")).click();
//	System.out.println("Selected 1");
	Thread.sleep(2000);
	
	ClaimsTransactionAccuracyOpenClose.click();
	System.out.println("Open close button clicked for Claims Transaction Accuracy");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[2]")).click();
//	System.out.println("Selected 2");
//	Thread.sleep(2000);
	
	EligibilityTransactionAccuracyOpenClose.click();
	System.out.println("Open close button clicked for Eligibility Transaction Accuracy");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[3]")).click();
//	System.out.println("Selected 3");
//	Thread.sleep(2000);
	
	TransactionDemographicInformationOpenClose.click();
	System.out.println("Open close button clicked for Transaction Demographic Information");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//label[@for='AuditParamAnswerYes_ri_1'])[4]")).click();
//	System.out.println("Selected 4");
//	Thread.sleep(2000);
		
	Thread.sleep(3000);
	SaveButton.click();
	System.out.println("Save button clicked");
	Thread.sleep(2000);
	
	SubmitButton.click();
	System.out.println("Submit button clicked");
	Thread.sleep(5000);
	
	if(DISCreate.isDisplayed())
	{
		System.out.println("DISCreate is present");

		//int iCount = 0;
		int iCount = driver.findElements(By.xpath("DISCreate")).size();
		//
		//constants.test.log(LogStatus.PASS, "'"+iCount+"' DISCreate is present");
		constants.test.log(LogStatus.PASS, "DISCreate is created");

	}
	else{
		constants.test.log(LogStatus.INFO, "DISCreate is not present");
	}
	constants.test.log(LogStatus.PASS, "Proceeded to Next");
	
	CloseButton.click();
	return SSRid;
	
}



}
