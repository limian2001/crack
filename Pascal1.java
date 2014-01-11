/*Pascal's Triangle Total Accepted: 4691 Total Submissions: 14833 My Submissions 





Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
 Return 
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


 * */

import java.util.*;

public class Pascal1 {
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> current=new ArrayList<Integer>();
        
        if(numRows == 0)
            return result;
            
        current.add(1);
            result.add(new ArrayList<Integer>(current));
            
        if(numRows == 1)
            return result;
        
        current.add(1);
            result.add(new ArrayList<Integer>(current));
       

        if(numRows == 2)
            return result;
        
        
        
        if(numRows > 2){
            for(int i=3;i<=numRows;i++){
                current.clear();
                current.add(1);
                for(int j=1;j<i-1;j++)
                    current.add((result.get(i-2)).get(j-1)+(result.get(i-2)).get(j));
                current.add(1);
                result.add(new ArrayList<Integer>(current));
            }
        }
        return result;
        
    
    }
    
    public static void main(String args[]) 
	{
		
		 System.out.println(generate(50));
}

}
