package PackageTwo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateTestNGOne {
    @Test
    public void HiWorld()
    {
        System.out.println("Hello world more formally");
        Assert.assertEquals(false, true);
    }
}
