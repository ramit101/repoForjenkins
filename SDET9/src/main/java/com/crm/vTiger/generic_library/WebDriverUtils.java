package com.crm.vTiger.generic_library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	/**
	 * @author hp
	 * this method  will wait explicitly for the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeClickable(WebDriver driver , WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, IConstant.explicitlyWait);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * @author amit
	 *  implicit wait will walt for dom page to load
	 * @param driver
	 */
	public void waitForHTMLDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstant.implicitlyWiat, TimeUnit.SECONDS);
		
	}
	
	/**
	 * @author hp
	 * this method driver will switch to alert popup window  & will accept
	 * @param driver 
	 */
	public void switch_AlertPopup_accept(WebDriver driver){
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	/**
	 *  this method driver will switch to alert popup window  & will dismiss
	 * @param driver
	 */
	public void switch_to_AlertPopup_cancel(WebDriver driver){
		Alert al = driver.switchTo().alert();
		al.dismiss();;
	}
	/**
	 * @author  amit
	 * through this method  driver will switch to alert popup and get the text of pop up 
	 * @param driver
	 * @return
	 */
	
	public String  switch_to_AlertPopup_getText(WebDriver driver){
		Alert al = driver.switchTo().alert();
		String txt = al.getText();
		System.out.println(txt);
		return txt;
	}
	/**
	 * @author hp
	 * @param driver
	 */
	public void switchWindow(WebDriver driver){
		String currentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
	      Iterator<String> it = allWindows.iterator();
	      while(it.hasNext()){
	         String childwindow = it.next();
	         if(childwindow.equalsIgnoreCase(currentwindow)){
	            driver.switchTo().window(childwindow);	            
	         }
	         else {
	            System.out.println("There are no children");
	         }
	      } 
	}
	/**
	 * @author amit
	 * this method will move the cursor to the specified element and then click on specified element
	 * @param driver
	 * @param element
	 * @param qot
	 */
	
	public void perform_mouse_Hover(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	
	}
	/**
	 * @author hp
	 * this method will wait for the specified timeduration to load the DOM page
	 * @param driver
	 */
	public void implicit_wait(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(IConstant.implicitlyWiat,TimeUnit.SECONDS);
	}
	
	/**
	 * @author hp
	 * it will help us to handle the dropdown with help of visibleText
	 * @param element
	 * @param text
	 */
	public void handling_dropDown(WebElement element,String text){
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * it will fetch the data from excel sheet
	 * @param path
	 * @param SheetNo
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Exception
	 */
	public String  read_XL_data(String path, String SheetNo,int rownum, int cellnum) throws Exception{
		
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		String data=wb.getSheet(SheetNo).getRow(rownum).getCell(cellnum).toString();
		
		return data;
	}
	/**
	 * @Deepak sir
	 * swttch to window method created by sir
	 * @param driver
	 * @param partailWindowTitle
	 */
	public void swicthToWindow(WebDriver driver , String partailWindowTitle) {
		  /*get all window session ID*/
		   Set<String> set = driver.getWindowHandles();
		   Iterator<String> it = set.iterator();
		    
		   while(it.hasNext()) {
			   String winID = it.next();
			   driver.switchTo().window(winID);
			   String actTitle = driver.getTitle();
			   if(actTitle.contains(partailWindowTitle)) {
				   System.out.println("swicthed to actual winow");
				   break;
			   }
		   }
	}
	
	/**
	 * method to take screenshot when it will get fail
	 * @author amit ranjan
	 * @throws IOException 
	 */
	public static String screenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/sshot.png");
		String path = dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return path;
	}
	
	
	
	
	
}
