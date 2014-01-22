/*Single Number II Total Accepted: 6761 Total Submissions: 21620 My Submissions 





Given an array of integers, every element appears three times except for one. Find that single one. 

Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

*
*/
public class SingleNum2 {
	
	    public int singleNumber(int[] A) {
	    	//����һ��32λ�����飬a[i]��ʾ����������iλ���ֵĴ�����
	    	 
	    	int[] arr=new int[32];
	        int result=0;
	        for(int i=0;i<32;i++){
	            arr[i]=0;
	            for(int j=0;j<A.length;j++){
	            	//ȡ��A��ÿһ�����ֵĵ�iλ
	                if(((A[j]>>i) & 1) == 1)
	                	// ����a[i]��3��������������ԣ�����ͰѸ�λȡ������ɴ𰸡�
	                    arr[i]=(arr[i]+1)%3;
	            }
	            result|=arr[i]<<i;
	        }
	        return result;
	    }
	}


