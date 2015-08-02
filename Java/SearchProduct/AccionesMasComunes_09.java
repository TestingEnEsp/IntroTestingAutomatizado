import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AccionesMasComunes_09 {

	WebDriver driver;
	
	@Before
	public void SetUp() {
		 driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testDragAndDrop() {

		// Navegamos hasta la aplicacion
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		// localizamos el elemento a arrastrar
		WebElement source = driver.findElement(By.id("draggable"));
		
		// localizamos el lugar a donde lo queremos arrastrar
		WebElement target = driver.findElement(By.id("droppable"));

		// ejecutamos las acciones de arrastrar y soltar
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		
		// validamos que se realizo el drag and drop en forma exitosa
		assert target.getText().contains("Dropped!");
	}
	
	@Test
	public void testDropdown() {

        // Navegamos hasta la aplicacion
        driver.get("http://demo.magentocommerce.com/");

        // generamos el elements select
        Select select = new Select(driver.findElement(By.id("select-language")));

        // utilizamos el elemento select para seleccionar por valor visible
        select.selectByVisibleText("German");
	}
	
	@Test
	public void testDoubleClick() {

		// Navegamos hasta la aplicacion
		driver.get("http://api.jquery.com/dblclick/");
		
		// cambiamos el foco al frame
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		// capturamos el elemento
		WebElement box = driver.findElement(By.tagName("div"));
		
		// verificamos que la caja es azul
		assert box.getAttribute("background-color") == "rgba(0, 0, 255, 1)";
		
		Actions builder = new Actions(driver);
		
		// Nos posicionamos sobre el elemento
		builder.moveToElement(driver.findElement(By.tagName("span"))).perform();
		
		// realizamos el doble click
		builder.doubleClick(box).perform();
		
		// verificamos que cambio de color a amarillo por el doble click
		assert box.getAttribute("background-color") == "rgba(255, 255, 0, 1)";
	}

	@Test
	public void testToolTip() {

		// Navegamos hasta la aplicacion
		driver.get("http://jqueryui.com/tooltip/");
		
		// cambiamos de foco al iframe
		WebElement frameElm = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElm);
		
		// capturamos la caja donde vamos a hacer hover
		WebElement ageField = driver.findElement(By.id("age"));

    // hacemos hover para que aparezca el tooltip
    Actions builder = new Actions(driver);
		builder.moveToElement(ageField).perform();
		
		// esperamos que aparezca el toolyip
		WebElement toolTip = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-tooltip-content")));

		// verificamos el mensaje del tooltip
		assert toolTip.getText() == "We ask for your age only for statistical purposes.";
	}
	
	@Test
	public void testWindow() {
		// Navegamos hasta la aplicacion 
		driver.get("http://the-internet.herokuapp.com/windows");
		
		// Guardamos el nombre de la ventana actual para poder volver
		String parentWindow = driver.getWindowHandle();

		// Abrimos una nueva ventana
		WebElement link = driver.findElement(By.linkText("Click Here"));
		link.click();

		// Cambiamos el foco hacia la nueva ventana
		Set<String> handles = driver.getWindowHandles();
		handles.remove(parentWindow);
		String winHandle=handles.iterator().next();
		driver.switchTo().window(winHandle);
		
		// Cerramos la ventana
		driver.close();

		// Cambiamos el foco a la primer ventana
		driver.switchTo().window(parentWindow);
	}
	
	@Test
	public void testAlerts(){
		
        // Navegamos hasta la aplicacion 
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        // Hacemos click en el boton para JS Alert
        driver.findElements(By.tagName("button")).get(0).click();

        // ponemos el foco en el alert
        Alert js_alert = driver.switchTo().alert();

        // aceptamos el mensaje del popup
        js_alert.accept();
        // en caso de que tenga accept / cancel, lo podemos cancelar
        // con js_alert.dismiss()

        // verificamos el resultado
        assert driver.findElement(By.id("result")).getText() == "You successfuly clicked an alert";
	}
	
	@Test
	public void testElementScreenshot() throws IOException{

		// Navegamos hasta la aplicacion
		driver.get("http://demo.magentocommerce.com/");

		// hacemos fallar el test para capturar la pantalla
		try{
			
			WebElement promo_banner_elem = driver.findElement(By.id("promo_banner"));
            assert promo_banner_elem.getText() == "Promotions";
		}
		catch (NoSuchElementException e){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\main_page.png"));
		}
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}

}
