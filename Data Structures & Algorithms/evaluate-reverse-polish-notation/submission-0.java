class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack();
        Set<String> set = new HashSet();

        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String token: tokens){
            if(!set.contains(token)){
                operands.push(Integer.parseInt(token));
            }
            else{
                int op2 = operands.pop();
                int op1 = operands.pop();

                int ans = eval(token, op1, op2);
                operands.push(ans);
            }
        }

        return operands.pop();
    }

    public int eval(String op, int num1, int num2){
        switch(op){
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
        }

        return -1;
    }
}
