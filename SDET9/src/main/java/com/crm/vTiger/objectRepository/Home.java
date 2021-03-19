package com.crm.vTiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vTiger.generic_library.ExcelUtility;
import com.crm.vTiger.generic_library.FileUtility;
import com.crm.vTiger.generic_library.WebDriverUtils;

public class Home extends  WebDriverUtils  {
	WebDriver driver;
	public ExcelUtility excelLib= new ExcelUtility();
	
@FindBy(xpath="//a[text()='Products']")
private WebElement productlink;

@FindBy(id="qccombo")
private WebElement quickcreate;

@FindBy(name="productname")
private WebElement qkprodName;

@FindBy(xpath="//form[@name='QcEditView']/table/tbody/tr/td/table[2]/tbody/tr/td/table[1]/tbody/tr[3]/td[2]/input[2]")
private WebElement group;

@FindBy(xpath="//form[@name='QcEditView']/table/tbody/tr/td/table[2]/tbody/tr/td/table[1]/tbody/tr[3]/td[2]/span[2]/*")
private WebElement dropd;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement qksave;



public Home(WebDriver driver){
	PageFactory.initElements(driver, this);
}

public void getproductlink(){
	productlink.click();
}

public void getQuickcreate_product(){
	handling_dropDown(quickcreate,"New Product");
	
}
/**
 * @author hp
 * this method will enter product name in Quick product popup
 * @throws Throwable
 */
public void getQuickprodName() throws Throwable{
	qkprodName.sendKeys(excelLib.getExcelData("products", 1,1));
	}

public void get_selectGroup(){
	group.click();
}
/**
 * @author hp
 * it will select teamselling as a group 
 */
public void get_TeamSelling_dropDown(){
	handling_dropDown(dropd, "Team Selling");
}

public void getquickSave(){
	qksave.click();
}











}
