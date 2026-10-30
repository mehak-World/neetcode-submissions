class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;

        while(isValid(i, j, matrix.length, matrix[0].length)){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target){
                j--;
            }
            else i++;
        }

        return false;
    }

    boolean isValid(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
