package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider="getData")
	public void getApparel(String brand,int price,int size)
	{
		System.out.println(brand+"---->"+price+"---------->"+size);
		
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data =new Object[5][3];
		data[0][0]="Puma";
		data[0][1]=700;
		data[0][2]=9;
		
		data[1][0]="sparx";
		data[1][1]=800;
		data[1][2]=10;
		
		data[2][0]="adidas";
		data[2][1]=400;
		data[2][2]=7;
		
		data[3][0]="nike";
		data[3][1]=1000;
		data[3][2]=9;
		
		data[4][0]="wrangler";
		data[4][1]=600;
		data[4][2]=9;
		
		return data;
		
	}
	
}
