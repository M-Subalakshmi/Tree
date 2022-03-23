Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

class Solution {
    public void flatten(TreeNode root) {
        flat(root);
    }
    private TreeNode flat(TreeNode root){
        if(root==null) return null;
        TreeNode tmp=root.right;
        root.right=root.left!=null?root.left:root.right;
        TreeNode left=flat(root.left);
        root.left=null;
        if(left!=null){
            left.left=null;
            left.right=tmp;
        }
        TreeNode right=flat(tmp);
        return right!=null?right:(left!=null?left:root);
    }
}

Success
Details 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
Memory Usage: 42.7 MB, less than 41.29% of Java online submissions for Flatten Binary Tree to Linked List.
  
  
  
 // python:
  
  /*
  class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root: return
        temp=root.left
        
        if temp is not None:
            while(temp.right):
                temp=temp.right
            temp.right=root.right
            
            a=root.left
            root.left=None
            root.right=a
        self.flatten(root.right)
  */
  
  
  
  //java:
  
  class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode temp=root.left;
        if(temp!=null){
            while(temp.right!=null){
             temp=temp.right;   
            }
            temp.right=root.right;
            
            TreeNode a=root.left;
            root.left=null;
            root.right=a;
        }
        flatten(root.right);
    }
}
