package util;

public class NumberOf {

	public static void main(String[] args) {
		System.out.println(NumberOf1(-2147483648));

	}

	public static int NumberOf1(int n) {
		StringBuffer stringBuffer = new StringBuffer();
		int base = 0;
		while(Math.abs(n/2.0) >= 1) {
			if(Math.abs(n) % 2 == 1) {
				stringBuffer.append("1");
			}else {
			stringBuffer.append("0");
			}
			n = n/2;
		}
		stringBuffer.append("1");

		stringBuffer = stringBuffer.reverse();
		System.out.println(stringBuffer.toString());
		if(n<0) {
			for(int i=0;i<stringBuffer.length();i++) {
				if(stringBuffer.charAt(i) == '0') {
					stringBuffer.replace(i, i+1, "1");
				}else {
					stringBuffer.replace(i, i+1, "0");
				}
			}
			System.out.println(stringBuffer.toString());
			for(int i=stringBuffer.length();i>=0;i--) {
				if(stringBuffer.charAt(i-1) == '1') {
					stringBuffer.replace(i-1, i, "0");
				}else {
					stringBuffer.replace(i-1, i, "1");
					break;
				}
			}
			System.out.println("stringBuffer.length()"+stringBuffer.length());
			base = 32 - stringBuffer.length();
		}
		int cnt=0;
		for(int i=0;i<stringBuffer.length();i++) {
			if(stringBuffer.charAt(i) == '1') {
				cnt++;
			}
		}
		return cnt+base;

	}
	

}
