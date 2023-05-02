package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author PT
 *
 */

public class ExcelFileUtility {
		
	/**
	 * This method will read data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowNo);
		Cell ce = r.getCell(cellNo);
		String value=ce.getStringCellValue();
		wb.close();
		return value;
		
		}
	/**
	 * This meethod will write data into excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetname, int rownum, int cellnum, Date value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet=wb.createSheet(sheetname);
		Row r=sheet.createRow(rownum);
		Cell c=r.createCell(cellnum);
		c.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(ConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCel=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
		
	}
	
	

}
