/*
 *Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
 Given "25525511135", 

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
*/
import java.util.*;
public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> tmp = new ArrayList<String>();
        //validate input
        if(s.length() < 4 || s.length() > 12)
            return res;
            
        dfs(s,tmp,res);
        return res;
    }
    
    public void dfs(String s,ArrayList<String> tmp,ArrayList<String> res){
        //construct last digit, confirm it is not like ".01",".002" but can be ".0"
        if(tmp.size() == 3){
            if(Integer.parseInt(s) <= 255 && (s.length() == 1 ||s.charAt(0) != '0')){
                tmp.add(s);
                convert(tmp,res);
                tmp.remove(tmp.size() - 1);
            }       
        }
    	else{
    	    //we divide two situations: if next char is "0", only divide "0", otherwise try 1~3 digits
    	 if(s.charAt(0) != '0'){
          for(int i=1;i<=3;i++){   
              //confirm the reminder is good to construct a IP address after divided by i digits
              if(s.length() - i >= 3 - tmp.size() && s.length() - i <= 3*(3 - tmp.size()) && Integer.parseInt(s.substring(0,i)) <= 255){
                tmp.add(s.substring(0,i));
                dfs(s.substring(i),tmp,res);
                tmp.remove(tmp.size() - 1);
              }
        	}
    	 }
    	 //if next digit is "0", just get 0 as next segment
    	 else{
    		 if(s.length() - 1 >= 3 - tmp.size() && s.length() - 1 <= 3*(3 - tmp.size())){
                 tmp.add(s.substring(0,1));
                 dfs(s.substring(1),tmp,res);
                 tmp.remove(tmp.size() - 1);
               }
         	}
    	 }
          
    }
    //transfer tmp arraylist to result
    public void convert(ArrayList<String> tmp,ArrayList<String> res){
        StringBuilder r = new StringBuilder();
        for(String s:tmp)
            r.append(s + ".");
        r.deleteCharAt(r.length() - 1);
        res.add(r.toString());
        
    }
    
}
