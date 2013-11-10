import java.util.Stack;


public class sortstack3_6 {
	public static void main(String args[]){
		Stack<Integer> s=new Stack<Integer>();
		s.push(20);
		s.push(24);
		s.push(17);
		s.push(15);
		for(int i:sort(s))
		  System.out.println(i);
	}

	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r=new Stack<Integer>();
		while(!s.isEmpty()){
		int temp=s.pop();
		while(!r.isEmpty()&&r.peek()>temp){
			s.push(r.pop());
		}
			r.push(temp);
		}
		return r;	
		}
	}

