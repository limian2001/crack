/*3Sum Total Accepted: 6304 Total Submissions: 37396 My Submissions 





Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

•Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
•The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

*/

import java.util.*;

public class ThreeSum {
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
        if(num.length<3)
            return new ArrayList<ArrayList<Integer>>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); 
        Arrays.sort(num);
      
        for(int j=0;j<num.length-2;j++){
           if(num[j]<=0){
            int rest = 0 - num[j];
            int head = j + 1;
            int end = num.length-1;
            while(head < end){
                if(rest == num[head] + num[end]){
                    set.add(new ArrayList<Integer>(Arrays.asList(num[j],num[head],num[end])));
                    head++;
                    end--;
                }
                else if(rest < num[head] + num[end])
                    end--;
                else
                    head++;
                
                    
            }
        }
        }
           
 
        return new ArrayList<ArrayList<Integer>>(set);           
    }
	    
	   
public static void main(String args[]){
	int[] a={1,2,3,-3,5,6};
	System.out.println(threeSum(a));
}

}
