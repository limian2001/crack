import java.util.HashMap;
import java.util.HashMap;

public class test {
	

	public static void main(String args[]) 
	{
		    String s="IVXALCDM";
	        HashMap map = new HashMap();
	        char rome[] = {'I','V','X','L','C','D','M'};
	        int romeValue[] = {1,5,10,50,100,500,1000};
	        for(int i=0;i<7;i++)
	        	map.put(rome[i], romeValue[i]);
	        int number = 0;
	        System.out.print((int)map.get(s.charAt(5)) > 50);
	        s = s.substring(0, 4) + s.substring(5);
	        System.out.print(s);
	        
}
}
