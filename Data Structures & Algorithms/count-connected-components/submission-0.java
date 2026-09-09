class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer>[] graph = createGraph(n, edges);

        int components = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                components++;
                dfs(i, graph, visited);
            }
        }

        return components;
    }

    public void dfs(int i, ArrayList<Integer>[] graph, boolean[] visited){
        visited[i] = true;

        for(int neigh: graph[i]){
            if(!visited[neigh]){
                dfs(neigh, graph, visited);
            }
        }
    }

    public ArrayList<Integer>[] createGraph(int n, int[][] edges){
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }

        for(int[] edge: edges){
            int src = edge[0];
            int dest = edge[1];

            graph[src].add(dest);
            graph[dest].add(src);
        }

        return graph;
    }
}
