package 04_MasTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import 04_MasTests.HomePage;
import 04_MasTests.SearchPage;

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

		HomePage homePage = new HomePage(driver);
		
		SearchPage searchPage = homePage.searchFor("telefonos");
		
		assert 50 == searchPage.getCantResultados();
	}

	@Test
	public void testSearchByName() {

		HomePage homePage = new HomePage(driver);
		
		SearchPage searchPage = homePage.searchFor("software testing: fundamental principles and essential know");
		
		assert 1 == searchPage.getCantResultados();
	}

	@After
	public void TearDown() {
		driver.quit();
	}

}
