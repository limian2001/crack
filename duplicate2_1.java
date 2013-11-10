import java.util.Hashtable;


public class duplicate2_1 {

	public static void deleteDups(LinkedListNode n){
		Hashtable table=new Hashtable();
		LinkedListNode previous=null;
		while(n!=null){
			if(table.containsKey(n.data)){
				previous.next=n.next;
			}
			else{
				table.put(n.data,true);
				previous=n;
			}
			n=n.next;
		}
	}

public class LinkedListNode {
	 LinkedListNode next = null;
	 int data = 0;
     
	}
	
}
