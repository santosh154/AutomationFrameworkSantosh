package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void asserPractice()
	{
		SoftAssert sa=new  SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals(true, false);
		
		
		System.out.println("Step 3");
		
		System.out.println("Step 4");
		Assert.assertEquals(true, false);
		sa.assertAll();   //log all the assertion failures
	}
	
	@Test
	public void practice()
	{
		System.out.println("2nd script Step 1");
		Assert.assertEquals(false, true);
		System.out.println("2nd script Step 2");
		
		
	}
}
