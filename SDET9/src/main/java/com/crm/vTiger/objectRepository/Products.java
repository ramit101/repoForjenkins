package com.crm.vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vTiger.generic_library.WebDriverUtils;

public class Products extends WebDriverUtils {
	WebDriver driver;
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement crtProd;
	
	@FindBy(xpath="//img[contains(@src,'themes/softed/images/user.PNG')]")
	private WebElement ele;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement ele1;

	
	public	Products(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
		
	public void logOut(){
		
		perform_mouse_Hover(driver,ele);
		//waitforElementToBeClickable(driver, ele);
		ele1.click();
	}

		public void click_CreateProduct(){
			crtProd.click();
		}

}
