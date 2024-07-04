class Solution {
    public void dfs(int[][] isConnected,boolean[] visited,int city){
        visited[city]=true;
        for(int neighbour=0;neighbour<isConnected.length;neighbour++){
            if(isConnected[city][neighbour]==1 && visited[neighbour]==false){
                dfs(isConnected,visited,neighbour);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                provinces++;
                dfs(isConnected,visited,i);
            }
        }
        return provinces;
    }
}