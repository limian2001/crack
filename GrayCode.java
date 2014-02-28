/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
00 - 0
01 - 1
11 - 3
10 - 2


Note:
 For a given n, a gray code sequence is not uniquely defined. 

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

import java.util.*;

public class GrayCode {
	public static ArrayList<Integer> grayCode(int n) {
        ArrayList<ArrayList<Integer>> allres = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
      
        
        result.add(0);
        if(n == 0)
            return result;
            
        allres.add(new ArrayList<Integer>(result));
        result.add(1);
        if(n == 1)
            return result;
            
        allres.add(new ArrayList<Integer>(result));
        
        for(int i=2;i<=n;i++){
        	 ArrayList<Integer> res = new ArrayList<Integer>();
             ArrayList<Integer> tmp = new ArrayList<Integer>();
             //这个策略就是把上一个n-1的结果拿出来，前面加0，然后把n-1的结果倒过来并每一个最前面加上1（即加上2的n-1次方），这样前后就连接起来了，保证从0开始
             //并且中间衔接的时候只差最高位从0到1.
             //例如n=1是 [0, 1], n=2就是[0+0, 0+1, 2+1, 2+0] = [0, 1, 3, 2]， n=3就是[0+0, 0+1, 0+3, 0+2, 4+2, 4+3, 4+1, 4+0]
             res = allres.get(i-1);
             for(int k : res){
                 tmp.add(k);
             }
             for(int j=res.size()-1;j>=0;j--){
                 tmp.add((int)Math.pow(2,i-1) + res.get(j));
             }
             
             allres.add(new ArrayList<Integer>(tmp));
            
            
        }
        System.out.println(allres);
        return allres.get(n);
        
        
        
    }
	
	public static void main(String args[]){
		System.out.println(grayCode(10));
		
	}


}
