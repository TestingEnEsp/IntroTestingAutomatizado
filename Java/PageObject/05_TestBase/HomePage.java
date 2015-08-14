package testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testbase.SearchPage;

public class HomePage {
	
	WebDriver _driver;
	String _url = "http://demo.magentocommerce.com/";
	String _title = "Madison Island";
	
	public HomePage(WebDriver driver) {
		this._driver = driver;
	}
	
	public SearchPage searchFor(String keyword){
        WebElement search_field = this._driver.findElement(By.id("search"));
        search_field.sendKeys(keyword);
        search_field.submit();

        return new SearchPage(this._driver);
	}
}
