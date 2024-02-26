import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonCarousalHandlingTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		driver.manage().window().maximize();
		
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		getLiveStreamElements();

	}
	
	public static void getLiveStreamElements() {

		String listxpath = "//h2[text()='Amazon Live | Shop livestreams']/parent::div/parent::div/following-sibling::div//div[@data-id ='TileTitle']" ;
		
		List<WebElement> listitems = driver.findElements(By.xpath(listxpath));
		
		Set<String > ActualItemslist = new TreeSet<String>();
		
		
		String CarosalXpath = "//h2[text()='Amazon Live | Shop livestreams']/parent::div/parent::div/following-sibling::div//a[@data-id='carouselControlFeedNext']" ;
		
		
		while(!driver.findElement(By.xpath(CarosalXpath)).getAttribute("class").contains("feedDisable")) {
			
			
			for (WebElement e : listitems) {
				
				String text = e.getText();
				
				if(!text.isEmpty()) {
					
					ActualItemslist.add(text);
					
				}
				driver.findElement(By.xpath(CarosalXpath)).click();
				
				listitems = driver.findElements(By.xpath(listxpath));
				
				
			}
			
			}
		
		for (String e : ActualItemslist) {
			
			//System.out.println(e);
			
			String[] split = e.split(",");
			
		      for (String e1 : split) {
		    	  
		    	  System.out.println(e1);
				
			}
			
			
		}
		
	}

}
