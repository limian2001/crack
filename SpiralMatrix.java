import java.util.*;

public class SpiralMatrix {
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        int m=matrix.length;
        if(m == 0)
            return res;
        
        
        int n=matrix[0].length;
        int total = m*n;
        
        if(total == 1){
            res.add(matrix[0][0]);
            return res;
        }
            
        
        int start = 0;
        
        while(res.size() < total){
        
        
        for(int i=start;i<=n-start-1;i++)
            res.add(matrix[start][i]);
            
        if(res.size() == total)
            return res;
            
        for(int i=start+1;i<=m-start-1;i++)
            res.add(matrix[i][n-start-1]);
            
        if(res.size() == total)
            return res;
            
        for(int i=n-start-2;i>=start;i--)
            res.add(matrix[m-start-1][i]);
            
        if(res.size() == total)
            return res;
            
        for(int i=m-start-2;i>=start+1;i--)
            res.add(matrix[i][start]);
            
        if(res.size() == total)
            return res;
        
        start++;
        
        }
        
        return res;
        
    }
	public static void main(String args[]){
		int[][] matrix = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		
		System.out.println(spiralOrder(matrix));
	}

}
