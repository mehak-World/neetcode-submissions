class Info{
    int row;
    int col;
    int time;

    Info(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<Info> q = new LinkedList();

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, 1, -1, 0};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.add(new Info(i, j, 0));
            }
        }

        while(!q.isEmpty()){
            Info info = q.remove();
            int row = info.row;
            int col = info.col;
            int time = info.time;

            minutes = time;

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                    // Make it rotten
                    grid[nr][nc] = 2;
                    q.add(new Info(nr, nc, time+1));
                }
            }
        }
        
        return anyFreshFruit(grid) ? -1: minutes;
    }

    public boolean anyFreshFruit(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return true;
            }
        }

        return false;
    }
}
