package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class IoUtils {
	/*
	 * 主要的类如下: 1. File（文件特征与管理）：用于文件或者目录的描述信息，例如生成新目录，修改文件名，删除文件，判断文件所在路径等。 File
	 * 不能访问文件内容本身。如果需要访问文件内容本身，则需要使用输入/输出流。
	 * 
	 * 这下面四个是基础 字节流：以byte为单位传输 字符流：以char为单位传输 2.
	 * InputStream（二进制格式操作）：抽象类，基于字节的输入操作，是所有输入流的父类。定义了所有输入流都具有的共同特征。
	 * 
	 * 3. OutputStream（二进制格式操作）：抽象类。基于字节的输出操作。是所有输出流的父类。定义了所有输出流都具有的共同特征。
	 * 
	 * 4. Reader（文件格式操作）：抽象类，基于字符的输入操作。 字符流
	 * 
	 * 5. Writer（文件格式操作）：抽象类，基于字符的输出操作。 字符流 分为 File ByteArray Piped Buffered Object
	 * Filter 流还包含 Data 输出 还包含 Print 6.
	 * RandomAccessFile（随机文件操作）：一个独立的类，直接继承至Object.它的功能丰富，可以从文件的任意位置进行存取（输入输出）操作。
	 * 
	 * 
	 * 字节流-缓冲流（重点） 输入流InputStream-FileInputStream-BufferedInputStream
	 * 输出流OutputStream-FileOutputStream-BufferedOutputStream 字符流-缓冲流（重点）
	 * 输入流Reader-FileReader-BufferedReader 输出流Writer-FileWriter-BufferedWriter 转换流
	 * InputSteamReader和OutputStreamWriter
	 * 对象流ObjectInputStream和ObjectOutputStream（难点） 序列化 反序列化
	 * 随机存取流RandomAccessFile（掌握读取、写入）
	 * 
	 */

	public static void main(String[] args) {
		// FileWriterDemo("FireWriterDemo.txt");
		// FileReaderDemo("FireWriterDemo.txt");
		// BufferDemo();
		// try {
		// testMyInput();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// StandardIo();
		// PrintDemo();
		DataStreamDemo();
	}

	public static void FileWriterDemo(String filename) {
		// 创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。
		// 而且该文件会被创建到指定目录下。如果该目录有同名文件，那么该文件将被覆盖。

		FileWriter fw = null;
		try {
			// 目的是明确数据要存放的目的地。
			fw = new FileWriter(filename);
			// 调用write的方法将字符串写到流中
			fw.write("hello world!\n");
			// 刷新流对象缓冲中的数据，将数据刷到目的地中
			fw.flush();
			fw.write("FireWriterDemo");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					// 关闭流资源，但是关闭之前会刷新一次内部缓冲中的数据。当我们结束输入时候，必须close();
					// flush和close的区别：flush刷新后可以继续输入，close刷新后不能继续输入。
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void FileReaderDemo(String filename) {
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			char[] buf = new char[1024];
			int len = 0;
			while ((len = fr.read(buf)) != -1) {
				System.out.println(new String(buf, 0, len));
			}
		} catch (IOException e) {
			System.out.println("read-Exception :" + e.toString());
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("close-Exception :" + e.toString());
				}
			}
		}
	}

	// 缓冲流

	public static void BufferDemo() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// step1:创建缓冲流对象：它是过滤流，是对节点流的包装
			br = new BufferedReader(new FileReader("G:\\code\\java\\Algorithm\\data\\db_stard.txt"));
			bw = new BufferedWriter(new FileWriter("BufferDemo.txt"));
			String str = null;
			while ((str = br.readLine()) != null) { // 一次读取字符文本文件的一行字符
				bw.write(str); // 一次写入一行字符串
				bw.newLine(); // 写入行分隔符
			}
			bw.flush(); // step2:刷新缓冲区
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// step3: 关闭IO流对象
			try {
				if (bw != null) {
					bw.close(); // 关闭过滤流时,会自动关闭它所包装的底层节点流
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (br != null) {
					br.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	// 转换流 InputStreamReader和OutputStreamWriter 字节流中的数据都是字符时，转成字符流操作更高效。
	/*
	 * 常见的编码表ASCII：美国标准信息交换码。用一个字节的7位可以表示。 ISO8859-1：拉丁码表。欧洲码表 用一个字节的8位表示。
	 * GB2312：中国的中文编码表。 GBK：中国的中文编码表升级，融合了更多的中文文字符号。
	 * Unicode：国际标准码，融合了多种文字。所有文字都用两个字节来表示,Java语言使用的就是unicode UTF-8：最多用三个字节来表示一个字符。
	 * 编码：字符串à字节数组 解码：字节数组à字符串 可以将字符按指定编码格式存储。可以对文本数据按指定编码格式来解读。
	 */

	public static void testMyInput() throws Exception {

		FileInputStream fis = new FileInputStream("BufferDemo.txt");
		FileOutputStream fos = new FileOutputStream("BufferDemoc.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(osw);
		String str = null;
		while ((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}

	// 标准输入输出流
	/*
	 * System.in和System.out分别代表了系统标准的输入和输出设备 默认输入设备是键盘，输出设备是显示器
	 * System.in的类型是InputStream
	 * System.out的类型是PrintStream，其是OutputStream的子类FilterOutputStream 的子类
	 * 通过System类的setIn，setOut方法对默认设备进行改变。 public static void setIn(InputStream in)
	 * public static void setOut(PrintStream out)
	 */
	public static void StandardIo() {
		System.out.println("请输入信息(退出输入e或exit):"); // 把"标准"输入流(键盘输入)这个字节流包装成字符流,再包装成缓冲流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			while ((s = br.readLine()) != null) { // 读取用户输入的一行数据 --> 阻塞程序
				if (s.equalsIgnoreCase("e") || s.equalsIgnoreCase("exit")) {
					System.out.println("安全退出!!");
					break;
				}
				// 将读取到的整行字符串转成大写输出
				System.out.println("-->:" + s.toUpperCase());
				System.out.println("继续输入信息");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close(); // 关闭过滤流时,会自动关闭它包装的底层节点流
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 打印流 在整个IO包中，打印流是输出信息最方便的类。 PrintStream(字节打印流)和PrintWriter(字符打印流)
	public static void PrintDemo() {
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(new File("BufferDemo.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
		PrintStream ps = new PrintStream(fos, true);
		if (ps != null) { // 把标准输出流(控制台输出)改成文件
			System.setOut(ps);
		}
		for (int i = 0; i <= 255; i++) { // 输出ASCII字符
			System.out.print(i);
			if (i % 50 == 0) { // 每50个数据一行
				System.out.println(); // 换行
			}
		}

		ps.close();

	}

	// 数据流
	public static void DataStreamDemo() {
		DataOutputStream dos = null;

		try { // 创建连接到指定文件的数据输出流对象
			dos = new DataOutputStream(new FileOutputStream("DataStreamDemo.dat"));
			dos.writeUTF("ab中国"); // 写UTF字符串
			dos.writeBoolean(false); // 写入布尔值
			dos.writeLong(1234567890L); // 写入长整数
			System.out.println("写文件成功!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 关闭流对象
			try {
				if (dos != null) {
					// 关闭过滤流时,会自动关闭它包装的底层节点流
					dos.close();
				}
			} catch (IOException e) {

				e.printStackTrace();

			}
		}
	}

	// RandomAccessFile 类
	/*
	 * ObjectOutputStream oos = new ObjectOutputStream(new
	 * FileOutputStream("test3.txt")); Person p = new Person("韩梅梅",18,"中华大街",new
	 * Pet()); oos.writeObject(p); oos.flush(); oos.close(); //反序列化：将磁盘中的对象数据源读出。
	 * ObjectInputStream ois = new ObjectInputStream(new
	 * FileInputStream("test3.txt")); Person p1 = (Person)ois.readObject();
	 * System.out.println(p1.toString()); ois.close();
	 */
	// RandomAccessFile 类
	public static void RandomAccessDemo() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("RandomAccessFile.txt", "rw");
		raf.seek(5);
		byte[] b = new byte[1024];
		int off = 0;
		int len = 5;
		raf.read(b, off, len);
		String str = new String(b, 0, len);
		System.out.println(str);
		raf.close();

		RandomAccessFile raf1 = new RandomAccessFile("test.txt", "rw");
		raf.seek(5);
		// 先读出来
		String temp = raf1.readLine();
		raf1.seek(5);
		raf1.write("xyz".getBytes());
		raf1.write(temp.getBytes());
		raf.close();
	}
}
