package PackageOne;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTestNGOne implements ITest{

    Operation op = new Operation();
    int firstValue = 2;
    int secondValue = 2;

    @Test(testName = "TC-IT-003")
    public void SumTest()
    {
        int sumLocal = op.Sum(firstValue, secondValue);
        Assert.assertEquals(sumLocal, 5);
        System.out.println("Sum operation has been executed");
    }
    @Test
    public void DifferenceTest()
    {
        int sumLocal = op.Difference(firstValue, secondValue);
        Assert.assertEquals(sumLocal, 0);
        System.out.println("Difference operation has been executed");
    }
    @Override
    public String getTestName() {
        // TODO Auto-generated method stub
        return "[Tested by Adrian]";
    }
    @DataProvider
    public Object[][] provideNumbers(Method method) {
        Object[][] result = null;
        if (method.getName().equals("two")) {
            result = new Object[][] { new Object[] { 2 }};
        }
        else if (method.getName().equals("three")) {
            result = new Object[][] { new Object[] { 3 }};
        }
        return result;
    }
    @Test(dataProvider = "provideNumbers")
    public void two(int param) {
        System.out.println("Two received: " + param);
    }
    @Test(dataProvider = "provideNumbers")
    public void three(int param) {
        System.out.println("Three received: " + param);
    }
}
