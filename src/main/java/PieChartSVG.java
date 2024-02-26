import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PieChartSVG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
	    driver.get("https://emicalculator.net/");
	    
	    driver.manage().window().maximize();
	    
	   List<WebElement>  pielist= driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g']//*[name()='g' and contains(@class,'highcharts-pie-series')]//*[name()='path']"));
	    
	    for (WebElement  e :pielist ) {
	    	
	    	Actions ac = new Actions(driver);
	    	
	    	ac.moveToElement(e).build().perform();
	    	
	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	String text = driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-label highcharts-tooltip')]//*[name()='text']")).getText();
			
		    System.out.println(text);
	    
	    }

	}

}
