/**
 * 
 */
package problems.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class Sum3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 0, 0 };
		List<List<Integer>> result = threeSum(nums);
		for (List<Integer> list : result)
			System.out.println(list);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		if (n < 3)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> tuple = new ArrayList<Integer>();
					tuple.add(nums[i]);
					tuple.add(nums[j]);
					tuple.add(nums[k]);
					result.add(tuple);
					while (j < k && nums[j] == nums[j + 1])
						j++;
					while (j < k && nums[k] == nums[k - 1])
						k--;
					j++;
					k--;
				} else if (sum > 0)
					k--;
				else
					j++;
			}
		}

		return result;
	}

}
