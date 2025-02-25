package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public  FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtilities(String path) {
		this.path = path;
		}
	
	
	
	public int getRowCount(String sheetName) throws IOException
	
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet("sheet1");
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		
		return rowCount;	
	}
	
public int getcellCount(String sheetName, int rowNum) throws IOException
	
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet("sheet1");
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		
		return cellCount;	
	}
	
public String getcellData(String sheetName, int rowNum, int cellNum) throws IOException

{
	fi = new FileInputStream(path);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(sheetName);
	row = ws.getRow(rowNum);
	cell = row.getCell(cellNum);
	
	DataFormatter formatter = new DataFormatter();
	String data;
	
	try {
		data = formatter.formatCellValue(cell);
	}
	catch(Exception e) {
		data = "";
	}
	wb.close();
	fi.close();
	
	return data;	
}

public void setcellData(String sheetName, int rowNum, int cellNum, String data)throws IOException {
	File xfile = new File(path);
	if(!xfile.exists()) {
		wb = new XSSFWorkbook();
		fo = new FileOutputStream(path);
		wb.write(fo);
	}
	fi = new FileInputStream(path);
	wb = new XSSFWorkbook(fi);
	if(wb.getSheetIndex(sheetName)==-1) {
		wb.createSheet(sheetName);
		ws =wb.getSheet(sheetName);
	}
	if(ws.getRow(rowNum)==null) {
		ws.createRow(rowNum);
		row = ws.getRow(rowNum);
	}
	cell = row.createCell(cellNum);
	cell.setCellValue(data);
	fo = new FileOutputStream(path);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();	
}
}
