package ArrayUtils;

public class SearchInsertPosition {
	/*
	 * 给定一个有序数组和目标值，如果找到目标，则返回索引。 如果没有，则返回索引，如果它是按顺序插入的话。 你可能会认为没有重复的数组。
	 */
	public static void main(String[] args) {
		System.out.println(searchInsertPosition(new int[] { 1,4,5,6,7,8,8,8,8,9 },9));

	}
  // 直接采用顺序遍历注意边界值
	private static int searchInsertPosition(int[] nums,int target) {
		int post = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=target) {
				post = i;
				break;
			}else {
				post = i;
			}
		}
		if(post==nums.length-1 && nums[nums.length-1] <target) {
			return post +1;
		}
		return post;

	}
	// 二分查找法
	public static int searchInsertPosition1(int[] nums, int target) 
	{
	        if (null == nums || nums.length == 0)
	            return 0;

	        int low = 0;
	        int high = nums.length - 1;

	        while(low <= high)
	        {
	            int mid = low + ((high - low) >>> 1);
	            if (nums[mid] == target)
	            {
	                return mid;
	            }
	            else if (nums[mid] < target)
	            {
	                low = mid + 1;
	            }
	            else
	            {
	                high = mid - 1;
	            }
	        }

	        return high + 1;
	}

}
