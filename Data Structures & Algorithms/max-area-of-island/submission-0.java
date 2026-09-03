class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;

        int[] dr = {0, 1, -1, 0}; 
        int[] dc = {1, 0, 0, -1};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    // perform the dfs and increase islands cnt
                    int cnt = dfs(i, j, grid, dr, dc);
                    maxArea = Math.max(cnt, maxArea);
                }
            }
        }

        return maxArea;
    }
    
    public int dfs(int row, int col, int[][] grid, int[] dr, int[] dc){
        grid[row][col] = 0;

        int cnt = 1;
        for(int i = 0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if( nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                cnt += dfs(nr, nc, grid, dr, dc);
            }
        }

        return cnt;
    }
}
