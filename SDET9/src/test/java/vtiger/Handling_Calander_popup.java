package vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.crm.vTiger.generic_library.WebDriverUtils;

public class Handling_Calander_popup extends WebDriverUtils{
	@Test
	public void clearTrip() throws InterruptedException{

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
WebDriver driver=	new ChromeDriver(option);
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 driver.get("https://www.cleartrip.com/");
   driver.findElement(By.id("FromTag")).sendKeys("BLR");
 Thread.sleep(2000);
   driver.findElement(By.xpath("//a[contains(@id,'ui-id-58')]")).click();
   
   Alert al = driver.switchTo().alert();
   al.accept();
   
   driver.findElement(By.id("ToTag")).sendKeys("NYC");
   driver.findElement(By.xpath("//a[text(),'NYC")).click();
   
 driver.findElement(By.xpath("//td[@data-month='1' and @data-year='2021' ]/a[text()='8']")).click();
   
   driver.close();
	}
}
