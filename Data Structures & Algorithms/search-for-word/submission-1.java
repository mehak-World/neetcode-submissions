class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;

        int m = board.length;
        int n = board[0].length;
        
        
        Queue<int[]> q = new LinkedList();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.remove();
            boolean[][] visited = new boolean[m][n];
            visited[cell[0]][cell[1]] = true;
            if(helper(cell[0], cell[1], 1, word, board, visited)){
                return true;
            }
        }

        return false;
    }

    public boolean helper(int row, int col, int i, String word, char[][] board, boolean[][] visited){
        if(i == word.length()) return true;

        int[] dr = {0, 1, -1, 0};
        int[] dc = {1, 0, 0, -1};

        for(int j = 0; j < 4; j++){
            int nr = row + dr[j];
            int nc = col + dc[j];

            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && !visited[nr][nc] && word.charAt(i) == board[nr][nc]){
                visited[nr][nc] = true;
            if(helper(nr, nc, i+1, word, board, visited)) return true;
            visited[nr][nc] = false;
            }
        }

        return false;
    }
}
