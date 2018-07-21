package ArrayUtils;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = new int[] { 0 };
		System.out.println(removeDuplicates(nums));

	}

	public static int removeDuplicates(int[] nums) {
		int pos = 0;

		for (int i = 0; i < nums.length - 2; i++) {

			if (nums[i] == nums[i + 2]) {
				pos++;
			}

		}
		return nums.length - pos;

	}

	public static int removeDuplicates1(int[] nums) {
		int k = 1, c = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				nums[k++] = nums[i];
				c = 0;
			} else if (c == 0) {
				nums[k++] = nums[i];
				c = 1;
			}
		}
		return k;
	}

}
