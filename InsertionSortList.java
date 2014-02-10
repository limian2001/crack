/*Insertion Sort List Total Accepted: 5247 Total Submissions: 20677 My Submissions 





Sort a linked list using insertion sort.

/**
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
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null)
            return head;

        ListNode point = head;
        
        ListNode pre = point;
        point = point.next;
        while(point != null){
            
            if(pre.val <= point.val){
                pre = point;
                point = point.next;
            }
            else{
                ListNode tmp = head;
                if(point.val <= tmp.val){
                    pre.next = point.next;
                    point.next = head;
                    head = point;
                    if(pre != null)
                        point = pre.next;
                    else 
                        return head;
                    
                }
                else{
                    ListNode tmppre = tmp;
                    while(tmp.val < point.val){
                        tmppre = tmp;
                        tmp = tmp.next;
                    }
                    pre.next = point.next;
                    point.next = tmp;
                    tmppre.next = point;
                    if(pre != null)
                        point = pre.next;
                    else 
                        return head;
                
            }
            }
        }
        return head;
    }

}
