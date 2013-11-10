
public class isUniqueChar{
	
	public static void main(String[] args)
	{
		String a="sjifurboldkacpzy";
		System.out.println(isUniqueChar(a));
	}

	public static boolean isUniqueChar(String str)
	{
		if(str.length()>256)
			return false;
		boolean[] char_set=new boolean[256];
		for(int i=0;i<str.length();i++)
		{ int var=str.charAt(i);
		  if(char_set[var])
			  return false;  
		char_set[var]=true;
	     }
		return true;
	}
	
}
