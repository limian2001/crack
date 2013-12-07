import java.util.HashMap;

public class RometoInt {
	
	public static int romanToInt(String s) {
        HashMap map = new HashMap();
        char rome[] = {'I','V','X','L','C','D','M'};
        int romeValue[] = {1,5,10,50,100,500,1000};
        for(int i=0;i<7;i++)
        	map.put(rome[i], romeValue[i]);
        int number = 0;

        /*to find IXO as left minus number*/     
        for(int i=0;i<s.length()-1;i++){
        	if(s.charAt(i) == 'I' && s.charAt(i+1) != 'I'){
        		number = number-1;
        	    s = s.substring(0, i) + s.substring(i+1); }
        	else if(s.charAt(i) == 'X' && ((Integer)map.get(s.charAt(i+1))).intValue() > 10){
        		number = number-10;
        	    s = s.substring(0, i) + s.substring(i+1);                   }
        	else if(s.charAt(i) == 'C' && ((Integer)map.get(s.charAt(i+1))).intValue() > 100){
        		number = number-100;
        	    s = s.substring(0, i) + s.substring(i+1);                    }
        }
        System.out.println(s);
        /*add up all other non-left minus numbers*/
        for(int i=0;i<s.length();i++)
        	number = number + (int)map.get(s.charAt(i));
        return number;
    }
	public static void main(String args[]) 
	{
		String t = "DXLVII";
		System.out.println(romanToInt(t));
	}

}
