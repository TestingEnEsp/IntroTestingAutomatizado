package mastests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sipageobject.HomePage;
import sipageobject.SearchPage;

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

		HomePage homePage = new HomePage(driver);
		
		SearchPage searchPage = homePage.searchFor("phones");
		
		assert 2 == searchPage.getCantResultados();
	}

	@Test
	public void testSearchByProduct() {

		HomePage homePage = new HomePage(driver);
		
		SearchPage searchPage = homePage.searchFor("Oxford");
		
		assert 3 == searchPage.getCantResultados();
	}

	@Test
	public void testNoResults() {

		HomePage homePage = new HomePage(driver);
		
		SearchPage searchPage = homePage.searchFor("accesories");
		
		assert 0 == searchPage.getCantResultados();
	}

	
	@After
	public void TearDown() {
		driver.quit();
	}

}
