class Solution {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    static void createGraph(int[][] flights, ArrayList<ArrayList<Edge>> graph,int n) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); 
        }
        for (int[] flight : flights) {
            int src = flight[0];
            int dest = flight[1];
            int weight = flight[2];
            graph.get(src).add(new Edge(src, dest, weight));
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        createGraph(flights, graph,n);
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph.get(curr.v).size(); i++) {
                Edge e = graph.get(curr.v).get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dest];
    }
}