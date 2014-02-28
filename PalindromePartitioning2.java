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
     
   //����һ����ά���飬�Ѵ�i��j����һ��substring�ǲ��ǻ���д��ȥ�����������ѯ��ʱ��ֱ�ӵ������鼴�ɣ�������һЩ������ѯ��
    //������������Եݹ鷽����һЩ���ã�������������û���ظ���ѯ���������ⷨ����û�а����ⲿ��
     
// boolean[][] dp = new boolean[n+1][n+1];
   /*  for(int i=0;i<=n-1;i++)
         for(int j=i+1;j<=n;j++){
             if(isPal(s.substring(i,j)))
                 dp[i][j] = true;
     }
     
   */
   
   //Ϊ��ͨ���Ǹ�1462���ȵļ���ȫa��case��һ��ʼ��һ���ǲ���1 cut���ܸ㶨
   for(int k=1;k<n-1;k++){
       if(isPal(s.substring(0,k)) && isPal(s.substring(k)))
         return 1;
   }
    //�����ά����������¼��i��j����Сcut������ʵ����ֻ�õ��˴�0��j��������ʵһά����͹���
     int[][] min = new int[n+1][n+1];
     
     
     //DP, ���ƹ�ʽ�ǣ�0,j����Сcut�������ڣ�������kʹ��k,jΪ���ģ���0,j����Сcut������ ---- Min((0,k����Сcut��)+1) ����kΪ����ʹ��k,jΪ���ĵ���(i<k<j)
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
   
  // return minDp(s);  �ݹ������ķ���

 }
  //���ǵݹ������������ȷ�����ǻᳬʱ��˼�������һ��  
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
