Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000

#solution.....................................................................................................................................................................

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        parents={}
        
        def dfs(root,parent):
            if not root:
                return 
            parents[root]=parent
            dfs(root.left,root)
            dfs(root.right,root)
        dfs(root,None)
        
        visited=set()
        q=[]
        level=0
        visited.add(target)
        q.append(target)
        while q:
            if level==k:
                break
            for i in range(len(q)):
                node=q.pop(0)
                if node.left and node.left not in visited:
                    q.append(node.left)
                    visited.add(node.left)
                if node.right and node.right not in visited:
                    q.append(node.right)
                    visited.add(node.right)
                if parents[node] and parents[node] not in visited:
                    q.append(parents[node])
                    visited.add(parents[node])
            level+=1
        ans=[]
        for i in range(len(q)):
            node=q.pop(0)
            ans.append(node.val)
        return ans
