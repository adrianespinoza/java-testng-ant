package TestNGUtils;

import org.testng.ITestResult;

public class TestngUtils {
    public static String getFullNameMethod(ITestResult testResult) {
        String testClassName = testResult.getTestClass().getName();
        String testMethodName = testResult.getMethod().getConstructorOrMethod().getName();
        return (testClassName + "." + testMethodName);
    }
    public static String getFullNameMethodWithoutDot(ITestResult testResult) {
        String result = (getFullNameMethod(testResult)).replaceAll("\\.", "");
        return result;
    }
}
