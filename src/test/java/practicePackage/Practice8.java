package practicePackage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import practicePackage.MyListener;

@Listeners(MyListener.class)
public class Practice8 {
    @Test
    public void testPass() {
        System.out.println("Running testPass...");
        System.out.println("Running tested");
        
    }

    @Test
    public void testFail() {
        System.out.println("Running testFail...");
        assert false;
    }
}
