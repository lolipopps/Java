package telnet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSVDELETE {

	public static void main(String[] args) {
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		List<Map<String, String>> list = null;
		String cellData = null;
		String filePath = "test.xlsx";
		wb = readExcel(filePath);
		int begin = 0;
		Boolean flag = true;
		HSSFWorkbook wbCreat = new HSSFWorkbook();
		if (wb != null) {
			// 鐢ㄦ潵瀛樻斁琛ㄤ腑鏁版嵁
			list = new ArrayList<Map<String, String>>();
			// 鑾峰彇绗竴涓猻heet
			sheet = wb.getSheetAt(0);
			HSSFSheet n_sheet = wbCreat.createSheet();
			// 鑾峰彇鏈�澶ц鏁�
			int rownum = sheet.getPhysicalNumberOfRows();
			// 鑾峰彇绗竴琛�
			row = sheet.getRow(0);
			// 鑾峰彇鏈�澶у垪鏁�
			int colnum = row.getPhysicalNumberOfCells();
			for (int i = 0; i < rownum; i++) {
				int count = 0;
				row = sheet.getRow(i);
				for (int j = 0; j < colnum; j++) {
					if (row.getCell(j).toString() == "") {
						count++;
					}
					
				}
				if (count < 4 && flag) {
					begin = i;
					flag = false;
				}
			}

			for (int i = begin + 1; i < rownum; i++) {
				ArrayList list2 = new ArrayList<String>();
				row = sheet.getRow(i);
				for (int j = 0; j < colnum; j++) {
					if (row.getCell(j).toString() != "") {
						System.out.print(i + " " + j + "  " + row.getCell(j) + " ");
					}

				}
				System.out.println("");
			}

		}

	}

	// 璇诲彇excel
	public static Workbook readExcel(String filePath) {
		Workbook wb = null;
		if (filePath == null) {
			return null;
		}
		String extString = filePath.substring(filePath.lastIndexOf("."));
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
			if (".xls".equals(extString)) {
				return wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(extString)) {
				return wb = new XSSFWorkbook(is);
			} else {
				return wb = null;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}

	public static Object getCellFormatValue(Cell cell) {
		Object cellValue = null;
		if (cell != null) {
			// 鍒ゆ柇cell绫诲瀷
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC: {
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			}
			case Cell.CELL_TYPE_FORMULA: {
				// 鍒ゆ柇cell鏄惁涓烘棩鏈熸牸寮�
				if (DateUtil.isCellDateFormatted(cell)) {
					// 杞崲涓烘棩鏈熸牸寮廦YYY-mm-dd
					cellValue = cell.getDateCellValue();
				} else {
					// 鏁板瓧
					cellValue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING: {
				cellValue = cell.getRichStringCellValue().getString();
				break;
			}
			default:
				cellValue = "";
			}
		} else {
			cellValue = "";
		}
		return cellValue;
	}

}