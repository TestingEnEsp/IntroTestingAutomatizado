package sipageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	
	WebDriver _driver;
	
	public SearchPage(WebDriver driver){
		this._driver=driver;
	}
	
	public int getCantResultados(){
		return this._driver.findElements(By.cssSelector(".product-name a")).size();
	}

}
