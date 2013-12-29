
 
public class solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Integer t1;
		Integer t2;
		String s1="";
		String s2="";
		
		while(l1!=null){

			t1=l1.val;
			s1=t1.toString()+s1;
			l1=l1.next;
			
			}
		while(l2!=null){
			
			t2=l2.val;
		    s2=t2.toString()+s2;
		    l2=l2.next;
		    }
	    long s=Long.parseLong(s1)+Long.parseLong(s2);
	    System.out.println(s1);
	    System.out.println(s2);
	    System.out.println(s);
	    return inputlist(s);
    }
    
    public static ListNode inputlist(long a){
		long x=a;
		long b=x%10;
		System.out.println("b= "+b);
		ListNode l1=new ListNode((int)b);
		System.out.println(l1.val);
		ListNode t1=l1;
		x=x/10;
		
		    while(x>0){
		    	
		    	long c=x%10;
		    	
		        ListNode t2=new ListNode((int)c);
		        System.out.println(t2.val);
		        t1.next=t2;
		        t1=t2;
		        x=x/10;
		            }
		    return l1;
		  
		}
    
    public static void main(String args[]){
    	
    	ListNode a=new ListNode(1);

    	ListNode b=new ListNode(9);
    	ListNode k=a;
    	for(int i=0;i<9;i++)
    	{
    		ListNode t = new ListNode(9);
    		k.next=t;
    		k=t;
    	}
    	
    	
    	System.out.println(addTwoNumbers(a,b));
    	
    }
}