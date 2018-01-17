package TestNGListeners;

import log4jUtils.Log;
import log4jUtils.Log4jPropertiesHandler;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import TestNGUtils.TestngUtils;

public class TmpInvokedMethodListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Before From Invoked Method Listener ::: Method: " + testResult.getMethod().getConstructorOrMethod().getName() + " Class: " + testResult.getTestClass().getName());
        String testMethodName = testResult.getMethod().getConstructorOrMethod().getName();
        //String logFileName = (testClassName + testMethodName).replaceAll("\\.", "");
        Log4jPropertiesHandler.instance().swithLogFileName(testMethodName);
        Log.LOGGER.info("Starting test with" + TestngUtils.getFullNameMethod(testResult) + " method");

        Reporter.setCurrentTestResult(testResult);
        Reporter.log(testMethodName + ": <a href=logs/" + testMethodName + ".log>Log File</a><br/>");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("After From Invoked Method Listener ::: Method: " + testResult.getMethod().getConstructorOrMethod().getName() + " Class: " + testResult.getTestClass().getName());
        System.out.println("-------------------------------------------------------------------------------------------");

        Log.LOGGER.info("Finishing test for" + TestngUtils.getFullNameMethod(testResult) + " method");
    }

}
