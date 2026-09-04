class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList();

        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];

        // left boundary
        for(int i = 0; i < m; i++){
           if(board[i][0] == 'O') q.add(new int[]{i, 0});
        }

        // top boundary
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') q.add(new int[]{0, j});
        }

        // right boundary
        for(int i = 1; i < m; i++){
            if(board[i][n-1] == 'O') q.add(new int[]{i, n-1});
        }

        // bottom boundary
        for(int j = 0; j < n; j++){
            if(board[m-1][j] == 'O') q.add(new int[]{m-1, j});
        }

        while(!q.isEmpty()){
            int[] cell = q.remove();
            int row = cell[0];
            int col = cell[1];

            dfs(row, col, board, visited);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board, int[][] visited){
        visited[row][col] = 1;

        int m = board.length;
        int n = board[0].length;

        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, 1, -1, 0};

        for(int i = 0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && visited[nr][nc] == 0 && board[nr][nc] == 'O'){
                visited[nr][nc] = 1;
                dfs(nr, nc, board, visited);
            }
        }
    }
}
