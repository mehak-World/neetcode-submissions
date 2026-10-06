class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int stone: stones){
            pq.add(stone);
        }

        while(pq.size() > 1){
            int wt1 = pq.remove();
            int wt2 = pq.remove();

            if(wt1 != wt2){
                pq.add(Math.abs(wt1 - wt2));
            }
        }

        return pq.isEmpty() ? 0 : pq.remove();
    }
}
