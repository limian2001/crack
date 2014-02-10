/*4Sum Total Accepted: 4286 Total Submissions: 19680 My Submissions 





Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

•Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
•The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

*/
public class FourSum {
	 public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        Arrays.sort(num);
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	       // ArrayList<Integer> tmp = new ArrayList<Integer>();
	        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
	        for(int i=0;i<num.length-3;i++)
	            for(int j=i+1;j<num.length-2;j++){
	                int res = target - num[i] - num[j];
	                int head = j+1;
	                int end = num.length-1;
	                while(head < end){
	                    if(num[head] + num[end] == res){
	                        ArrayList<Integer> tmp = new ArrayList<Integer>();
	                        tmp.add(num[i]);
	                        tmp.add(num[j]);
	                        tmp.add(num[head]);
	                        tmp.add(num[end]);
	                        set.add(tmp);
	                        head++;
	                        end--;
	                    }
	                    else if(num[head] + num[end] < res)
	                        head++;
	                    else
	                        end--;
	                }
	            }
	            
	        for(ArrayList<Integer> a:set)
	            result.add(a);
	        
	        return result;
	    }

}
