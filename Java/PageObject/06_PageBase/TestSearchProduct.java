package pagebase;

import org.junit.Test;

import sipageobject.HomePage;
import sipageobject.SearchPage;

public class TestSearchProduct extends TestBase{

	
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

}
