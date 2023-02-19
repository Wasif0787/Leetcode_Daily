class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue <TreeNode> q = new LinkedList();
        q.add(root);
        List<List<Integer>> ans = new LinkedList();
        if(root==null){
            return ans;
        }
        List<Integer> sub;
        int level = 0;
        while(!q.isEmpty()){
            int size =q.size();
            sub = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                sub.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            if(level%2!=0)Collections.reverse(sub);
            level++;
            ans.add(sub);
        }
        return ans;
    }
}
