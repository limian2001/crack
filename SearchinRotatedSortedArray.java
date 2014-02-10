/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

//�������ȻAC�ˣ������ҵ�����������
//��ʵ���õݹ�Ҳ���������ظ����������࣬��ʵӦ�������ж�һ��A0,A[mid]�Ĵ�С��ϵ�����A[mid]>A[0]����ô����ǰ������ϸ�����ģ�������Ǻ����ϸ�����
//Ȼ��target�ǲ��������ϸ�����Ķ������ǣ�ֻҪ����ν���BST��������ǣ��Ͷ�����һ��BST�����һ��ǰ�������ķ�ʽѭ�����Ƚ���λ���м�λ��

public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
        int len = A.length;
        if(len == 0)
            return -1;
        if(len == 1){
            if(A[0] == target)
                return 0;
            else
                return -1;
        }
        if(len == 2){
            if(A[0] == target)
                return 0;
            else if(A[1] == target)
                return 1;
            else
                return -1;
        }
            
        return bst(A,0,len-1,target);
       
        
        }
        
    public int bst(int[] A,int start,int end,int target){
        int a=-10,b=-10;
        if(end - start < 2){
            if(A[start] == target)
                return start;
            else if(A[end] == target)
                return end;
            else
                return -1;
        }
            
    
        int mid = (start+end)/2;
        if(A[mid] == target)
            return mid;
        else{
            a = bst(A,start,mid-1,target);
            b = bst(A,mid+1,end,target);
        }
        
        if(a == -1 && b == -1) 
            return -1;
        if(a == -1)
            return b;
        else
            return a;
    
    }
	

}
//�����Ǳ��˵Ĵ���

/*int rotated_binary_search(int A[], int N, int key) {
int L = 0;
int R = N - 1;

while (L <= R) {
  // Avoid overflow, same as M=(L+R)/2
  int M = L + ((R - L) / 2);
  if (A[M] == key) return M;

  // the bottom half is sorted
  if (A[L] <= A[M]) {
    if (A[L] <= key && key < A[M])
      R = M - 1;
    else
      L = M + 1;
  }
  // the upper half is sorted
  else {
    if (A[M] < key && key <= A[R])
      L = M + 1;
    else 
      R = M - 1;
  }
}
return -1;
}
*/
