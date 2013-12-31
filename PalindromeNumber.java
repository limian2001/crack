/* Determine whether an integer is a palindrome. Do this without extra space. */

public class PalindromeNumber {
	/*负数不可能是回文，直接false*/
	public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int t=x;
        int i=0;
        /*找出这个数的位数，用i记录*/
        while(t!=0){
            t=t/10;
            i++;
        }
        /*如果位数是1或者0，直接返回true*/
        if(i==1 || i==0 )
            return true;
        
        int j=0;
        int y=x;
        /*取最高位和最低位比较，如果相等，就比较次高位和次低位，直到出现不等，或者所有数字比较完毕*/
        int left = (int)(x/Math.pow(10,i-1))%10;
        int right = (int)(y/Math.pow(10,j))%10;
        while(left == right && i>j){
            i--;
            j++;
            left = (int)(x/Math.pow(10,i-1))%10;
            right = (int)(y/Math.pow(10,j))%10;
        }
        
        if(i==j || i<j)
            return true;
        else
            return false;
    }
}
