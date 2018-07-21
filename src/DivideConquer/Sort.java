package DivideConquer;

import util.Common;

public class Sort {
	// 递归的方式实现归并排序
	public static void Mergesort(int a[], int first, int last, int temp[]) {
		if (first < last) {
			int mid = (first + last) / 2;
			Mergesort(a, first, mid, temp); // 左边有序
			Mergesort(a, mid + 1, last, temp); // 右边有序
			Merge(a, first, mid, last, temp); // 再将二个有序数列合并
		}

	}

	// 合并两个有序子数组 这两个数组 分别是一个大数组的部分 mid 是中间 借助temp 数组完成
	private static void Merge(int a[], int first, int mid, int last, int temp[]) {
		int i = first, j = mid + 1;
		int m = mid, n = last;
		int k = 0;

		while (i <= m && j <= n) {
			if (a[i] <= a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}

		while (i <= m)
			temp[k++] = a[i++];

		while (j <= n)
			temp[k++] = a[j++];

		for (i = 0; i < k; i++)
			a[first + i] = temp[i];
	}

	public static void QuickSort(int r[], int first, int end) {
		if (first < end) {
			int pivot = Partition(r, first, end); // 问题分解 , pivot 是轴值在序列中的位置
			QuickSort(r, first, pivot - 1); // 递归地对左侧子序列进行快速排序
			QuickSort(r, pivot + 1, end); // 递归地对右侧子序列进行快速排序
		}
	}

	public static int Partition(int r[], int first, int end) {
		int i = first;
		int j = end; // 初始化
		int temp = 0;
		while (i < j) {
			while (i < j && r[i] <= r[j])
				j--; // 右侧扫描
			if (i < j) {
				temp = r[i];
				r[i] = r[j];
				r[j] = temp;// 将较小记录交换到前面
				i++;
			}
			while (i < j && r[i] <= r[j])
				i++; // 左侧扫描
			if (i < j) {
				temp = r[j];
				r[j] = r[i];
				r[i] = temp; // 将较大记录交换到后面
				j--;
			}
		}
		return i; // i为轴值记录的最终位置
	}

}
