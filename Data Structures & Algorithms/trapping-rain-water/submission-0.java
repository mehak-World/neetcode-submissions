class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int maxWater = 0;

        leftMax[0] = -1;
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
        }

        rightMax[n-1] = -1;
        for(int i = n-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }

        for(int i = 0; i < n; i++){
            int left = leftMax[i];
            int right = rightMax[i];

            if(left > height[i] && right > height[i]){
                int water = Math.min(left, right) - height[i];
                maxWater += water;
            }
        }

        return maxWater;
    }
}
