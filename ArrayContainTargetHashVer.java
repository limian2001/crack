/*Given an array of integers, find two numbers such that they add up to a specific target number.
 * For example, {1,3,5,7} and target=10, It should return "True" because 3+7=10
	*/
import java.util.HashMap;

public class ArrayContainTargetHashVer {
/*put all array into hashmap*/
		public static void main(String args[]){
			int target=10;
			int array[]={1,3,4,5,5,10,13};
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
