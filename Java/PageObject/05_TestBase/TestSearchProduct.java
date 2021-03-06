package 05_TestBase;

import org.junit.Test;

import 05_TestBase.HomePage;
import 05_TestBase.SearchPage;

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
