import java.util.*;
/*Valid Parentheses Total Accepted: 5926 Total Submissions: 21430 My Submissions 





Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class ValidParentheses {
	public boolean isValid(String s) {
	       // if(s == "")
	         //   return true;
	        HashMap<Character,Character> map = new HashMap<Character,Character>();
	        
	        map.put('(',')');
	        map.put('{','}');
	        map.put('[',']');
	        Stack<Character> stack= new Stack<Character>();
	        
	        for(int i=0;i<s.length();i++){
	            if(map.containsKey(s.charAt(i)))
	                stack.push(s.charAt(i));
	            else if(map.containsValue(s.charAt(i))){
	                if(!stack.empty() && map.get(stack.peek()) == s.charAt(i))
	                    stack.pop();
	                else
	                    return false;
	            }
	            else
	                return false;
	            
	        }
	        return stack.empty();
	        
	    
	      
	    }
}
