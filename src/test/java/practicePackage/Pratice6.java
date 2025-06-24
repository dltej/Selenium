package practicePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Pratice6 {

    @Test(dataProvider = "getData")
    public void Satellite(String username, String password) {
        System.out.println("Satellite");
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "firstusername";
        data[0][1] = "firstpassword";
        data[1][0] = "secondusername";
        data[1][1] = "secondpassword";
        data[2][0] = "Thirdusername";
        data[2][1] = "Thirdpassword";

        return data;
    }
}
