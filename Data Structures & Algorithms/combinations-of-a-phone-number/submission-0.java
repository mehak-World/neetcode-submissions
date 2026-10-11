class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList();
        if(digits.length() == 0) return ans;
        Map<Character, List<Character>> map = new HashMap();

        map.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        map.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        map.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        map.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        map.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        map.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        map.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));

        helper(0, digits, new StringBuilder(), ans, map);
        return ans;
    }

    public void helper(int i, String digits, StringBuilder sb, List<String> ans, Map<Character, List<Character>> map){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }

        List<Character> list = map.get(digits.charAt(i));
        for(char ch: list){
            sb.append(ch);
            helper(i+1, digits, sb, ans, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
