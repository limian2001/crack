
public class permutation {
	public static void main(String[] args)
	{
		String a="sjifurb";
		String b="jiurbf1";
		System.out.println(permutation(a,b));
	}
    
	public static boolean permutation(String a,String b)
	{
		if(a.length()!=b.length())
			return false;
		return(sort(a).equals(sort(b)));
		
	}
	public static String sort(String s)
	{
		char[] a=s.toCharArray();
		java.util.Arrays.sort(a);
		return new String(a);
	}
	
}
