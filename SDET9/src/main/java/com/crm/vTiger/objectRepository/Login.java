package com.crm.vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vTiger.generic_library.FileUtility;
import com.crm.vTiger.generic_library.WebDriverUtils;

public class Login  {
	FileUtility fliby=new FileUtility();	

	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement  pwd;	
	
	@FindBy(id="submitButton")
	private WebElement lognButton;
	

	
	
	
	public Login(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	
	public void getUsername() throws Throwable {
			
		username.sendKeys(fliby.getPropertyValue("username"));
	}

	public void getPwd() throws Throwable {
		pwd.sendKeys(fliby.getPropertyValue("password"));
	}

	public void getLognButton() {
		lognButton.click();
	}


	
	
	
}
