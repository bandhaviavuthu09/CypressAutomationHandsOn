package remoteTesting.DockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandAloneTest {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();

		URL u = new URL("https://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(u,cap);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
	}
}
