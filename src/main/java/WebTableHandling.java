import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandling {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.espncricinfo.com/series/new-zealand-in-bangladesh-2021-1272089/bangladesh-vs-new-zealand-4th-t20i-1272096/full-scorecard");
		
		
		List<String> scoreList = getScoreList("Finn Allen");
		
		System.out.println(scoreList);
	}
	
	
	public static  List<String>  getScoreList (String batsmanname) {
		
		
		String scoreXpath = "(//table)[1]//span[text()='"+batsmanname+"']/ancestor::td/following-sibling::td/following-sibling::td";
		
		List<WebElement> Scorelist = driver.findElements(By.xpath(scoreXpath));
		
		List<String> ActualScrorelist = new ArrayList<String>();
		
		for(int i=0;i<=Scorelist.size()-1;i++) {
			
			
			String text = Scorelist.get(i).getText();
			
			
			ActualScrorelist.add(text);
		      
			
			
		}
		
		return ActualScrorelist;
		
	}

}
