class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        int n = maxHeap.remove();
        minHeap.add(n);

        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        int n1 = minHeap.size();
        int n2 = maxHeap.size();

        if((n1 + n2) % 2 == 0){
            // even
            return ((double) minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
