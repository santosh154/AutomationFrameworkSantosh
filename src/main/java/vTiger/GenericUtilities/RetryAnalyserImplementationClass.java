package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class is an implementation class for IRetryAnalyzer interface for testNG
 * @author PT
 *
 */
public class RetryAnalyserImplementationClass implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count=0;
		int retryCount=3;    //Analyse manually and get the retry count
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
