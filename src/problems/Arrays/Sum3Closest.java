/**
 * 
 */
package problems.Arrays;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class Sum3Closest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 0, 0 };
		int closest = threeSumClosest(nums, 1);
		System.out.println(closest);
	}

	public static int threeSumClosest(int[] nums, int target) {

		int n = nums.length;
		if (n < 3)
			return 0;
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum > target)
					k--;
				else
					j++;
				if (Math.abs(sum - target) < Math.abs(closest - target))
					closest = sum;
			}
		}
		return closest;
	}

}
