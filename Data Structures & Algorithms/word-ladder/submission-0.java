class Pair{
    String word;
    int seq;

    Pair(String word, int seq){
        this.word = word;
        this.seq = seq;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int minLen = Integer.MAX_VALUE;
        Set<String> words = new HashSet();

        for(String word: wordList){
            words.add(word);
        }

        Queue<Pair> q = new LinkedList();
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair p = q.remove();
            String word = p.word;
            int seq = p.seq;

            if(word.equals(endWord)) return seq;

            for(int i = 0; i < word.length(); i++){
                for(int j = 0; j < 26; j++){
                    char ch = (char)('a' + j);
                    String s = word.substring(0, i) + ch + word.substring(i+1);
                    if(words.contains(s)){
                        q.add(new Pair(s, seq+1));
                        words.remove(s);
                    }
                }
            }
            
        }

        return 0;
    }
}
