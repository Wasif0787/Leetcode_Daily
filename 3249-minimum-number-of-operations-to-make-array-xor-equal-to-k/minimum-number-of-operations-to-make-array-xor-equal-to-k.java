class Solution {
    public int minOperations(int[] nums, int k) {
        int curr_xor =0;
        for(int num:nums) curr_xor^=num;
        int cnt=0;
        while(curr_xor>0 || k>0){
            if((k%2)!=(curr_xor%2)) cnt++;
            k/=2;
            curr_xor/=2;
        }
        return cnt;
    }
}