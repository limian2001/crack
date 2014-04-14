


public class SortList {
	
	public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        if(head.next.next == null){
            ListNode node = head.next;
            head.next = null;
            return merge(head,node);
        }
        
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        p2 = p1.next;
        p1.next = null;
        
        
        
        
        return merge(sortList(head),sortList(p2));
        
    }
    
    
    public static ListNode merge(ListNode p,ListNode q){
        ListNode myhead = new ListNode(0);
        ListNode point = myhead;
        while(p != null && q != null){
            if(p.val < q.val){
                point.next = p;
                p = p.next;
            }
            else{
                point.next = q;
                q = q.next;
            }
            point = point.next;
        }
        if(p == null)
            point.next = q;
        else
            point.next = p;
            
        return myhead.next;
        
        
    }
    
    public static void  main(String args[]){
    	ListNode node = new ListNode(3);
    	ListNode node2 = new ListNode(2);
    	ListNode node3 = new ListNode(4);
    	node.next = node2;
    	node2.next = node3;
    	ListNode p = sortList(node);
    	while(p != null){
    		System.out.println(p.val);
    		p = p.next;
    	}
    	
    }

}
