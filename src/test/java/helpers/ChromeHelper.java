package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeHelper {

	private static WebDriver driver;

	public static WebDriver create(String url) {

		System.setProperty("webdriver.chrome.driver", "C:\\workspace_testes\\chromedriver.exe");

		if (driver == null)
			driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();

		return driver;
	}
}
