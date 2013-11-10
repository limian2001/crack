import java.util.LinkedList;
import java.util.List;


public class Linkedlist2_5 {
   public static void main(String[] args){
	   LinkedList<Integer> a=new LinkedList();
	   a=addlist(inputlist(617),inputlist(295));
	   for(Integer t:a)
	   System.out.print(t);
   
   }
	
	public static LinkedList inputlist(int a){
		int x=a;
		LinkedList l1=new LinkedList();
		while(x>0){
			l1.add(x%10);
			x=x/10;
		}
		return l1;
		}
		
	public static LinkedList addlist(LinkedList<Integer> a,LinkedList<Integer> b){
		String s1="";
		String s2="";
		while(a.isEmpty()==false){
			Integer t1=a.removeLast();
			s1+=t1.toString();}
		while(b.isEmpty()==false){
			Integer t2=b.removeLast();
		    s2+=t2.toString();}
	    int s=Integer.parseInt(s1)+Integer.parseInt(s2);
	    return inputlist(s);
	}
		
	
	}
	
	

