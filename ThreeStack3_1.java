
public class ThreeStack3_1 {

	    public static void main(String[] args){
	    	try{
	    	    for(int i=1;i<=100;i++)
	    	    {
	    		    push(0,i);
	    	    }
	    //	peek(1);
	    //	pop(1);
	   // 	pop(1);
	    //	pop(1);
	   // 	peek(1);

	        peek(0);
	        pop(0);
	        peek(0);
	        push(0,321);
	        pop(0);
	    	}catch (Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    	}
	    	
	
	
		static int size=100;
		static int[] buffer=new int[size*3];
		static int[] stackPointer={-1,-1,-1};	
		public static void push(int stacknum,int value) throws Exception{
			if(stackPointer[stacknum]+1>=size){
				throw new Exception("out of space");
			}
			stackPointer[stacknum]++;
			buffer[stacknum*size+stackPointer[stacknum]]=value;
		}
		public static int pop(int stacknum) throws Exception{
			if(stackPointer[stacknum]==-1){
				throw new Exception("empty stack");
			}
			int value=buffer[stacknum*size+stackPointer[stacknum]];
			buffer[stacknum*size+stackPointer[stacknum]]=0;
			stackPointer[stacknum]--;
			System.out.println(value);
			return value;
		}	
		public static int peek(int stacknum){
			System.out.println(buffer[stacknum*size+stackPointer[stacknum]]);
			return buffer[stacknum*size+stackPointer[stacknum]];
		}
	
}
