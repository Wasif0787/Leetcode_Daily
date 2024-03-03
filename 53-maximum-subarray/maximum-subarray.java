class Solution {
    public int maxSubArray(int[] nums) {
        int maxc = nums[0];
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > maxc)
                maxc = sum;
            if (sum < 0)
                sum = 0;
        }
        return maxc;
    }
}