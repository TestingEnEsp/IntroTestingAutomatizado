package magento.searchproduct;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Vemos como configurar el test para correr otros browsers en forma local

public class TestSimpleCrossBrowsing_07 {
		
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
	
	@After
	public void TearDown() {
		driver.quit();
	}

}
