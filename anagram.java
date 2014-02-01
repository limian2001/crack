/*Anagrams Total Accepted: 4194 Total Submissions: 18689 My Submissions 





Given an array of strings, return all groups of strings that are anagrams. 

Note: All inputs will be in lower-case.
*/

import java.util.*;

public class anagram {
	public static ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        
        for(int i=0;i<strs.length;i++){
            String t = sort(strs[i]);
         //   if(t == null){         ������Ϊnullר��дһ�Σ����Ǻ������ֲ��ã�HashMap����key����value�����Դ�null String
         //       if(map.containsKey("NULL"))
          //          map.get("NULL").add(t);
        //        else{
         //       ArrayList<String> arrlistN = new ArrayList<String>();
         //       arrlistN.add(t);
         //       map.put("NULL",arrlistN);
        //        }
        //    }
            if(map.containsKey(t))
                map.get(t).add(strs[i]); //Hashmap ����value��Arraylist��ʱ��ֻҪ��һ���½�put��ȥһ��list��֮��ı�list����
            else{
                ArrayList<String> arrlist = new ArrayList<String>();   
                arrlist.add(strs[i]);
                map.put(t,arrlist);
            }
            
        }
      //����map.values()�����ݴ������[ [abc,abc], [bcd,dbc], [ , ] ]
        for(ArrayList<String> s:map.values()){   //�����õ���ȡ��map��value�ķ�����������ȥ����arraylist�ĸ�ʽ
            if(s.size() > 1){    //
                for(String u:s)  //�ٽ�ȥÿ��Ԫ�ر�����������String�����ʱ���String����д��result����
                    result.add(u);
            }
        }
        return result;
    }
    
    public static String sort(String s){
        if(s == null)
            return s;
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return String.valueOf(str);  //��ؼ��ģ�������str.toString()��ֱ�ӹ�Ҫ���������
    }
    
    public static void main(String args[]){
    	String[] tr={"","","",""};
    	System.out.println(anagrams(tr));
    }

}
