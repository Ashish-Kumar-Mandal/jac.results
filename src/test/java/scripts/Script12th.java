package scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Year;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import helper.Help;

public class Script12th extends BaseScript {
	static int i = 0;
	static int rollNo = 0;
	File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\outputs\\JAC_12th_Results.xlsx");
	String sheetName;
	
	@Test
	public void searchResult() throws IOException {
		sheetName = super.stream+"_"+super.rollCode+"-"+Year.now();
		createNewSheet();
		
		int rollNumberLength = super.rollNumber.length();
		rollNo = Integer.parseInt(super.rollNumber);

		while(true) {
			++i;			
			String roll_number = String.format("%0"+rollNumberLength+"d", rollNo);
			rollNo = rollNo + 1;
			
			jac12.setRollCode(super.rollCode);
			jac12.setRollNumber(roll_number);
			jac12.clickSubmit();
			
			if(jac12.getRollNumber() == null) {
				driver.quit();
				break;
			}
			
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
	
			sheet.createRow(i);
			sheet.getRow(i).createCell(0).setCellValue("");
			sheet.getRow(i).createCell(1).setCellValue(Help.capitalizeWord(jac12.getName()));
			
			if (jac12.totalNumberOfRows() == 8) {
				sheet.getRow(i).createCell(2).setCellValue(jac12.getTotalMarks());
				sheet.getRow(i).createCell(3).setCellValue(Help.getPercentage(jac12.getTotalMarks()));
				sheet.getRow(i).createCell(4).setCellValue(jac12.getResultStatus());
			} else if(jac12.totalNumberOfRows() == 9){
				sheet.getRow(i).createCell(2).setCellValue(jac12.getTotalMarksExtra());
				sheet.getRow(i).createCell(3).setCellValue(Help.getPercentage(jac12.getTotalMarksExtra()));
				sheet.getRow(i).createCell(4).setCellValue(jac12.getResultStatusExtra());
			} else {
				sheet.getRow(i).createCell(2).setCellValue(0);
				sheet.getRow(i).createCell(3).setCellValue(0);
				sheet.getRow(i).createCell(4).setCellValue("F/A");
			}
			
			sheet.getRow(i).createCell(5).setCellValue(jac12.getRollNumber());
			sheet.getRow(i).createCell(6).setCellValue(Help.capitalizeWord(jac12.getFatherName()));
			sheet.getRow(i).createCell(7).setCellValue(Help.capitalizeWord(jac12.getMotherName()));
			sheet.getRow(i).createCell(8).setCellValue(Help.capitalizeWord(jac12.getCollegeName()));
			
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			workbook.close();
	
			jac12.goBack();
		}
	}
	
	void createNewSheet() throws IOException{
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet st = null;
		
		if(wb.getSheet(sheetName) == null) {
			st = wb.createSheet(sheetName);
		}else {
			st = wb.getSheet(sheetName);			
		}
								
		st.createRow(0);
		st.getRow(0).createCell(0).setCellValue("Rank");
		st.getRow(0).createCell(1).setCellValue("Name");
		st.getRow(0).createCell(2).setCellValue("Marks");
		st.getRow(0).createCell(3).setCellValue("Percentage");
		st.getRow(0).createCell(4).setCellValue("Division");
		st.getRow(0).createCell(5).setCellValue("Roll No");
		st.getRow(0).createCell(6).setCellValue("Father's Name");
		st.getRow(0).createCell(7).setCellValue("Mother's Name");
		st.getRow(0).createCell(8).setCellValue("School/College Name");
		
		OutputStream fos = new FileOutputStream(file);	
		wb.write(fos);
		fos.close();
		wb.close();
	}
}
