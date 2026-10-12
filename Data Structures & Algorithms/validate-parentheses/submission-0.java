class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;

        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;
                if(stack.peek() != map.get(ch)) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
