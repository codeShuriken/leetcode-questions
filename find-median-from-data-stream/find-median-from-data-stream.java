class MedianFinder {
    
    PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> highers = new PriorityQueue<>();

    
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (lowers.isEmpty() || num <= lowers.peek())lowers.add(num);
        else highers.add(num);
        
        heapify();
    }
    
    private void heapify(){
        PriorityQueue<Integer> smaller = (lowers.size() < highers.size()) ? lowers : highers;
        PriorityQueue<Integer> bigger = (lowers.size() > highers.size()) ? lowers : highers;
        
        if (bigger.size() - smaller.size() > 1){
            smaller.add(bigger.poll());
        }
        
    }
    
    public double findMedian() {
        if ((lowers.size() + highers.size())  % 2 == 0){
            return (lowers.peek() + highers.peek()) / 2.0;
        }
        return (highers.size() < lowers.size()) ? lowers.peek() : highers.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */