Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> value=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                value.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            res.add(value);
        }
        return res;
    }
}

Success
Details 
Runtime: 1 ms, faster than 82.91% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 43.5 MB, less than 53.20% of Java online submissions for Binary Tree Level Order Traversal.
  
  
  
// python:
  
  class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None:
            return root
        res=[]
        q=deque([root])
        while q:
            n=len(q)
            temp=[]
            for i in range(0,n):
                node=q.popleft()
                temp.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(temp)
        return res
    
Success
Details 
Runtime: 35 ms, faster than 89.13% of Python3 online submissions for Binary Tree Level Order Traversal.
Memory Usage: 14.2 MB, less than 59.88% of Python3 online submissions for Binary Tree Level Order Traversal.
