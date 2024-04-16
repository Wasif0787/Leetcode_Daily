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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        return dfs(root,1,depth,val);
    }
    private static TreeNode dfs(TreeNode node,int curr,int depth,int val){
        if(node==null) return null;
        if(curr==depth-1){
            TreeNode ltemp = node.left;
            TreeNode rtemp = node.right;
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            node.left.left=ltemp;
            node.right.right=rtemp;

            return node;
        }
        node.left = dfs(node.left,curr+1,depth,val);
        node.right = dfs(node.right,curr+1,depth,val);

        return node;
    }
}