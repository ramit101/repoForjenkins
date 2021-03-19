package gridProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Handle {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  //      WebElement dp = driver.findElement(By.id("dropdown"));
        
  driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\hp\\Pictures\\Capture.PNG");
      
    
	}

}
