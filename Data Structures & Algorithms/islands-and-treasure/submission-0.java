class Info{
    int row;
    int col;
    int dist;

    Info(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {

    public void islandsAndTreasure(int[][] grid) {
        Queue<Info> q = new LinkedList();

        int m = grid.length;
        int n = grid[0].length;

        int[] dr = {0, 1, -1, 0};
        int[] dc = {1, 0, 0, -1};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    q.add(new Info(i, j, 0));                
                }
            }
        }

        while(!q.isEmpty()){
            Info info = q.remove();
            int row = info.row;
            int col = info.col;
            int dist = info.dist;

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == Integer.MAX_VALUE){
                    // update it
                    grid[nr][nc] = dist + 1;
                    q.add(new Info(nr, nc, dist+1));
                }
            }
        }
    }
}
