/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. 

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome. 

Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. 
*/

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
        if(s == null||s.length() == 1)
            return true;
            
        StringBuilder s2 = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122 ||s.charAt(i) >= 48 && s.charAt(i) <= 57)
                s2.append(s.charAt(i));
            else if(s.charAt(i) >= 65 && s.charAt(i) <= 90)
                s2.append((char)(s.charAt(i) + 32));
            else
                continue;
        }
        return isPalin(s2.toString());
        
    }
    
    public static boolean isPalin(String s){
        if(s.length() == 1)
            return true;
        int i=0;
        int j=s.length()-1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
    
    public static void main(String args[]){
    	String k = "kwtbjmsjvbrwriqwxadwnufplszhqccayvdhhvscxjaqsrmrrqngmuvxnugdzjfxeihogzsdjtvdmkudckjoggltcuybddbjoizu";
    	String l = "1a2";
    	System.out.println(isPalindrome(l));
    }

}
