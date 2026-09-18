class Edge{
    int src;
    int dest;
    int cost;

    Edge(int src, int dest, int cost){
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = createGraph(n, flights);

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{src, 0, 0});

        int[] costs = new int[n];
        for(int i = 0; i < n; i++){
            costs[i] = Integer.MAX_VALUE;
        }
        costs[src] = 0;

        while(!q.isEmpty()){
            int[] arr = q.remove();
            int arr_src = arr[0];
            int cost = arr[1];
            int stops = arr[2];

            if(stops > k) break;

            ArrayList<Edge> neighbors = graph[arr_src];
            for(Edge neigh: neighbors){
                int neigh_dest = neigh.dest;
                int neigh_cost = neigh.cost;
                
                if(cost + neigh_cost < costs[neigh_dest]){
                    costs[neigh_dest] = cost + neigh_cost;
                    q.add(new int[]{neigh_dest, cost + neigh_cost, stops+1});
                }
                
            }
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    public ArrayList<Edge>[] createGraph(int n, int[][] flights){
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }

        for(int[] flight: flights){
            int src = flight[0];
            int dest = flight[1];
            int cost = flight[2];

            graph[src].add(new Edge(src, dest, cost));
        }

        return graph;
    }
}
