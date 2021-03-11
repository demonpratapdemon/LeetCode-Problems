/**
 * 
 */
package problems.Arrays;

/**
 * @author PRATAP
 *
 */
public class ContainerWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1, 3, 2, 5, 25, 24, 5 };
		int maxArea = maxArea(height);
		System.out.println(maxArea);
	}

	public static int maxArea(int[] height) {

		int low = 0;
		int high = height.length - 1;
		int maxArea = 0;
		while (low <= high) {
			int area = Math.min(height[low], height[high]) * (high - low);
			/*
			 * int areaIncreLow = Math.min(height[low + 1], height[high]) * (high - low -
			 * 1); int areaDecreHigh = Math.min(height[low], height[high - 1]) * (high - low
			 * - 1); if (areaIncreLow > areaDecreHigh) { area = Math.max(area,
			 * areaIncreLow); maxArea = Math.max(maxArea, area); low += 1; } else if
			 * (areaDecreHigh > areaIncreLow) { area = Math.max(area, areaDecreHigh);
			 * maxArea = Math.max(maxArea, area); high -= 1; } else { maxArea =
			 * Math.max(area, maxArea); break; }
			 */
			maxArea = Math.max(maxArea, area);
			if (height[low] < height[high])
				low += 1;
			else
				high -= 1;
		}
		System.out.println(low + "," + high);
		return maxArea;
	}

}
