/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:


•Integers in each row are sorted from left to right.
•The first integer of each row is greater than the last integer of the previous row.


For example,

Consider the following matrix: 
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]


Given target = 3, return true.
*/
public class Searcha2DMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
	        int i = 0;
	        int j = matrix.length-1;
	        if(j == -1)
	            return false;
	            
	        //only one row case
	        if(j == 0)
	            return bst(matrix,0,target);
	            
	        //out of range
	        if(target < matrix[0][0] || target > matrix[j][matrix[0].length-1])
	            return false;
	            
	        //i=0,j>=1,bst
	        while(i != j){
	            int mid = (i+j)/2;
	            if(matrix[mid][0] == target)
	                return true;
	            else if(target < matrix[mid][0])
	                j = mid - 1;
	            else if(target < matrix[mid+1][0])
	                return bst(matrix,mid,target);
	            else
	                i = mid + 1;
	            
	        }
	        return bst(matrix,i,target);
	        
	        
	    }
	    
	    public boolean bst(int[][] a,int row,int target){
	        int i = 0;
	        int j = a[0].length-1;
	        //only one element case
	        if(j == 0){
	            if(a[row][0] == target)
	                return true;
	            else
	                return false;
	        }
	        int mid = 0;
	        //bst 
	        while(i < j){
	            mid = (i+j)/2;
	            if(a[row][mid] == target)
	                return true;
	            else{
	                if(target < a[row][mid])
	                    j = mid - 1;
	                else
	                    i = mid + 1;
	            }
	            
	        }
	        if(a[row][i] == target)
	            return true;
	        else
	            return false;
	        
	    }

}
