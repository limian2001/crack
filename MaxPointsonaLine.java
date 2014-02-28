/*Max Points on a Line Total Accepted: 4299 Total Submissions: 43092 My Submissions 





Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

import java.util.*;

public class MaxPointsonaLine {
    public static int maxPoints(Point[] points) {

        int len = points.length;
        if(len < 3)
            return len;
        int max = 0;
        //这个Hashmap用来存点，为了把重复的点归集到一起，Key就是点转成String形式，Value就是重复出现了几次
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        //这样把点存进map
        for(int i=0;i<len;i++){
            String s = points[i].x + "," + points[i].y;
            if(map.containsKey(s)){
                
                map.put(s,map.get(s)+1);
                //这里顺便把最多出现次数的点存进max，防止只有一个不重复的点的情况（下面循环会不操作，直接返回max）
                if(map.get(s) > max)
                    max = map.get(s);
            }
            else
                map.put(s,1);
        }
        
        
        //为了下面方便操作，遍历map，把不重复的点都写进一个string数组
        String[] distpo = new String[map.size()];
        int c = 0;
        for(String t : map.keySet()){
            
            distpo[c] = t;
            c++;
        }
        
      
        //这里设计了一个n^2的循环，因为所有的点都不重复，对第i个点，与j点连线算斜率，把斜率写进一个新的hashmap，map2，如果两个点和i的直线斜率相同，那么肯定同时与i在一条直线上，map2的value用来存下这一个斜率下（一条直线）所有的点数量（包括重复点）
        for(int i=0;i<map.size();i++){
            
            Point a = new Point(Integer.parseInt(distpo[i].substring(0,distpo[i].indexOf(','))),Integer.parseInt(distpo[i].substring(distpo[i].indexOf(',')+1)));
            int tmp = map.get(distpo[i]);
            HashMap<Float,Integer> map2 = new HashMap<Float,Integer>();
            for(int j=0;j<map.size();j++){
                if(j != i){
              
                   Point b = new Point(Integer.parseInt(distpo[j].substring(0,distpo[j].indexOf(','))),Integer.parseInt(distpo[j].substring(distpo[j].indexOf(',')+1)));
                   if(b.x == a.x){
                       //这个斜率为正无穷的情况
                       if(map2.get(Float.POSITIVE_INFINITY) != null)
                            map2.put(Float.POSITIVE_INFINITY,map2.get(Float.POSITIVE_INFINITY) + map.get(distpo[j]));
                       else
                            map2.put(Float.POSITIVE_INFINITY,map.get(distpo[i])+map.get(distpo[j]));
                    }
                    
                    else{
                        float k = (float)(b.y - a.y)/(float)(b.x - a.x);
                        if(map2.get(k) != null)
                            map2.put(k,map2.get(k) + map.get(distpo[j]));
                        else
                            map2.put(k,map.get(distpo[i])+map.get(distpo[j]));
                    }
                   
               //遍历完j，对map2遍历一下，找与i一样斜率的点中最多的数目，存在tmp，并且和max比较，更新max
               for(int x : map2.values()){
                   if(x > tmp)
                        tmp = x;
               }
               if(tmp > max)
                   max = tmp;
                }
            }
           
           }
           
            
        return max;
    }
    
    public static void main(String args[]){
    	Point[] p = {new Point(3,1),new Point(12,3),new Point(3,1),new Point(-6,-1)};
    	System.out.println(maxPoints(p));
    }

}
