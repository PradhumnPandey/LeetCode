import java.util.*;
public class LRU
{
    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.get(1));
        test.put(3, 3);
        System.out.println(test.get(2));
        test.put(4, 4);
        System.out.println(test.get(1));
        System.out.println(test.get(3));
        System.out.println(test.get(4));

    }
}
class Node
{
    int key, value;
    Node prev,next;
    Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
    Node()
    {
        prev = null;
        next = null;
    }
}

class LRUCache {
    Node head,tail;
    HashMap<Integer,Node> map; //key & Node
    int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
         map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            //removing from tail
            Node existing = map.get(key);
            existing.prev.next = existing.next;
            existing.next.prev = existing.prev;

            //adding to head
            existing.next = head.next;
            existing.prev = head;
            head.next = existing;
            existing.next.prev = existing;
            
            return existing.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        Node n = new Node(key,value);
        if(map.containsKey(key)) // already exists
        {
            Node existing = map.get(key);
            existing.prev.next = existing.next;
            existing.next.prev = existing.prev;
            map.remove(key);
        }
        if(map.size() == cap) // new node but cache full
        {
           Node LRU = tail.prev;
           LRU.prev.next = tail;
           tail.prev = LRU.prev;
           LRU.next = null;
           LRU.prev = null;
           map.remove(LRU.key);
        }
        
        map.put(key,n);
        n.next = head.next;
        n.prev = head;
        head.next = n;
        n.next.prev = n;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */