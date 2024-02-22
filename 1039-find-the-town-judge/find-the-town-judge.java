class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] countTrust = new int[n+1];
        for(int i=0;i<trust.length;i++){
            countTrust[trust[i][0]]=-1;
            if(countTrust[trust[i][1]]==-1) continue;
            countTrust[trust[i][1]]++;
        }
        for(int i=1;i<=n;i++){
            if(countTrust[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}