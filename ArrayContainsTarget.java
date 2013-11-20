/*Given an array of integers, find two numbers such that they add up to a specific target number.
*/

public class ArrayContainsTarget {
	public static void main(String args[]){
		int target=10;
		int array[]={1,3,4,5,8,10,13};
		System.out.println(findNei(target,array,0,array.length-1));
		System.out.println(isContainsTarget(target,array));  
	}
	/*The algorithm is find a index in array which is just smaller than target/2,
	 * then set two pointers that one is the index and another is next index, named
	 * low and high, compare the low+high to target, if target is smaller, move low
	 * to left. If target is bigger, move high to right, until one pointer arrive at
	 * end  */
	public static boolean isContainsTarget(int target,int array[]){
		if (array.length <= 1)
			return false;
		int i=findNei(target,array,0,array.length-1);
		int lowp=i,highp=i+1;
		while(lowp >= 0 && highp <= array.length-1){
			if(array[lowp]+array[highp] == target)
				return true;
			else if(array[lowp]+array[highp] < target)
				highp++;
			else
				lowp--;
		}
		return false;
			
	}
	/*Write a method to find a array index, which is just smaller than target/2
	 * for example, array is {2,4,6,7,8,12,14}, target=10, then we will find "4"
	 *  is just smaller than target/2=5.(6 is just larger than 5), so return the
	 *  index of element "4": 1 
	 *  This search adopts Binary search algorithm*/
	public static int findNei(int target,int arr[],int str,int end){
		int mid=(end+str)/2;
		if(end-str == 1 && arr[str] <= target/2 && arr[end] >= target/2)
			return str;
		if(arr[mid] <= target/2 && target/2 <= arr[mid+1])
			return mid;
		else if(target/2 < arr[mid])
			return findNei(target,arr,str,mid);
		else if(target/2 > arr[mid])
		    return findNei(target,arr,mid+1,end);
		else
			return -1;
	}

}
