import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practicetest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
WebDriverManager.chromedriver().setup();
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver-win64\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	  getCarousalList("Blockbuster Deals");
	
	
	}
	
	public static void getCarousalList(String Carosualname) {
		
		List<WebElement> carousallist = driver.findElements(By.xpath("//h2[text()='"+Carosualname+"']/parent::div/following-sibling::div//ul/li"));
		
		String carosalxpath = "//div[@class='a-section feed-carousel-viewport']/following-sibling::a[@aria-label='Carousel next slide']";
		
		Set<String> itemslist = new TreeSet<String>();
		
		while(!driver.findElement(By.xpath(carosalxpath)).getAttribute("class").contains("feed-control-disabled")) {
			
			
			for(WebElement e : carousallist) {
				
				String text = e.getText();
				
				if(!text.isEmpty()) {
				
				itemslist.add(text);
				
				}
				
			}
			
			
			driver.findElement(By.xpath(carosalxpath)).click();
			
			carousallist = driver.findElements(By.xpath("//h2[text()='"+Carosualname+"']/parent::div/following-sibling::div//ul/li"));
			
			
			
		}
		
	      
	      for (String e : itemslist) {
	    	  
	        System.out.println(e);
			
		}
	     
       
	
	
	}
	
	
	
	
	
}
