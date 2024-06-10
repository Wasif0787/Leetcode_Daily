class Solution {
    public int heightChecker(int[] heights) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int h:heights){
            pq.add(h);
        }
        int cnt=0;
        for(int h:heights){
            if(h!=pq.poll()) cnt++;
        }
        return cnt;
    }
}