package vTiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCMDLine {
	
	@Test
	public void readData()
	{
		String BVALUE = System.getProperty("browser");
		System.out.println(BVALUE);
		String UVALUE = System.getProperty("url");
		System.out.println(UVALUE);
		String ZVALUE = System.getProperty("password");
		System.out.println(ZVALUE);
	}

}
