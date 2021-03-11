/**
 * 
 */
package problems.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import problems.Entity.TreeNode;
import problems.Utility.Utilities;

/**
 * @author PRATAP
 *
 */
public class CousinsInBT {

	static int parentX = -1;
	static int parentY = -1;
	static int counter = 1;

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			System.out.println(
					"Enter the node values of the tree space separated and whenever there is no node please enter N");
			String[] input = br.readLine().split("\\s+");
			TreeNode root = Utilities.createBinaryTree(input);
			System.out.println("Enter the 2 node values : ");
			input = br.readLine().split("\\s+");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			parentX = -1;
			parentY = -1;
			counter = 1;
			boolean isCousins = isCousins(root, x, y);
			System.out.println(isCousins);
		}
	}

	private static boolean isCousins(TreeNode root, int x, int y) {
		// TODO Auto-generated method stub
		if (root.val == x || root.val == y)
			return false;
		int heightX = findHeight(root, parentX, x, 0);
		counter++;
		int heightY = findHeight(root, parentY, y, 0);
		if ((heightX == heightY) && (parentX != parentY))
			return true;
		return false;
	}

	private static int findHeight(TreeNode root, int parent, int node, int height) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		if (root.val == node) {
			if (counter == 1)
				parentX = parent;
			else
				parentY = parent;
			return height;
		}
		parent = root.val;
		int leftHeight = findHeight(root.left, parent, node, height + 1);
		int rightHeight = findHeight(root.right, parent, node, height + 1);
		if (leftHeight > 0)
			return leftHeight;
		else if (rightHeight > 0)
			return rightHeight;
		return 0;
	}

}
