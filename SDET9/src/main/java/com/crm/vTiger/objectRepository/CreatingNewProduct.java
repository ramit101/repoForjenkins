package com.crm.vTiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vTiger.generic_library.WebDriverUtils;

public class CreatingNewProduct extends WebDriverUtils {
@FindBy(name="productname")
private WebElement prodName;

@FindBy(xpath="//input[@name='discontinued']")
private WebElement chkbox;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement save;

@FindBy(id="serial_no")
private WebElement prodSerialNo;


public CreatingNewProduct(WebDriver driver){
	PageFactory.initElements(driver, this);
}


public void getproductName(String productName){
	prodName.sendKeys(productName);
	}

public void clickProductactivecheckbox(){
	chkbox.click();
}
public void getSave(){
	save.click();
}
public void getproductSerialNo(WebDriver driver,String serialNo){
	prodSerialNo.sendKeys(serialNo);
	waitforElementToBeClickable(driver, prodSerialNo);
}

}
