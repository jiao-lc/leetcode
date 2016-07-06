class Node {
    int key;
    int val;
    Node prev;
    Node next;
    Node(int k, int v) { key = k; val = v;}
}

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head = null;
    Node tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.val = value;
            remove(old);
            setHead(old);
        } else {
            Node newnode = new Node(key, value);
            if(map.size() >= capacity){
                map.remove(tail.key);
                remove(tail);
                setHead(newnode);
            }else{
                setHead(newnode);
            }
            map.put(key, newnode);
        }
    }
    
    public void remove(Node n) {
        if(n.prev != null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }
        if(n.next != null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
    }
    
    public void setHead(Node n){
        n.next = head;
        n.prev = null;
        
        if(head != null){
            head.prev = n;
        }
        head = n;
        if(tail == null){
            tail = head;
        }
    }
}