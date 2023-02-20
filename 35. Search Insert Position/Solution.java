class Solution {
    public int searchInsert(int[] nums, int target) {
       int st=0,en=nums.length-1;
       int mid=0;
       while(st<=en){
           mid=(st+en)/2;
           if(nums[mid]==target){
               return mid;
           }
           if(target>nums[mid]){
               st=mid+1;
           } else {
               en=mid-1;
           }
       }
       return st;
    }
}
