class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = createGraph(numCourses, prerequisites);

        int[] result = new int[numCourses];
        int[] inDeg = new int[numCourses];

        // Calc inDeg
        for(int i = 0; i < numCourses; i++){
            ArrayList<Integer> neighbors = graph[i];
            for(int neigh: neighbors){
                inDeg[neigh]++;
            }
        }

       Queue<Integer> q = new LinkedList();

       for(int i = 0; i < numCourses; i++){
            if(inDeg[i] == 0) q.add(i);
       }

       int processed = 0;
       while(!q.isEmpty()){
            int curr = q.remove();
            result[processed] = curr;
            processed++;
            ArrayList<Integer> neighbors = graph[curr];

            for(int neigh: neighbors){
                inDeg[neigh]--;
                if(inDeg[neigh] == 0) q.add(neigh);
            }
       }

       return processed == numCourses ? result : new int[]{};
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
