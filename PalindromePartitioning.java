import java.util.*;

public class PalindromePartitioning {
	public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();
        
        int n = s.length() - 1;
        if(n == 0){
            tmp.add(s);
            res.add(new ArrayList<String>(tmp));
            return res;
        
        }
        //������ǻ��ģ�ֱ�ӷŽ�ȥres����Ϊ�����BFS���ٿ���û�жϵ�����
        if(stringisPalindrom(s)){
            tmp.add(s);
            res.add(new ArrayList<String>(tmp));
            tmp.clear();
        }
            
        //BFS������һ�����У�����Ŷϵ�
        Queue<String> q = new LinkedList<String>();
        
        //�ŵ�һ���ϵ��λ�ã����0���ϵ�֮���substring���ǻ��ģ�ֱ�Ӷ���
        for(int i=1;i<=n;i++){
        	if(stringisPalindrom(s.substring(0,i)))
        		q.offer(String.valueOf(i));
        
        }
        //�Զ��н��в�����ȡ��һ�����������Ƿ�ÿһ�ζ��ǻ��ģ��ǵĻ��Ž��������ʵ�Ž����е�ʱ���Ѿ��ж���ǰ�沿�֣�ֻҪ�ж������һ���ǲ��Ǽ��ɣ�
        while(!q.isEmpty()){
        	//�������泤����2;4;7"��ʾ�ϵ���2,4,7��λ��
            String a = q.poll();
            String[] c = a.split(";");
            String ss = s;
            //�ж������һ�Σ�����7��end���ǵĻ��Ͱ��նϵ��string���Ž����
           if(stringisPalindrom(ss.substring(Integer.parseInt(c[c.length-1])))){
               for(int i=0;i<c.length;i++){
            	
            	   if(i == 0)
            			tmp.add(ss.substring(0,Integer.parseInt(c[i])));
            	   else            		
            			tmp.add(ss.substring(Integer.parseInt(c[i-1]),Integer.parseInt(c[i])));
            	
               }
       
            tmp.add(ss.substring(Integer.parseInt(c[c.length - 1])));
            res.add(new ArrayList<String>(tmp));
           }
            tmp.clear();
            //��ʱqueueȡ�����Ķϵ����û�е��ﳤ��ĩβ����Ҫ���������ټ��ϱ������жϵ㲢���ԣ����糤��Ϊ10��Ŀǰ�ǡ�2;4;7"�������"2;4;7;8","2;4;7;9"......
            if(Integer.parseInt(c[c.length-1]) < n){
                for(int j=Integer.parseInt(c[c.length-1])+1;j<=n;j++){
                    String t = a;
                    //���Լ��Ϻ���ϵ���µ�����ǲ��ǻ��ģ����ǵĻ����������ǵĻ�д������
                    if(stringisPalindrom(ss.substring(Integer.parseInt(c[c.length-1]),j))){
                    	t = t + ";" + j;
                    	q.offer(t);
                }
          
            }
            }
        }
        return res;

    }
    

    
    public static boolean stringisPalindrom(String s){
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
    	String l = "aaaaaaaaaaaaaaa";
    	System.out.println(partition(l));
    }

}
