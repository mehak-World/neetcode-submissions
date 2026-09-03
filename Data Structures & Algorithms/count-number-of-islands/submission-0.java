class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        int[] dr = {0, 1, -1, 0};
        int[] dc = {1, 0, 0, -1};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    // perform the dfs and increase islands cnt
                    dfs(i, j, grid, visited, dr, dc);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(int row, int col, char[][] grid, int[][] visited, int[] dr, int[] dc){
        visited[row][col] = 1;

        for(int i = 0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if( nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc] == 0 && grid[nr][nc] == '1'){
                dfs(nr, nc, grid, visited, dr, dc);
            }
        }
    }
}
