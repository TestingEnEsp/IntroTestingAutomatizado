package movemosintenciones_02;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSearchProduct {

	WebDriver driver;
	
	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mercadolibre.com.ar/");
	}
	
	@Test
	public void testSearchByCategory() {

		WebElement searchField = driver.findElement(By.id("query"));
		
		searchField.sendKeys("telefonos");
		
		searchField.submit();
		//driver.findElement(By.className("nav-search-btn.ml-search-btn")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector("#searchResults>li"));
		
		assert products.size() == 50;
	}

	@Test
	public void testSearchByName() {

		WebElement searchField = driver.findElement(By.id("query"));
		
		searchField.sendKeys("software testing: fundamental principles and essential know");
		
		searchField.submit();
		//driver.findElement(By.className("nav-search-btn.ml-search-btn")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector("#searchResults>li"));
		
		assert products.size() == 1;
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}

}
