
package practicePackage;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice4 {
	
@Test(invocationCount = 5)
public void car(){
System.out.println("Car");
System.out.println("Carmela");

}


@Test
public void bike(){
System.out.println("Bike");
}

	
@Test
@Parameters({ "username", "password" })
public void loginTest(String user, String pass) {
    System.out.println("Username: " + user);
    System.out.println("Password: " + pass);
}


@Test
public void Aeroplane(){
System.out.println("Aeroplane");

	
}




}



