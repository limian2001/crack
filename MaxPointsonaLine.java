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
        //���Hashmap������㣬Ϊ�˰��ظ��ĵ�鼯��һ��Key���ǵ�ת��String��ʽ��Value�����ظ������˼���
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        //�����ѵ���map
        for(int i=0;i<len;i++){
            String s = points[i].x + "," + points[i].y;
            if(map.containsKey(s)){
                
                map.put(s,map.get(s)+1);
                //����˳��������ִ����ĵ���max����ֹֻ��һ�����ظ��ĵ�����������ѭ���᲻������ֱ�ӷ���max��
                if(map.get(s) > max)
                    max = map.get(s);
            }
            else
                map.put(s,1);
        }
        
        
        //Ϊ�����淽�����������map���Ѳ��ظ��ĵ㶼д��һ��string����
        String[] distpo = new String[map.size()];
        int c = 0;
        for(String t : map.keySet()){
            
            distpo[c] = t;
            c++;
        }
        
      
        //���������һ��n^2��ѭ������Ϊ���еĵ㶼���ظ����Ե�i���㣬��j��������б�ʣ���б��д��һ���µ�hashmap��map2������������i��ֱ��б����ͬ����ô�϶�ͬʱ��i��һ��ֱ���ϣ�map2��value����������һ��б���£�һ��ֱ�ߣ����еĵ������������ظ��㣩
        for(int i=0;i<map.size();i++){
            
            Point a = new Point(Integer.parseInt(distpo[i].substring(0,distpo[i].indexOf(','))),Integer.parseInt(distpo[i].substring(distpo[i].indexOf(',')+1)));
            int tmp = map.get(distpo[i]);
            HashMap<Float,Integer> map2 = new HashMap<Float,Integer>();
            for(int j=0;j<map.size();j++){
                if(j != i){
              
                   Point b = new Point(Integer.parseInt(distpo[j].substring(0,distpo[j].indexOf(','))),Integer.parseInt(distpo[j].substring(distpo[j].indexOf(',')+1)));
                   if(b.x == a.x){
                       //���б��Ϊ����������
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
                   
               //������j����map2����һ�£�����iһ��б�ʵĵ���������Ŀ������tmp�����Һ�max�Ƚϣ�����max
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
