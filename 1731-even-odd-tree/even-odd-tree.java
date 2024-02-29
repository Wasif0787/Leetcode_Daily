/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean evenLevel = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if ((evenLevel && (node.val % 2 == 0 || node.val <= prev)) ||
                        (!evenLevel && (node.val % 2 == 1 || node.val >= prev))) {
                    return false;
                }

                prev = node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            evenLevel = !evenLevel;
        }

        return true;
    }
}