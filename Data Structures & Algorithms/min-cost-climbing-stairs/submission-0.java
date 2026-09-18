class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCosts = new int[n];

        for(int i = 0; i < n; i++){
            minCosts[i] = -1;
        }

        helper(0, cost, minCosts);

        return Math.min(minCosts[0], minCosts[1]);
    }

    public int helper(int i, int[] cost, int[] minCosts){
        if(i >= cost.length) return 0;

        if(minCosts[i] != -1) return minCosts[i];

        int price = cost[i];
        price += Math.min(helper(i+1, cost, minCosts), helper(i+2, cost, minCosts));

        return minCosts[i] = price;
    }
}
