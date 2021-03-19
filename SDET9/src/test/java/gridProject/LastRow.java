package gridProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LastRow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("password");
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.xpath("//a[text()='Products']")).click();
         List<WebElement> eles = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
         int lastrowcount = eles.size();
         System.out.println(lastrowcount);
       String str = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+lastrowcount+"]/td[3]")).getText();
       System.out.println(str);
	}

}
