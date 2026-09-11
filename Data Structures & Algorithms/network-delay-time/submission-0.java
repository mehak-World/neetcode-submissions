class Edge implements Comparable<Edge>{
    int dest;
    int wt;

    Edge(int dest, int wt){
        this.dest = dest;
        this.wt = wt;
    }

    public int compareTo(Edge e){
        return this.wt - e.wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = createGraph(n, times);

        int[] dist = new int[n+1];
        for(int i = 0; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue();
        pq.add(new Edge(k, 0));

        while(!pq.isEmpty()){
            Edge edge = pq.remove();
            int node = edge.dest;
            int wt = edge.wt;

            ArrayList<Edge> neighbors = graph[node];
            for(Edge e: neighbors){
                if(dist[node] + e.wt < dist[e.dest]){
                    dist[e.dest] = wt + e.wt;
                    pq.add(new Edge(e.dest, wt + e.wt));
                }
            }
        }

        int minTime = -1;

        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime;
    }

    public ArrayList<Edge>[] createGraph(int n, int[][] times){
        ArrayList<Edge>[] graph = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList();
        }

        for(int[] time: times){
            int src = time[0];
            int dest = time[1];
            int wt = time[2];

            graph[src].add(new Edge(dest, wt));
        }
        return graph;
    }
}
