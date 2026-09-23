class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // add all the dict words into the set
        Set<String> set = new HashSet();

        for(String word: wordDict){
            set.add(word);
        }

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        return helper(s, 0, n-1, set, dp);
    }

    public boolean helper(String s, int i, int j, Set<String> set, int[][] dp){
        if(i > j) return true;

        if(dp[i][j] != -1) return dp[i][j] == 1;

        for(int k = i+1; k <= j+1; k++){
            String word = s.substring(i, k);
            if(set.contains(word) && helper(s, k, j, set, dp)){
                dp[i][j] = 1;
                return true;
            }
        }

        dp[i][j] = 0;
        return false;
    }
}
