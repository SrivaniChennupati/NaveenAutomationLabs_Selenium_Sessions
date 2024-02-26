import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePracticing {
	
	static	WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.espncricinfo.com/series/new-zealand-in-bangladesh-2021-1272089/bangladesh-vs-new-zealand-4th-t20i-1272096/full-scorecard");
	
		
		String bowlername = getBowlerName("Tom Latham");
		
		System.out.println(bowlername);
		
		List<String> scoreList = getScoreList("Tom Blundell");
		
		System.out.println(scoreList);
		

	}
	
	public  static String getBowlerName(String BatsmanName) {
		
		
		String BatsmanXpath = "//span[text()='"+BatsmanName+"']/ancestor::td/following-sibling::td/span" ;
		
		
		String bowlername = driver.findElement(By.xpath(BatsmanXpath)).getText();
		     
		
		return bowlername;
		
	}
	
	
	public  static List<String> getScoreList (String batsmanname) {
		
		List<String> Actualscorelist = new ArrayList<String>();
		
		
		String batsmanxpath = "//th[text()='BATTING']/ancestor::thead/following-sibling::tbody//span[text()='"+batsmanname+"']/ancestor::td/following-sibling::td/following-sibling::td" ;
		
		List<WebElement> scorelist = driver.findElements(By.xpath(batsmanxpath));
		
		
		for (WebElement e : scorelist) {
			
			String text = e.getText();
			
			Actualscorelist.add(text);
			
			
		}
		
		return Actualscorelist;
		
	}
	
	
	
	
	

}
