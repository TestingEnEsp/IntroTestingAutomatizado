import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

# Vemos como funciona el explicit wait

public class ExplicitWait_07 {

	WebDriver driver;
	
	@Before
	public void SetUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.magentocommerce.com/");
	}
	
	@Test
	public void testAcountLink() {

		// Capturamos el elemento account cuando se cumple la condicion de que esta visible
		WebElement account = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.className("skip-account")));
		
		account.click();
	}
	

	@Test
	public void testCreateNewCustomer() {

		// Hacemos click en Account para habilitar el link de Login
		driver.findElement(By.className("skip-account")).click();

		// Esperamos por el link y le hacemos click
		WebElement myAccount = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#header-account .first a")));
		myAccount.click();
		
		// Capturamos el webelement Create account
		WebElement createAccountButton = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button[title='Create an Account']")));
		
		// Hacemos click y esperamos por el titulo de la pagina
		createAccountButton.click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains("Create New Customer Account"));
	}

	@After
	public void TearDown() {
		driver.quit();
	}

}
