/*Given a string S, find the longest palindromic substring in S.
 *  You may assume that the maximum length of S is 1000, and there 
 *  exists one unique longest palindromic substring
 * */


public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
        String max="";
        if(s.length() == 0)
            return max;
        if(s.length() == 1)
            return s;
        if(s.length() > 1){
        	/*如果前两位就相同，先记录一次长度为2的回文*/
        	if(s.charAt(0) == s.charAt(1))
        		max=s.substring(0,2);
        	/*然后遍历整个字符串，当出现前后两个字母一样的情况AA，或者跳一个字符一样如ABA；这两种情况出现的时候，调用check
        	 * 函数，检查子回文串的长度，如果比当前记录的max串长，就覆盖当前max*/
        	for(int i=2;i<s.length();i++){
        			if(s.charAt(i-1) == s.charAt(i)){
        				String t1=check(s,i,0);
        				if(t1.length() > max.length())
        					max=t1;
        			}
        			if(s.charAt(i-2) == s.charAt(i)){
        				String t2=check(s,i,1);
        				if(t2.length() > max.length())
        					max=t2;
        			}
        		}
        	
        	}
        return max;
    	}
    /*写一个check函数，用来检查子回文串长度*/
    public static String check(String s,int i,int b){
        
        int j=i-1-b;
        while(j>=0 && i<s.length() && s.charAt(j) == s.charAt(i)){
            j--;
            i++;
        }
        return s.substring(j+1,i);
    }

    public static void main(String args[]){
    	System.out.println(longestPalindrome("ccc"));
    
    	
    }
    
}


