package com.crm.qa.testcases;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ServetelTest extends TestBase {
	static Logger LOGGER = LoggerFactory.getLogger(ServetelTest.class);
	String ResponseCode;
	String Responsecodee = "200 OK";
	String Autoattendent = prop.getProperty("EnterAutoAttendentName");
	
	String Token;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;


	public ServetelTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

				// To Verify THE LOGIN and HomePage Title
				@Test(priority = 1, enabled = true)
				public void verifyHomePageTitleTest() {
					LOGGER.info("*******************Step 1 Execution Start**************************");
					System.out.println("*******************Step 1 Execution Start**************************");
					
					String homePageTitle = homePage.verifyHomePageTitle();
					System.out.println("homePageTitle:- " +homePageTitle);
					//Verify Homepage Title
					Assert.assertEquals(homePageTitle, "Welcome");
					
					System.out.println("*******************Step 1 Executed Successfully!!!**************************");
					LOGGER.info("*******************Step 1 Executed Successfully!!!**************************");
			
				}
				
				
			
				// 2) Create and Upload Recording (Service --->System Recordings--->Create
				// Recordings)
				@Test(priority = 2, enabled = true)
				public void createandUploadRecording() throws InterruptedException, UnsupportedFlavorException, IOException {
					LOGGER.info("*******************Step 2 Execution Start**************************");
					System.out.println("*******************Step 2 Execution Start**************************");
					
					//Click on Services--->System Recording
					homePage.clickonSystemRecording();
					
					//Click on Upload Recording button
					homePage.uploadRecording();
					
					String Recordingname = homePage.verifyCreatedRecording();
					System.out.println("Generated Recording name:- " +Recordingname);
					//Verify Created Recording file name
					Assert.assertEquals(Recordingname, prop.getProperty("RecordingFileName"));			
					
					System.out.println("*******************Step 2 Executed Successfully!!!**************************");
					LOGGER.info("*******************Step 2 Executed Successfully!!!**************************");
			
				}
				
				
			
				// 3) Create/Add Agent using the API POST Method, API Ref Link -
				// https://servetel.readme.io/reference#agent generate Auth Token
				// from the customer Portal (Services ---> Account API ---> Generate Token)
				@Test(priority = 3, enabled = true)
				public void addAgentUsingPost() throws InterruptedException {
					LOGGER.info("*******************Step 3 Execution Start**************************");
					System.out.println("*******************Step 3 Execution Start**************************");
					
					//Click on Services-->AccountApi
					homePage.clickonAccountApi();
					
					//Click on Generate Token Button
					homePage.clickonGenerateToken();
					
					//Enter Token Name
					homePage.EnterTokenName(prop.getProperty("Tokenname"));
					System.out.println("Entered TokenName:- " +prop.getProperty("Tokenname"));
					
					//Click on Save Button
					homePage.ClickOnSaveButton();
					
					//Click on view Token Button
					homePage.ClickOnViewToken();
					
					//Generate and Copy Token
					Token = homePage.generateToken();
					System.out.println("Generated Token:- " +Token);
					
					//Open POST API url
					homePage.GetPostURL(prop.getProperty("agentURL"));
					
					//Click on Post 
					homePage.clickonPost();
					
					//Enter Agent Name (Mandataory Information)
					homePage.EnterAgentName(prop.getProperty("agentName"));
					System.out.println("Entered AgentName:- " +prop.getProperty("agentName"));
					
					//Enter Follow me number (Mandataory Information)
					homePage.EnterFollowmenumber(prop.getProperty("followMeNumber"));
					System.out.println("Entered Followmenumber:- " +prop.getProperty("followMeNumber"));
					
					//Enter Generated AuthToken
					homePage.EnterAuthToken(Token);
					
					//Click on Tryit
					homePage.ClickonTryit();				
					
					//Get Response Code
					ResponseCode = homePage.GetResponseCode();
					System.out.println(ResponseCode+"   ResponseCode");
					
					//Verify Response Code
					Assert.assertEquals(ResponseCode, Responsecodee);
					
					System.out.println("*******************Step 3 Executed Successfully!!!**************************");
					LOGGER.info("*******************Step 3 Executed Successfully!!!**************************");
			
				}
				
				
			
				// 4) Create Auto-Attendant (Services ---> Auto-Attendant), select the recording
				// and the agent that you have created earlier in step2 and step3.
				@Test(priority = 4, enabled = true)
				public void CreateAutoAttendent() throws InterruptedException {
					LOGGER.info("*******************Step 4 Execution Start**************************");
					System.out.println("*******************Step 4 Execution Start**************************");		
					
					//Click on Services--> Autoattendent
					homePage.ClickonAutoattendent();
					
					//Click on AddAutoattendent Button
					homePage.ClickonAddAutoattendent();
					
					//Enter Name
					homePage.EnterName(prop.getProperty("EnterAutoAttendentName"));
					System.out.println("Entered AutoAttendent Name :- " +prop.getProperty("EnterAutoAttendentName"));
					
					//Enter Description
					homePage.EnterDescription(prop.getProperty("EnterAutoAttendenDesc"));
					System.out.println("Entered Description :- " +prop.getProperty("EnterAutoAttendenDesc"));
					
					//Choose Created Recording in Test 2
					homePage.ChooseRecording(prop.getProperty("RecordingFileName"));
					System.out.println("Choosen Recording Name :- " +prop.getProperty("RecordingFileName"));
					
					//Choose Created Agent
					homePage.ChooseAgent(prop.getProperty("agentName"));
					System.out.println("Choosen Agent Name :- " +prop.getProperty("agentName"));
					
					//Click on Save Button
					homePage.ClickonSave();
					
					String Auto = homePage.VerifyCreatedAutoattendent();
					
					//Verify Created Autoattendent
					Assert.assertEquals(Auto, Autoattendent);
					
					System.out.println("*******************Step 4 Executed Successfully!!!**************************");
					LOGGER.info("*******************Step 4 Executed Successfully!!!**************************");
					
				}
			
				
				
				// 5) Assign the Auto-Attendant to the Number (Services ---> My Numbers --->
				// Select Action and assign the Auto-Attendant created in step 4).
				@Test(priority = 5, enabled = true)
				public void AssignAutoattendentToNumber() {
					LOGGER.info("*******************Step 5 Execution Start**************************");
					System.out.println("*******************Step 5 Execution Start**************************");
					
					//Click on Services---> MMy Number
					homePage.ClickonMyNumber();
					
					//Select Action
					homePage.SelectAction();
					
					//Click on Edit
					homePage.clickOnEdit();
					
					//Click in Destination
					homePage.clickOnDestination();
					
					//Enter created AutoAttenedent name
					homePage.EnterAutoattendent(prop.getProperty("EnterAutoAttendentName"));
					System.out.println("Selected Autoattendent  :- " +prop.getProperty("EnterAutoAttendentName"));
					
					//Click on Save
					homePage.clickOnSave();
					
					//Verify Autoattendent added or not
					String AttendentName=homePage.verifyNumberadded();
					Assert.assertEquals(AttendentName, Autoattendent+" (Auto-Attendant)");
					
					System.out.println("*******************Step 5 Executed Successfully!!!**************************");
					LOGGER.info("*******************Step 5 Executed Successfully!!!**************************");
					
				}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
