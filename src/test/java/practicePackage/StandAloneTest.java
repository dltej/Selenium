package practicePackage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String productName = "ZARA COAT 3";
   WebDriverManager.chromedriver().setup();
   WebDriver driver = new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   driver.manage().window().maximize();
   driver.get("https://rahulshettyacademy.com/client");
   driver.findElement(By.xpath("//input[@type='email']")).sendKeys("luckytej04@gmail.com");
   driver.findElement(By.xpath("//input[@type='password']")).sendKeys("10March1998");
   driver.findElement(By.xpath("//input[@name='login']")).click();
   
  
		
		
		
	}

}
