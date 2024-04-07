class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, (a, b) -> {
            int freqCompare = Integer.compare(map.get(a), map.get(b));
            return freqCompare == 0 ? Integer.compare(b, a) : freqCompare;
        });
        int idx =0;
        for(int num:arr){
            int freq = map.get(num);
            for(int i=0;i<freq;i++){
                nums[idx++] = num;
            }
        }
        return nums;
    }
}