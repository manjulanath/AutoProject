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
 * Description :- This Class will contain all the web elements and methods related to iAudit application 'My Team' page.
 *
 */
public class MyTeam extends Base{
	
	@FindBy(xpath="//span[text()='My Team']")
	WebElement MyTeam;
	
	@FindBy(xpath="//h2[text()='My Workbasket(s)']")
	WebElement MyWorkbasketLink;
	
	@FindBy(xpath="//h2[text()='Team members']")
	WebElement TeammembersLink;
	
	@FindBy(xpath = "//a[@title='Next Page']")
	WebElement NextIcon;

	@FindBy(xpath="//span[text()='HCiAuditReviewerWB']")
	WebElement WorkbasketReviewer;
	
	@FindBy(xpath="//span[text()='HCiAuditErrorApproverWB']")
	WebElement WorkbasketErrorApprover;
	
	@FindBy(xpath = "//*[text()='Actions']")
	WebElement AButton;	
	
	@FindBy(xpath = "//*[text()='Approval']")
	WebElement Approval;
	
	@FindBy(xpath = "(//*[text()='Reject'])")
	WebElement RejectButton;
	
	@FindBy(xpath = "(//*[text()='Approve'])")
	WebElement ApproveButton;
	
	@FindBy(xpath = "(//*[text()='Cancel'])[2]")
	WebElement CancelButton;
	
	@FindBy(xpath = "//*[@id='pyNote']")
	WebElement Note;
	
	@FindBy(xpath = "//a[@class='ellipsis']")
	WebElement Status;
	
	@FindBy(xpath = "//*[text()='Close']")
	WebElement CloseButton;
	
	public MyTeam(){
		PageFactory.initElements(driver, this);
	}
	
/**
 * Author :- Manjula
 * Description :- Validate links
 * @param testdata :- NULL
 * @return :- NULL
 * @throws Exception
 */
public String validateLinks(HashMap<String , String> testdata) throws Exception
{
		String SSRid="";
		CommonUtils.switchToStandardObjFrame(MyTeam);
	try{
		Thread.sleep(2000);
		if(MyWorkbasketLink.isDisplayed()){
			constants.test.log(LogStatus.PASS, "My Workbasket Link is present");
			
		}else{
			constants.test.log(LogStatus.INFO, "My Workbasket Link is not present");
			lib.takeScreenshot();				
		}

		if(TeammembersLink.isDisplayed()){
			constants.test.log(LogStatus.PASS, "Team members Link is present");
			
		}else{
			constants.test.log(LogStatus.INFO, "Team members Link is not present");
			lib.takeScreenshot();				
		}

	}catch(Exception e){
		e.printStackTrace();
	}
	return SSRid;
}

/**
* Author :- Manjula
* Description :- Click workbasket on Reviewer
* @param testdata :- NULL
* @return :- NULL
* @throws Exception
*/
public void clickWorkbasketReviewer(HashMap<String , String> testdata) throws Exception{
	
	WorkbasketReviewer.click();
	Thread.sleep(3000);
	constants.test.log(LogStatus.PASS, "Displaying all the cases in the selected work basket");
}

/**
* Author :- Manjula
* Description :- Click workbasket on Error Approver
* @param testdata :- NULL
* @return :- NULL
* @throws Exception
*/
public void clickWorkbasketErrorApprover(HashMap<String , String> testdata) throws Exception{
	
	Thread.sleep(3000);
	WorkbasketErrorApprover.click();
	Thread.sleep(3000);
	constants.test.log(LogStatus.PASS, "Displaying all the cases in the selected work basket");
}

/**
* Author :- Manjula
* Description :- Select DIS Case from list of cases
* @param testdata :- This method needs Test Data. User needs to pass data from main test case.
* @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
* @throws Exception
*/
public String dataEntryForSelectingCase(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	//Enter Data for Audit 
	if(testdata.get("Case"+constants.i).isEmpty()){
		constants.test.log(LogStatus.INFO, "No data entered for 'Case' as there is no data in test data excel");

	}
	
	String CaseNo = testdata.get("Case"+constants.i);
	System.out.println(CaseNo);
	
	boolean result = false;
	while(result != true)
	{
	for(int a = 1; a<=10; a++)
	{
		Thread.sleep(2000);
		WebElement auditpath = driver.findElement(By.xpath("//div[text()='Case ID']/following::tr["+a+"]/td[2]/descendant::a[1]"));
		String audit = auditpath.getText();
		System.out.println(audit);
		if(audit.equals(CaseNo))
		{
			//Thread.sleep(3000);
			System.out.println("Case is selcted");
			auditpath.click();
			constants.test.log(LogStatus.PASS, "Case is selcted");
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
* Description :- Cancel Approve Reject option
* @param testdata :- NULL
* @return :- NULL
* @throws Exception
*/
public void cancelApproveReject(HashMap<String , String> testdata) throws Exception{
	
	Thread.sleep(3000);
	CommonUtils.switchToStandardObjFrame(AButton);
	constants.test.log(LogStatus.PASS, "Frame is changed and currently in Action button");
	
	AButton.click();
	Thread.sleep(3000);
	if(Approval.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Approval option is present in action button");
		Approval.click();
		Thread.sleep(3000);
	}
	else{
		constants.test.log(LogStatus.INFO, "Approval option is not present in action button");
	}

	if(ApproveButton.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Approve button is present");
		//Thread.sleep(3000);
	}
	else{
		constants.test.log(LogStatus.INFO, "Approve button is not present");
	}
	
	if(RejectButton.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Reject button is present");
		//Thread.sleep(3000);
	}
	else{
		constants.test.log(LogStatus.INFO, "Reject button is not present");
	}
	
	if(Approval.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Approval section is present");
	}
	else{
		constants.test.log(LogStatus.INFO, "Approval section is not present");
	}
	
	
	if(CancelButton.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Cancel button is present");
		CancelButton.click();
		Thread.sleep(3000);
	}
	else{
		constants.test.log(LogStatus.INFO, "Cancel button is not present");
	}
	
}


/**
* Author :- Manjula
* Description :- DIS Case Approval 
* @param testdata :- This method needs Test Data. User needs to pass data from main test case.
* @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
* @throws Exception
*/
public String approvecase(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	
	Thread.sleep(3000);
	CommonUtils.switchToStandardObjFrame(AButton);
	constants.test.log(LogStatus.PASS, "Frame is changed and currently in Action button");
	
	AButton.click();
	Thread.sleep(3000);
	if(Approval.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Approval option is present in action button");
		Approval.click();
		Thread.sleep(3000);
	}
	else{
		constants.test.log(LogStatus.INFO, "Approval option is not present in action button");
	}

	if(ApproveButton.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Approve button is present");
	}
	else{
		constants.test.log(LogStatus.INFO, "Approve button is not present");
	}
	
	if(RejectButton.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Reject button is present");
	}
	else{
		constants.test.log(LogStatus.INFO, "Reject button is not present");
	}
	
	Note.clear();
	Thread.sleep(1000);
	Note.sendKeys("Approve");
	Thread.sleep(1000);
	
	ApproveButton.click();
	Thread.sleep(3000);
	
	String statustext = Status.getText();
	System.out.println(statustext);
	constants.test.log(LogStatus.PASS, "Status is: " +statustext);
	Thread.sleep(1000);
	CloseButton.click();
	
	constants.test.log(LogStatus.PASS, "Proceeded to Next");
	return SSRid;
	
}



/**
* Author :- Manjula
* Description :- DIS Case rejection 
* @param testdata :- This method needs Test Data. User needs to pass data from main test case.
* @return :- This Method will return the Schedule Request ID as String. User can used the id for later flow.
* @throws Exception
*/
public String rejectcase(HashMap<String , String> testdata) throws Exception{
	
	String SSRid="";
	
	Thread.sleep(3000);
	CommonUtils.switchToStandardObjFrame(AButton);
	constants.test.log(LogStatus.PASS, "Frame is changed and currently in Action button");
	
	AButton.click();
	Thread.sleep(3000);
	if(Approval.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Approval option is present in action button");
		Approval.click();
		Thread.sleep(3000);
	}
	else{
		constants.test.log(LogStatus.INFO, "Approval option is not present in action button");
	}

	if(ApproveButton.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Approve button is present");
	}
	else{
		constants.test.log(LogStatus.INFO, "Approve button is not present");
	}
	
	if(RejectButton.isDisplayed())
	{
		constants.test.log(LogStatus.PASS, "Reject button is present");
	}
	else{
		constants.test.log(LogStatus.INFO, "Reject button is not present");
	}
	
	Note.clear();
	Thread.sleep(1000);
	Note.sendKeys("Reject");
	Thread.sleep(1000);
	
	RejectButton.click();
	Thread.sleep(3000);
	
	String statustext = Status.getText();
	System.out.println(statustext);
	constants.test.log(LogStatus.PASS, "Status is: " +statustext);
	Thread.sleep(1000);
	CloseButton.click();
	
	constants.test.log(LogStatus.PASS, "Proceeded to Next");
	return SSRid;
	
}


}
