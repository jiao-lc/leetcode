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
    
    public void remove(Node node) {
        if(node.next != null) {
            node.prev.next = node.next;
        } else {
            tail = node.prev;
        }
        if(node.prev != null) {
            node.next.prev = node.prev;
        } else {
            head = node.next;
        }
    }
    
    public void setHead(Node node) {
        if(head != null){
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        } else {
            head = node;
            tail = node;
        }
    }
}