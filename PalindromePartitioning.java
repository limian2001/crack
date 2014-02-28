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
        //本身就是回文，直接放进去res，因为后面的BFS不再考虑没有断点的情况
        if(stringisPalindrom(s)){
            tmp.add(s);
            res.add(new ArrayList<String>(tmp));
            tmp.clear();
        }
            
        //BFS，建立一个队列，里面放断点
        Queue<String> q = new LinkedList<String>();
        
        //放第一个断点的位置，如果0到断点之间的substring不是回文，直接丢弃
        for(int i=1;i<=n;i++){
        	if(stringisPalindrom(s.substring(0,i)))
        		q.offer(String.valueOf(i));
        
        }
        //对队列进行操作，取出一个来，测试是否每一段都是回文，是的话放进结果（其实放进队列的时候已经判断了前面部分，只要判断最后那一段是不是即可）
        while(!q.isEmpty()){
        	//队列里面长得像“2;4;7"表示断点在2,4,7的位置
            String a = q.poll();
            String[] c = a.split(";");
            String ss = s;
            //判断最后那一段，就是7到end，是的话就按照断点分string，放进结果
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
            //这时queue取出来的断点如果没有到达长度末尾，需要对它后面再加上遍历所有断点并测试，比如长度为10，目前是”2;4;7"，后面加"2;4;7;8","2;4;7;9"......
            if(Integer.parseInt(c[c.length-1]) < n){
                for(int j=Integer.parseInt(c[c.length-1])+1;j<=n;j++){
                    String t = a;
                    //测试加上后面断点后新的这段是不是回文，不是的话不操作，是的话写进队列
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
