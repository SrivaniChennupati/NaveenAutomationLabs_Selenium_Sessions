import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathWebTable {
	
     static  WebDriver driver;
	
	
	
	

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2022-23-1298134/new-zealand-vs-pakistan-1st-semi-final-1298177/full-scorecard");
		
		driver.manage().window().maximize();
		
		/*
		 * String bowlerName = getBowlerName("Daryl Mitchell");
		 * 
		 * System.out.println(bowlerName);
		 */
			
		/* List<String> score = getScore("James Neesham"); */
			
			//System.out.println(score);
			
			List<String> bowlerScore = getBowlerScore("Haris Rauf");
			
			System.out.println(bowlerScore);
		

	}
	
	
	public static String getBowlerName(String batsmanname) {
		
		
		String bowlerxpath = "//span[text()='"+batsmanname+"']/ancestor::td/following-sibling::td/span" ;
		
		
		return driver.findElement(By.xpath(bowlerxpath)).getText();
		
		
	}
	
	
	public static List<String> getScore(String batsmanname) {
		
		
		List<String> ActualScorelist = new ArrayList<String>();
		
		
		String ScroreXpath = "//span[text()='"+batsmanname+"']/ancestor::td/following-sibling::td[contains(@class,'text-right')]" ;
		
		List<WebElement> scorelist = driver.findElements(By.xpath(ScroreXpath));
		
		for(WebElement e : scorelist) {
			
			
			String text = e.getText();
			
			ActualScorelist.add(text);
		}
		
		
		return ActualScorelist;
	}
	
	
	
	public static List<String> getBowlerScore(String bowlername) {
		
		List<String> ActualBowlerscore = new ArrayList<String> ();
		
		
		String scorecardxpath = "//span[text()='"+bowlername+"']/ancestor::td/following-sibling::td" ;
		
		
		List<WebElement> scorelist = driver.findElements(By.xpath(scorecardxpath));
		
		
		for (WebElement e : scorelist) {
			
			String text = e.getText();
			
			ActualBowlerscore.add(text);
			
		}
		
		return ActualBowlerscore;
	}

}
