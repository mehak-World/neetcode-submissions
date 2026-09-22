class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++){
            int prevMax = max;
            int prevMin = min;
            int curr = nums[i];

            max = Math.max(curr, Math.max(curr*prevMax, curr*prevMin));
            min = Math.min(curr, Math.min(curr*prevMin, curr*prevMax));

            ans = Math.max(ans, max);
        }
        return ans;
    }
}
