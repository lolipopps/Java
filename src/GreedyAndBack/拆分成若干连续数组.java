package GreedyAndBack;

import java.util.HashMap;
import java.util.PriorityQueue;

public class 拆分成若干连续数组 {
	public static void main(String[] args) {
		System.out.println(isPossible(new int[] { 1, 2, 3, 4, 4, 4, 5, 5, 6, 6, 7 }));
	}

	private static HashMap<Integer, PriorityQueue<Integer>> dmap;

	public static boolean isPossible(int[] nums) {
		dmap = new HashMap<>();
		for (int num : nums) {
			PriorityQueue<Integer> pq0 = getOrPut(num - 1);
			int len = pq0.isEmpty() ? 0 : pq0.poll();
			PriorityQueue<Integer> pq1 = getOrPut(num);
			pq1.offer(len + 1);
		}
		for (int key : dmap.keySet()) {
			for (int len : dmap.get(key)) {
				if (len < 3)
					return false;
			}
		}
		return true;
	}

	public static PriorityQueue<Integer> getOrPut(int num) {
		PriorityQueue<Integer> pq = dmap.get(num);
		if (pq == null) {
			pq = new PriorityQueue<Integer>();
			dmap.put(num, pq);
		}
		return pq;
	}
}
