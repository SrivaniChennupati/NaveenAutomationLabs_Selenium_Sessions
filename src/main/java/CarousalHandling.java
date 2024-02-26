import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarousalHandling {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		driver.manage().window().maximize();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String ProdcutsList = "//h2[text()='Amazon Live | Shop livestreams']/parent::div/parent::div/following-sibling::div//div/following-sibling::div[@data-id='Products']//div[contains(@class,'doubleLinesTitle')]";
		
		String carosualbutton = "//a[contains(@class,'scroll-carousel_feedRight')]";
		
		
		List<WebElement> Prodctslist = driver.findElements(By.xpath(ProdcutsList));
		
		Set<String> productsvaluelist = new TreeSet<String>();
		
		while(!driver.findElement(By.xpath(carosualbutton)).getAttribute("class").contains("scroll-carousel_feedDisable")) {
			
			
			for(WebElement e :Prodctslist) {
				
				String text = e.getText();
				
				if(!text.isEmpty()) {
					
					productsvaluelist.add(text);
					
				}
				
				}
			
			driver.findElement(By.xpath(carosualbutton)).click();
			
			Prodctslist = driver.findElements(By.xpath(ProdcutsList));
			
			
			
		}
		
		for (String e : productsvaluelist) {
			
		System.out.println(e);
			
			
		}
		
		
		
	

	}

}
