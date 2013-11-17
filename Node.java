/*Node class, has value and next value
 * structure a method add to append a next node  */

class Node{
	
	String value;
	Node next;
	public Node(String value){
		this.value = value;
		this.next = null;
	}
	public void add(String value){
		Node tmp = this;
		while(tmp.next != null){
			tmp = tmp.next;
		}
		Node a=new Node(value);
		tmp.next=a;
	}
	
	
}