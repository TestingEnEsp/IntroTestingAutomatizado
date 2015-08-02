import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// vemos como agregar implicit wait a los tests

public class ImplicitWait_06 {

	WebDriver driver;
	
	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		// Definimos el Implicit Wait con una espera de 30s
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Navegamos hasta la aplicacion
		driver.get("http://demo.magentocommerce.com/");
	}
	
	@Test
	public void testSearchByCategory() {

		// Creamos el WebElement Search Field
		WebElement searchField = driver.findElement(By.id("search"));
		
		// Introducimos la busqueda
		searchField.sendKeys("phones");
		
		// Realizamos la busqueda 
		searchField.submit();
		//driver.findElement(By.className("search-button")).click();
		
		// Capturamos todos los elementos que devuelve la busqueda
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name a"));
		
		// Validamos el resultado
		assert products.size() == 2;
	}
	
	@Test
	public void testSearchByName() {

		// Creamos el WebElement Search Field
		WebElement searchField = driver.findElement(By.id("search"));
		
		// Introducimos la busqueda
		searchField.sendKeys("salt shaker");
		
		// Realizamos la busqueda
		searchField.submit();
		//driver.findElement(By.className("search-button")).click();
		
		// Capturamos todos los elementos que devuelve la busqueda
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name a"));
		
		// Validamos el resultado
		assert products.size() == 1;
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}
}
