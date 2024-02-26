import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTab {
	
	public static WebDriver driver;
	
	public static void main (String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		 
	
	     driver.get("https://www.w3schools.com/html/html_tables.asp");
	     
	     
		
		
	}
	
	public static void getData(int coulumn) {
		
		int rowsize=driver.findElements(By.xpath("//table[@id='customers']//tbody//tr")).size();
		
		for (int i=1;i<=rowsize-1;i++) {
			
			  ////table[@id='customers']//tbody//tr[4]//td[1]
			
			String beforexpath = "//table[@id='customers']//tbody//tr[";
			
			String afterxpath = "]//td['"+coulumn+"']";
		}
	}
	
	

}
