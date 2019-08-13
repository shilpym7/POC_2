package BASE_CLASSES;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


public class LogUpdate implements ITestListener{

	Logger log;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		log=Logger.getLogger("devpinoyLogger");
		  log.info("=======================================================================");
		  log.info(result.getName());
		  log.info("=======================================================================");
		  
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log=Logger.getLogger("devpinoyLogger");
		  log.info("=======================================================================");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log=Logger.getLogger("devpinoyLogger");
		  log.info("=======================================================================\n");
		
	}

}
