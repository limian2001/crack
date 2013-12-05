import java.util.HashMap;
/*find a max length substring without repeat char in a string*/
public class findMaxlenString {
	
	public static String getMaxString(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
		String maxstr = "";
		map.put(s.charAt(0), 0);
		int i=0,j=1;
		while(i<s.length() && j<s.length()){
			while(true){
				/*if find duplicate char, record the substring from i--j-1*/
				if(map.containsKey(s.charAt(j)))
				{   /*confirm the substring is longest, if not, discard*/
					
					if (j-i > maxstr.length())
					{
						maxstr = s.substring(i, j);
						int k=i;
						i = map.get(s.charAt(j))+1;
						/*delete all chars in hashmap before i */
						int l = map.get(s.charAt(j));
						for(; k <= l; k++)
							map.remove(s.charAt(k));
						
						/*put the j char into hashmap*/
						map.put(s.charAt(j), j);
						j++;
						break;
					}
					else
					{
						int k=i;
						i = map.get(s.charAt(j))+1;
						/*delete all chars in hashmap before i */
						int l = map.get(s.charAt(j));
						for(; k <= l; k++)
	 					    map.remove(s.charAt(k));
						
						/*put the j char into hashmap*/
						map.put(s.charAt(j), j);
						j++;
			            break;
					}
					}
				else
				{	/*put each char in j into hashmap until find duplicate char*/
					map.put(s.charAt(j), j);
				    j++;
				    break;
		        }
				
			}
		}
		if (j-i > maxstr.length())
			return s.substring(i, j);
		else
		    return maxstr;
	}
	
	public static void main(String args[]){
		String t = "abcdefgbhijk";
	    System.out.println(getMaxString(t));
	}

}
