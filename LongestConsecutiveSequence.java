/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence. 

For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4. 

Your algorithm should run in O(n) complexity. 
*/
import java.util.*;
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        int count = 1;
        int max = 0;
        
        for(int i : num)
            set.add(i);
            
        for(int i : num){
            int k = i;
            count = 1;
            while(set.contains(k+1)){
                count++;
                set.remove(k+1);
                k++;
            }
            k = i;
            while(set.contains(k-1)){
                count++;
                set.remove(k-1);
                k--;
            }
            max = Math.max(max,count);
        }
        return max;
    }

}
