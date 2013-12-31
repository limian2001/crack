/* Determine whether an integer is a palindrome. Do this without extra space. */

public class PalindromeNumber {
	/*�����������ǻ��ģ�ֱ��false*/
	public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int t=x;
        int i=0;
        /*�ҳ��������λ������i��¼*/
        while(t!=0){
            t=t/10;
            i++;
        }
        /*���λ����1����0��ֱ�ӷ���true*/
        if(i==1 || i==0 )
            return true;
        
        int j=0;
        int y=x;
        /*ȡ���λ�����λ�Ƚϣ������ȣ��ͱȽϴθ�λ�ʹε�λ��ֱ�����ֲ��ȣ������������ֱȽ����*/
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
