package com.crm.vTiger.generic_library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.vTiger.objectRepository.Home;
import com.crm.vTiger.objectRepository.Products;

public class BaseClass {
	
	public FileUtility flib=new FileUtility();
	public JavaUtility javaLib= new JavaUtility();
	public ExcelUtility excelLib= new ExcelUtility();
    public WebDriverUtils	webutl=new WebDriverUtils();    
	public WebDriver driver;
	
	
	                                                                           /*applicable in jdbc connection*/
@BeforeSuite
public void startConnection(){
	System.out.println("start database connection");
}
  //  @Parameters("browser")                                                                        /*applicable in crossbrowsertesting*/
@BeforeTest 

public void startcbt() throws Throwable{
    	
    /*	if(browser.equalsIgnoreCase("chrome")) {
    		driver=new ChromeDriver();
    	 }
    	else if(browser.equalsIgnoreCase("firefox")) {
    		driver=new FirefoxDriver();
    	 }
    	else if(browser.equalsIgnoreCase("ie")) {
    		driver=new InternetExplorerDriver();
    	 }
    	driver.manage().window().maximize();
    	webutl.waitForHTMLDOM(driver);
    	driver.get(flib.getPropertyValue("url"));*/
    	System.out.println("this is before test");
}

                                                                                    /*launching the browser*/
@BeforeClass
public void launchBrowser() throws Throwable {
	
String BROWSER = flib.getPropertyValue("browser");                //        run time polymorphism  best Example.
if(BROWSER.equalsIgnoreCase("chrome")) {
	driver=new ChromeDriver();
 }
else if(BROWSER.equalsIgnoreCase("firefox")) {
	driver=new FirefoxDriver();
 }
else if(BROWSER.equalsIgnoreCase("ie")) {
	driver=new InternetExplorerDriver();
 }
driver.manage().window().maximize();
webutl.waitForHTMLDOM(driver);
System.out.println("this is before class");

}
                                                                                     /*login in to application @BM will execute himself before starting @Test */
@BeforeMethod
public void logintoAppl() throws Throwable{
	driver.get(flib.getPropertyValue("url"));
	System.out.println("this is before method");
}
                                                                                     /*logout from application @AM will execute himself after the end of  @Test*/
@AfterMethod
public void logoutAppl(){
	WebElement ele = driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/user.PNG')]"));
	webutl.perform_mouse_Hover(driver, ele);
	WebElement ele1 = driver.findElement(By.xpath("//a[text()='Sign Out']"));
	ele1.click();
	System.out.println("this is after method");
	
	
	}
                                                                                             /*close the browser*/
@AfterClass
public void closeBrowser(){
	driver.close();
	System.out.println("this is after class");
}
                                                                                       /*stop cross browser testing */
@AfterTest
public void stopCrossbrowserTesting(){
	System.out.println("this is after test");
}
                                                                                          /*close database connection*/
@AfterSuite
public void closeConnection(){
	System.out.println("close database connection");
}
}
