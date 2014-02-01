/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0 
*/
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        if(A.length == 0)
            return 0;
        if(A.length == 1 && A[0] < target)
            return 1;
        else if(A.length == 1 && A[0] >= target)
            return 0;
        if(A[0] > target)
			return 0;
		if(A[A.length-1] < target)
		    return A.length;
		return findNei(target,A,0,A.length-1);
    }
    
    public static int findNei(int target,int arr[],int str,int end){
		int mid=(end+str)/2;
		if(end-str == 1 && arr[str] < target && arr[end] >= target)
			return end;
	    if(end-str == 1 && arr[str] == target)
			return str;
		if(arr[mid] < target && target <= arr[mid+1])
			return mid+1;
		else if(arr[mid] == target)
		    return mid;
		else if(target < arr[mid])
			return findNei(target,arr,str,mid);
		else
		    return findNei(target,arr,mid+1,end);
		
	}

}
