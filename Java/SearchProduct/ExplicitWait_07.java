package magento.searchproduct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSimpleExplicitWait_06 {

	WebDriver driver;
	
	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mercadolibre.com.ar/");
	}
	
	@Test
	public void testSuggestions() {
		// Creamos el WebElement Search Field
		WebElement searchField = driver.findElement(By.id("query"));
		
		// Introducimos la busqueda
		searchField.sendKeys("tele");

		WebElement suggestions = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("ac-popover-2")));
		
		suggestions.findElement(By.className("ac-autocomplete-item")).click();
		
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}
}
