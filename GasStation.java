/*There are N gas stations along a circular route, where the amount of gas at station i is gas[i]. 

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations. 

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1. 

Note:
 The solution is guaranteed to be unique. 
*/

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int[] diff = new int[gas.length];
        
        for(int i=0;i<gas.length;i++)
            diff[i] = gas[i] - cost[i];
        
        int point = 0;
        
        //find a [i,n] sequence, each sum of diff is not smaller than 0 (diff[i]>=0, diff[i]+[i+1]>=0....etc)
        //if sum [i,j] sequence <0, impossible to find a start point between [i,j], so discard [i,j], sum = 0, go to next
        for(int i=0;i<gas.length;i++){
            
            total += diff[i];
            sum += diff[i];
            
            if(sum < 0){
                sum = 0;
                point = i + 1;
            }
        }
        //if total sum of diff[] is smaller than 0, impossible to find a point can circle
        if(total < 0)
            return -1;
        //if total sum >0, there should be one point to start can circle
        else
            return point;
    }
}
