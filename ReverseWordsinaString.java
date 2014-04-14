
public class ReverseWordsinaString {
	public static String reverseWords(String s) {
        if(s.equals(null) || s.length() == 0)
            return s;
        String[] revs = s.split(" ");
        if(revs.length == 0)
            return "";
        if(revs.length == 1)
            return revs[0];
        String res = "";
        for(String k: revs){
            if(!k.equals("")) 
                res = k + " " + res;
        }
        res = res.substring(0,res.length() - 1);
        return res;
    }
	
	public static void main(String args[]){
		System.out.println(reverseWords("hello world!"));
	}

}
