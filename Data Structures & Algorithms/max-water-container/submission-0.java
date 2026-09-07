class Solution {
    public int maxArea(int[] heights) {
        int max_area = 0;

        int i = 0;
        int j = heights.length - 1;

        while(i < j){
            int width = j - i;
            int area = Math.min(heights[i], heights[j]) * width;

            max_area = Math.max(area, max_area);
            if(heights[i] < heights[j]) i++;
            else j--;
        }

        return max_area;
    }
}
