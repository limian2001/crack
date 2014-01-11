/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 

For example,
 If n = 4 and k = 2, a solution is: 
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


 * */

import java.util.ArrayList;


public class Combinations {
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp_array=new ArrayList<Integer>();
        
        dfs(k,n,tmp_array,result,0);
        return result;
        
    }
    
    public static void dfs(int k,int n,ArrayList<Integer> tmp,ArrayList<ArrayList<Integer>> result,int start){
        
    	
    	if(start == k)
            return;
    	//ѭ���ӵ�һ�����ֿ�ʼ����n��������׸����֣����жϴ�С��ֱ�ӱ�����0��n���������
    	//�׸�����֤�������ȥ�����ֱ�ǰ��Ĵ������ȱ������ظ����֣��ֽ�ʡ�������õ����
    	//�ݹ�����˼·�Ǹ���startλ��Ҳ����0-k���ݹ鵽k֮�����ɾ��tmpĩβ�����֣�ֱ���˻ص���ͷ��
        for(int i=0;i<n;i++){
        	if(start == 0){
        		 tmp.add(i+1);
                 dfs(k,n,tmp,result,start+1);
                 if(tmp.size() == k)
                     result.add(new ArrayList<Integer>(tmp));
                 tmp.remove(tmp.size()-1);
        	}
        	
        	else{
        	if(i+1 > tmp.get(tmp.size()-1)){
            tmp.add(i+1);
            dfs(k,n,tmp,result,start+1);
            if(tmp.size() == k)
                result.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size()-1);
        	}
        	}
        }
    }
    

	public static void main(String args[]) 
	{
		
		 System.out.println(combine(5,4));
}

}
