package gridProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
@Test
public void cbt() throws MalformedURLException{
	URL url = new URL("http://192.168.43.36:4444/wd/hub");
	DesiredCapabilities ds = new DesiredCapabilities();
	ds.setBrowserName("chrome");
	
	RemoteWebDriver driver = new RemoteWebDriver(url, ds);
	driver.get("http://localhost:8888/");
         }
}
