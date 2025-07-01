package practicePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import lakshmitej.pageobjects.Landingpage;

public class StandAloneTest {

    public static void main(String[] args) throws InterruptedException {

        String productName = "ZARA COAT 3";
     
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Landingpage landingpage = new Landingpage(driver);
        landingpage.goTo();
       // driver.get("https://rahulshettyacademy.com/client");

        
        // Login
        landingpage.loginApplication("luckytej04@gmail.com", "10March1998");
        //driver.findElement(By.cssSelector("input[type='email']")).sendKeys("luckytej04@gmail.com");
       // driver.findElement(By.cssSelector("input[type='password']")).sendKeys("10March1998");
       // driver.findElement(By.cssSelector("input[name='login']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        // Find and add product to cart
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        WebElement targetProduct = products.stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));

        targetProduct.findElement(By.cssSelector(".card-body button.w-10")).click();

        // Wait for toast and animation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

        // Go to cart
        driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        boolean match = cartProducts.stream()
                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);

        // Checkout
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();

        // Enter country
        WebElement countryInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("input[placeholder='Select Country']")));
        Actions actions = new Actions(driver);
        actions.sendKeys(countryInput, "india").build().perform();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
        driver.findElement(By.xpath("(//*[contains(text(),'India')])[2]")).click();

        // Place order
        driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
        String confirmMessage = driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        Thread.sleep(5000);
        System.out.println("Tej");
        driver.quit();
    }
}
