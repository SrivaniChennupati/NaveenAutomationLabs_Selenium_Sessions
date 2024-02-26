import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandling {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		
      WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.id("datepicker")).click();
		
		selectDate("March 2025", "19");
		
		
		

	}
	
	
	public  static void selectDay(String Day) {
		
		driver.findElement(By.xpath("//a[text()='"+Day+"']")).click();
		
		
	}
	
	public static void selectDate(String ExpectedMonthYear, String Day) {
		
		if (Integer.parseInt(Day)>31) {
			
			System.out.println("wrong date passed....please pass the correct day/date....");
			return;
			
		}
		
		
		
		if (ExpectedMonthYear.contains("February")&& Integer.parseInt(Day)>29) {
			
			System.out.println("wrong date passed....please pass the correct day/date....");
			return;
			
			
		}
		
	
		String ActualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		
		while(!ActualMonthYear.equalsIgnoreCase(ExpectedMonthYear)){
			
			
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			
			 ActualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			
			
		}
		
		selectDay(Day);
		
		
		
	}
	
}
	

	



