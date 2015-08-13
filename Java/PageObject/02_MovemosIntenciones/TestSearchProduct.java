package nopageobject;

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

	@Test
	public void testSearchByProduct() {

		WebElement searchField = driver.findElement(By.id("search"));
		
		searchField.sendKeys("Oxford");
		
		searchField.submit();
		//driver.findElement(By.className("search-button")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name a"));
		
		assert products.size() == 2;
	}

	@Test
	public void testNoResults() {

		WebElement searchField = driver.findElement(By.id("search"));
		
		searchField.sendKeys("accesories");
		
		searchField.submit();
		//driver.findElement(By.className("search-button")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name a"));
		
		assert products.size() == 0;
	}

	
	@After
	public void TearDown() {
		driver.quit();
	}

}
