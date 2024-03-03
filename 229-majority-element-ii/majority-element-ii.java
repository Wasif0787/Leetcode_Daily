class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                el1 = nums[i];
                cnt1++;
            } else if (cnt2 == 0 && el1 != nums[i]) {
                el2 = nums[i];
                cnt2++;
            } else if (nums[i] == el1)
                cnt1++;
            else if (nums[i] == el2)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int mini = (int) (n / 3) + 1;
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1)
                cnt1++;
            if (nums[i] == el2)
                cnt2++;
        }
        if (cnt1 >= mini)
            ans.add(el1);
        if (cnt2 >= mini)
            ans.add(el2);
        return ans;
    }
}