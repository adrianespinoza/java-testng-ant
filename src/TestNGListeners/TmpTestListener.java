package TestNGListeners;

import log4jUtils.Log;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class TmpTestListener extends TestListenerAdapter {
    private int m_count = 0;

    @Override
    public void onTestFailure(ITestResult testResult) {
        Throwable thrown = testResult.getThrowable();
        StackTraceElement[] outTrace = new StackTraceElement[0];
        thrown.setStackTrace(outTrace);

        System.out.println("Method name failed: " + testResult.getMethod().getConstructorOrMethod().getName() + " Class name: " + testResult.getTestClass().getName() );
        System.out.println("Line number: " + Thread.currentThread().getStackTrace()[3].getClassName() + " Other informarion: " + testResult.getName() + " More information: " + thrown.getMessage());

        Reporter.setCurrentTestResult(testResult);
        Reporter.log("<a href=images/TestProgram.png" + ">Screenshot File</a> <br/>");

        /*testResult.setStatus(ITestResult.SKIP);
        Log.LOGGER.warn("Error in " + testResult.getName() + " with status " + testResult.getStatus());
        Log.LOGGER.info("Setting test run attempt status to Skipped");*/

        Log.LOGGER.error("Error in " + testResult.getName() + " with status " + testResult.getStatus(), thrown);

        log("F");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        System.out.println("Method name skipped: " + tr.getMethod().getConstructorOrMethod().getName() + " Class name: " + tr.getTestClass().getName());
        Reporter.setCurrentTestResult(tr);
        Reporter.log("<a href=\"" + "Adrian" + "\">Screenshot</a>");
        //Reporter.log("<h1>" + tr.getMethod().getConstructorOrMethod().getName() + " method failed</h1><br/>");
        log("S");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        Log.LOGGER.info("TEST SUCCESS!");
        log(".");
    }

    private void log(String string) {
        System.out.println(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }
}