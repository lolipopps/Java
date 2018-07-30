package StringUtils;

public class StringUtils {
	  public static char[] swap(char[] arr, int begin, int end) {  
	        while(begin < end) {  
	            char temp = arr[begin];  
	            arr[begin] = arr[end];  
	            arr[end] = temp;  
	            begin++;  
	            end--;  
	        }  
	        return arr;
	    }  
	  
	  public static char[] swap(String string, int begin, int end) {  
		  char[] arr = string.toCharArray();  
	        while(begin < end) {  
	            char temp = arr[begin];  
	            arr[begin] = arr[end];  
	            arr[end] = temp;  
	            begin++;  
	            end--;  
	        }  
	        return arr;
	    }  
	    //I love java  
	    public static String swapWords(String str) {  // 单词的反转
	        char[] arr = str.toCharArray();  
	        swap(arr, 0, arr.length - 1);  
	        int begin = 0;  
	        for (int i = 1; i < arr.length; i++) {  
	            if (arr[i] == ' ') {  
	                swap(arr, begin, i - 1);  
	                begin = i + 1;  
	            }  
	        }  
	  
	        return new String(arr);  
	    }
	    
	    
	    
	  //I love java  
	    public String swapWords(char[] arr) {  
	        //char[] arr = str.toCharArray();  
	        swap(arr, 0, arr.length - 1);  
	        int begin = 0;  
	        for (int i = 1; i < arr.length; i++) {  
	            if (arr[i] == ' ') {  
	                swap(arr, begin, i - 1);  
	                begin = i + 1;  
	            }  
	        }  
	  
	        return new String(arr);  
	    }  
	    
	    public static void main(String[] args) {  
	        String str = "I love java";  
	        System.out.println(swap(str,2,str.length()-1));  
	    }  
	  
	    
}
