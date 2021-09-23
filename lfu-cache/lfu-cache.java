class LFUCache {
    Map<Integer, Node> nodeMap;
    Map<Integer, DList> countMap;
    int min, capacity, size;
    
    public LFUCache(int capacity) {
        countMap = new HashMap<>();
        nodeMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null)
            return -1;
        
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0)return;
        Node node = nodeMap.get(key);
        if (node == null){
            Node newNode = new Node(key, value);
            if (size == capacity){
                //remove node from min count dlist
                Node toRemove = countMap.get(min).removeTail();
                nodeMap.remove(toRemove.key);
                size--;
            }
            
            ++size;
            nodeMap.put(key, newNode);
            min = 1;
            DList newList = countMap.getOrDefault(min, new DList());
            newList.addNode(newNode);
            countMap.put(min, newList);
        }else{
            node.val = value;
            update(node);
        }
    }
    
    private void update(Node node){
        DList oldList = countMap.get(node.cnt);
        oldList.removeNode(node);
        
        if (oldList.size == 0 && node.cnt == min){
            ++min;
        }
        
        node.cnt++;
        DList newList = countMap.getOrDefault(node.cnt, new DList());
        newList.addNode(node);
        countMap.put(node.cnt, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node{
    int key;
    int val;
    int cnt;
    Node next, prev;
    Node(){
        this(-1, -1);
    }
    Node(int key, int val){
        this.key=key;
        this.val=val;
        cnt=1;
    }
}

class DList{
    Node head;
    Node tail;
    int size;
    DList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    void addNode(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        
        ++size;
    }
    
    
    void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        --size;
    }
    
    Node removeTail(){
        if (size > 0){
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
        
        return null;
    }
}