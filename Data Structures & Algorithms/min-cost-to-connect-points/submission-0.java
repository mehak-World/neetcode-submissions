class Info implements Comparable<Info>{
    int[] p1;
    int[] p2;
    int dist;

    Info(int[] p1, int[] p2, int dist){
        this.p1 = p1;
        this.p2 = p2;
        this.dist = dist;
    }

    public int compareTo(Info i){
        return this.dist - i.dist;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Info> pq = new PriorityQueue<>();

        for(int i = 0; i < points.length; i++){
            int[] p1 = points[i];
            for(int j = i+1; j < points.length; j++){
                int[] p2 = points[j];
                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                pq.add(new Info(p1, p2, dist));
            }
        }

        Map<int[], int[]> par = new HashMap();
        Map<int[], Integer> size = new HashMap();

        for(int i = 0; i < points.length; i++){
            par.put(points[i], points[i]);
            size.put(points[i], 1);
        }

        int sum = 0;
        while(!pq.isEmpty()){
            Info i = pq.remove();
            int[] p1 = i.p1;
            int[] p2 = i.p2;
            int dist = i.dist;

            int[] par1 = findPar(par, p1);
            int[] par2 = findPar(par, p2);

            if(par1 != par2){
                sum += dist;
                if(size.get(par1) >= size.get(par2)){
                    par.put(par2, par1);
                    // increase the size of p1
                    size.put(par1, size.get(par1) + size.get(par2));
                }
                else{
                    par.put(par1, par2);
                    // increase the size of p1
                    size.put(par2, size.get(par2) + size.get(par1));
                }
            }
            
        }

        return sum;
    }

    public int[] findPar(Map<int[], int[]> par, int[] point){
        
        while(par.get(point) != point){
            int[] parent = findPar(par, par.get(point));
            par.put(point, parent);
            return parent;
        }

        return point;
    }

    
}
