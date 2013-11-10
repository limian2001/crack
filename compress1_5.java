
public class compress1_5 {
	public static void main(String[] args)
	{
		String a="sssssjjjj";
		System.out.println(compress(a));
	}
	public static String compress(String s)
	{
		char[] a=s.toCharArray();
		char[] b=new char[50];
		int count;
		for(int i=1,j=0;i<a.length;i++){
			count=1;
			while(a[i]==a[i-1]){
			   i++;
		       count++;}
			b[j]=a[i-1];
			b[j+1]=(char)count;
			j+=2;
		}
		if(b.length>a.length)
			return s;
		else
		    return b.toString();
		
	}
	
	
	
}
