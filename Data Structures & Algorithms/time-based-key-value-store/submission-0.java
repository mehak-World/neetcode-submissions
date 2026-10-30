class Pair{
    String val;
    int timestamp;

    Pair(String val, int timestamp){
        this.val = val;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    Map<String, List<Pair>> timestamps;
    public TimeMap() {
        timestamps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timestamps.containsKey(key)){
            timestamps.put(key, new ArrayList<>());
        }
        timestamps.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!timestamps.containsKey(key)) return "";

        List<Pair> list = timestamps.get(key);
        int low = 0;
        int high = list.size()-1;
        String ans = "";

        while(low <= high){
            int mid = low + (high - low)/2;
            if(list.get(mid).timestamp == timestamp) return list.get(mid).val;

            else if(list.get(mid).timestamp < timestamp){
                ans = list.get(mid).val;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }
}
