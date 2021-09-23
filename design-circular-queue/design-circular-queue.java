class MyCircularQueue {
    int[] queue;
    int front, rear = -1;
    int len = 0;
    public MyCircularQueue(int k) {
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (!isFull()){
            rear = (rear + 1) % queue.length;
            queue[rear] = value;
            len++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()){
            front = (front + 1) % queue.length;
            len--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        return (!isEmpty()) ? queue[front] : -1;
    }
    
    public int Rear() {
        return (!isEmpty()) ? queue[rear] : -1;
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */