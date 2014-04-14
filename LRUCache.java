import java.util.*;




public class LRUCache {
    //use hashmap to record key and noded
    private HashMap<Integer,Noded> map1 = new HashMap<Integer,Noded>();
    
	private int size;
	//deinfe the head & end of list, head is the most frequent used element and new element add to, end is the least used element 
	//noded is defined by a new class, include key, value, next, prev, like a double linked list
    private Noded head;
    private Noded end = head;
    public LRUCache(int capacity) {
    	
        this.size = capacity;
        
    }
    //implement get method
    //each time get, move the element to head
    public int get(int key) {
        if(map1.containsKey(key)){
            movetoHead(map1.get(key));
            return map1.get(key).value;
        }
        else
            return -1;
  
    }
    //implement set, each time set, move the element to head
    public void set(int key, int value) {
        
        Noded node = new Noded(key,value);
        //if contains, just update it, don't consider the size exceed
        if(map1.containsKey(key)){
            removeNode(map1.get(key));
            map1.put(key,node);
            
            //add this node to head
            if(head != null){
                node.next = head;
                head.prev = node;
                head = node;
                }
            else{
                head = node;
                end = node;
            }
        }
        //if not contains, consider the size arrive at capacity or not
        else{
           if(map1.size() < size){
                map1.put(key,node);
            
                //add this node to head
                if(head != null){
                    node.next = head;
                    head.prev = node;
                    head = node;
                    }
                else{
                    head = node;
                    end = node;
                }
            }
            else{ 
                //delete the least recently used node
                map1.remove(end.key);
                if(end.prev != null){
                    end.prev.next = null;
                    end = end.prev;
                }
                else{
                    end = null;
                    head = null;
                }
            
                //update map
                map1.put(key,node);
            
                //add this node to head
                if(head != null){
                    node.next = head;
                    head.prev = node;
                    head = node;
                    }
                else{
                    head = node;
                    end = node;
                }
            }
        }
        
        
    }
    
    public void removeNode(Noded node){
        if(node.next == null && node.prev == null){
            head = null;
            end = null;
        }
        else if(node.next == null){
            end = node.prev;
            end.next = null;
        }
        else if(node.prev == null){
            head = node.next;
            node.next = null;
            head.prev = null;
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    
    public void movetoHead(Noded node){
        removeNode(node);
        
        node.prev = null;
        if(head != null){
            node.next = head;
            head.prev = node;
            head = node;
        }
        else{
            head = node;
            end = node;
        }
        
    }
}

class Noded{
    public Noded prev;
    public Noded next;
    public int value;
    public int key;
    
    public Noded(int k,int v){
        this.prev = null;
        this.next = null;
        this.value = v;
        this.key = k;
    }

}


