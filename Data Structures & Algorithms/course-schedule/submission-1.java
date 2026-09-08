class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {   
        ArrayList<Integer>[] graph = createGraph(numCourses, prerequisites);

        Queue<Integer> q = new LinkedList();
        int[] inDeg = new int[numCourses];
        
        for(int i = 0; i < graph.length; i++){
            ArrayList<Integer> list = graph[i];

            for(int j = 0; j < list.size(); j++){
                inDeg[list.get(j)]++;
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(inDeg[i] == 0) q.add(i);
        }

        int processed = 0;

        while(!q.isEmpty()){
            int course = q.remove();
            processed++;

            List<Integer> neighbors = graph[course];

            for(int neigh: neighbors){
                inDeg[neigh]--;
                if(inDeg[neigh] == 0) q.add(neigh);
            }
        }

        return processed == numCourses;
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
