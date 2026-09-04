class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {   
    ArrayList<Integer>[] graph = createGraph(numCourses,prerequisites);


    int[] visited = new int[numCourses];
    int[] stack = new int[numCourses];

    for(int i = 0; i < numCourses; i++){
        if(visited[i] == 0 && hasCycleDfs(i, graph, visited, stack)) return false;
    }
    return true;
}

    public boolean hasCycleDfs(int i, ArrayList<Integer>[] graph, int[] visited, int[] stack){
        visited[i] = 1;
        stack[i] = 1;

        ArrayList<Integer> neighbors = graph[i];

        for(int neigh: neighbors){
            if(visited[neigh] == 0 && hasCycleDfs(neigh, graph, visited, stack)){
                return true;
            }
            else{
                if(stack[neigh] == 1) return true;
            }
        }

        stack[i] = 0;
        return false;
    }

    public ArrayList<Integer>[] createGraph(int n, int[][] prerequisites){
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }

        for(int[] req: prerequisites){
            graph[req[0]].add(req[1]);
        }

        return graph;
    }
}
