import java.util.*;
public class SwapNodesinPairs {
	public static ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null)
            return head;
            
        ListNode myhead = head.next;
        
       
        ListNode tmp = head;
        ListNode newpoint1 = new ListNode(0);
        ListNode newpoint2 = new ListNode(0);
        //下面把两个node位置换一下
        while(tmp != null && tmp.next != null){
            ListNode k = tmp;
        	tmp = tmp.next.next;
        	
                
                newpoint2 = k.next;
                newpoint1.next = newpoint2;
                newpoint1 = k;
                newpoint2.next = newpoint1;
        
        }
        
        if(tmp == null){
                newpoint1.next = null; //最后要断开，否则p1和p2之间存在环路
        		return myhead;
        }
        if(tmp.next == null){
                newpoint1.next = tmp;
                return myhead;
            }
      
        
        return myhead;
        
    }
	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.next = b;
		
		System.out.println(swapPairs(a).next.val);
	}

}
