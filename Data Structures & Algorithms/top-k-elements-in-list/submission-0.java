class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[1] - b[1]);
        
        for(int key: map.keySet()){
            pq.add(new int[]{key, map.get(key)});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] output = new int[k];
        int j = 0;
        while(!pq.isEmpty()){
            output[j] = pq.remove()[0];
            j++;
        }
        return output;
    }
}

