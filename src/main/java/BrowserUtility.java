import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {

	public WebDriver driver;

	/**
	 * This method will initialize the Driver on the basis of the browser we pass
	 * @param browsername
	 * @return driver
	 * @author srivaniChennupati
	 */

	public WebDriver initDriver(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\sriva\\eclipse-workspace\\ChromeDriver.exe");

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("firefox")) {

			// System.setProperty("webdriver.gecko.driver",
			// "C:\\Users\\sriva\\eclipse-workspace\\geckodriver.exe");

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}

		else {

			System.out.println("Pass the correct Browser" + browsername);

		}

		return driver;
	}

	/**
	 * This method will launch the URL
	 * 
	 * @param Url
	 * @return void
	 * @author srivaniChennupati
	 */

	public void launchURL(String Url) {

		if (Url == null || Url.isEmpty()) {

			System.out.println("URL is Incorrect");

		}

		driver.get(Url);

		return;

	}

	/**
	 * This method will help us to get the title of the Page
	 * 
	 * @return String
	 * @author srivaniChennupati
	 */

	public String getPageTitle() {

		return driver.getTitle();

	}

	/**
	 * This method gives us the Current Page URL
	 * 
	 * @return String
	 * @author srivaniChennupati
	 */

	public String getPageURL() {

		return driver.getCurrentUrl();
	}

	/**
	 * This method will close the browser
	 * 
	 * @author srivaniChennupati
	 */

	public void closeBrowser() {

		driver.close();
	}

}
