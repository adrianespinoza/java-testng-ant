package PackageThree;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

public class NoInjectionTest {

    @DataProvider(name = "provider")
    public Object[][] provide() throws Exception {
        return new Object[][] { { CC.class.getMethod("f") } };
    }

    @Test(dataProvider = "provider")
    public void withoutInjection(@NoInjection Method m) {
        System.out.println("22222222222 Method name without injection: " + m.getName() + " 22222222222");
        Assert.assertEquals(m.getName(), "f");
    }

    @Test(dataProvider = "provider")
    public void withInjection(Method m) {
        System.out.println("22222222222 Method name with injection: " + m.getName() + " 22222222222");
        Assert.assertEquals(m.getName(), "withInjection");
    }
}
