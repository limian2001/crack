/*Given a set of distinct integers, S, return all possible subsets. 

Note:

•Elements in a subset must be in non-descending order.
•The solution set must not contain duplicate subsets.


For example,
 If S = [1,2,3], a solution is: 
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


 * */

import java.util.*;

public class subsets {
	
    public static ArrayList<ArrayList<Integer>> subsets1(int[] S) {
    	ArrayList<Integer> tmp= new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        result.add(tmp);
        
        dfs(S,result,tmp,0);
        return result;
    }
    
    public static void dfs(int[] S,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> tmp,int po){
        for(int i=po;i<S.length;i++){
            tmp.add(S[i]);
            result.add(new ArrayList<Integer>(tmp));
            dfs(S,result,tmp,i+1);
            tmp.remove(tmp.size()-1);
            
        }
        
        
    }
		    public static void main(String args[]){
		    	int[] s={1,2};
		    	System.out.println(subsets1(s));
		    }


}
