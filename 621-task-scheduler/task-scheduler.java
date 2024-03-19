class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char ch: tasks){
            freq[ch-'A']++;
        }
        Arrays.sort(freq);
        int chunk = freq[25]-1;
        int idel = chunk*n;
        for(int i=24; i>=0; i--){
            idel -= Math.min(chunk,freq[i]);
        }
        return idel < 0 ? tasks.length : tasks.length + idel;
    }
}