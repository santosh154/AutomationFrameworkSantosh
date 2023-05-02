package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will generate random number for every run
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	/**
	 * This method will generate the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
		
	}
	/**
	 * This method will generate system date in format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[] dArr=d.toString().split(" ");
		String day=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":", "-");
		String date=day+"-"+month+"-"+year+" "+time;
		return date;
		
		}
	
}
