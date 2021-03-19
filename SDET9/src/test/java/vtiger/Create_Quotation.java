package vtiger;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.vTiger.generic_library.WebDriverUtils;

public class Create_Quotation {

	public static void main(String[] args) {
		WebDriverUtils lib=new WebDriverUtils();
		WebDriver driver = new FirefoxDriver();
		lib.implicit_wait(driver);
		
		/*login to the application*/
		
		driver.get("http://localhost:8888");
          
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("password");
		  driver.findElement(By.id("submitButton")).click(); 
		  
		WebElement mor = driver.findElement(By.xpath("//a[text()='More']"));
		WebElement qot = driver.findElement(By.xpath("//a[text()='Quotes']"));
		
		
		 lib.perform_mouse_Hover(driver,mor);
		 qot.click();
		  
		  driver.findElement(By.xpath("//img[@title='Create Quote...']")).click();
		  driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("100 HP Systems");
		  
		  driver.findElement(By.xpath("//input[@name='assigntype']//following-sibling::input")).click();
		  driver.findElement(By.xpath("//input[@name='potential_name']/following-sibling::img")).click();
		  
		 lib.swicthToWindow(driver,"specific_potential_account_address");
		 driver.findElement(By.xpath("//a[text()='vtiger - 1000 units']")).click();
		 
		 /* switch back to parent window*/
		 lib.swicthToWindow(driver,"Administrator");
		 
		 driver.findElement(By.xpath("//input[@name='contact_name']/following-sibling::img")).click();
		 lib.swicthToWindow(driver,"specific");
		 
		 lib.waitforElementToBeClickable(driver,driver.findElement(By.xpath("//a[text()='Mary Smith']")));
		 driver.findElement(By.xpath("//a[text()='Mary Smith']")).click();
		 lib.switch_AlertPopup_accept(driver);
		 
		 /* switch back to parent window*/
		 lib.swicthToWindow(driver,"Administrator");
		 lib.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//input[contains(@onclick,'return copyAddressRight(EditView)')]")) );
		 driver.findElement(By.xpath("//input[contains(@onclick,'return copyAddressRight(EditView)')]")).click();
		 
		 
		 driver.findElement(By.id("searchIcon1")).click();
		 lib.swicthToWindow(driver,"inventory_prod");
		 driver.findElement(By.xpath("//a[text()='Vtiger Single User Pack']")).click();
		 
		 /* switch back to parent window*/
		 lib.swicthToWindow(driver,"Administrator");
		 driver.findElement(By.xpath("//input[@name='qty1']")).sendKeys("3");
		 driver.findElement(By.xpath("//table/tbody/tr[25]/td/div/input[1]")).click();
		 
	}

}
