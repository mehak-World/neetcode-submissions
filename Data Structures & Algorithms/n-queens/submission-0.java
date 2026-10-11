class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList();
        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = '.';
            }
        }

        helper(0, grid, ans);
        return ans;
    }

    public void helper(int i, char[][] grid, List<List<String>> ans){
        if(i == grid.length){
            List<String> l = convertArrToStringList(grid);
            ans.add(new ArrayList(l));
            return;
        }

        for(int j = 0; j < grid.length; j++){
            if(canPlaceQueen(i, j, grid)){
                grid[i][j] = 'Q';
                helper(i+1, grid, ans);
                grid[i][j] = '.';
            }
            else{
                grid[i][j] = '.';
            }
        }
    }

    public boolean canPlaceQueen(int row, int col, char[][] grid){
        int i = row-1;
        int j = col+1;

        while(i >= 0){
            if(grid[i][col] == 'Q') return false;
            i--;
        }

        i = row-1;

        while(i >= 0 && j < grid.length){
            if(grid[i][j] == 'Q') return false;
            i--;
            j++;
        }

        j = col -1;
        i = row-1;

        while(i >= 0 && j >= 0){
            if(grid[i][j] == 'Q') return false;
            i--;
            j--;
        }
        
        return true;
    }

    public List<String> convertArrToStringList(char[][] grid){
        List<String> list = new ArrayList();

        for(char[] row: grid){
            StringBuilder sb = new StringBuilder();
            for(char ch: row){
                sb.append(ch);
            }
            list.add(sb.toString());
        }

        return list;
    }
}
