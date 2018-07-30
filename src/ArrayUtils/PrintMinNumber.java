package ArrayUtils;

import java.util.HashMap;

public class PrintMinNumber {

	public static void main(String[] args) {
		System.out.println(printMinNumber(new int[] { 3,323,32123 }));

	}

	public static String printMinNumber(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length-1; j++) {
				if ((numbers[j]==comperint(numbers[j], numbers[j + 1]))) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					StringBuffer stringBuffer = new StringBuffer();
					for(int a:numbers) {
						stringBuffer.append(a);
					}
					System.out.println(stringBuffer);
				}
			
			}
		}
		StringBuffer stringBuffer = new StringBuffer();
		for(int a:numbers) {
			stringBuffer.append(a);
		}
		return stringBuffer.toString();

	}

	public static int comperint(int a, int b) {
		String str1 = String.valueOf(a);
		String str2 = String.valueOf(b);
		int length = str1.length() > str2.length() ? str2.length():str1.length();
		for (int i = 0; i < length; i++) {
			if (str1.charAt(i) < str2.charAt(i)) {
				return b;
			} else if (str1.charAt(i) == str2.charAt(i)) {
				continue;
			} else {
				return a;
			}
		}
		if(length == str1.length()) {
			for(int i=length-1;i<str2.length()-1;i++) {
				if(str2.charAt(i) == str2.charAt(i+1)) {
					continue;
				}
				if(str2.charAt(i)<str2.charAt(i+1)) {
					return b;
				}else {
					return a;
				}
			}
		}else {
			for(int i=length-1;i<str1.length()-1;i++) {
				if(str1.charAt(i) == str1.charAt(i+1)) {
					continue;
				}
				if(str1.charAt(i)<str1.charAt(i+1)) {
					return a;
				}else {
					return b;
				}
			}
		}
		return a;
	}
}
