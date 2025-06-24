package practicePackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice3 {

	@Test(enabled = false)
	public void sum() {
		int a = 1;
		int b = 2;
		System.out.println(a + b);

	}

	@Test(groups = { "Run" }, priority = 1)
	public void multiply() {
		int a = 1;
		int b = 2;
		System.out.println(a * b);
	}

	@Test(groups = { "Running" }, priority = 2)
	public void sub() {
		int a = 1;
		int b = 2;
		System.out.println(a - b);

	}

	@Test
	public void quotient() {
		int a = 4;
		int b = 2;
		System.out.println(a / b);
	}

	 @BeforeMethod
	public void cookiesclear() {
		System.out.println("Cookies are clearing before");
    }

	 @AfterMethod
	public void cachieclear() {

		System.out.println("Cachies are clearing after");

	}

	@Test(dependsOnMethods = { "quotient" })
	public void remainder() {
		int a = 4;
		int b = 2;
		System.out.println(a % b);

	}

}
