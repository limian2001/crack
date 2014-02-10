/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4]. 
*/

public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        int r = -2;
        
        r = bst(A,0,A.length-1,target);
        
        //�����Ǹ��ݷ��صĵ㣬����ǰ���ǲ��ǻ����ظ���
        if(r == -1)
            return res;
        int tmp = r;
        while(tmp >= 0 && A[tmp] == target){
            tmp--;
        }
        
        res[0] = tmp + 1;
        
        tmp = r;
        while(tmp < A.length && A[tmp] == target){
            tmp++;
        }
        
        res[1] = tmp -1;
        
        return res;
        
        }
        //����������Ƕ���������
        public int bst(int[] A,int start,int end,int target){
        
        while(start <= end){
            int mid = (start+end)/2;
            if(A[mid] == target)
                return mid;
            else if(target < A[mid])
                end = mid - 1;
            else
                start = mid + 1;
            
        }
        return -1;
        }
	

}
