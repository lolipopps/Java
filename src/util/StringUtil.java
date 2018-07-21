package util;

import java.util.ArrayList;

public class StringUtil {
	public static ArrayList<Integer>  lists = new ArrayList<Integer>();
	public static void main(String[] args) {
//		//lists.add(Atoi("+-234rfsasd123d-212323 ssdf sd123"));
//		for(Integer i:lists) {
//			System.out.println(i);
//		}
//		System.out.println(myAtoi("wwe asd 1231"));
//		System.out.println(WmyAtoi("wwe asd 1231"));
		System.out.println(isPalindromeint(1001));
	}
	// 自动转换第一个遇到的字符串为数字 
	 public static int myAtoi(String str) {
		 if(str.length()==0) {
			 return 0;
		 }
		 int sign = 1, base = 0, i = 0;
		 while (i<str.length()  && (str.charAt(i) > '9' || str.charAt(i) < '0')   )
		        i++;
		 if (i!=0 && str.charAt(i-1) == '-')
		        sign = str.charAt(i-1) == '-' ? -1 : 1;
		 while(i<str.length() && str.charAt(i)>'0' && str.charAt(i)<'9') {
			 if(base>Integer.MAX_VALUE/10 || base == Integer.MAX_VALUE/10 && str.charAt(i)-'0'>7) {
				 return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			 }
			 base = 10 * base + (str.charAt(i++) - '0');
		 }
		 return base * sign;
	        
	    }
	// 自动转换第一个遇到的字符串为数字 加上两层递归就可以解析所有的数字了
	public static int Atoi(String str) {
	    if (str.isEmpty()) return 0;
	    int sign = 1, base = 0, i = 0;
	    while (str.charAt(i) > '9' || str.charAt(i) < '0' )
	        i++;
	    if(i!=0 &&  str.charAt(i-1) == '-')
	        sign = str.charAt(i-1) == '-' ? -1 : 1;
	    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	        if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
	        	lists.add(Atoi(str.substring(i, str.length())));
	            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        }
	        base = 10 * base + (str.charAt(i++) - '0');
	    }
	    lists.add(Atoi(str.substring(i, str.length())));
	    return base * sign;
	}
	
    public static int WmyAtoi(String str) {
     if (str.isEmpty()) return 0;
     int sign = 1, base = 0, i = 0;
     while (str.charAt(i) == ' ')
         i++;
     if (str.charAt(i) == '-' || str.charAt(i) == '+')
         sign = str.charAt(i++) == '-' ? -1 : 1;
     while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
         if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
             return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
         }
         base = 10 * base + (str.charAt(i++) - '0');
     }
     return base * sign;
      }
    
    
    public static boolean isPalindromeint(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
        	rev = rev*10 + x%10;  // 意思是 例如 1221 rev= 1 x = 122  rev = 12 x = 12
        	x = x/10;
        }
        return (x==rev || x==rev/10);
    }	
    
    public static boolean isPalindromeint1(int x) {
    	if(x<0)
    		return false;
    	String string  = String.valueOf(x);
    	for(int i=0;i<string.length()/2;i++) {
    		if(string.charAt(i) != string.charAt(string.length()-i-1))
    			return false;
    	}
    	return true;
        
    }	
    
    public static boolean isPalindromeStr(int x) {
    	if(x<0)
    		return false;
    	String string  = String.valueOf(x);
    	for(int i=0;i<string.length()/2;i++) {
    		if(string.charAt(i) != string.charAt(string.length()-i-1))
    			return false;
    	}
    	return true;
        
    }	
	
}
