import java.util.*;

public class combunationSum {
	
	    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	        
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> tmp = new ArrayList<Integer>();
	        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
	        Queue<Integer> sum = new LinkedList<Integer>();
	        Arrays.sort(candidates);
	        
	        if(target == candidates[0]){
	            tmp.add(target);
	            res.add(new ArrayList<Integer>(tmp));
	            return res;
	        }
	        //each element which is smaller than target offer into queue 
	        for(int i=0;i<candidates.length;i++){
	            if(candidates[i] > target)
	                break;
	            else{
	                
	                ArrayList<Integer> el = new ArrayList<Integer>();
	                el.add(candidates[i]);
	                q.add(el);
	                sum.add(candidates[i]);
	            }
	        }
	        //BFS, find combination
	        while(!q.isEmpty()){
	            tmp = q.poll();
	            int add = sum.poll();
	            
	            if(add == target)
	                res.add(new ArrayList<Integer>(tmp));
	            
	            if(add < target){
	                for(int i=0;i<candidates.length;i++){
	                    if(candidates[i] > target - add)
	                        break;
	                    else{
	                        if(candidates[i] >= tmp.get(tmp.size()-1)){
	                            ArrayList<Integer> tmp2 = new ArrayList<Integer>(tmp);
	                            tmp2.add(candidates[i]);
	                            q.add(tmp2);
	                            sum.add(add+candidates[i]);
	                        }
	                        
	                    }
	                }
	            }
	        }
	        
	        return res;
	        
	   
	    }
	    
	    
	}


