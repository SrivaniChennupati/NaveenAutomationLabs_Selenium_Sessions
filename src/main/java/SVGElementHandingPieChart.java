import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementHandingPieChart {

	public static void main(String[] args) {
		
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 String PiechartXpath = "//*[local-name()='svg']//*[contains(@class,'highcharts-series-group')]//*[name()='g' and contains(@class,'highcharts-pie-series highcharts-tracker')]//*[name()='path']";
		
		 String tooltipXpath = "//*[local-name()='svg']//*[contains(@class,'highcharts-label highcharts-tooltip')]//*[name()='text']";
       
		 List<WebElement> piechartlist = driver.findElements(By.xpath(PiechartXpath));
		 
		 Actions ac = new Actions(driver);
		 
		 for (WebElement e : piechartlist) {
			 
			 ac.moveToElement(e).build().perform();
			 
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 String text = driver.findElement(By.xpath(tooltipXpath)).getText();
			 
			 System.out.println(text);
			 
		}
		 
		 
		 
		 
	}

}
