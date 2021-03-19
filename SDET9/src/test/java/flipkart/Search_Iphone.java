package flipkart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Search_Iphone {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		Actions act = new Actions(driver);
		act.click().build().perform();

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone in mobile");
		driver.findElement(By.xpath("//div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form/div[1]/button")).click();

		WebElement  dropElement = driver.findElement(By.xpath("//select[@class='_2YxCDZ']/../../div[3]/*"));

		Select selElement = new Select(dropElement);
		selElement.selectByValue("50000");
		Thread.sleep(5000);


		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_4rR01T']/../../div[2]/div[1]/div[1]/div[1]"));
		List<WebElement> deviceName = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> storageCapacity = driver.findElements(By.xpath("//div[@class='_4rR01T']/../div[3]/ul[*]/li[1]"));
		List<WebElement> rating = driver.findElements(By.xpath("//div[@class='_4rR01T']/../div[2]/span[1]"));


		for(WebElement webEle1:deviceName){
			System.out.println(webEle1.getText());	
			
		}
		for(WebElement webEle2:prices){		   
			System.out.println(" "+webEle2.getText());
			/*String txt = webEle2.getText();
			System.out.println(Integer.parseInt(txt));*/
		}


		for(WebElement webEle3:storageCapacity){
			System.out.println(" "+ webEle3.getText());
		}

		for(WebElement webEle4:rating){
			System.out.println(" "+ webEle4.getText()+"  ");

		}


	}  


}


