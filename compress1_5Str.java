
public class compress1_5Str {

	public static void main(String[] args)
	{
		String a="sssssjjjja";
		System.out.println(compress(a));
	}
	public static String compress(String s)
	{
		String mystr="";
		char last=s.charAt(0);
		int count=1;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==last)
			{	count++;  }
			else{
				mystr+=last+""+count;
				last=s.charAt(i);
				count=1;
			}
		}
			return mystr+last+count;

}
}