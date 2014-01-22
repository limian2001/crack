/*Single Number II Total Accepted: 6761 Total Submissions: 21620 My Submissions 





Given an array of integers, every element appears three times except for one. Find that single one. 

Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

*
*/
public class SingleNum2 {
	
	    public int singleNumber(int[] A) {
	    	//创建一个32位的数组，a[i]表示所有数字在i位出现的次数。
	    	 
	    	int[] arr=new int[32];
	        int result=0;
	        for(int i=0;i<32;i++){
	            arr[i]=0;
	            for(int j=0;j<A.length;j++){
	            	//取出A中每一个数字的第i位
	                if(((A[j]>>i) & 1) == 1)
	                	// 假如a[i]是3的整数倍，则忽略；否则就把该位取出来组成答案。
	                    arr[i]=(arr[i]+1)%3;
	            }
	            result|=arr[i]<<i;
	        }
	        return result;
	    }
	}


