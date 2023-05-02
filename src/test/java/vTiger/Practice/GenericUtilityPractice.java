package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		JavaUtility jUtil=new JavaUtility();
	int value = jUtil.getRandomNumber();
	System.out.println(value);
	System.out.println(jUtil.getSystemDate());
	System.out.println(jUtil.getSystemDateInFormat());
	
	PropertyFileUtility pUtil=new PropertyFileUtility();
	String value1=pUtil.ReadDataFromPropertyFile("browser");
	System.out.println(value1);
	
	ExcelFileUtility eUtil=new ExcelFileUtility();
	String value2=eUtil.readDataFromExcel("Organization", 7, 2);
	System.out.println(value2);
	
	

	}

}
