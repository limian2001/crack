/*Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,


There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]


The total number of unique paths is 2.

Note: m and n will be at most 100.
*/
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //nump is used for record how many paths from 0,0 to here
        int[][] nump = new int[m][n];
        //if the start point or end point has obstacle, return 0
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        nump[0][0] = 1;
        //fill up the boundary value, if there is obstacle, skip (nump=0) it, then following should be all 0
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0] == 0)
                nump[i][0] = nump[i-1][0];
        }
        for(int j=1;j<n;j++){
            if(obstacleGrid[0][j] == 0)
                nump[0][j] = nump[0][j-1];
        }
        
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                    //if there is obstacle, skip it,the default nump is 0.
                    if(obstacleGrid[i][j] == 0){
                        nump[i][j] = nump[i-1][j] + nump[i][j-1];
                    }
                
            }
        return nump[m-1][n-1];
    }

}
