/*Given an array of integers, find two numbers such that they add up to a specific target number.
*/

public class ArrayContainsTarget {
	public static void main(String args[]){
		int target=74;
		int array[]={448,74,41,680,719,173,774,492,636,199,362,792,74,647,587,678,261,874,467,462,735,582,999,479,34,294,702,834,239,853,349,142,690,81,324,188,813,931,502,707,967,895,445,878,426,430,93,255,304,928,960,192,452,211,495,787,328,568,313,194,608,990,944,256,204,616,44,991,461,59,854,348,611,535,459,724,213,683,777,885,460,751,450,918,806,395,454,603,57,655,110,542,24,82,777,395,877,229,550,685,142,845,139,804,353,111,599,114,679,728,82,137,274,490,340,244,880,982,281,852,568,428,474,348,487,432,749,586,983,402,386,210,300,864,29,980,715,911,738,375,688,515,374,945,513,392,999,214,658,920,695,391,880,600,916,235,384,763,943,399,958,826,663,844,733,461,226,616,536,246,155,83,732,940,392,176,806,925,377,824,465,175,342,291,113,186,410,490,170,32,701,162,471,742,297,791,541,243,885,603,292,933,948,326,894,686,316,341,119,610,276,463,883,849,854,682,304,737,99,760,411,426,445,682,794,541,147,520,576,644,727,499,369,222,226,836,354,53,996,868,37,42,293,271,452,181,219,125,943,149,591,599,972,961,351,545,928,922,376,917,621,777,844,655,151,881,125,877,258,291,566,76,58,18,692,815,448,224,286,191,110,655};
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
