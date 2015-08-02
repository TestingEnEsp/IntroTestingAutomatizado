import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// En este caso incluimos el Framework JUnit de Java para correr pruebas 
// y agregar un setup a las mismas.

public class SearchProductConSetUp_02 {

	WebDriver driver;
	
	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// Navegamos hasta la aplicacion
		driver.get("http://demo.magentocommerce.com/");
		
	}
	
	@Test
	public void testSearchByCategory() {

		// Creamos el WebElement Search Field
		WebElement searchField = driver.findElement(By.id("search"));
		
		// Introducimos la busqueda
		searchField.sendKeys("phones");
		
		// realizamos la busqueda
		searchField.submit();
		//driver.findElement(By.className("search-button")).click();
		
		// Capturamos todos los elementos que devuelve la busqueda
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name a"));
		
		// validamos el resultado
		assert products.size() == 2;
	}
}