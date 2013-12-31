/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 

 */
public class ReverseInt {
	
	    public int reverse(int x) {
	        Integer y=x;
	        String s=y.toString();
	        String s2="";
	        Boolean c=false;
	        /*处理负数的情况，把符号去掉，用c来记录这个数的符号*/
	        if(s.charAt(0) == '-') 
	        {
	            c=true;
	            s=s.substring(1);
	         }
	        
	        /*处理尾部有0的情况，比如10000或12300，把后面的0都去掉*/
	        if(s.charAt(s.length()-1) == 0){
	            int i=0;
	            for(i=s.length()-1;i>=0 && s.charAt(i)==0;i--)
	            {}
	            s=s.substring(0,i+1);
	        }
	        
	        if(s == "")
	            return 0;
	        /*把这个数反转*/
	        for(int i=s.length()-1;i>=0;i--){
	            s2+=s.charAt(i);
	        }
	        /*根据记录的符号，恢复数字*/
	        if(c == false)
	             return Integer.parseInt(s2);
	        else
	             return Integer.parseInt("-"+s2);
	        
	        
	    }
	}

