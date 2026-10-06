class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] ans = new int[k][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for(int[] point: points){
            int x = point[0];
            int y = point[1];

            int dist = (int)(Math.pow(x, 2) + Math.pow(y, 2));

            if(pq.size() < k){
                pq.add(new int[]{x, y, dist});
            }

            else{
                if(dist < pq.peek()[2]){
                    pq.remove();
                    pq.add(new int[]{x, y, dist});
                }
            }
        }

        int i = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            ans[i] = new int[]{arr[0], arr[1]};
            i++;
        }

        return ans;
    }
}
