import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchProduct_01 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		// Navegamos hacia la aplicacion
		driver.get("http://demo.magentocommerce.com/");
		
		// Creamos el WebElement Search Field
		WebElement searchField = driver.findElement(By.id("search"));
		
		// Introducimos la busqueda
		searchField.sendKeys("phones");
		
		// Realizamos la busqueda
		searchField.submit(); // sin presionar el boton buscar
		// presionando buscar seria asi
		//driver.findElement(By.className("search-button")).click();
		
		//Capturamos todos los elementos que devuelve la busqueda
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name a"));
		
		// Validamos la cantidad de resultados devueltos
		assert products.size() == 2;
	}
}
