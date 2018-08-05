package ArrayUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class 所有字符串子集 {

	public static void main(String[] args) {
		List<List<Integer>> result = subsets1(new int[] { 1, 2, 3 ,2});
		for (List<Integer> i : result) {
			for (Integer num : i) {
				System.out.print(num);
			}
			System.out.println();
		}

	}
	public static List deepCopy(List src) {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		List dest = null;
		try {
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(src);
			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			ObjectInputStream in = new ObjectInputStream(byteIn);
			dest = (List) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dest;
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		for (int i : nums) {
			int num = list.size();
			for (int n = 0; n < num; n++) {
				List<Integer> temp = deepCopy(list.get(n));
				temp.add(i);
				list.add(temp);
				temp = null;
			}

		}

		return list;

	}

	public static void generate(List<List<Integer>> res, List<Integer> cur, int[] nums, int step) {
		res.add(new ArrayList<>(cur));
		if (step >= nums.length) {
			return;
		}
		for (int i = step; i < nums.length; ++i) { // 相当于先把 长度为一的列表加进去 通过递归的方式 循环加递归 可以解决 拿进拿出的问题
			cur.add(nums[i]);
			generate(res, cur, nums, i + 1);
			cur.remove(cur.size() - 1);
		}
	}

	public static List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		generate(res, cur, nums, 0);
		return res;
	}

}
