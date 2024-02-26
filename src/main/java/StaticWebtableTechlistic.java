import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebtableTechlistic {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		driver.manage().window().maximize();
		
		//table[@id='customers']//tr[2]/td[1]
		
		getTableData(2);
		
		
		}
	
	public static void getTableData(int coloumnNumber) {
		
		String beforexpath = "//table[@id='customers']//tr[" ;
		
		String afterxpath = "]/td["+coloumnNumber+"]" ;
		
		List<WebElement> rowcount = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		
		
		for (int row = 2 ; row<=rowcount.size()-1;row++ ) {
			
			
			String completexpath = beforexpath+row+afterxpath;
			
			String text = driver.findElement(By.xpath(completexpath)).getText();
			
			System.out.println(text);
			
			
			
			
		}
		
		
		
		
	}

}
