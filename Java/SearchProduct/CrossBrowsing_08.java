import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Vemos como configurar el test para correr otros browsers en forma local

public class CrossBrowsing_08 {
		
	WebDriver driver;
	
	@Before
	public void SetUp() {
		// Le indicamos donde se ubica el chromedriver.exe 
		System.setProperty("webdriver.chrome.driver", 
				"/opt/pythonenv/WebDriver/introTestingAutomatizado/search_product/search_product/chromedriver");
		// Instanciamos Chrome
		driver = new ChromeDriver();

		// Para el caso de IE, seria asi
		// Le indicamos donde se ubica el IeDriver.exe 
		//System.setProperty("webdriver.internetexplorer.driver", 
		//		"/opt/pythonenv/WebDriver/introTestingAutomatizado/search_product/search_product/internetexplorer.exe");
		// Instanciamos IE
		// driver = new InternetExplorerDriver()

		driver.manage().window().maximize();
		driver.get("http://demo.magentocommerce.com/");
	}
	
	@Test
	public void testSearchByCategory() {

		WebElement searchField = driver.findElement(By.id("search"));
		
		searchField.sendKeys("phones");
		
		searchField.submit();
		//driver.findElement(By.className("search-button")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name a"));
		
		assert products.size() == 2;
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}

}
