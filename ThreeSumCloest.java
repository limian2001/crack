import java.util.*;
public class ThreeSumCloest {
	
	    public static int threeSumClosest(int[] num, int target) {
	        Arrays.sort(num);
	        
	      //  if(num[0] <= target){
	            int diff = num[0]+num[1]+num[2] - target;
	            for(int i=0;i<num.length-2;i++){
	                int res = target - num[i];
	                int head = i+1;
	                int end = num.length-1;
	                
	                while(head < end){
	                    if(num[head] + num[end] == res)
	                        return target;
	                    else if(num[head] + num[end] > res){
	                        if(num[head] + num[end] - res < Math.abs(diff)){
	                            diff = num[head] + num[end] - res;
	                            end--;
	                        }
	                        else
	                            end--;
	                    }
	                    else{
	                        if(res - (num[head] + num[end]) < Math.abs(diff)){
	                            diff = num[head] + num[end] -res;
	                            head++;
	                        }
	                        else
	                            head++;
	                    }
	                }
	                
	                
	            }
	            return diff + target;
	            
	        }
	   //     else 
	     //       return num[0]+num[1]+num[2];
	//    }
	    public static void main(String args[]){
	    	int[] a={6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10}; 
            

	    	int t=-52; 
	    	System.out.println(threeSumClosest(a,t));
	    }
	

}
