package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class ReadWriteExcel {

	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	/**
	 * 判断Excel的版本,获取Workbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbok(InputStream in, File file) throws IOException {
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel 2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

	/**
	 * 判断文件是否是excel
	 * 
	 * @throws Exception
	 */
	public static void checkExcelVaild(File file) throws Exception {
		if (!file.exists()) {
			throw new Exception("文件不存在");
		}
		if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
			throw new Exception("文件不是Excel");
		}
	}

	/**
	 * 读取Excel测试，兼容 Excel 2003/2007/2010
	 * 
	 * @throws Exception
	 */
	public static void getData(String filename) throws Exception {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("G:\\2017.txt"), true));
		try {
			// 同时支持Excel 2003、2007
			File excelFile = new File(filename); // 创建文件对象
			FileInputStream is = new FileInputStream(excelFile); // 文件流
			checkExcelVaild(excelFile);
			Workbook workbook = getWorkbok(is, excelFile);
			// Workbook workbook = WorkbookFactory.create(is); // 这种方式
			// Excel2003/2007/2010都是可以处理的
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			System.out.println(filename + "总共用个" + sheetCount + "sheet");
			for (int i = 0; i < sheetCount; i++) {
				/**
				 * 设置当前excel中sheet的下标：0开始
				 */
				Sheet sheet = workbook.getSheetAt(i); // 遍历第一个Sheet
				// System.out.println(sheet.getSheetName());
				if (!(sheet.getSheetName().contains("五保") || sheet.getSheetName().contains("五保"))){
					continue;
				}
				// 为跳过第一行目录设置count
				int count = 0;
				boolean flag = false;
				for (Row row : sheet) {
					// 跳过第一行的目录
					// if (count == 0) {
					// count++;
					// continue;
					// }
					if (row.getLastCellNum() < 2) {
						continue;
					}

					// 如果当前行没有数据，跳出循环
					if (row.getCell(0) == null || row.getCell(0).toString().equals("")) {
						continue;
					}

					String rowValue = "";

					int nums = 0;
					for (int ii = 0; ii < row.getLastCellNum(); ii++) {
						// if (cell.toString() == null) {
						// continue;
						// }
						if (ii == 100) {
							break;
						}
						Cell cell = row.getCell(ii);
						if (cell == null) {
							cell = row.createCell(ii);
						}

						int cellType = cell.getCellType();
						String cellValue = "";
						switch (cellType) {
						case Cell.CELL_TYPE_STRING: // 文本
							cellValue = cell.getRichStringCellValue().getString() + "#";
							break;
						case Cell.CELL_TYPE_NUMERIC: // 数字、日期
							if (DateUtil.isCellDateFormatted(cell)) {
								cellValue = fmt.format(cell.getDateCellValue()) + "#";
							} else {
								cell.setCellType(Cell.CELL_TYPE_STRING);
								cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN: // 布尔型
							cellValue = String.valueOf(cell.getBooleanCellValue()) + "#";
							break;
						case Cell.CELL_TYPE_BLANK: // 空白
							cellValue = cell.getStringCellValue() + " #";
							break;
						case Cell.CELL_TYPE_ERROR: // 错误
							cellValue = "错误#";
							break;
						case Cell.CELL_TYPE_FORMULA: // 公式
							// 得到对应单元格的公式
							// cellValue = cell.getCellFormula() + "#";
							// 得到对应单元格的字符串
							cell.setCellType(Cell.CELL_TYPE_STRING);
							cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
							break;
						default:
							cellValue = "# ";
						}
						if (cellValue.contains("序号") || cellValue.contains("承包方编码")) {
							flag = true;
							break;

						}
						if(flag) {
						if (nums==0) {
							String[] temp = filename.split("\\\\");
							String names = temp[temp.length - 1].split("\\.")[0];
							if (cellValue.length() > 5) {
								rowValue = names + "#" + cellValue;
							} else {
								rowValue = names+ "#";
							}
						} else {
							rowValue += cellValue.replace("\n", "");;
						}
						nums++;
						// System.out.print(cellValue);
						
						}
					}
					if (rowValue == null || rowValue == "") {
						continue;
					}
					if (rowValue.split("#").length < 7) {
						int total = rowValue.split("#").length;
						for (int nnn = total; nnn < 7; nnn++) {
							rowValue = rowValue + " #";
						}
					}
					count++;
					rowValue ="420822#建始县#"+rowValue;
					bw.write(rowValue + "\n");

					// writeSql(rowValue,bw);
					// System.out.println(rowValue);
					// System.out.println();
				}
				bw.flush();
				// System.out.println("第" + i + "个sheet 总共有"+
				// sheet.getLastRowNum()+"行,读取了"+count+"行");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bw.close();
		}
	}

	public static void getData1(String filename) throws Exception {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("G:\\发包方信息.txt"), true));
		try {
			// 同时支持Excel 2003、2007
			File excelFile = new File(filename); // 创建文件对象
			FileInputStream is = new FileInputStream(excelFile); // 文件流
			checkExcelVaild(excelFile);
			Workbook workbook = getWorkbok(is, excelFile);
			// Workbook workbook = WorkbookFactory.create(is); // 这种方式
			// Excel2003/2007/2010都是可以处理的
			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			// System.out.println(filename+"总共用个"+ sheetCount+"sheet");
			for (int i = 0; i < sheetCount; i++) {
				/**
				 * 设置当前excel中sheet的下标：0开始
				 */
				Sheet sheet = workbook.getSheetAt(i); // 遍历第一个Sheet
				// System.out.println(sheet.getSheetName());
				if (!sheet.getSheetName().contains("发包方信息")) {
					continue;
				}
				// 为跳过第一行目录设置count
				int count = 0;
				boolean flag = false;
				for (Row row : sheet) {
					// 跳过第一行的目录
					// if (count == 0) {
					// count++;
					// continue;
					// }
					if (row.getLastCellNum() < 10) {
						continue;
					}

					// 如果当前行没有数据，跳出循环
					// if (row.getCell(0) == null || row.getCell(0).toString().equals("")) {
					// continue;
					// }

					String rowValue = "";

					int nums = 0;
					String temps = "";
					// System.out.println(row.getFirstCellNum());
					for (int ii = 0; ii < row.getLastCellNum(); ii++) {
						if (ii == 27) {
							break;
						}
					
						Cell cell = row.getCell(ii);
						// if (cell.toString() == null) {
						// continue;
						// }

						if (cell == null) {
							cell = row.createCell(ii);
						}
						int cellType = cell.getCellType();
						String cellValue = "";
						switch (cellType) {
						case Cell.CELL_TYPE_STRING: // 文本
							cellValue = cell.getRichStringCellValue().getString() + "#";
							break;
						case Cell.CELL_TYPE_NUMERIC: // 数字、日期
							if (DateUtil.isCellDateFormatted(cell)) {
								cellValue = fmt.format(cell.getDateCellValue()) + "#";
							} else {
								cell.setCellType(Cell.CELL_TYPE_STRING);
								cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN: // 布尔型
							cellValue = String.valueOf(cell.getBooleanCellValue()) + "#";
							break;
						case Cell.CELL_TYPE_BLANK: // 空白
							cellValue = cell.getStringCellValue() + " #";
							break;
						case Cell.CELL_TYPE_ERROR: // 错误
							cellValue = "错误#";
							break;
						case Cell.CELL_TYPE_FORMULA: // 公式
							// 得到对应单元格的公式
							// cellValue = cell.getCellFormula() + "#";
							// 得到对应单元格的字符串
							cell.setCellType(Cell.CELL_TYPE_STRING);
							cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
							break;
						default:
							cellValue = "# ";
						}
						if (cellValue.contains("标识码")) {
							flag = true;
							break;
						}
						if (flag) {
							if(nums == 3 || nums==4) {
								temps +=cellValue.replace("\n", "");
							}
							if (nums == 0) {
								String[] temp = filename.split("\\\\");
								String names = temp[temp.length - 1].split("\\.")[0];
								rowValue = names+"#";
							} else {
								rowValue += cellValue.replace("\n", "");
							}
							nums++;
							// System.out.print(cellValue);

						}
					}

					// if (rowValue.split("#").length < 7) {
					// int total = rowValue.split("#").length;
					// for (int nnn = total; nnn < 7; nnn++) {
					// rowValue = rowValue + " #";
					// }
					// }
					if (rowValue == null || rowValue == "") {
						continue;
					}
					if(temps=="") {
						System.out.println("空行:  "+ rowValue);
						continue;
					}
					count++;
					bw.write(rowValue + "\n");

					// writeSql(rowValue,bw);
					// System.out.println(rowValue);
					// System.out.println();
				}
				bw.flush();
				System.out.println("第" + i + "个sheet 总共有" + sheet.getLastRowNum() + "行,读取了" + count + "行");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bw.close();
		}
	}

	public static boolean isCNChar(String s) {
		boolean booleanValue = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c > 128) {
				booleanValue = true;
				break;
			}
		}
		return booleanValue;
	}

	public static boolean HasDigit(String content) {
		boolean flag = false;
		Pattern p = Pattern.compile(".*\\d+.*");
		Matcher m = p.matcher(content);
		if (m.matches()) {
			flag = true;
		}
		return flag;
	}
}