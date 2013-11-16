/* Cracking 1.5 
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2b1c5a3. If the "compressed" string would not become smaller than the 
 * original string, your method should return the original string. */
public class compress1_5Str {

	public static void main(String[] args)
	{
		String a="aaabc";
		System.out.println(compress(a));
	}
/* write a method to produce compressed string */
	public static String compress(String s)
	{
		/* if the input is null, return -1*/
		if(s.length()==0)
			return "-1";
		String mystr="";
		char last=s.charAt(0);
		int count=1;
		/*    */
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==last)
			{	count++;  }
			else{
				mystr+=last+""+count;
				last=s.charAt(i);
				count=1;
			}
		}
			String compString=mystr+last+count;
			if(compString.length()>s.length())
				return s;
			else
				return compString;

}
}