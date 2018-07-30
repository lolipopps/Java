package ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 矩阵最大面积 {
	/*
	 * 给一个数组 值代表高度 给定n个非负整数a1，a2，...，an，其中每个代表坐标（i，ai）处的一个点。
	 * 绘制n条垂直线，使得线i的两个端点位于（i，ai）和（i，0）处。 找到两条线，它们与x轴一起形成一个容器，
	 * 使容器中的水含量最多。注意：您不得倾斜容器，并且n至少为2. 意思是找到两个点使得面积区域最大
	 * 个人解题思路 先求出左边第一个值和右边第一个值构成的水的容量 先从左边遍历当发现 比当前值要大 重新
	 * 求水的容量 否则继续求得之后 从右边遍历
	 */
	public static void main(String[] args) {
//		int[] num = new int[] { 2, 0 };
//		System.out.println(maxArea(num));
		maxRectangle(new int[] {2,1,5,6,2,3,2,2,2,2,2});

	}
	
	public static int myMaxArea(int[] num) {
		int begin = 0;
		int end = num.length - 1;
		int result = 0;
		while (begin < end) {
			int area = Math.max(result, Math.min(num[begin], num[end]) * (end - begin));
			result = Math.max(result, area);
			if (num[begin] > num[end])
				end--;
			else
				begin++;
			System.out.println(begin + " " + end);
		}
		return result;
	}

	

	public static int maxArea(int[] num) {
		int begin = 0;
		int end = num.length - 1;
		int result = 0;
		while (begin < end) {
			int area = Math.max(result, Math.min(num[begin], num[end]) * (end - begin));
			result = Math.max(result, area);
			if (num[begin] > num[end])
				end--;
			else
				begin++;
			System.out.println(begin + " " + end);
		}
		return result;
	}

	/*
	 * 进行两次扫描，一次从左往右，一次从右往左。第一次扫描的时候维护对于每一个bar左边最大的高度是多少，存入数组对应元素中，
	 * 第二次扫描的时候维护右边最大的高度，并且比较将左边和右边小的最大高度（我们成为瓶颈）存入数组对应元素中。
	 * 
	 * 这个方法算是一种常见的技巧，从两边各扫描一次得到我们需要维护的变量， 通常适用于当前元素需要两边元素来决定的问题。 一个地方能装多少水 和
	 * 它左边最高和右边最高的地方有关
	 */
	public static int maxTrap(int[] num) {
		int begin = 0;
		int max = 0;
		int result = 0;
		int[] contain = new int[num.length];
		contain[0] = 0;
		for (int i = 0; i < num.length - 1; i++) { // 找到左边最大的
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

	public static int maxTrap1(int[] num) {
		int begin = 0;
		int end = num.length - 1;
		int min = 0;
		int result = 0;
		while (begin < end) {
			min = Math.min(num[begin], num[end]);
			if (num[begin] == min) {
				begin++;

				while (num[begin] < min && begin < end) {
					begin++;
					result += min - num[begin];
				}
			} else {
				end++;
				while (num[end] <= min && begin < end) {

					result += min - num[end];
					end--;
				}
			}
		}
		return result;
	}
// 和水滴的概念一样。通过一次遍历获取某个位置的左边最大值 和 右边最大值 然后把求得的值存起来就可以了  
// 找出里面最大的  当这个值是比较大的时候存的并不是结果    2 1 5 6 2 3
	public static int maxRectangle(int[] num) {
		int result = 0;
		if(num.length ==0) {
			return result;
		}
		// 在最后存一个0 使得每个值都会退栈
		Stack<Integer> stack = new Stack<Integer>();
		int destination[] = new int[num.length + 1];
	    System.arraycopy(num, 0, destination, 0, num.length);
		
		 for(int i=0;i<destination.length;++i)
		    {
			 // 判断当前的值和栈顶的值的大小 如果栈顶对应位置的值小于当前值进栈  维持一个递增的栈当栈递增
			 // 面积最大值可能还没出现 当出现小于栈顶的位置的元素时。出栈计算所有可能的最大值
		        if(stack.empty()||destination[stack.peek()]<=destination[i])
		        	stack.push(i);
		        else
		        {
		            int temp=stack.peek();
		            stack.pop();
		            result=Math.max(result,destination[temp]*(stack.empty()?i:(i-stack.peek()-1)));
		            --i; // 使得出栈的时候不会动
		        }
		    }
		
		return result;
	}
	   
}
