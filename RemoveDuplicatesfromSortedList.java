/*Remove Duplicates from Sorted List Total Accepted: 7765 Total Submissions: 22815 My Submissions 





Given a sorted linked list, delete all duplicates such that each element appear only once. 

For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3. 
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
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode p=head;
        while(p != null && p.next != null){
            
            if(p.next.val == p.val)
                p.next = p.next.next;
            else
                p=p.next;
        }
        return head;
    }
}


