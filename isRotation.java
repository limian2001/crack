
public class isRotation {
	/*contat S1 and S1, judge S2 is subString of S1+S1. String.Contains is also ok */
	public static boolean isRotation(String s1,String s2){
		return(s1.length()==s2.length()&&(s1+s1).indexOf(s2)!=-1);
	}
	//concat 
	public static void main(String args[]){
		String a="abcdefg";
		String b="cdefgab";
		System.out.println(isRotation(a,b));
	}
}
