Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000

class Solution {
    private int minC=0,maxC=0,minR=0,maxR=0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer, Map<Integer, List<Integer>>> mapByCol=new HashMap<>();
        dfs(root, 0, 0, mapByCol);

        for(int i=minC;i<=maxC;i++){
            List<Integer> values=new ArrayList<>();
            Map<Integer, List<Integer>> MapByRow=mapByCol.get(i);
            for(int j=minR;j<=maxR;j++){
                if(MapByRow.containsKey(j)){
                    List<Integer> value=MapByRow.get(j);
                    if(value.size()==1){
                        values.addAll(value);
                    }
                    else{
                        Collections.sort(value);
                        values.addAll(value);
                    }
                }
            }
            res.add(values);
        }
        
        return res;
    }
    private void dfs(TreeNode root,int row,int col,Map<Integer, Map<Integer, List<Integer>>>mapC){
        if(root==null) return;
        minC=Math.min(minC,col);maxC=Math.max(maxC,col);minR=Math.min(minR,row);maxR=Math.max(maxR,row);
        Map<Integer, List<Integer>> mapByRow = mapC.get(col);
        if(mapByRow==null){
            mapByRow=new HashMap<>();
            List<Integer> values=new ArrayList<>();
            values.add(root.val);
            mapByRow.put(row,values);
            mapC.put(col,mapByRow);
        }
        else{
            List<Integer> values=mapByRow.get(row);
            if(values==null){
                values=new ArrayList<>();
                values.add(root.val);
                mapByRow.put(row,values);
            }
            else{
                values.add(root.val);
            }
        }
        dfs(root.left,row+1,col-1,mapC);
        dfs(root.right,row+1,col+1,mapC);
    }
}
