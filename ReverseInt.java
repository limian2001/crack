/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 

 */
public class ReverseInt {
	
	    public int reverse(int x) {
	        Integer y=x;
	        String s=y.toString();
	        String s2="";
	        Boolean c=false;
	        /*��������������ѷ���ȥ������c����¼������ķ���*/
	        if(s.charAt(0) == '-') 
	        {
	            c=true;
	            s=s.substring(1);
	         }
	        
	        /*����β����0�����������10000��12300���Ѻ����0��ȥ��*/
	        if(s.charAt(s.length()-1) == 0){
	            int i=0;
	            for(i=s.length()-1;i>=0 && s.charAt(i)==0;i--)
	            {}
	            s=s.substring(0,i+1);
	        }
	        
	        if(s == "")
	            return 0;
	        /*���������ת*/
	        for(int i=s.length()-1;i>=0;i--){
	            s2+=s.charAt(i);
	        }
	        /*���ݼ�¼�ķ��ţ��ָ�����*/
	        if(c == false)
	             return Integer.parseInt(s2);
	        else
	             return Integer.parseInt("-"+s2);
	        
	        
	    }
	}

