package Dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数组任意组合成数 {
/*
 * 回溯算法的基本思想是：从一条路往前走，能进则进，不能进则退回来，换一条路再试。
 * 回溯法中，首先需要明确下面三个概念：

约束函数：约束函数是根据题意定出的。通过描述合法解的一般特征用于去除不合法的解，从而避免继续搜索出这个不合法解的剩余部分。
因此，约束函数是对于任何状态空间树上的节点都有效、等价的。

状态空间树：刚刚已经提到，状态空间树是一个对所有解的图形描述。树上的每个子节点的解都只有一个部分与父节点不同。

扩展节点、活结点、死结点：所谓扩展节点，就是当前正在求出它的子节点的节点，在DFS中，只允许有一个扩展节点。活结点就是通过与约束函数的对照，
节点本身和其父节点均满足约束函数要求的节点；死结点反之。由此很容易知道死结点是不必求出其子节点的（没有意义）。
 */
	public static void main(String[] args) {
		System.out.println(combinationSum1(new int[] {1,2,3,5},8));

	}
	 public static List<List<Integer>> combinationSum1(int[] candidates, int target) 
	    {
	        List<List<Integer>> list = new ArrayList<>();
	        Arrays.sort(candidates);
	        backtrack(list, new ArrayList<>(), candidates, target, 0);
	        
	        return list;
	    }
	    
	    public static boolean backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start)
	    {
	        if(remain < 0) // if remain is 0 or less than 0, meaning the rest numbers are even greater
	            return false; // therefore, no need to continue the loop, return false
	        else if(remain == 0)
	        {
	            list.add(new ArrayList<>(tempList));
	            return false;
	        }
	        else
	        {
	            for(int i=start; i<nums.length; i++)
	            {
	                boolean flag;
	                tempList.add(nums[i]);
	                flag = backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can use same number.
	                tempList.remove(tempList.size() - 1);
	                
	                if(!flag) // if find a sum or fail to find a sum, there is no need to continue
	                    break;// because it is a sorted array with no duplicates, the rest numbers are even greater.
	            }
	            
	            return true; // return true because previous tempList didn't find a sum or fail a sum
	        }
	    }
}
