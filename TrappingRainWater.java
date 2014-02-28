/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 

For example, 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 




The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/
public class TrappingRainWater {
	public int trap(int[] A) {
        if(A.length == 0)
            return 0;
        
        int[] leftmax = new int[A.length];
        int[] rightmax = new int[A.length];
        leftmax[0] = A[0];
        rightmax[A.length-1] = A[A.length-1];
        
        for(int i=1;i<A.length;i++)
            leftmax[i] = Math.max(leftmax[i-1],A[i-1]);
        for(int i=A.length-2;i>=0;i--)
            rightmax[i] = Math.max(rightmax[i+1],A[i+1]);
        
        int res = 0;
        for(int i=1;i<=A.length-2;i++){
            if(Math.min(leftmax[i],rightmax[i]) > A[i])
                res += Math.min(leftmax[i],rightmax[i]) - A[i];
        }
        return res;
        
    }

}
