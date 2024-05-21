class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList();
        List<Integer> temp=new ArrayList();
        int n = nums.length;
        solve(0,n,nums,temp,ans);
        return ans;
    }
    
    void solve(int ind,int n,int[] nums,List<Integer> temp,List<List<Integer>> ans){
        if(ind==n){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        //pick
        temp.add(nums[ind]);
        solve(ind+1,n,nums,temp,ans);
        temp.remove(temp.size()-1);
        
        //notpick
        solve(ind+1,n,nums,temp,ans);
    }
}