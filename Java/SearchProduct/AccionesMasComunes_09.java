package magento.searchproduct;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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

public class TestSimpleDistintasAcciones_08 {

	WebDriver driver;
	
	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testDragAndDrop() {

		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement trgt = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);
		builder.dragAndDrop(src, trgt).perform();
		
		assert trgt.getText().contains("Dropped!");
	}
	
	@Test
	public void testDropdown() {

        driver.get("http://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));

        select.selectByVisibleText("Option 2");
	}
	
	@Test
	public void testDoubleClick() {

		driver.get("http://api.jquery.com/dblclick/");
		
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		WebElement box = driver.findElement(By.tagName("div"));
		
		assert box.getAttribute("background-color") == "rgba(0, 0, 255, 1)";
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.tagName("span"))).perform();
		builder.doubleClick(box).perform();
		
		assert box.getAttribute("background-color") == "rgba(255, 255, 0, 1)";
	}

	@Test
	public void testToolTip() {

		driver.get("http://jqueryui.com/tooltip/");
		
		WebElement frameElm = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElm);
		
		WebElement ageField = driver.findElement(By.id("age"));

		Actions builder = new Actions(driver);
		builder.moveToElement(ageField).perform();
		
		WebElement toolTip = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-tooltip-content")));

		
		assert toolTip.getText() == "We ask for your age only for statistical purposes.";
	}
	
	@Test
	public void testWindow() {
		
		driver.get("http://the-internet.herokuapp.com/windows");
		
		String parentWindow = driver.getWindowHandle();

		WebElement link = driver.findElement(By.linkText("Click Here"));
		link.click();

		Set<String> handles = driver.getWindowHandles();
		
		handles.remove(parentWindow);
		
		String winHandle=handles.iterator().next();
			
		driver.switchTo().window(winHandle);
		driver.close();

		driver.switchTo().window(parentWindow);
	}
	
	@Test
	public void testAlerts(){
		
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
		driver.get("http://www.mercadolibre.com.ar/");

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
	
	@Test
	public void testDoubleClick2() {

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

	
	@After
	public void fin() {
		driver.close();
		driver.quit();
	}
}
