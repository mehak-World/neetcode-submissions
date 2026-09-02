class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for(String word: strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList());
            }
            map.get(sorted).add(word);
        }

        for(String key: map.keySet()){
            output.add(map.get(key));
        }

        return output;
    }
}
