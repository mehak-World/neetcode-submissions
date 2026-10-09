class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> bag = new ArrayList();

        for(int num: nums){
            bag.add(num);
        }

        helper(bag, new ArrayList(), ans);
        return ans;
    }

    public void helper(List<Integer> bag, List<Integer> list, List<List<Integer>> ans){
        if(bag.size() == 0){
            ans.add(new ArrayList(list));
            return;
        }

        for(int i = 0; i < bag.size(); i++){
            int el = bag.get(i);
            bag.remove(i);
            list.add(el);
            helper(bag, list, ans);
            list.remove(list.size()-1);
            bag.add(i, el);
        }
    }
}
