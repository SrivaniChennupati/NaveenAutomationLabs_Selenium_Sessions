import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandlingTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("datepicker")).click();
		
		String ActualyearandMonthXapth = "//div[@class='ui-datepicker-title']" ;
		
		
	

	}
	
	
	public void selectDate(String ExpectedYearMonth, String dateToSelect) {
		
		 if(Integer.parseInt(dateToSelect)>31) {
			 
			 System.out.println("Please pass the correct Date");
			 
		 }
		 
		 if (ExpectedYearMonth.contains("February")&&Integer.parseInt(dateToSelect)>29) {
			 
			 System.out.println("Please pass the corrcet Date");
			 
		 }
		
		
		
	    String ActaulYearAndMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	    
	    while(!ActaulYearAndMonth.equalsIgnoreCase(ExpectedYearMonth)) {
	    	
	    	driver.findElement(By.xpath("//span[text()='Next']")).click();
	    	
	    	ActaulYearAndMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	    	
	    	
	    	
	    }
	    
	    selectDay(dateToSelect);
		
	}
	
	
	
	public static void selectDay(String dateToSelect) {
		
		driver.findElement(By.xpath("//a[text()='"+dateToSelect+"']")).click();
		
		
	}

}
