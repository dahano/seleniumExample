package BaseTestSetup;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by ofirdahan on 3/3/17.
 */
public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 3;

    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxRetryCount){
            System.out.println("Retrying tests" + iTestResult.getName() + " with status: "
                    + getResultStatus(iTestResult.getStatus()) + " for the " + (retryCount+1) + " time(s)");
            retryCount++;
            return true;
        }
        return false;
    }

    private String getResultStatus(int status) {
        String resultName = null;

        if(status==1)
            resultName = "SUCCESS";
        if(status==2)
            resultName = "FAILURE";
        if(status==3)
            resultName = "SKIP";
            return resultName;

    }


}
