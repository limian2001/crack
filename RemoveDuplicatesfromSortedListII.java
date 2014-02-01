/*
 * Remove Duplicates from Sorted List II Total Accepted: 5390 Total Submissions: 21758 My Submissions 





Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 

For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3. 
*/
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null)
            return head;
            
        ListNode myHead=new ListNode(0);
        myHead.next = head;
        ListNode newhead = myHead;
        
        while(myHead != null && myHead.next != null && myHead.next.next != null){
            if(myHead.next.next.val == myHead.next.val){
                ListNode tmp=myHead.next.next; 
                while(tmp.val == myHead.next.val && tmp.next != null){
                    tmp = tmp.next;
                }
                if(tmp.val != myHead.next.val)
                    myHead.next = tmp;
                else
                    myHead.next = null;
            }
            else
                myHead = myHead.next;
        }
        return newhead.next;
    }

}
