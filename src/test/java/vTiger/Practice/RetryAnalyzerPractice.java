package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer=vTiger.GenericUtilities.RetryAnalyserImplementationClass.class)
	public void analyzerPractice()
	{
		
		System.out.println("Hii");
		Assert.fail();
	}
	

}
