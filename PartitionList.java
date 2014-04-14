/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. 

You should preserve the original relative order of the nodes in each of the two partitions. 

For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5. 
*/
//这种题目不难，但是一定要把变量设置画图解释清楚后再开始做，否则会很乱
public class PartitionList {
public ListNode partition(ListNode head, int x) {
        
        //small number connect to S list and Large number connect to L list, myhead is a previous head
        ListNode Smyhead = new ListNode(0);
        ListNode Lmyhead = new ListNode(0);
        ListNode Scur = Smyhead;
        ListNode Lcur = Lmyhead;
        
        while(head != null){
            if(head.val < x){
                Scur.next = head;
                Scur = Scur.next;
            }
            else{
                Lcur.next = head;
                Lcur = Lcur.next;
            }
            head = head.next;
        }
        
        Scur.next = Lmyhead.next;
        //disconnct the Lcur's next
        Lcur.next = null;
        return Smyhead.next;
    }

}
