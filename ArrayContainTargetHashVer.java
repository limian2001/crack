/*Given an array of integers, find two numbers such that they add up to a specific target number.
 * For example, {1,3,5,7} and target=10, It should return "True" because 3+7=10
	*/
import java.util.HashMap;

public class ArrayContainTargetHashVer {
/*put all array into hashmap*/
		public static void main(String args[]){
			int target=74;
			int array[]={448,74,41,680,719,173,774,492,636,199,362,792,74,647,587,678,261,874,467,462,735,582,999,479,34,294,702,834,239,853,349,142,690,81,324,188,813,931,502,707,967,895,445,878,426,430,93,255,304,928,960,192,452,211,495,787,328,568,313,194,608,990,944,256,204,616,44,991,461,59,854,348,611,535,459,724,213,683,777,885,460,751,450,918,806,395,454,603,57,655,110,542,24,82,777,395,877,229,550,685,142,845,139,804,353,111,599,114,679,728,82,137,274,490,340,244,880,982,281,852,568,428,474,348,487,432,749,586,983,402,386,210,300,864,29,980,715,911,738,375,688,515,374,945,513,392,999,214,658,920,695,391,880,600,916,235,384,763,943,399,958,826,663,844,733,461,226,616,536,246,155,83,732,940,392,176,806,925,377,824,465,175,342,291,113,186,410,490,170,32,701,162,471,742,297,791,541,243,885,603,292,933,948,326,894,686,316,341,119,610,276,463,883,849,854,682,304,737,99,760,411,426,445,682,794,541,147,520,576,644,727,499,369,222,226,836,354,53,996,868,37,42,293,271,452,181,219,125,943,149,591,599,972,961,351,545,928,922,376,917,621,777,844,655,151,881,125,877,258,291,566,76,58,18,692,815,448,224,286,191,110,655};
			System.out.println(isContainsTarget(target,array));  
		}
		
		/*Target-every element in array, check the key in hashmap or not and return */
		public static boolean isContainsTarget(int target,int array[]){
			
			HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
			
			/*Build hashmap*/
			for(int i=0;i<array.length;i++)
				map.put(array[i], i);
			
			/*print hashmap*/
			for(int i:map.keySet())
				System.out.print(i+" "+map.get(i)+"\n");
			
			/*Decide the target is included by two elements in array  */
			for(int i=0;i<array.length;i++){
				if(map.containsKey(target-array[i]) && map.get(target-array[i]) != i){
					System.out.println("Yes, the indexs are "+i+" "+map.get(target-array[i]));
					return true;}
			}
				return false;
					
		}
}
