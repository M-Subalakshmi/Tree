226. Invert Binary Tree
Easy

7870

105

Add to List

Share
Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        invert(root);
        return root;
    }
    public void invert(TreeNode root){
        if(root==null) return;
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
        invert(root.left);
        invert(root.right);
    }
}

//Another

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            invertTree(root.left);
            invertTree(root.right);
            
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            
        }
        return root;
    }
}

Success
Details 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
Memory Usage: 42.4 MB, less than 6.90% of Java online submissions for Invert Binary Tree.
