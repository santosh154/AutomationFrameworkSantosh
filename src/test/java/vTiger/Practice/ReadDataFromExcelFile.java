package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		// step 1:open the document in java readable format using file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// step2:create a workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);

		// step3:get the control of sheet
		Sheet sh = wb.getSheet("Organization");

		// step 4:get the control of row
		Row row = sh.getRow(4);

		// step 5:get control of cell
		Cell ce = row.getCell(3);

		// step6:read the data inside cell
		String s = ce.getStringCellValue();
		
		System.out.println(s);
		
		//step 7:close the workbook
		wb.close();

	}

}
