/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 

For example,
 If n = 4 and k = 2, a solution is: 
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


 * */

import java.util.ArrayList;


public class Combinations {
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp_array=new ArrayList<Integer>();
        
        dfs(k,n,tmp_array,result,0);
        return result;
        
    }
    
    public static void dfs(int k,int n,ArrayList<Integer> tmp,ArrayList<ArrayList<Integer>> result,int start){
        
    	
    	if(start == k)
            return;
    	//循环从第一个数字开始，到n。如果是首个数字，不判断大小，直接遍历从0到n。如果不是
    	//首个，保证后面加上去的数字比前面的大。这样既避免了重复数字，又节省大量无用的组合
    	//递归的设计思路是根据start位，也就是0-k。递归到k之后逐个删除tmp末尾的数字，直到退回到开头。
        for(int i=0;i<n;i++){
        	if(start == 0){
        		 tmp.add(i+1);
                 dfs(k,n,tmp,result,start+1);
                 if(tmp.size() == k)
                     result.add(new ArrayList<Integer>(tmp));
                 tmp.remove(tmp.size()-1);
        	}
        	
        	else{
        	if(i+1 > tmp.get(tmp.size()-1)){
            tmp.add(i+1);
            dfs(k,n,tmp,result,start+1);
            if(tmp.size() == k)
                result.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size()-1);
        	}
        	}
        }
    }
    

	public static void main(String args[]) 
	{
		
		 System.out.println(combine(5,4));
}

}
