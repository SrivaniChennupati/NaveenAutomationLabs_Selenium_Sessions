import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoOpenCart {

	public static void main(String[] args) {

		BrowserUtility BU = new BrowserUtility();

		WebDriver driver = BU.initDriver("Chrome");

		BU.launchURL("https://demo.opencart.com/index.php?route=account/login&language=en-gb");

		driver.manage().window().maximize();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> FooterlinksList = driver.findElements(By.xpath("//footer//a"));

		System.out.println(FooterlinksList.size());

		for (int i = 0; i <= FooterlinksList.size() - 1; i++) {

			String footerlinkstext = FooterlinksList.get(i).getText();

			System.out.println(footerlinkstext);

			if (footerlinkstext.equals("My Account")) {

				JavascriptExecutor Js = (JavascriptExecutor) driver;

				Js.executeScript("arguments[0].click()", FooterlinksList.get(i));

				break;

			}

			/*
			 * for (WebElement e : FooterlinksList) {
			 * 
			 * String text = e.getText();
			 * 
			 * System.out.println(text);
			 * 
			 * if(text.equals("Delivery Information")) {
			 * 
			 * 
			 * // e.click();
			 * 
			 * JavascriptExecutor Js = (JavascriptExecutor)driver;
			 * 
			 * Js.executeScript("arguments[0].click()", e);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * }
			 */

		}

		// ElementUtility EU = new ElementUtility(driver);

	}

}
