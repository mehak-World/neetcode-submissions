class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // add all the dict words into the set
        Set<String> set = new HashSet();

        for(String word: wordDict){
            set.add(word);
        }

        int n = s.length();
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
                dp[i] = -1;
        }

        return helper(s, 0, set, dp);
    }

    public boolean helper(String s, int i, Set<String> set, int[] dp){
        if(i > s.length()-1) return true;

        if(dp[i] != -1) return dp[i] == 1;

        for(int k = i+1; k <= s.length(); k++){
            String word = s.substring(i, k);
            if(set.contains(word) && helper(s, k, set, dp)){
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}
