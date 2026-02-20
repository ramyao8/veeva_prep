package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	private  FileInputStream fin;
	private  FileOutputStream fout;
	private  XSSFWorkbook wb;
	private  XSSFSheet sheet;
	private  XSSFRow row;
	private  XSSFCell cell;
	private  CellStyle style;
	private  String filePath;
	public ExcelUtilities(String filePath)
	{
		this.filePath=filePath;
	}
	public  int getRowsCount(String sheetName) throws IOException {
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);
		
		int r = sheet.getLastRowNum();
		fin.close();
		wb.close();
		return r;
	}
	
	public  int getColumnsCount(String sheetName) throws IOException {
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);
		
		int c = sheet.getRow(0).getLastCellNum();
		fin.close();
		wb.close();
		return c;
	}
	
	public  String getCellValue(String sheetName, int r, int c) throws IOException{
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet.getRow(r).getCell(c));
		//String data = sheet.getRow(r).getCell(c).toString();
		fin.close();
		wb.close();
		return data;
	}
	
	public  void setCellValue(String sheetName, int r, int c, String data) throws IOException{
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);
		
		row = sheet.getRow(r);
		cell = row.createCell(c);
		cell.setCellValue(data);
		
		fout = new FileOutputStream(filePath);
		wb.write(fout);
		fin.close();
		fout.close();
		wb.close();
	}
	
	public  void fillGreenColor(String sheetName, int r, int c) throws IOException {
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);		
		row = sheet.getRow(r);
		cell = row.createCell(c);
		
		style = wb.createCellStyle();
		//apply green back ground color
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//apply style to cell
		cell.setCellStyle(style);
		
		fout = new FileOutputStream(filePath);
		wb.write(fout);
		fin.close();
		fout.close();
		wb.close();
		
	}
	
	public  void fillRedColor(String sheetName, int r, int c) throws IOException {
		fin = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fin);
		sheet = wb.getSheet(sheetName);		
		row = sheet.getRow(r);
		cell = row.createCell(c);
		
		style = wb.createCellStyle();
		//apply green back ground color
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//apply style to cell
		cell.setCellStyle(style);
		
		fout = new FileOutputStream(filePath);
		wb.write(fout);
		fin.close();
		fout.close();
		wb.close();
		
	}
}
