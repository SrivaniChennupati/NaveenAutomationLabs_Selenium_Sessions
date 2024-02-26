import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebtablePracticing {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		getTableData(2);
		

	}
	
	public static void getTableData(int CouloumnNumber) {
		
		
		String beforexpath = "//table[@id='customers']//tbody//tr/following-sibling::tr[";
		
		String afterxpath = "]//td["+CouloumnNumber+"]" ;
		 
		
		List<WebElement> totalrows = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
		
		for(int i=1;i<=totalrows.size()-1;i++) {
			
			
			String CompleteXpath = beforexpath+i+afterxpath;
			
			
			String text = driver.findElement(By.xpath(CompleteXpath)).getText();
			
			
			System.out.println(text);
			
			
		}
		
		
		
		
	}

}
