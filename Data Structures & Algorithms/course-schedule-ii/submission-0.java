class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = createGraph(numCourses, prerequisites);

        int[] visited = new int[numCourses];
        int[] stack = new int[numCourses];

        Stack<Integer> ans = new Stack();

        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                boolean hasCycle = dfs(i, graph, visited, stack, ans);
                if(hasCycle) return new int[]{};
            }
        }

        int i = 0;
        while(!ans.isEmpty()){
            result[i] = ans.pop();
            i++;
        }
        return result;
    }

    public boolean dfs(int i, ArrayList<Integer>[] graph, int[] visited, int[] stack, Stack<Integer> ans){
        visited[i] = 1;
        stack[i] = 1;

        ArrayList<Integer> neighbors = graph[i];

        for(int neigh: neighbors){
            if(visited[neigh] == 0 && dfs(neigh, graph, visited, stack, ans)) return true;
            if(stack[neigh] == 1) return true;
        }

        stack[i] = 0;
        ans.push(i);

        return false;
    }

    public ArrayList<Integer>[] createGraph(int n, int[][] prereq){
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }

        for(int[] req: prereq){
            graph[req[1]].add(req[0]);
        }

        return graph;
    }
}
