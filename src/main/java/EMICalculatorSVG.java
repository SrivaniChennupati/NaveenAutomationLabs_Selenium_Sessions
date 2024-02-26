import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EMICalculatorSVG {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
	    driver.get("https://emicalculator.net/");
	    
	    driver.manage().window().maximize();
	    
	    List<WebElement> svglist = driver.findElements(By.xpath("(//*[local-name()='svg'])[2]//*[name()='g' and contains(@class,'highcharts-tracker')]//*[name()='rect']"));
	    
	    
		for (WebElement e : svglist) {
			
			Actions ac = new Actions(driver);
			
			ac.moveToElement(e).build().perform();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			  String text = driver.findElement(By.xpath("(//*[local-name()='svg'])[2]//*[local-name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']")).getText();
			  
			  System.out.println(text);
			
		}
		
		
		
		
		

	}

}
