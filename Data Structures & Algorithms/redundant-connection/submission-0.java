class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        int n = edges.length;

        int[] par = new int[n+1];
        int[] size = new int[n+1];

        for(int i = 0; i <= n; i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int[] edge: edges){
            int src = edge[0];
            int dest = edge[1];

            int p1 = findPar(src, par);
            int p2 = findPar(dest, par);

            if(p1 != p2){
                if(size[p1] >= size[p2]){
                    par[p2] = p1;
                    size[p1] += size[p2];
                }
                else{
                    par[p1] = p2;
                    size[p2] += size[p1];
                }
            }

            else{
                return edge;
            }
        }

        return new int[]{-1, -1};
    }

    public int findPar(int i, int[] par){

        if(par[i] != i){
            return findPar(par[i], par);
        }

        return i;
    }
}
