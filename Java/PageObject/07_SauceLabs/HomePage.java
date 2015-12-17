package 07_SauceLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import 07_SauceLabs.SearchPage;

public class HomePage extends PageBase{
		
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
