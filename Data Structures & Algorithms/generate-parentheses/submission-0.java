class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        helper(n, n, new StringBuilder(), list);
        return list;
    }

    public void helper(int open, int closed, StringBuilder sb, List<String> list){
        if(open == 0 && closed == 0){
            list.add(sb.toString());
            return;
        }

        if(open == closed){
            sb.append('(');
            helper(open-1, closed, sb, list);
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        if(open > 0){
            sb.append('(');
            helper(open-1, closed, sb, list);
            sb.deleteCharAt(sb.length()-1);
        }

        sb.append(')');
        helper(open, closed-1, sb, list);
        sb.deleteCharAt(sb.length()-1);

    }
}
