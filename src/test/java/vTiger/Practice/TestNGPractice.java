package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	@Test
	public void createUser()
	{
		
		System.out.println("createuser");
	}
	@Test(dependsOnMethods="createUser")
	public void modifyUser()
	{
		System.out.println("modifyuser");
	}
	@Test(enabled=true)
	public void deleteUser()
	{
		System.out.println("deleteuser");
	}

}
