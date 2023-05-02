package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFile {

	public static void main(String[] args) throws IOException {
		// step 1:open the document in java readable format using file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// step2:create a workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);

		// step3:get the control of sheet
		Sheet sh = wb.getSheet("Contact");

		// step4:create a row
		Row r = sh.createRow(10);
		// step5:create a cell
		Cell ce = r.createCell(7);

		// step6:set the value into cell
		ce.setCellValue("Batman");

		// step 7:open the excel in writable format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		// step8:write data into workbook
		wb.write(fos);

		// step9:close the workbook
		wb.close();
		System.out.println("Data added and Workbook closed");

	}

}
