package lakshmitej.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import lakshmitej.pageobjects.Landingpage;

public class BaseTest {

	public WebDriver driver;
	public Landingpage landingpage;

	public WebDriver initizlizeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\dudal\\gitStuff\\Selenium\\src\\main\\java\\lakshmitej\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			// edge
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	@BeforeMethod
	public Landingpage launchApplication() throws IOException {

		driver = initizlizeDriver();
		landingpage = new Landingpage(driver);
		landingpage.goTo();
		return landingpage;

	}

	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("Tej");
		//driver.quit();
		driver.close();
		
		
	}
	
}
