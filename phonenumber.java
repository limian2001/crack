/*Letter Combinations of a Phone Number Total Accepted: 3552 Total Submissions: 14449 My Submissions 

Given a digit string, return all possible letter combinations that the number could represent. 

A mapping of digit to letters (just like on the telephone buttons) is given below.

 * */

import java.util.*;

public class phonenumber {
	
	
	public static ArrayList<String> letterCombinations(String digits) {
        
		ArrayList<String> result=new ArrayList<String>();
		String tmp="";
		if(digits == ""){
            result.add(digits);
            return result;
            }
   
        dfs(digits,0,result,tmp);
        return result;
    }

    public static void dfs(String digits,int start,ArrayList<String> result,String tmp){
    	String[] num={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    	
    	
    	if(start == digits.length())
    		return;
    	
        int n=digits.charAt(start)-'0';
        
        for(int i=0;i<num[n].length();i++){
            tmp+=num[n].charAt(i);
            dfs(digits,start+1,result,tmp);
            /*这里不完美，输出的结果里面包含一位和两位的，最后通过if语句来控制，*/
            if(tmp.length() == digits.length())  
            	result.add(tmp);
            tmp=tmp.substring(0,tmp.length()-1);
        }
    }
    public static void main(String args[]){
    	
    	System.out.println(letterCombinations("234"));
    }
}
