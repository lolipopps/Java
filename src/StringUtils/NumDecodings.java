package StringUtils;
public class NumDecodings {
	public static void main(String[] args) {
		System.out.println(numDecodings("2261"));
	}
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int [] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = isValid(s.substring(0,1)) ? 1 : 0;
        
        for(int i = 2; i<dp.length; i++){
            if(isValid(s.substring(i-1, i))){
                dp[i] += dp[i-1];
            }
            if(isValid(s.substring(i-2, i))){
                dp[i] += dp[i-2];
            }
        }
        return dp[dp.length - 1];
    }
    
    private static boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return false;
        }
        return Integer.valueOf(s) >= 1 && Integer.valueOf(s) <= 26;
    }
}
