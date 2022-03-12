A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
  
  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    int max=0;
    public int maxPathSum(TreeNode root) {
        max=root.val;
        subpath(root);
        return max;
    }
    private int subpath(TreeNode node){
        if(node==null) return 0;
        int left=subpath(node.left);
        int right=subpath(node.right);
        left=Math.max(left,0);
        right=Math.max(right,0);
        max=Math.max(max,node.val+left+right);
        return node.val+Math.max(left,right);
    }
}


Success
Details 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Maximum Path Sum.
Memory Usage: 43.5 MB, less than 90.25% of Java online submissions for Binary Tree Maximum Path Sum.
