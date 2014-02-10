/*Unique Binary Search Trees Total Accepted: 7239 Total Submissions: 20386 My Submissions 





Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
 Given n = 3, there are a total of 5 unique BST's. 
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        if(n == 0){
            return result[n];
        }
        result[1] = 1;
        if(n == 1){
            return result[n];
        }
        result[2] = 2;
        if(n == 2){
            return result[n];
        }
        if(n > 2){
        for(int i=3;i<=n;i++){
            int t=0;
            for(int k=0;k<i;k++){
                t+=result[k]*result[i-1-k];
            }
            result[i] = t;
            
        }
        }
        return result[n];
    }
	
	public static void main(String args[]){
		System.out.println(numTrees(3));
	}
	

}
