package generalutils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	static String projectPath;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		
		try {
			workBook = new XSSFWorkbook(excelPath);
			sheet = workBook.getSheet(sheetName);
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
		
	}
	
	public static void getRowCount() {

		try {
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number Of Rows is :" + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	public static void getCellDataString(int rowNum, int colNum) {
		try {
			projectPath = System.getProperty("user.dir");
			workBook = new XSSFWorkbook(projectPath + "/excel/canadaRoots_data.xlsx");
			sheet = workBook.getSheet("signUp");
			String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(celldata);
			
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	
	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			projectPath = System.getProperty("user.dir");
			workBook = new XSSFWorkbook(projectPath + "/excel/canadaRoots_data.xlsx");
			sheet = workBook.getSheet("signUp");
			double celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(celldata);
			
		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

}
