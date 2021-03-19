package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.vTiger.generic_library.WebDriverUtils;

public class Create_Lead {

	public static void main(String[] args) throws Exception {
		WebDriverUtils lib = new WebDriverUtils();
		WebDriver driver=new ChromeDriver();
		lib.implicit_wait(driver);
		
       /*login to the application*/  //             
    	 String url = lib.read_XL_data("./Excel.xlsx"," Sheet1",1,1);
	     driver.get(url);
	     String userName = lib.read_XL_data("./Excel.xlsx"," Sheet1",2,1);
		  driver.findElement(By.name("user_name")).sendKeys(userName);
		  
		  String password = lib.read_XL_data("./Excel.xlsx"," Sheet1",3,1);
		  driver.findElement(By.name("user_password")).sendKeys(password);
		  
		  driver.findElement(By.id("submitButton")).click(); 
		  
		  driver.findElement(By.xpath("//a[text()='Leads']")).click();
          driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
          
          
          lib.handling_dropDown(driver.findElement(By.xpath("//select[@name='salutationtype']")),"Mr.");
          
          String frstName = lib.read_XL_data("./Excel.xlsx"," Sheet1",4,1);
          driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(frstName);
          
          String lstName = lib.read_XL_data("./Excel.xlsx"," Sheet1",5,1);
          driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lstName);
          
          String compName = lib.read_XL_data("./Excel.xlsx"," Sheet1",6,1);
          driver.findElement(By.xpath("//input[@name='company']")).sendKeys(compName);
          
          driver.findElement(By.xpath("//input[contains(@onclick,'toggleAssignType')]/following-sibling::input[@name='assigntype']")).click();
          lib.handling_dropDown(driver.findElement(By.xpath("//select[@name='assigned_group_id']")),"Team Selling");
          
          driver.findElement(By.xpath(" //table/tbody/tr[18]/td/div/input[1]")).click();
	}

}
