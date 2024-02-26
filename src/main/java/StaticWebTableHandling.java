import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandling {
	
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		
		//table[@id='customers']//tbody//tr[1]/td[1]
		//table[@id='customers']//tbody//tr[2]/td[1]
		//table[@id='customers']//tbody//tr[3]/td[1]
		//table[@id='customers']//tbody//tr[4]/td[1]
		
		
		getTableData(2);
        
        
        
       
	}
	
	 public static void getTableData(int ColoumnNumber) {
		 
		            
		    //String beforexpath = "//table[@id='customers']/tbody/tr[" ;
		    
		   String beforexpath=  "//table[@id='customers']/tbody//tr/following-sibling::tr[" ;
		    
		    String Afterxpath = "]/td["+ColoumnNumber+"]";
		    
		   

			List<WebElement> rowlist = driver.findElements(By.xpath("//table[@id='customers']//tr"));
			
			
			for(int i=1;i<=rowlist.size()-1;i++) {
				
				String CompleteXpath = beforexpath+i+Afterxpath ;
				
				 String text = driver.findElement(By.xpath(CompleteXpath)).getText();
				 
				 System.out.println(text);
				
				
				
				
	
	        	
	        }
		 
		 
		 
	 }
		
	
	
	
}
