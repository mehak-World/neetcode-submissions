class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList();

        helper(0, target, candidates, list, ans);
        return ans;
    }

    public void helper(int i, int target, int[] candidates, List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList(list));
            return;
        }

        

        for(int j = i; j < candidates.length; j++){
            if(j != i && candidates[j] == candidates[j-1]) continue;
            if(candidates[j] <= target){
                list.add(candidates[j]);
                helper(j+1, target - candidates[j], candidates, list, ans);
                list.remove(list.size()-1);
            }
            else{
                break;
            }
        }

    }
}
