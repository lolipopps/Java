package util;

import java.util.Random;

public class Common {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numberChar = "0123456789";

	/**
	 * 返回一个定长的随机字符串(只包含大小写字母、数字)
	 * 
	 * @param length
	 *            随机字符串长度
	 * @return 随机字符串
	 */
	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString();
	}

	/**
	 * 返回一个定长的随机的整数数组 小范围（1-100）
	 * 
	 * @param length 随机字符串长度
	 * @return 随机字符串
	 */
	public static int[] getNumberArray(int length) {
		int number[] = new int[length];
		for (int i = 0; i < length; i++) {
			number[i] = (int) (Math.random() * 100);
		}
		return number;
	}
	/**
	 * 返回一个定长的随机的整数数组 大范围（1-10000）
	 * 
	 * @param length 随机字符串长度
	 * @return 随机字符串
	 */
	public static int[] generateNumberArray(int length) {
		int number[] = new int[length];
		Random ran=new Random(100); 
		for (int i = 0; i < length; i++) {
			number[i] = ran.nextInt(10000); // 10000 以内
		}
		return number;
	}
	/**
	 * 打印数组 toString
	 * 
	 * @param length 随机字符串长度
	 * @return 随机字符串
	 */
	public static void arraytoString(int[] number) {
		for(int i : number) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
