class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        // Store frequency
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int cycle = 1;

        // MAX heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (char task : map.keySet()) {
            pq.add(map.get(task));
        }

        // {remainingFrequency, availableAt}
        Queue<int[]> q = new LinkedList<>();

        while (!pq.isEmpty() || !q.isEmpty()) {

            // Move cooled-down tasks back to heap
            while (!q.isEmpty() && q.peek()[1] <= cycle) {
                int[] task = q.remove();
                pq.add(task[0]);
            }

            // Execute highest-frequency available task
            if (!pq.isEmpty()) {

                int freq = pq.remove();

                freq--;

                if (freq > 0) {
                    q.add(new int[]{
                        freq,
                        cycle + n + 1
                    });
                }
            }

            cycle++;
        }

        return cycle - 1;
    }
}