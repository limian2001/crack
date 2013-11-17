/*judge a string is palindrome, for example "abcba", "abcccba* are
 * both palindrome.  
 */


import java.util.LinkedList;
import java.util.Stack;


public class isPalinedrome {
	public static boolean isPalinedrome(Node head){
		/*use two pace pointers, fast and slow, fast is double speed of slow
		 * when the fast pointer arrive at end, the slow pointer is in mid */
		Node fast = head;
		Node slow = head;
		/*use stack save the slow pointer, the first half of string is in stack */
		Stack<Node> stack=new Stack<Node>();
		/*consider the two situation, odd and even. the end situations include
		 * fast = -1 or 0 */
		while(fast != null && fast.next != null){
		fast = fast.next.next;
		stack.push(slow);
		slow = slow.next;
		}
		
		/*fast == null, even length, slow=mid+1, stack mid */
		if(fast == null){
			while(stack.size()>0){
				if(stack.pop().value == slow.value)
				slow=slow.next;
				else 
					return false;
			}
			return true;
		}
		/* fast.next==null, odd length, slow=mid, stack=mid-1 */
		else{
			slow=slow.next;  /*skip the mid node*/
			while(stack.size()>0){
				if(stack.pop().value == slow.value)
				slow=slow.next;
				else 
					return false;
			}
			return true;
		}
			
		
		
	}
	
		
	public static void main(String args[]){
/*use Node class, Node class is written by self*/
		Node a=new Node("a");
		a.add("c");
		a.add("a");

/*print the whole string*/
		Node tmp=a;
		while(tmp != null){
	    System.out.println(tmp.value);
	    tmp=tmp.next;}
	    System.out.println(isPalinedrome(a));
		}
    
	
	}




