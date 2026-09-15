class Info implements Comparable<Info>{
    int x;
    int y;
    int dist;

    Info(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public int compareTo(Info i){
        return this.dist - i.dist;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        PriorityQueue<Info> pq = new PriorityQueue();
        pq.add(new Info(0, 0, grid[0][0]));

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, 1, -1, 0};

        while(!pq.isEmpty()){
            Info info = pq.remove();
            int x = info.x;
            int y = info.y;
            int time = info.dist;

            if(x == n-1 && y == n-1) return time;

            for(int i = 0; i < 4; i++){
                int nr = x + dr[i];
                int nc = y + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] > Math.max(time, grid[nr][nc])){
                    dist[nr][nc] = Math.max(time, grid[nr][nc]);
                        pq.add(new Info(nr, nc, dist[nr][nc]));
                }
            }
        }

        return -1;
    }
}
