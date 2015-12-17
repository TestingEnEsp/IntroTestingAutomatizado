package 07_SauceLabs;

import org.junit.Test;

import 07_SauceLabs.HomePage;
import 07_SauceLabs.SearchPage;

public class TestSearchProduct extends TestBase{

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

}
