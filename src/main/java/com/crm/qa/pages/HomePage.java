package com.crm.qa.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	String Recording="Test Recorder";
	String GeneratedToken;

	
	@FindBy(xpath = "//span[normalize-space()='Services']")
	@CacheLookup
	WebElement Services;
	
	@FindBy(xpath = "//div[@class='name']")
	WebElement Username;

	@FindBy(xpath = "//span[normalize-space()='System Recordings']")
	WebElement SystemRecordings;
	
	@FindBy(xpath = "//button[normalize-space()='Upload Recording']")
	WebElement UploadRecording;
	

	@FindBy(xpath = "//input[@id='name']")
	WebElement RecordingFileName;

	@FindBy(xpath = "//label[@for='create_recording']")
	WebElement CreateRecording;
	
	@FindBy(xpath = "//button[@id='generate_recording']")
	WebElement Generate;
	
	@FindBy(xpath = "//textarea[@id='speechinput']")
	WebElement InputSpeechText;
	
	@FindBy(xpath = "//button[@id='saveandsubmitbtn']")
	WebElement SaveButton;

	@FindBy(xpath = "//td[normalize-space()='Mohit_Test_Recording']")
	WebElement CreatedRecording;

	@FindBy(xpath = "//i[normalize-space()='code']")
	WebElement accountApi;
	
	@FindBy(id = "generateToken")
	WebElement GenerateToken;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement TokenName;
	
	@FindBy(xpath = "//button[@id='addsave']")
	WebElement SaveeButton;
	
	@FindBy(xpath = "//a[normalize-space()='View']")
	WebElement ViewToken;
	
	@FindBy(xpath = "//textarea[@id='apiToken']")
	WebElement CopyToken;
	
	@FindBy(xpath = "//form[@id='api_token']//button[@type='button'][normalize-space()='CLOSE']")
	WebElement CloseToken;
	
	
	@FindBy(xpath = "//a[@title='Agent']")
	WebElement Agent;
	
	@FindBy(xpath = "//a[@title='/v1/agent']//span[@title='post'][normalize-space()='post']")
	WebElement ClickPost;
	
	@FindBy(xpath = "//input[@id='body-postv1agent_name']")
	WebElement EnterName;
	
	@FindBy(xpath = "//input[@id='body-postv1agent_follow_me_number']")
	WebElement Followmenumber;
	
	@FindBy(xpath = "//input[@id='header-postv1agent_Authorization']")
	WebElement AuthToken;
	
	@FindBy(xpath = "//div[@id='page-post_v1-agent']//span[contains(text(),'Try It')]")
	WebElement Tryit;
	
	@FindBy(xpath = "//div[@class='hub-reference-results-explorer code-sample']//span[@class='httpsuccess']")
	WebElement ResponseCode;
	
	@FindBy(xpath = "//span[normalize-space()='Auto-Attendant']")
	WebElement Autoattendent;
	
	@FindBy(xpath = "//a[normalize-space()='Add Auto-Attendant']")
	WebElement Autoattendentbutton;
		
	@FindBy(xpath = "//input[@id='name']")
	WebElement EnterNamee;
	
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement EnterDescrip;
	
	@FindBy(xpath = "//div[@id='recording_chosen']//a[@class='chosen-single']")
	WebElement ChooseRecoding;
	
	@FindBy(xpath = "//div[@id='recording_chosen']//input[@type='text']")
	WebElement EnterRecordinganme;
	
	@FindBy(xpath = "//span[normalize-space()='Agent 1']")
	WebElement ChooseDestination;
	
	@FindBy(xpath = "//div[@id='destination_chosen']//input[@type='text']")
	WebElement EnterDestination;
	
	@FindBy(xpath = "//button[normalize-space()='SAVE']")
	WebElement Save;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement SaveAlert;

	@FindBy(xpath = "//span[normalize-space()='My Numbers']")
	WebElement MyNumbers;
	
	@FindBy(xpath = "//button[normalize-space()='Select an Action']")
	WebElement SelectAction;
	
	@FindBy(xpath = "//tr[@class='odd']/td[contains(text(),'TestAutoAttendent')]")
	WebElement Odd;
	
	@FindBy(xpath = "//tr[@class='even']/td[contains(text(),'TestAutoAttendent')]")
	WebElement Even;
	
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	WebElement Edit;
	
	@FindBy(xpath = "//div[@id='did_destination_chosen']")
	WebElement Destination;
	
	@FindBy(xpath = "//div[@id='did_destination_chosen']//input[@type='text']")
	WebElement Autooattendent;
	
	@FindBy(xpath = "//button[normalize-space()='SAVE']")
	WebElement ClickSave;
	
	@FindBy(xpath = "//a[normalize-space()='TestAutoAttendent (Auto-Attendant)']")
	WebElement Verify;
	
	
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return Username.isDisplayed();
	}
	
	public void clickonSystemRecording(){	
		Services.click();
		SystemRecordings.click();
		
	}
	
	
	
	
	public void uploadRecording() throws InterruptedException{	
		UploadRecording.click();
		RecordingFileName.sendKeys(prop.getProperty("RecordingFileName"));
		TestUtil.WaitforWebElement(CreateRecording);		
		CreateRecording.click();
		InputSpeechText.sendKeys(prop.getProperty("RecordingFileName"));
		Generate.click();
		TestUtil.WaitforWebElement(SaveButton);		
		SaveButton.click();
	
	}
	
	public String verifyCreatedRecording(){
		TestUtil.WaitforWebElement(CreatedRecording);		
		return CreatedRecording.getText();
	}
	

	
	
	public String generateToken() throws InterruptedException  {
		String copy = Keys.chord(Keys.CONTROL,Keys.chord("c"));
		CopyToken.sendKeys(Keys.CONTROL+"a");
		CopyToken.sendKeys(copy);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		
		try {
			GeneratedToken = (String) contents.getTransferData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		CloseToken.click();
		return GeneratedToken;
	
	}
	
	
	
	public void clickonAccountApi(){	
		 Services.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",accountApi);	
	}
	
	public void clickonGenerateToken(){	
		GenerateToken.click();	
	}
	
	public void EnterTokenName(String Tokenname){	
		TokenName.clear();
		TokenName.sendKeys(Tokenname);
	}
	
	
	public void ClickOnSaveButton(){	
		TestUtil.WaitforWebElement(SaveeButton);	
		SaveeButton.click();
	}
	
	
	public void ClickOnViewToken(){	
		TestUtil.WaitforWebElement(ViewToken);	
		ViewToken.click();
	}
	
	
	public void GetPostURL(String URL) throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to(URL);		
	}
	
	public void clickonAgent(){	
		TestUtil.WaitforWebElement(Agent);	
		Agent.click();	
	}
	
	public void clickonPost(){	
		TestUtil.WaitforWebElement(ClickPost);	
		ClickPost.click();	
	}
	
	
	public void EnterAgentName(String agentName){	
		TestUtil.WaitforWebElement(EnterName);	
		EnterName.sendKeys(agentName);
	}
	
	
	public void EnterFollowmenumber(String followMeNumber){	
		TestUtil.WaitforWebElement(Followmenumber);	
		Followmenumber.sendKeys(followMeNumber);
	}
	
	
	public void EnterAuthToken(String Authtoken){	
		TestUtil.WaitforWebElement(AuthToken);	
		AuthToken.sendKeys(Authtoken);
	}
	
	
	public void ClickonTryit(){	
		TestUtil.WaitforWebElement(Tryit);	
		Tryit.click();
	}
	
	public String GetResponseCode(){
		TestUtil.WaitforWebElement(ResponseCode);		
		return ResponseCode.getText();

	}
	
	public void ClickonAutoattendent(){	
		Services.click();
		TestUtil.WaitforWebElement(Autoattendent);	
		Autoattendent.click();
	}
	
	public void ClickonAddAutoattendent(){	
		TestUtil.WaitforWebElement(Autoattendentbutton);	
		Autoattendentbutton.click();
	}
	
	
	public void EnterName(String EnterNam){	
		TestUtil.WaitforWebElement(EnterNamee);	
		EnterNamee.sendKeys(EnterNam);
	}
	
	public void EnterDescription(String EnterDesc){	
		TestUtil.WaitforWebElement(EnterDescrip);	
		EnterDescrip.sendKeys(EnterDesc);
	}
	
	public void ChooseRecording(String Recordingname){	
		TestUtil.WaitforWebElement(ChooseRecoding);	
		ChooseRecoding.click();
		TestUtil.WaitforWebElement(EnterRecordinganme);	
		EnterRecordinganme.sendKeys(Recordingname+Keys.ENTER);		
	}
	
	public void ChooseAgent(String AgentName){	
		TestUtil.WaitforWebElement(ChooseDestination);	
		ChooseDestination.click();
		TestUtil.WaitforWebElement(EnterDestination);	
		EnterDestination.sendKeys(AgentName+Keys.ENTER);		
	}
	
	
	public void ClickonSave(){	
		TestUtil.WaitforWebElement(Save);	
		Save.click();
	}
	
	public String VerifyCreatedAutoattendent(){
		String text = null;
		if(Odd.isDisplayed()) {
			
			text= Odd.getText();
		}else if (Even.isDisplayed()) {
			 text= Even.getText();
		}else {
			
			System.out.println("Autoattendent is not availabe");
		}
		return text;

	}
	
	
	
	public void ClickonMyNumber(){	
		Services.click();
		TestUtil.WaitforWebElement(MyNumbers);	
		MyNumbers.click();
	}
	
	
	public void SelectAction(){	
		TestUtil.WaitforWebElement(SelectAction);	
		SelectAction.click();
	}
	
	
	public void clickOnEdit(){
		TestUtil.WaitforWebElement(Edit);	
		Edit.click();
	}
	
	public void clickOnDestination(){
		TestUtil.WaitforWebElement(Destination);	
		Destination.click();
	}

	public void EnterAutoattendent(String Attendentname) {
		TestUtil.WaitforWebElement(Autooattendent);	
	Autooattendent.sendKeys(Attendentname+Keys.ENTER);
	}
	
	public void clickOnSave(){
		TestUtil.WaitforWebElement(Destination);	
		ClickSave.click();
	}
	
	public String verifyNumberadded(){
		return Verify.getText();
	}
	
	
	
	
	
	
	

}
