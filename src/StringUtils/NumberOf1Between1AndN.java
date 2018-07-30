package StringUtils;

public class NumberOf1Between1AndN {

	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(100));

	}
	public static int NumberOf1Between1AndN_Solution(int n) {
		int res = 0;
		StringBuffer string= new StringBuffer();
		for(int i=1;i<=n;i++) {
			string.append(i);
		}
		System.out.println(string);
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i) == '1') {
				res++;
			}
		}
		return res;
	    
    }
}
