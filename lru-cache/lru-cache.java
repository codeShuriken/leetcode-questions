class LRUCache {
    Map<Integer, Node> map;
    int cnt, capacity;
    DList dList;
   
    public LRUCache(int capacity) {
       map = new HashMap<>();
       dList = new DList();
       cnt = 0;
       this.capacity = capacity;
    }
    
    public int get(int key) {
      Node node = map.get(key);
      if (node == null)
          return -1;
      dList.moveToHead(node);
      return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0)return;
        Node node = map.get(key);
        if (node == null){
            Node newNode = new Node(key, value);
            if (cnt == capacity){
                Node toRemove = dList.popTail();
                map.remove(toRemove.key);
                --cnt;
            }
            map.put(key, newNode);
            dList.addNode(newNode);
            ++cnt;
        }else{
            node.val = value;
            dList.moveToHead(node);
        }
    }
    
    
}
class Node{
    int key;
    int val;
    Node prev, next;
    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
    Node(){
        this(0,0);
    }
}

class DList{
    Node head;
    Node tail;
    int count;
    DList(){
        head = new Node();
        tail = new Node();
        count = 0;
        head.next = tail;
        tail.prev = head;
    }
    
    void moveToHead(Node node){
        deleteNode(node);
        addNode(node);
    }
    
    void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    void addNode(Node node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
    
    Node popTail(){
        Node node = tail.prev;
        deleteNode(node);
        return node;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */