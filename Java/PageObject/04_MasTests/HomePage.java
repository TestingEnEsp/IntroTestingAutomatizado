package 04_MasTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import 04_MasTests.SearchPage;

public class HomePage {
	
	WebDriver _driver;
	String _url = "http://www.mercadolibre.com.ar/";
	String _title = "MercadoLibre Argentina";
	
	public HomePage(WebDriver driver) {
		this._driver = driver;
	}
	
	public SearchPage searchFor(String keyword){
        WebElement search_field = this._driver.findElement(By.id("query"));
        search_field.sendKeys(keyword);
        search_field.submit();

        return new SearchPage(this._driver);
	}
}
