/**
 * 
 */
package problems.Arrays;

/**
 * @author PRATAP
 *
 */
public class MedianOf2SortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 3,4 };
		int[] nums2 = {  };
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int n1 = nums1.length;
		int n2 = nums2.length;
		int low = 0;
		int high = n1;
		double median = 0;
		while (low <= high) {
			int cut1 = low + (high - low) / 2;
			int cut2 = (n1 + n2) / 2 - cut1;
			int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
			int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
			int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
			int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
			if (l1 > r2) {
				high = cut1 - 1;
			} else if (l2 > r1) {
				low = cut1 + 1;
			} else {
//				System.out.println(Math.max(l1, l2) + Math.min(r1, r2));
				median = (n1 + n2) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : Math.min(r1, r2);
				break;
			}
		}
		return median;
	}

}
