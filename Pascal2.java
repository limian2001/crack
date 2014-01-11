/*Pascal's Triangle II Total Accepted: 3999 Total Submissions: 13650 My Submissions 





Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
 Return [1,3,3,1]. 

Note:
 Could you optimize your algorithm to use only O(k) extra space? 

 * */
import java.util.*;

public class Pascal2 {
	public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(rowIndex == 0){
        	result.add(1);
            return result;
        }
        if(rowIndex == 1){
        //    result.clear();
            result.add(1);
            result.add(1);
            return result;
        }
        if(rowIndex > 1){
        //    result.clear();
            result.add(1);
            ArrayList<Integer> tmp=getRow(rowIndex-1);
            for(int i=1;i<rowIndex;i++)
                result.add(tmp.get(i-1)+tmp.get(i));
            result.add(1);
            
        }
            return result;
        }
	public static void main(String args[]) 
	{
		
		 System.out.println(getRow(0));
}

}
