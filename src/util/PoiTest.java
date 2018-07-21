package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.scene.chart.PieChart.Data;

public class PoiTest {

	private static final String EXCEL_PATH = "G:\\data\\poi\\";
	// 2003版本的.xls, 一张sheet表允许存2^16 ＝ 次方行数据，2^8 = 256列数据，
	private static final String SUFFIX_HSSF = ".xls";
	// 2007版本以上的.xlsx，一张sheet表允许存的数据就更大了，是百万级别的。行： 2^20 = 1048576; 列：2^14 =
	// 16384 行。
	private static final String SUFFIX_XSSF = ".xlsx";
	
	  public static ArrayList<String> getAllFilePaths(File filePath, ArrayList<String> filePaths)
	  {
	    File[] files = filePath.listFiles();
	    if (files == null) {
	      return filePaths;
	    }
	    for (File f : files) {
	      if (f.isDirectory())
	      {
	        getAllFilePaths(f, filePaths);
	      }
	      else {
	    	  if(f.getPath().endsWith(".xlsx") || f.getPath().endsWith(".xls"))
	    		  filePaths.add(f.getPath());
	    	  }
	    }

	    return filePaths;
	  }

	public static void main(String[] args) throws Exception {
		//createWorkBook("G:\\data\\poi\\output");
		ArrayList<String> files = new ArrayList<String>();
		String bathpath = "C:\\Users\\hyt\\Desktop\\82 特困供养发放明细表（民政局）\\2017年五保资金实际发放\\五保临时价格补贴";
		File file = new File(bathpath);
		getAllFilePaths(file, files);
		for(String filename:files) {
			System.out.println(filename);
			ReadWriteExcel.getData(filename);
			//System.exit(0);
		
		}
	}
}