/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 

click to show follow up.

Follow up: 
Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution? 
*/

public class SetMatrixZeroesInPlace {
	public void setZeroes(int[][] matrix) {
        HashSet<String> set = new HashSet<String>();
        
        
        for(int i=0;i<matrix.length;i++)
             for(int j=0;j<matrix[0].length;j++){
                
                    if(matrix[i][j] == 0)
                        set.add(i+";"+j);
             }
        
            
             for(String t : set){
                 String[] s = t.split(";");
                 int i = Integer.parseInt(s[0]); 
                 int j = Integer.parseInt(s[1]);
                 for(int k=0;k<matrix[i].length;k++)
                    matrix[i][k] = 0;
                 for(int k=0;k<matrix.length;k++)
                    matrix[k][j] = 0;
                        
                            
             }
   
}

}
