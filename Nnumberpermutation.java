/*Given n. Generate all numbers with number of digits equal to n, such that the digit 
 * to the right is greater than the left digit (ai+1 > ai). E.g. if n=3 
 * (123,124,125,����129,234,��..789)*/
import java.util.*;
public class Nnumberpermutation {
	public static LinkedList<String> number(int n){
		if(n == 1){
			for(int i=1;i<=9;i++)
				System.out.println(i);
		}
		String tmp = "";
		LinkedList<String> result = new LinkedList<String>();
		dfs(n,n,tmp,result);
		return result;
	}
	
	public static void dfs(int n,int len,String tmp,LinkedList<String> res){
		for(int i=1;i<=9-len+1;i++){
			//�ж�һ��string�ǲ���nullһ��Ҫ��isEmpty��������== null
			//�жϺ������ֱ�ǰ��Ĵ�Ž����ַ����ӣ�����ֱ��for��һ��i������if�жϸ�������for
			if(tmp.isEmpty() || i > tmp.charAt(tmp.length()-1) - '0' ){
			tmp+= Integer.toString(i);
			//������������ˣ������
			if(tmp.length() == n){
				res.add(tmp);
			}
			//�������û�е�n���ͶԺ���ݹ�,len��ʾ���ж���λ
			else
				dfs(n,len-1,tmp,res);
			
			//һ��Ҫ��for���������ɾ��β���ַ�������ǰ��ݹ��˳���ʱ�򣬿��Ա�֤ɾ����ͷ
			tmp = tmp.substring(0,tmp.length()-1);
			}
		}
		
		
		
		
		
	}
	public static void main(String args[]){
		System.out.println(number(6));
	}

}
