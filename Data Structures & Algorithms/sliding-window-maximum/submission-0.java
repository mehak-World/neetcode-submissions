class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i = 0; i < k; i++){
            pq.add(new int[]{nums[i], i});
        }

        ans[0] = pq.peek()[0];
        for(int i = k; i < n; i++){
            pq.add(new int[]{nums[i], i});
            while(pq.peek()[1] <= i - k){
                pq.remove();
            }

            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }
}
