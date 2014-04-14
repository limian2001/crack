import java.util.*;

public class MergeIntervals {
	 public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	        //sort the intervals as collections
	        Collections.sort(intervals, new IntervalComparator());
	        
	        
	        ArrayList<Interval> res = new ArrayList<Interval>();

	        //if null input
	        if(intervals.size() == 0)
	            return res;
	            
	            
	            
	        
	        res.add(intervals.get(0));
	        int i = 1;
	        int j = 0;
	        
	        while(i < intervals.size()){
	            //example like  [1,2],[3,4]
	            if(res.get(j).end < intervals.get(i).start){
	                res.add(intervals.get(i));
	                i++;
	                j++;
	            }
	            else{
	                //example like  [1,3],[2,4]
	                if(res.get(j).end >= intervals.get(i).start && res.get(j).end < intervals.get(i).end){
	                    Interval intl = new Interval(res.get(j).start,intervals.get(i).end);
	                    res.set(j,intl);
	                    i++;
	                }
	                //example like  [1,5],[3,4]
	                else{
	                    if(res.get(j).end >= intervals.get(i).end)
	                        i++;
	                }
	                    
	            }
	        }
	        return res;
        
        
        
    }
}
class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}