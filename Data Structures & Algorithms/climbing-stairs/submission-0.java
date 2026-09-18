class Solution {

    public int climbStairs(int n) {
        int[] ways = new int[n+1];

        for(int i = 0; i <= n; i++){
            ways[i] = -1;
        }

        return helper(n, ways);
    }

    public int helper(int n, int[] ways){
        if(n == 1 || n == 2) return n;

        if(ways[n] != -1) return ways[n];

        return ways[n] = helper(n-1, ways) + helper(n-2, ways);
    }

}
