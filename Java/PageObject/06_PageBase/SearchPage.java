package 06_PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase{
		
	public SearchPage(WebDriver driver){
		this._driver=driver;
	}
	
	public int getCantResultados(){
		return this._driver.findElements(By.cssSelector("#searchResults>li")).size();
	}

}
