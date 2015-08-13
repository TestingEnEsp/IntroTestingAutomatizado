package saucelabs;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	
	WebDriver driver;
	
	String USERNAME = "";
	String ACCESS_KEY = "";
	
	
	@Before
	public void SetUp() throws MalformedURLException {		
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "17");
        capabilities.setCapability("platform", Platform.XP);

        this.driver = new RemoteWebDriver(
                new URL("http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);

		driver.manage().window().maximize();
		driver.get("http://demo.magentocommerce.com/");
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}
}
