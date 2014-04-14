public class Noded{
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
