package 05_TestBase;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	WebDriver driver;
	
	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mercadolibre.com.ar/");
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}
}
