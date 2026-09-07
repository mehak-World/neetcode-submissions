class Solution {
    public boolean isPalindrome(String s) {
        // First make string simpler
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append((ch + "").toLowerCase());
            }
        }

        s = sb.toString();

        int i = 0;
        int j = s.length()-1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
