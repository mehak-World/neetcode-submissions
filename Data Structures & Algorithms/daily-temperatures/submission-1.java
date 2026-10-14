class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();

        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i = n-1; i >= 0; i--){
            int num = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] <= num){
                stack.pop();
            }

            if(!stack.isEmpty()){
                ans[i] = stack.peek() - i;
            }
            else{
                ans[i] = 0;
            }

            stack.push(i);
        }

        return ans;
    }
}
