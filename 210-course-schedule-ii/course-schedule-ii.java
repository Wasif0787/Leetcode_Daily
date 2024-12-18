class Solution {
    public void countIndegree(int[][] graph, int[] indegree) {
        for (int i = 0; i < graph.length; i++) {
            indegree[graph[i][0]]++;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        countIndegree(prerequisites, indeg);
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        int idx = 0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            ans[idx] = curr;
            idx++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) {
                    int neigh = prerequisites[i][0];
                    indeg[neigh]--;
                    if (indeg[neigh] == 0) {
                        q.add(neigh);
                    }
                }
            }
        }
        if (idx < numCourses) {
            return new int[0];
        }
        return ans;
    }
}