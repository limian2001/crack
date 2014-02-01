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
         //   if(t == null){         本来想为null专门写一段，但是后来发现不用，HashMap无论key还是value都可以存null String
         //       if(map.containsKey("NULL"))
          //          map.get("NULL").add(t);
        //        else{
         //       ArrayList<String> arrlistN = new ArrayList<String>();
         //       arrlistN.add(t);
         //       map.put("NULL",arrlistN);
        //        }
        //    }
            if(map.containsKey(t))
                map.get(t).add(strs[i]); //Hashmap 后面value是Arraylist的时候，只要第一次新建put进去一个list，之后改变list就行
            else{
                ArrayList<String> arrlist = new ArrayList<String>();   
                arrlist.add(strs[i]);
                map.put(t,arrlist);
            }
            
        }
      //这里map.values()的内容大概这样[ [abc,abc], [bcd,dbc], [ , ] ]
        for(ArrayList<String> s:map.values()){   //这里用到了取出map的value的方法，遍历进去才是arraylist的格式
            if(s.size() > 1){    //
                for(String u:s)  //再进去每个元素遍历出来才是String，这个时候把String重新写到result里面
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
        return String.valueOf(str);  //最关键的，不能用str.toString()，直接跪，要用这个方法
    }
    
    public static void main(String args[]){
    	String[] tr={"","","",""};
    	System.out.println(anagrams(tr));
    }

}
