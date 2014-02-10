/*Given n. Generate all numbers with number of digits equal to n, such that the digit 
 * to the right is greater than the left digit (ai+1 > ai). E.g. if n=3 
 * (123,124,125,……129,234,…..789)*/
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
			//判断一个string是不是null一定要用isEmpty，不能用== null
			//判断后面数字比前面的大才进行字符连接，否则直接for下一个i，所以if判断覆盖整个for
			if(tmp.isEmpty() || i > tmp.charAt(tmp.length()-1) - '0' ){
			tmp+= Integer.toString(i);
			//如果长度满足了，就输出
			if(tmp.length() == n){
				res.add(tmp);
			}
			//如果长度没有到n，就对后面递归,len表示还有多少位
			else
				dfs(n,len-1,tmp,res);
			
			//一定要在for最后无条件删除尾部字符，这样前面递归退出的时候，可以保证删除到头
			tmp = tmp.substring(0,tmp.length()-1);
			}
		}
		
		
		
		
		
	}
	public static void main(String args[]){
		System.out.println(number(6));
	}

}
