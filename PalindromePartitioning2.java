/*Given a string s, partition s such that every substring of the partition is a palindrome. 

Return the minimum cuts needed for a palindrome partitioning of s. 

For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
*/
import java.util.*;

public class PalindromePartitioning2 {
public static int minCut(String s) {

        
	 int n = s.length();
     if(n <= 1 || isPal(s))
         return 0;
     
   //建立一个二维数组，把从i到j的这一段substring是不是回文写进去，这样后面查询的时候，直接调用数组即可，避免了一些反复查询。
    //但是这个方法对递归方法有一些作用，迭代方法本身没有重复查询，所以最后解法里面没有包括这部分
     
// boolean[][] dp = new boolean[n+1][n+1];
   /*  for(int i=0;i<=n-1;i++)
         for(int j=i+1;j<=n;j++){
             if(isPal(s.substring(i,j)))
                 dp[i][j] = true;
     }
     
   */
   
   //为了通过那个1462长度的几乎全a的case，一开始查一下是不是1 cut就能搞定
   for(int k=1;k<n-1;k++){
       if(isPal(s.substring(0,k)) && isPal(s.substring(k)))
         return 1;
   }
    //这个二维数组用来记录从i到j的最小cut数，其实这里只用到了从0到j，所以其实一维数组就够了
     int[][] min = new int[n+1][n+1];
     
     
     //DP, 递推公式是：0,j的最小cut数，等于：假设有k使得k,j为回文，则0,j的最小cut数等于 ---- Min((0,k的最小cut数)+1) 其中k为所有使得k,j为回文的数(i<k<j)
     int i=0;
         for(int j=i+1;j<=n;j++){
             if(isPal(s.substring(i,j))){
                 min[i][j] = 0;
             }
             else{
                 min[i][j] = j-i-1;
                 for(int k=j-1;k>i;k--){
                     if(isPal(s.substring(k,j))){
                             if(min[i][j] > min[i][k] + 1)
                                 min[i][j] = min[i][k] + 1;
                      
                     }
                 }
             }
             
         }
         


     return min[0][n];
   
  // return minDp(s);  递归做法的返回

 }
  //这是递归做法，结果正确，但是会超时，思想和上面一样  
/*  public int minDp(String s){
int n = s.length();
if(isPal(s))
    return 0;
int min = s.length()-1;
for(int k=s.length()-1;k>0;k--){
    if(isPal(s.substring(k))){
        int tmpmin = minDp(s.substring(0,k)) + 1;
        if(tmpmin == 1)
            return 1;
        if(min > tmpmin)
            min = tmpmin;
    }
}
return min;

}
*/
    
  
 
 public static boolean isPal(String s){
     if(s.length() == 1)
         return true;
     int i=0;
     int j=s.length()-1;
     
     while(i < j){
         if(s.charAt(i) != s.charAt(j))
             return false;
         else{
             i++;
             j--;
         }
     }
     return true;
 }
 
    public static void main(String args[]){
    	String k = "kwtbjmsjvbrwriqwxadwnufplszhqccayvdhhvscxjaqsrmrrqngmuvxnugdzjfxeihogzsdjtvdmkudckjoggltcuybddbjoizu";
    	String i = "abcdefghijklmn";
    	String o = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    	String l = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
    	System.out.println(minCut(l));
    

    }   

}
