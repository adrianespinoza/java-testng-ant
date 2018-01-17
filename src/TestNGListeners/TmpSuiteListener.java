package TestNGListeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.Reporter;

public class TmpSuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Starting");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Finishing");
    }

}
