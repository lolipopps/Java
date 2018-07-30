package ArrayUtils;

public class 最长升序子序列 {
	 public static void main(String[] args) {
	        String str="3223456189";
	        System.out.println(lis(str));
	    }

	    public static int lis(String str) {
	        char[] ch = str.toCharArray();
	        int max;//记录当前对应的最大长度
	        int ans = 0;//记录总共的最大长度
	        for (int i = 1; i < ch.length; i++) {
	            max = 0;//对应该ch[i]开始时，总是要初始化max
	            for (int j = ans; j >= 0; j--) {
	                if (ch[i] > ch[j]) {//找到比ch[i]小的
	                    max = j + 1;//j代表的是ch[j]对应最大上升子序列的长度，加1也就是在该子序列后面再加ch[i]
	                    ans=ans>max?ans:max;//如果ch[i]对应的长度大于ans,就赋值给ans
	                    break;
	                }
	            }
	            if( max==ans || ch[i]<ch[max])//max==ans表示当前得到的是最长的子序列，直接存下来就好了。否则得到的不是最长的，就要和之前的比较，存较小的。
	                ch[max]=ch[i];
	        }
	        return ans+1;//下标加1才是长度。
	    }
}
