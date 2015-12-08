package magento.searchproduct;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSimpleOtroTest_04 {

	WebDriver driver;
	
	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mercadolibre.com.ar/");
	}
	
	@Test
	public void testSearchByCategory() {
		// Creamos el WebElement Search Field
		WebElement searchField = driver.findElement(By.id("query"));
		
		// Introducimos la busqueda
		searchField.sendKeys("telefonos");
		
		// Realizamos la busqueda
		searchField.submit(); // sin presionar el boton buscar
		// presionando buscar seria asi
		//driver.findElement(By.className("nav-search-btn.ml-search-btn")).click();
		
		//Capturamos todos los elementos que devuelve la busqueda
		List<WebElement> products = driver.findElements(By.cssSelector("#searchResults>li"));
		
		// Validamos la cantidad de resultados devueltos
		assert products.size() == 50;
	}
	
	@Test
	public void testSearchByName() {
		// Creamos el WebElement Search Field
		WebElement searchField = driver.findElement(By.id("query"));
		
		// Introducimos la busqueda
		searchField.sendKeys("software testing: fundamental principles and essential know");
		
		// Realizamos la busqueda
		searchField.submit(); // sin presionar el boton buscar
		// presionando buscar seria asi
		//driver.findElement(By.className("nav-search-btn.ml-search-btn")).click();
		
		//Capturamos todos los elementos que devuelve la busqueda
		List<WebElement> products = driver.findElements(By.cssSelector("#searchResults>li"));
		
		// Validamos la cantidad de resultados devueltos
		assert products.size() == 1;
	}
	
	
	@After
	public void TearDown() {
		driver.quit();
	}
}
