package GreedyAndBack;

public class 汽车加油站问题 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] b = new int[] { 3, 4, 5, 1, 2 };
		canCompleteCircuit(a, b);
		/*
		 * gas = [1,2,3,4,5] cost = [3,4,5,1,2]
		 */

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0)
			return -1;
		int sum = 0;// 到达当前加油站的总净容量
		int total = 0;// 整个完成一圈的总容量
		int pointer = 0;// 定义起点
		for (int i = 0; i < gas.length; i++) {
			int diff = gas[i] - cost[i];
			sum += diff;
			total += diff;
			if (sum < 0) // 到达该节点油不够。那么这之间的节点都不能作为起点，因为这之间的节点都是正净容量。
			{
				sum = 0;
				pointer = i + 1;  // pointer 标记为i+1,意味着从之前pointer到i之间的加油站都不能作为起始加油站。
			}
		}
		return total >= 0 ? pointer : -1;
	}

}
