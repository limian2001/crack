/*Reverse Linked List II Total Accepted: 7609 Total Submissions: 30133 My Submissions 





Reverse a linked list from position m to n. Do it in-place and in one-pass. 

For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4, 

return 1->4->3->2->5->NULL. 

Note:
 Given m, n satisfy the following condition:
 1 ¡Ü m ¡Ü n ¡Ü length of list. 
*/
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        //parameter reference:  1,    2,     3,    4,    5,     6,    7,  null       m=3,n=5
        //                     head  node1  nodem       noden  node2
        ListNode myhead = head;
        
        if(m == n ||head == null)
            return head;
        
        int i = 1;
        ListNode nodem = head;
        ListNode node1 = head;
        
        if(m == 1)
            node1 = null;
        else if(m == 2){
            node1 = head;
            nodem = head.next;
        }
        else{
            while(i < m - 1){
                myhead = myhead.next;
                i++;
            }
            node1 = myhead;
            nodem = myhead.next;
        }
        //At this time:
        //     2,   m=3,   4
        //         nodep  nodec
        ListNode nodep = nodem;
        ListNode nodec = nodem.next;
        i = m;
        
        while(i < n){
            ListNode tmp1 = nodep;
            ListNode tmp2 = nodec;
            //Notice: can't write "nodep = nodep.next" instead of "nodep = nodec", because at this time "nodep.next" probably is not
            //nodec any more, but the previous one!
            nodep = nodec;
            nodec = nodec.next;
            i++;
            tmp2.next = tmp1;
        }
        //At this time:
        //     4,   n=5,   6
        //         nodep  nodec
        ListNode noden = nodep;
        ListNode node2 = nodec;
        
        nodem.next = node2;
        if(m != 1)
            node1.next = noden;
        else
            head = noden;
        
        
        return head;
        
        
    }

}
