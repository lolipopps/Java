package ArrayUtils;

public class 收集雨水 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 进行两次扫描，一次从左往右，一次从右往左。第一次扫描的时候维护对于每一个bar左边最大的高度是多少，存入数组对应元素中，
	 * 第二次扫描的时候维护右边最大的高度，并且比较将左边和右边小的最大高度（我们成为瓶颈）存入数组对应元素中。
	 * 
	 * 这个方法算是一种常见的技巧，从两边各扫描一次得到我们需要维护的变量， 通常适用于当前元素需要两边元素来决定的问题。 一个地方能装多少水 和
	 * 它左边最高和右边最高的地方有关
	 */
	public static int Trap1(int[] num) {
		int begin = 0;
		int max = 0;
		int result = 0;
		int[] contain = new int[num.length];
		contain[0] = 0;
		for (int i = 0; i < num.length - 1; i++) { // 找到当前位置左边最大的
			contain[i] = max;
			max = Math.max(num[i], max);
		}
		max = 0;
		for (int i = num.length - 1; i >= 0; i--) {
			contain[i] = Math.min(max, contain[i]); // 得到左边和右边的最小的
			max = Math.max(max, num[i]); // 找到右边最大的
			result += contain[i] - num[i] > 0 ? contain[i] - num[i] : 0;
		}
		return result;
	}

	public int Trap2(int[] height) {
		int res = 0, l = 0, r = height.length - 1;
		while (l < r) {
			int mn = Math.min(height[l], height[r]);  // 首先定义左右两端为最大的值 从相对小的开始 如果左边最小 
			// 如果下一个比当前的要小则盛水数就是 相减 否则重新确定知道循环结束。相当于就是左右摆动。
			if (height[l] == mn) {
				++l;
				while (l < r && height[l] < mn) {
					res += mn - height[l++];
				}
			} else {
				--r;
				while (l < r && height[r] < mn) {
					res += mn - height[r--];
				}
			}
		}
		return res;
	}
	 public int Trap21(int[] height) {
	        int l = 0, r = height.length - 1, level = 0, res = 0;
	        while (l < r) {
	            int lower = height[(height[l] < height[r]) ? l++ : r--];
	            level = Math.max(level, lower);
	            res += level - lower;
	        }
	        return res;
	    }
	 
	 
	  
}
