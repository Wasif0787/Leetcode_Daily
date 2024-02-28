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
    int maxdepth;
    int leftmost;
    public int findBottomLeftValue(TreeNode root) {
        maxdepth=-1;
        dfs(root,0);
        return leftmost;
    }
    void dfs(TreeNode root,int depth){
        if(root==null) return;
        if(depth>maxdepth){
            maxdepth=depth;
            leftmost=root.val;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}