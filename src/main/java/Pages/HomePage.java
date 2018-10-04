package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Base.Base;
import Util.constants;
import Util.lib;

/**
 * @author Arnab
 * Description :- This Class will contain all the web elements and methods related to iAudit application 'Home' page.
 *
 */
public class HomePage extends Base{
	
	@FindBy(xpath="//h3[text()='Welcome to iAudit']/following::a[1]")
	WebElement welcomeIAuditCloseIcon;
	
	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement dashboard;
	
	//@FindBy(xpath="//span[@class='menu-item-title' and text()='My Team']")
	@FindBy(xpath= "(//span[@class='menu-item-icon-imageclass pi pi-users'])[1]")
	WebElement myTeam;
	
	@FindBy(xpath="//span[text()='Case Search']")
	WebElement caseSearch;
	
//	@FindBy(xpath="//span[text()='Sample Schedule Request']")
//	WebElement sampleScheduleRequest;
	
	@FindBy(xpath= ".//span[@class='menu-item-icon-imageclass pi pi-eye']")
	WebElement sampleScheduleRequestIcon;
	
	@FindBy(xpath=".//*[@id='RULE_KEY']")
	WebElement Logosection;
	
	@FindBy(xpath= ".//span[@class='menu-item-icon-imageclass pi pi-flag']")
	WebElement MyWorkIcon;
	
	@FindBy(xpath="//*[@title='Pega logo']/following::img[2]")
    WebElement OperatorImage;
    
    @FindBy(xpath="//span[text()='Log off']")
    WebElement LogOff;  
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Author :- Arnab
	 * Description :- This Method closes the iAudit welcome screen.
	 */
	public void welocmeToIAuditCloseDialoge(){
		try{
			Thread.sleep(4000);
			if(welcomeIAuditCloseIcon.isDisplayed()){
				welcomeIAuditCloseIcon.click();
				constants.test.log(LogStatus.PASS, "Closing the Welcome Screen");
				
			}else{
				constants.test.log(LogStatus.INFO, "Welcome Screen is not displayed");
				lib.takeScreenshot();				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Author :- Arnab
	 * Modifier :-Manjula
	 * Description :- This method will navigate to sample schedule request.	 * 
	 * @return :- Returns the object of the next page.
	 * @throws Exception
	 */
	public SampleScheduleRequest navigateToSampleScheduleRequest() throws Exception{
	 
		sampleScheduleRequestIcon.click();
		//caseSearch.click();
		Actions builder = new Actions(driver);
	    Action mouseOverHome = builder.moveToElement(Logosection).build();
	    mouseOverHome.perform();
		constants.test.log(LogStatus.PASS, "Clicked 'Sample Schedule Request' to Navigate to Sample Schedule Request page.");
		return new SampleScheduleRequest();
	}
	
/**
* Author :- Manjula Nath
* Description :- This method will navigate to My Work Page.
* @return 
* @return :- Returns the object of the next page.
* @throws Exception
*/
	public MyWork navigateToMyWork() throws Exception{
	 
		MyWorkIcon.click();
		//caseSearch.click();
		Actions builder = new Actions(driver);
	    Action mouseOverHome = builder.moveToElement(Logosection).build();
	    mouseOverHome.perform();
		constants.test.log(LogStatus.PASS, "Clicked 'My work' to Navigate to My work page.");
		return new MyWork();
	}

/**
* Author :- Manjula Nath
* Description :- This method will navigate to My Work Page.
* @return 
* @return :- Returns the object of the next page.
* @throws Exception
*/
	public MyWork navigateToMyTeam() throws Exception{
	 
		System.out.println("A");
		myTeam.click();
		//caseSearch.click();
		Actions builder = new Actions(driver);
	    Action mouseOverHome = builder.moveToElement(Logosection).build();
	    mouseOverHome.perform();
		constants.test.log(LogStatus.PASS, "Clicked 'My Team' to Navigate to My Team page.");
		return new MyWork();
	}

	

/**
 * Author :-  Manjula
 * Description :- This method is used to logout to the iAudit Application
 * @param NULL
 * @return :- It returns object of the next page
 */
public void logoff() throws Exception{
       
       try{
              Thread.sleep(5000);
              driver.switchTo().defaultContent();
              
              if(OperatorImage.isDisplayed()){
                    // System.out.println("OperatorImage");
                     OperatorImage.click();
                     //System.out.println("OperatorImage Clicked");
                     Thread.sleep(4000);
                     LogOff.click();
                                          
                     constants.test.log(LogStatus.PASS, "System is Logged Off ");
                  //   lib.takeScreenshot();
                     
              }else{
                     constants.test.log(LogStatus.INFO, "System is not Logged Off ");
                     lib.takeScreenshot();                           
              }
              
       }catch(Exception e)
       {
              e.printStackTrace();
       }
}
	
}
