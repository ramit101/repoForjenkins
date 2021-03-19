package gridProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart_Xpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new  ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
         driver.get("https://www.flipkart.com/");
    //     driver.manage().window().maximize();
      Actions act = new Actions(driver);
      act.click().perform();
         driver.findElement(By.xpath("//input[@type='text']")).sendKeys("redmi");
         driver.findElement(By.xpath("//button[@type='submit']")).click();
         
         driver.findElement(By.xpath("//div[text()='Redmi 9i (Nature Green, 64 GB)']")).click();
         
         Set<String> wds = driver.getWindowHandles();
         System.out.println(wds.size());
         for( String wd:wds){
        	 driver.switchTo().window(wd);
        	 Thread.sleep(5000);
        
         }
         System.out.println(  driver.findElement(By.xpath("//span[text()='Redmi 9i (Nature Green, 64 GB)']/../../..")).getText());
	}

}
