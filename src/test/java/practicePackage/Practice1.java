package practicePackage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    //driver.get("https://www.google.com/");
	    driver.navigate().to("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=10709697163011237488&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062140&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
	    //Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
	    driver.quit();
	    
	    
	    
	    
	    
	 

		
	
		
		
	}

}
