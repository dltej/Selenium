package lakshmitej.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {
	WebDriver driver;

	public Landingpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	  //driver.findElement(By.cssSelector("input[type='email']")).sendKeys("luckytej04@gmail.com");
    // driver.findElement(By.cssSelector("input[type='password']")).sendKeys("10March1998");
    // driver.findElement(By.cssSelector("input[name='login']")).click();
	
	
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

	public void loginApplication(String email, String password) {

		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();

	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");

	}

}
