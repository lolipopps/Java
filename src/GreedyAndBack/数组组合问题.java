package GreedyAndBack;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class 数组组合问题 {

	public static void main(String[] args) {
		subsetsWithDup(new int[] { 1, 2, 2 });

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		helper(nums, 0, cur, res);
		System.out.println(res);
		return res;
	}

	private static void helper(int[] nums, int step, List<Integer> cur, List<List<Integer>> res) {
		res.add(new ArrayList<>(cur));
		if (step >= nums.length) {
			return;
		}
		for(int i=step;i<nums.length;i++) {
			cur.add(nums[i]);
			helper(nums, i+1,cur, res);
			cur.remove(cur.size() - 1);
		}
		
	}
}
