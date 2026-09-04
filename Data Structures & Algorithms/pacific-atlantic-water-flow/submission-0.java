class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> output = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        canReachPacific(heights, pacific);
        canReachAtlantic(heights, atlantic);

        // find the common cells
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    output.add(list);
                }
            }
        }

        return output;
    }

    public void canReachPacific(int[][] heights, int[][] pacific){
        Queue<int[]> q = new LinkedList();
        int m = heights.length;
        int n = heights[0].length;

        for(int i = 0; i < m; i++){
            q.add(new int[]{i, 0});
            pacific[i][0] = 1;
        }

        for(int i = 0; i < n; i++){
            q.add(new int[]{0, i});
            pacific[0][i] = 1;
        }

        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, 1, -1, 0};

        while(!q.isEmpty()){
            int[] cell = q.remove();

            for(int i = 0; i < 4; i++){
                int nr = cell[0] + dr[i];
                int nc = cell[1] + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && heights[nr][nc] >= heights[cell[0]][cell[1]] && pacific[nr][nc] == 0){
                    q.add(new int[]{nr, nc});
                    pacific[nr][nc] = 1;
                }
            }
        }
    }

    public void canReachAtlantic(int[][] heights, int[][] atlantic){
        Queue<int[]> q = new LinkedList();
        int m = heights.length;
        int n = heights[0].length;

        for(int i = 0; i < m; i++){
            q.add(new int[]{i, n-1});
            atlantic[i][n-1] = 1;
        }

        for(int i = 0; i < n; i++){
            q.add(new int[]{m-1, i});
            atlantic[m-1][i] = 1;
        }

        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, 1, -1, 0};

        while(!q.isEmpty()){
            int[] cell = q.remove();

            for(int i = 0; i < 4; i++){
                int nr = cell[0] + dr[i];
                int nc = cell[1] + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && heights[nr][nc] >= heights[cell[0]][cell[1]] && atlantic[nr][nc] == 0){
                    q.add(new int[]{nr, nc});
                    atlantic[nr][nc] = 1;
                }
            }
        }
    }


}
