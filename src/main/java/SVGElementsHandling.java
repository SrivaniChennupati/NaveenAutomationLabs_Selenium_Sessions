import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementsHandling {

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
		
		List<WebElement> ChartsList = driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-column-series highcharts-tracker')]//*[name()='rect']"));
		
         String ToolTipxpath = "//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']" ;
		
		Actions act = new Actions(driver);
         
         for (WebElement e : ChartsList) {
        	 
        	 
			act.moveToElement(e).build().perform();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			String text = driver.findElement(By.xpath(ToolTipxpath)).getText();
			
			System.out.println(text);
        	 
			
		}
	
	
	
	}

}
