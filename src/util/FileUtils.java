package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class FileUtils {

	// 1.创建文件夹
	// import java.io.*;
	public static void createDir(String dirname) {
		File myFolderPath = new File(dirname);
		try {
			if (!myFolderPath.exists()) {
				myFolderPath.mkdir();
			}
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
		}

	}

	// 2.创建文件
	// import java.io.*;
	public static void createFile(String filename) {
		File myFilePath = new File(filename);
		try {
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			myFile.println();
			resultFile.close();
		} catch (Exception e) {
			System.out.println("新建文件操作出错");
			e.printStackTrace();
		}
	}

	// 3.删除文件
	// import java.io.*;
	public static void delFile(String filename) {
		File myDelFile = new File(filename);
		try {
			myDelFile.delete();
		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		}
	}

	// 4.删除文件夹
	// import java.io.*;
	public static void delDir(String dirName) {
		File delFolderPath = new File(dirName);
		try {
			delFolderPath.delete(); // 删除空文件夹
		} catch (Exception e) {
			System.out.println("删除文件夹操作出错");
			e.printStackTrace();
		}
	}

	// 5.删除一个文件下夹所有的文件夹
	// import java.io.*;
	public static void delAllDir(String dirName) {
		File delfile = new File(dirName);
		File[] files = delfile.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				files[i].delete();
			}
		}
	}

	// 6.清空文件夹
	// import java.io.*;
	public static void cleanAllDir(String dirName) {
		File delfilefolder = new File(dirName);
		try {
			if (!delfilefolder.exists()) {
				delfilefolder.delete();
			}
			delfilefolder.mkdir();
		} catch (Exception e) {
			System.out.println("清空目录操作出错");
			e.printStackTrace();
		}
	}

	// 7.读取文件
	// import java.io.*;
	// 逐行读取数据
	public static void readFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		String string = "";
		while (str != null) {
			string = string + str;
			str = br.readLine();
		}
		br.close();
		fr.close();
	}

	// 8.写入文件
	// import java.io.*;
	// 将数据写入文件
	public static void writeFile(String str, String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(str);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void AppendFile(String str, String fileName) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
			out.write(str + "\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeListFile(String[] strs, String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			for (String str : strs) {
				if (str != null)
					fw.write(str);
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void AppendListFile(String[] strs, String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName,true);
			for(String str:strs) {
				if(str!= null)
					fw.write(str);
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 9.写入随机文件
	// import java.io.*;
	public static void writeRandomFile(String str, String fileName) {
		try {
			RandomAccessFile logFile = new RandomAccessFile(fileName, "rw");
			long lg = logFile.length();
			logFile.seek(lg);
			logFile.writeBytes(str);
		} catch (IOException ioe) {
			System.out.println("无法写入文件：" + ioe.getMessage());
		}
	}

	// 10.读取文件属性
	// import java.io.*;
	// 文件属性的取得
	public static void getFilePro(String filename) {
		File f = new File(filename);
		if (f.exists()) {
			System.out.println(f.getName() + "的属性如下： 文件长度为：" + f.length());
			System.out.println(f.isFile() ? "是文件" : "不是文件");
			System.out.println(f.isDirectory() ? "是目录" : "不是目录");
			System.out.println(f.canRead() ? "可读取" : "不");
			System.out.println(f.canWrite() ? "是隐藏文件" : "");
			System.out.println("文件夹的最后修改日期为：" + new Date(f.lastModified()));
		} else {
			System.out.println(f.getName() + "的属性如下：");
			System.out.println(f.isFile() ? "是文件" : "不是文件");
			System.out.println(f.isDirectory() ? "是目录" : "不是目录");
			System.out.println(f.canRead() ? "可读取" : "不");
			System.out.println(f.canWrite() ? "是隐藏文件" : "");
			System.out.println("文件的最后修改日期为：" + new Date(f.lastModified()));
		}
		if (f.canRead()) {
			System.out.println(f.getName() + "可以读");
		}
		if (f.canWrite()) {
			System.out.println(f.getName() + "可以写");
		}
	}

	// 11.写入属性
	// import java.io.*;
	public static void setFilePro(String fileName) {
		File filereadonly = new File(fileName);
		try {
			boolean b = filereadonly.setReadOnly();
		} catch (Exception e) {
			System.out.println("拒绝写访问：");
			e.printStackTrace();
		}
	}

	// 12.枚举一个文件夹中的所有文件
	// import java.io.*;
	// import java.util.*;
	public static void getAllFile(String dirName) {
		LinkedList<String> folderList = new LinkedList<String>();
		folderList.add(dirName);
		while (folderList.size() > 0) {
			File file = new File(folderList.peek());
			folderList.removeLast();
			File[] files = file.listFiles();
			ArrayList<File> fileList = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					folderList.add(files[i].getPath());
				} else {
					fileList.add(files[i]);
				}
			}
			for (File f : fileList) {
				File filePath = f.getAbsoluteFile();
				System.out.println(filePath.getAbsolutePath());
			}
		}
	}

	// 13.复制文件夹
	// import java.io.*;
	// import java.util.*;
	public static void copyDir(String dirName1, String dirName2) {
		LinkedList<String> folderList = new LinkedList<String>();
		folderList.add(dirName1);
		LinkedList<String> folderList2 = new LinkedList<String>();
		folderList2.add(dirName2 + dirName1.substring(dirName1.lastIndexOf("\\")));
		while (folderList.size() > 0) {
			(new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File folders = new File(folderList.peek());
			String[] file = folders.list();
			File temp = null;
			try {
				for (int i = 0; i < file.length; i++) {
					if (folderList.peek().endsWith(folders.separator)) {
						temp = new File(folderList.peek() + folders.separator + file[i]);
					} else {
						temp = new File(folderList.peek() + folders.separator + file[i]);
					}
					if (temp.isFile()) {
						FileInputStream input = new FileInputStream(temp);
						FileOutputStream output = new FileOutputStream(
								folderList2.peek() + folders.separator + (temp.getName()).toString());
						byte[] b = new byte[5120];
						int len;
						while ((len = input.read(b)) != -1) {
							output.write(b, 0, len);
						}
						output.flush();
						output.close();
						input.close();
					}
					if (temp.isDirectory()) {// 如果是子文件夹
						for (File f : temp.listFiles()) {
							if (f.isDirectory()) {
								folderList.add(f.getPath());
								folderList2.add(folderList2.peek() + folders.separator + f.getName());
							}
						}
					}
				}
			} catch (Exception e) {
				// System.out.println("复制整个文件夹内容操作出错");
				e.printStackTrace();
			}
			folderList.removeFirst();
			folderList2.removeFirst();
		}
	}

	// 14.复制一个文件夹下所有的文件夹到另一个文件夹下
	// import java.io.*;
	// import java.util.*;
	public static void copyDirtodir(String dirName1, String dirName2) {
		File copyfolders = new File(dirName1);
		File[] copyfoldersList = copyfolders.listFiles();
		for (int k = 0; k < copyfoldersList.length; k++) {
			if (copyfoldersList[k].isDirectory()) {
				ArrayList<String> folderList = new ArrayList<String>();
				folderList.add(copyfoldersList[k].getPath());
				ArrayList<String> folderList2 = new ArrayList<String>();
				folderList2.add(dirName2 + "/" + copyfoldersList[k].getName());
				for (int j = 0; j < folderList.size(); j++) {
					(new File(folderList2.get(j))).mkdirs(); // 如果文件夹不存在 则建立新文件夹
					File folders = new File(folderList.get(j));
					String[] file = folders.list();
					File temp = null;
					try {
						for (int i = 0; i < file.length; i++) {
							if (folderList.get(j).endsWith(File.separator)) {
								temp = new File(folderList.get(j) + "/" + file[i]);
							} else {
								temp = new File(folderList.get(j) + "/" + File.separator + file[i]);
							}
							FileInputStream input = new FileInputStream(temp);
							if (temp.isFile()) {
								FileInputStream input1 = new FileInputStream(temp);
								FileOutputStream output = new FileOutputStream(
										folderList2.get(j) + "/" + (temp.getName()).toString());
								byte[] b = new byte[5120];
								int len;
								while ((len = input1.read(b)) != -1) {
									output.write(b, 0, len);
								}
								output.flush();
								output.close();
								input1.close();
							}
							if (temp.isDirectory()) {// 如果是子文件夹
								folderList.add(folderList.get(j) + "/" + file[i]);
								folderList2.add(folderList2.get(j) + "/" + file[i]);
							}
						}
					} catch (Exception e) {
						System.out.println("复制整个文件夹内容操作出错");
						e.printStackTrace();
					}
				}
			}
		}
	}

	// 15.移动文件夹
	// import java.io.*;
	// import java.util.*;
	public static void MoveDir(String dirName) {
		LinkedList<String> folderList = new LinkedList<String>();
		folderList.add(dirName);
		LinkedList<String> folderList2 = new LinkedList<String>();
		folderList2.add(dirName.substring(dirName.lastIndexOf("\\")));
		while (folderList.size() > 0) {
			(new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File folders = new File(folderList.peek());
			String[] file = folders.list();
			File temp = null;
			try {
				for (int i = 0; i < file.length; i++) {
					if (folderList.peek().endsWith(File.separator)) {
						temp = new File(folderList.peek() + File.separator + file[i]);
					} else {
						temp = new File(folderList.peek() + File.separator + file[i]);
					}
					if (temp.isFile()) {
						FileInputStream input = new FileInputStream(temp);
						FileOutputStream output = new FileOutputStream(
								folderList2.peek() + File.separator + (temp.getName()).toString());
						byte[] b = new byte[5120];
						int len;
						while ((len = input.read(b)) != -1) {
							output.write(b, 0, len);
						}
						output.flush();
						output.close();
						input.close();
						if (!temp.delete())
							System.out.println("删除单个文件操作出错!");
					}
					if (temp.isDirectory()) {// 如果是子文件夹
						for (File f : temp.listFiles()) {
							if (f.isDirectory()) {
								folderList.add(f.getPath());
								folderList2.add(folderList2.peek() + File.separator + f.getName());
							}
						}
					}
				}
			} catch (Exception e) {
				// System.out.println("复制整个文件夹内容操作出错");
				e.printStackTrace();
			}
			folderList.removeFirst();
			folderList2.removeFirst();
		}
		File f = new File(dirName);
		if (!f.delete()) {
			for (File file : f.listFiles()) {
				if (file.list().length == 0) {
					System.out.println(file.getPath());
					file.delete();
				}
			}
		}
	}

	// 16.移动一个文件夹下所有的文件夹到另一个目录下
	// import java.io.*;
	// import java.util.*;
	public static void MoveDir(String dirNameSrc, String dirNameDec) {
		File movefolders = new File(dirNameSrc);
		File[] movefoldersList = movefolders.listFiles();
		for (int k = 0; k < movefoldersList.length; k++) {
			if (movefoldersList[k].isDirectory()) {
				ArrayList<String> folderList = new ArrayList<String>();
				folderList.add(movefoldersList[k].getPath());
				ArrayList<String> folderList2 = new ArrayList<String>();
				folderList2.add(dirNameDec + "/" + movefoldersList[k].getName());
				for (int j = 0; j < folderList.size(); j++) {
					(new File(folderList2.get(j))).mkdirs(); // 如果文件夹不存在 则建立新文件夹
					File folders = new File(folderList.get(j));
					String[] file = folders.list();
					File temp = null;
					try {
						for (int i = 0; i < file.length; i++) {
							if (folderList.get(j).endsWith(File.separator)) {
								temp = new File(folderList.get(j) + "/" + file[i]);
							} else {
								temp = new File(folderList.get(j) + "/" + File.separator + file[i]);
							}
							FileInputStream input = new FileInputStream(temp);
							if (temp.isFile()) {
								FileInputStream input1 = new FileInputStream(temp);
								FileOutputStream output = new FileOutputStream(
										folderList2.get(j) + "/" + (temp.getName()).toString());
								byte[] b = new byte[5120];
								int len;
								while ((len = input1.read(b)) != -1) {
									output.write(b, 0, len);
								}
								output.flush();
								output.close();
								input1.close();
								temp.delete();
							}
							if (temp.isDirectory()) {// 如果是子文件夹
								folderList.add(folderList.get(j) + "/" + file[i]);
								folderList2.add(folderList2.get(j) + "/" + file[i]);
							}
						}
					} catch (Exception e) {
						System.out.println("复制整个文件夹内容操作出错");
						e.printStackTrace();
					}
				}
				movefoldersList[k].delete();
			}
		}
	}

	// 17.以一个文件夹的框架在另一个目录创建文件夹和空文件
	// import java.io.*;
	// import java.util.*;
	public static void CopyStruct(String dirNmae1, String dirName2) {
		boolean b = false;// 不创建空文件
		ArrayList<String> folderList = new ArrayList<String>();
		folderList.add(dirNmae1);
		ArrayList<String> folderList2 = new ArrayList<String>();
		folderList2.add(dirName2);
		for (int j = 0; j < folderList.size(); j++) {
			(new File(folderList2.get(j))).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File folders = new File(folderList.get(j));
			String[] file = folders.list();
			File temp = null;
			try {
				for (int i = 0; i < file.length; i++) {
					if (folderList.get(j).endsWith(File.separator)) {
						temp = new File(folderList.get(j) + "/" + file[i]);
					} else {
						temp = new File(folderList.get(j) + "/" + File.separator + file[i]);
					}
					FileInputStream input = new FileInputStream(temp);
					if (temp.isFile()) {
						if (b)
							temp.createNewFile();
					}
					if (temp.isDirectory()) {// 如果是子文件夹
						folderList.add(folderList.get(j) + "/" + file[i]);
						folderList2.add(folderList2.get(j) + "/" + file[i]);
					}
				}
			} catch (Exception e) {
				System.out.println("复制整个文件夹内容操作出错");
				e.printStackTrace();
			}
		}
	}
	// 18.复制文件
	// import java.io.*;

	public static void CopyFile(String filename1, String filename2) {
		int bytesum = 0;
		int byteread = 0;
		File oldfile = new File(filename1);
		try {
			if (oldfile.exists()) { // 文件存在时
				FileInputStream inStream = new FileInputStream(oldfile); // 读入原文件
				FileOutputStream fs = new FileOutputStream(new File(filename2, oldfile.getName()));
				byte[] buffer = new byte[5120];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
	}

	// 19.复制一个文件夹下所有的文件到另一个目录
	// import java.io.*;

	public static void CopyDirFile(String dirName1, String dirName2) {
		File copyfiles = new File(dirName1);
		File[] files = copyfiles.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				int bytesum = 0;
				int byteread = 0;
				try {
					InputStream inStream = new FileInputStream(files[i]); // 读入原文件
					FileOutputStream fs = new FileOutputStream(new File(dirName2, files[i].getName()));
					byte[] buffer = new byte[5120];
					int length;
					while ((byteread = inStream.read(buffer)) != -1) {
						bytesum += byteread; // 字节数 文件大小
						System.out.println(bytesum);
						fs.write(buffer, 0, byteread);
					}
					inStream.close();
				} catch (Exception e) {
					System.out.println("复制单个文件操作出错");
					e.printStackTrace();
				}
			}
		}
	}

}
