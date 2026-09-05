class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0) maxHeap.add(num);
        else{
            if(maxHeap.peek() < num) minHeap.add(num);
            else maxHeap.add(num);
        }

        //balancing 
        if(maxHeap.size() == minHeap.size() + 2){
            minHeap.add(maxHeap.poll());
        }
        if(maxHeap.size() + 2 == minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        
        //if even
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else return minHeap.peek();
    }
}
