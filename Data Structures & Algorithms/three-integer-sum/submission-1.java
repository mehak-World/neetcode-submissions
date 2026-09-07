class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the arr
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList();

        int i = 0; // Fixed ptr
        int n = nums.length;

        while(i < n){
            while(i != 0 && i < n && nums[i] == nums[i-1]){
                i++;
                continue;
            }

            int j = i+1;
            int k = n-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    ArrayList<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    output.add(list);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
                else if(sum > 0) k--;
                else j++;
            }
            i++;
        }
 
        return output;
    }
}
