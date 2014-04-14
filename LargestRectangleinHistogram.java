/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 




Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].





The largest rectangle is shown in the shaded area, which has area = 10 unit.


For example,
 Given height = [2,1,5,6,2,3],
 return 10. 
*/

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
        int max = 0;
        
        Stack<Integer> s = new Stack<Integer>();
        //maintain a stack, which includes an ascending(value) order index. 
        //When next value is larger than the stack's peek value, push it into stack
        //when next value is equal or smaller than peek value, pop stack and calculate area until the current value
        //is larger than peek value
        for(int i=0;i<height.length;i++){
            if(s.empty() || height[s.peek()] <  height[i]){
                s.push(i);
            }
            else{
                int k = s.pop();
                int high = height[k];
                int width = 0;
                if(!s.empty())
                    width = i - s.peek() - 1;
                else
                    width = i;
                max = Math.max(max,high * width);
                i--;
            }
        }
        //arrive at i=length, pop stack and calculate area until stack is empty 
        while(!s.empty()){
            int k = s.pop();
            int high = height[k];
            int width = 0;
            if(!s.empty())
                width = height.length - s.peek() - 1;
            else
                width = height.length;
                max = Math.max(max,high * width);
        }
 
        return max;
        
    }

}
