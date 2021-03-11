/**
 * 
 */
package problems.Utility;

import java.util.LinkedList;
import java.util.Queue;

import problems.Entity.TreeNode;

/**
 * @author PRATAP
 *
 */
public class Utilities {
	
	public static TreeNode createBinaryTree(String[] input) {
		// TODO Auto-generated method stub
		if (input.length == 0 || input[0].equalsIgnoreCase("N"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(input[0]));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int i = 1;
		String currval;
		while (q.size() > 0 && i < input.length) {
			TreeNode curr = q.remove();
			currval = input[i];
			if (!currval.equalsIgnoreCase("N")) {
				curr.left = new TreeNode(Integer.parseInt(currval));
				q.add(curr.left);
			}
			i++;
			if (i >= input.length)
				break;
			currval = input[i];
			if (!currval.equalsIgnoreCase("N")) {
				curr.right = new TreeNode(Integer.parseInt(currval));
				q.add(curr.right);
			}
			i++;
		}
		return root;
	}

}
