package lakshmitej.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lakshmitej.AbstractComponents.AbstractComponent;

public class Landingpage extends AbstractComponent {
	WebDriver driver;

	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.cssSelector("input[type='email']")).sendKeys("luckytej04@gmail.com");
	// driver.findElement(By.cssSelector("input[type='password']")).sendKeys("10March1998");
	// driver.findElement(By.cssSelector("input[name='login']")).click();

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public ProductCatalogue loginApplication(String email, String password) {

		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public String getErrorMessage() 
	
	{
        waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");

	}

}
