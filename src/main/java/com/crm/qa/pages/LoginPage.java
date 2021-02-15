package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//input[@id='login_id']")
	WebElement username;

	@FindBy(xpath="//input[@id='password']")
	WebElement password;

	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginBtn;

	@FindBy(xpath="//div[normalize-space()='CAPTCHA validation failed. Please try again.']")
	WebElement Captcha;


	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}


	public HomePage login(String un, String pwd) throws InterruptedException{
      Thread.sleep(2000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();	
		/*try {
			while(Captcha.isDisplayed()==true) {
				username.sendKeys(un);
				password.sendKeys(pwd);
				loginBtn.click();
				if(Captcha.isDisplayed()==true) {
					Thread.sleep(2000);
					continue;

				}else {
					break;

				}

			}
		}
		catch(Exception e) {
		}*/

		return new HomePage();
	}

}
