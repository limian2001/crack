/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?




Above is a 3 x 7 grid. How many possible unique paths are there? 

Note: m and n will be at most 100.
*/
public class UniquePaths {
	public int uniquePaths(int m, int n) {
        int[][] a=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
            a[i][1]=1;
        for(int j=1;j<=n;j++)
            a[1][j]=1;
        for(int i=2;i<=m;i++)
            for(int j=2;j<=n;j++)
                a[i][j]=a[i-1][j]+a[i][j-1];
            
        return a[m][n];
        
        
        }

}
