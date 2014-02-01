/*Remove Duplicates from Sorted Array Total Accepted: 7728 Total Submissions: 23637 My Submissions 





Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory. 

For example,
 Given input array A = [1,1,2], 

Your function should return length = 2, and A is now [1,2]. 
*/
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
        int j=0;
        for(int i=1;i<A.length-j;i++){
            if(A[i] == A[i-1]){
                int k=i;
                for(;k<A.length-j-1;k++)
                    A[k]=A[k+1];
                j++;
                i--;
            }
                
        }
        return A.length-j;
    }
	

}
