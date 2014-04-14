/*Evaluate the value of an arithmetic expression in Reverse Polish Notation. 

Valid operators are +, -, *, /. Each operand may be an integer or another expression. 

Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

*/
import java.util.*;

public class EvaluateReversePolishNotation {
public static int evalRPN(String[] tokens) {
        
        if(tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        
        Stack<String> sta = new Stack<String>();

        int res = 0;
for(int i=0;i<tokens.length;i++){
            
            
            if(tokens[i].equals("+")||tokens[i].equals("-") ||tokens[i].equals("*") ||tokens[i].equals("/")){
                String x = sta.pop();
                String y = sta.pop();
                if(tokens[i].equals("+")){
                    res = Integer.parseInt(x) + Integer.parseInt(y);
                    sta.push(Integer.toString(res));
                }
                else if(tokens[i].equals("-")){
                    res = Integer.parseInt(y) - Integer.parseInt(x);
                    sta.push(Integer.toString(res));
                }
                else if(tokens[i].equals("*")){
                    res = Integer.parseInt(x) * Integer.parseInt(y);
                    sta.push(Integer.toString(res));
                }
                else {
                    res = Integer.parseInt(y) / Integer.parseInt(x);
                    sta.push(Integer.toString(res));
                }
                
                
            }
            else
                sta.push(tokens[i]);
        }

        
        return res;
    }

	public static void main(String args[]){
		String[] t = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163"};
		String[] k ={"-1","1","*","-1","+"};
		System.out.println(evalRPN(k));
	}

}
