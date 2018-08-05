package StringUtils;

public class 循环左移字符串 {

	public static void main(String[] args) {
		System.out.println(LeftRotateString("abcXYZdef",10));

	}
public static String LeftRotateString(String str,int n) {
	if(str==null || str.equals("")) {
		return str;
	}
	if(n>=str.length()) {
		n = n%str.length();
	}
	String temp = str.substring(0, n);
	String temp1 = str.substring(n,str.length());
	System.out.println(temp+" "+temp1);
	return temp1+temp;
        
    }

}
